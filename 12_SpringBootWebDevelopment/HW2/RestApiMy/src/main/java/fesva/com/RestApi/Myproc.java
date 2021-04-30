package fesva.com.RestApi;

import java.io.File;
import java.io.IOException;

public class Myproc {
    public static void mymain() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("python", "script.py");
        pb.directory(new File("C:\\path\\to\\py")); // tomcat???
        Process p = pb.start();
    }
}
