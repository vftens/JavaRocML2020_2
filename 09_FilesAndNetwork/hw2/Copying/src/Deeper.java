import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.Files.createDirectory;

public class Deeper {  // FileTree

    public void FileTree(Path args) {

        Path pathSource = args;
        //Path pathSource = Paths.get("Введите сюда путь к какому-либо каталогу, содержащему другие каталоги и файлы");
        try {
            Files.walkFileTree(pathSource, new MyFileVisitor());
            //System.out.println(pathSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path path,
                                         BasicFileAttributes fileAttributes) {
            //System.out.println("file name:" + path.getFileName());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path path,
                                                 BasicFileAttributes fileAttributes) throws IOException {
            System.out.println("Directory name:" + path); // Скопировать дир А path в дир Б pathBB

            Path pathBB = Paths.get(myfile(String.valueOf(path) + Copying.target));

            System.out.println("Directory name B:" + pathBB);
            if (!pathBB.toFile().isDirectory()) {
                createDirectory(pathBB);  // создаем отсутствующую директорию
            }

            //Copying.copyDir(String.valueOf(path), String.valueOf(pathBB));

            return FileVisitResult.CONTINUE;
        }

        private String myfile(String path) { // заменить в дир А на Б и ок

            String pa = Copying.target + path.substring(Copying.source.length(),
                    path.length());
            return pa;
        }
    }
}
