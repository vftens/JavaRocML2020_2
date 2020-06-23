import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Copying {

    public static void main(String[] args) throws InterruptedException, IOException {
        ArrayList<String> selectFiles = new ArrayList<>();
        File folder = new File("путь");
        File[] listOfFiles = folder.listFiles();

        for (File f : listOfFiles) {
            selectFiles.add(f + "");
        }

        File source = new File(" " + selectFiles);// ПОЛУЧАЮ СПИСОК ФАЙЛОВ ПРИСВАИВАЮ ПЕРЕМЕННУЮ С ФАЙЛАМИ
        File dest = new File("путь");// ПРОПИСЫВАЮ ПУТЬ КУДА КОПИРОВАТЬ
        copy(source, dest);
    }

    public static void copy(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
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