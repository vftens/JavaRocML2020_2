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
                String GetFileSize;

                Files.walkFileTree(path, fileVizitor);
                System.out.println("Всего папок - " + (fileVizitor.getFoldersCount() - 1));
                System.out.println("Всего файлов - " + fileVizitor.getFilesCount());

                long SizeInByte = fileVizitor.getSize();
                System.out.println("Общий размер - " + SizeInByte + " байт");

                System.out.println(humanReadableByteCountBin(SizeInByte));
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
        CharacterIterator ci = new StringCharacterIterator("KMGTPE");
        for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
            value >>= 10;
            ci.next();
        }
        value *= Long.signum(bytes);
        return String.format("%.1f %ciB", value / 1024.0, ci.current());
    }

    static class FileVizitor extends SimpleFileVisitor<Path> {
        private int foldersCount = 0;
        private int filesCount = 0;
        private int size = 0;

        public int getFilesCount() {
            return filesCount;
        }

        public int getFoldersCount() {
            return foldersCount;
        }

        public int getSize() {
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