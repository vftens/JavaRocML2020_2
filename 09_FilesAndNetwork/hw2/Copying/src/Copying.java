import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.Files.createDirectory;

public class Copying {

    static String source, target;

    public static void main(String[] args) throws InterruptedException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Введите путь до исходной папки А :");
            Path path = Paths.get(reader.readLine());
            System.out.println("Введите путь до конечной папки Б :");
            Path pathB = Paths.get(reader.readLine());

            source = String.valueOf(path);
            target = String.valueOf(pathB);
            FileVizitor fileVizitor = new FileVizitor();
            if (!path.toFile().isDirectory()) {
                System.out.println("ИЗВИНИТЕ, " + path.toAbsolutePath() + " - не папка");
            } else {
                long sizeInByte;

                if (!pathB.toFile().isDirectory()) {
                    createDirectory(pathB);  // создаем отсутствующую директорию
                }

                Copy cp = new Copy();
                cp.mycopy();

                //Filewalker fw = new Filewalker();
                //fw.walk(String.valueOf(path));

                Files.walkFileTree(path, fileVizitor);
                //Deeper dp = new Deeper();
                //dp.FileTree(path);
                //copyDir(String.valueOf(path), String.valueOf(pathB)); // dest;
                System.out.println("Всего папок - " + (fileVizitor.getFoldersCount() - 1));
                System.out.println("Всего скопировано файлов - " + fileVizitor.getFilesCount());

                sizeInByte = fileVizitor.getSize();
                System.out.println("Общий размер - " + sizeInByte + " байт");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
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

            //copyDir(String.valueOf(dir), target);
            return super.postVisitDirectory(dir, exc);
        }
    }

    public static void copyDir(String sourceDirName, String targetSourceDir) throws IOException {
        File folder = new File(sourceDirName);

        File[] listOfFiles = folder.listFiles();

        Path destDir = Paths.get(targetSourceDir);
        if (listOfFiles != null) {
            for (File file : listOfFiles)
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}