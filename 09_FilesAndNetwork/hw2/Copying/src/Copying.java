import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import static java.nio.file.Files.createDirectory;

public class Copying {

    public static void main(String[] args) throws InterruptedException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Введите путь до исходной папки А :");
            Path path = Paths.get(reader.readLine());
            System.out.println("Введите путь до конечной папки Б");
            Path pathB = Paths.get(reader.readLine());

            FileVizitor fileVizitor = new FileVizitor();
            if (!path.toFile().isDirectory()) {
                System.out.println("ИЗВИНИТЕ, " + path.toAbsolutePath() + " - не папка");
            } else {
                if (!pathB.toFile().isDirectory()) {
                    createDirectory(pathB);  // создаем отсутствующую директорию
                    //System.out.println("ИЗВИНИТЕ, " + path.toAbsolutePath() + " - не папка");
                }
                long sizeInByte;

                Files.walkFileTree(path, fileVizitor);
                System.out.println("Всего папок - " + (fileVizitor.getFoldersCount() - 1));
                System.out.println("Всего файлов - " + fileVizitor.getFilesCount());

                sizeInByte = fileVizitor.getSize();
                System.out.println("Общий размер - " + sizeInByte + " байт");


            }

            /*
            ArrayList<String> selectFiles = new ArrayList<>();
            File folder = new File(String.valueOf(pathB));
            File[] listOfFiles = folder.listFiles();

            for (File f : listOfFiles) {
                selectFiles.add(f + "");
            }

            File source = new File(" " + selectFiles);// ПОЛУЧАЮ СПИСОК ФАЙЛОВ ПРИСВАИВАЮ ПЕРЕМЕННУЮ С ФАЙЛАМИ
            File dest = new File(String.valueOf(pathB));// ПРОПИСЫВАЮ ПУТЬ КУДА КОПИРОВАТЬ

             */
            copyDir(String.valueOf(path), String.valueOf(pathB)); // dest;
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    public static void copy(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
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

    private static void copyDir(String sourceDirName, String targetSourceDir) throws IOException {
        File folder = new File(sourceDirName);

        File[] listOfFiles = folder.listFiles();

        Path destDir = Paths.get(targetSourceDir);
        if (listOfFiles != null) {
            for (File file : listOfFiles)
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
        }

    }

    private static void copyFiles(File[] listOfFiles) throws IOException {
        for (File f : listOfFiles) {
            Files.copy(f.toPath(), new File("путь" + File.separator + f.getName()).toPath());
        }
    }

}