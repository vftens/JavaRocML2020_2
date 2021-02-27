import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MioResult {

    public static void write() {

        File file = new File("./output.txt");

        try (PrintWriter writer = new PrintWriter(file)) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
