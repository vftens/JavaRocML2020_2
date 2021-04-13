import java.io.*;

public class MioResult {

    public static void write(String msMap, boolean append) {
        File file = new File("./output.txt");
        System.out.println("Записываем файл...");

        try (FileWriter writer = new FileWriter(file, append)) {
            writer.write(msMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
