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
        copyDir(source, dest);
    }

    private static void copyDir(String sourceDirName, String targetSourceDir) throws IOException {
        File folder = new File(sourceDirName);

        File[] listOfFiles = folder.listFiles();

        Path destDir = Paths.get(targetSourceDir);
        if (listOfFiles != null)
            for (File file : listOfFiles)
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);

    }

}