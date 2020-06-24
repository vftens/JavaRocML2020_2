import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Directory {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Введите путь до папки: ");
            Path path = Paths.get(reader.readLine());
            FileVizitor fileVizitor = new FileVizitor();
            if (!path.toFile().isDirectory()) {
                System.out.println("ИЗВИНИТЕ, " + path.toAbsolutePath() + " - не папка");
            } else {
                String getFileSize;
                long sizeInByte;

                Files.walkFileTree(path, fileVizitor);
                System.out.println("Всего папок - " + (fileVizitor.getFoldersCount() - 1));
                System.out.println("Всего файлов - " + fileVizitor.getFilesCount());

                sizeInByte = fileVizitor.getSize();
                System.out.println("Общий размер - " + sizeInByte + " байт");

                getFileSize = humanReadableByteCountBin(sizeInByte);
                System.out.println(getFileSize);
            }

        } catch (Exception e) {
            Thread current = Thread.currentThread();
            StackTraceElement[] methods = current.getStackTrace();

            for (var info : methods)
                System.out.println(info);
            System.out.println(e);
        }
    }

    public static String humanReadableByteCountBin(long bytes) {
        long absB = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
        if (absB < 1024) {
            return bytes + " B";
        }
        long value = absB;
        CharacterIterator ci = new StringCharacterIterator("KMGTPE");  // countable letter of bytes power
        for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
            // while absB > сдвинутого вправо на 10*(0..5) бит
            // а 0xfffccccccccccccL это то что Билл Гейтс или Путин назвали Ясно Формулировать -
            // это близкое к максимальному значение которое мы сдвигаем на 40..30..20..10..0 бит, пока
            // не найдем подходящую Букву обозначающую нашу размерность множителя байт.
            // for i = 40 downto 0 step -10
            value >>= 10;  // сдвиг вправо на 10 бит значения в байтах
            ci.next();  // считаем следующую букву множителя байт
        }
        value *= Long.signum(bytes);
        return String.format("%.1f %ciB", value / 1024.0, ci.current());
    }

    static class FileVizitor extends SimpleFileVisitor<Path> {
        private int foldersCount = 0;
        private int filesCount = 0;
        private long size = 0;

        public int getFilesCount() {
            return filesCount;
        }

        public int getFoldersCount() {
            return foldersCount;
        }

        public long getSize() {
            return size;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            size += attrs.size();
            ++filesCount;
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            ++foldersCount;
            return super.postVisitDirectory(dir, exc);
        }
    }
}