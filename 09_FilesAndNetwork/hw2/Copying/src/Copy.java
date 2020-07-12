import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import java.io.IOException;
import java.util.*;
/**
 * Код который копирует похоже на программу cp
 */
public class Copy {
    static void copyFile(Path source, Path target) {
        CopyOption[] options =
                new CopyOption[]{REPLACE_EXISTING};
        if (Files.notExists(target)) {
            try {
                Files.copy(source, target, options);
            } catch (IOException x) {
                System.err.format("Unable to copy: %s: %s%n", source, x);
            }
        }
    }

    /**
     * A  FileVisitor который копирует дерево
     */
    static class TreeCopier implements FileVisitor<Path> {
        private final Path source;
        private final Path target;

        TreeCopier(Path source, Path target) {
            this.source = source;
            this.target = target;

        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            // before visiting entries in a directory we copy the directory
            // (okay if directory already exists).
            CopyOption[] options =  new CopyOption[0];

            Path newdir = target.resolve(source.relativize(dir));
            try {
                Files.copy(dir, newdir, options);
            } catch (FileAlreadyExistsException x) {
                // ignore
            } catch (IOException x) {
                System.err.format("Unable to create: %s: %s%n", newdir, x);
                return SKIP_SUBTREE;
            }
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            copyFile(file, target.resolve(source.relativize(file)));

            return CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            // фикс время модификации директории
            if (exc == null) {
                Path newdir = target.resolve(source.relativize(dir));
                try {
                    FileTime time = Files.getLastModifiedTime(dir);
                    Files.setLastModifiedTime(newdir, time);
                } catch (IOException x) {
                    System.err.format("Unable to copy all attributes to: %s: %s%n", newdir, x);
                }
            }
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            if (exc instanceof FileSystemLoopException) {
                System.err.println("cycle detected: " + file);
            } else {
                System.err.format("Unable to copy: %s: %s%n", file, exc);
            }
            return CONTINUE;
        }
    }

    public static void mycopy() throws IOException {
        // проверить target это директория
        Path target = Paths.get(Copying.target);
        Path source = Paths.get(Copying.source);
        boolean isDir = Files.isDirectory(target);

        Path dest = (isDir) ? target.resolve(source.getFileName()) : target;

        // follow по ссылкам когда копируешь файлы
        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        TreeCopier tc = new TreeCopier(source, dest);
        Files.walkFileTree(source, opts, Integer.MAX_VALUE, tc);
    }
}

