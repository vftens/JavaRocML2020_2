import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MioResult {

    public static void write(String msMap) {
        File file = new File("./output.txt");
        System.out.println("Записываем файл...");

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(msMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
