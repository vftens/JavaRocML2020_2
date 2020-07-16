import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import java.util.regex.Pattern;

public class Download {
    public static void downloadImage(String strImageURL) {
        final int EOF = -1;

        String strImageName =
                strImageURL.substring(strImageURL.lastIndexOf("/") + 1);

        // Если есть расширения .jpg или .png - сохраняем
        boolean E = Pattern.matches(".*(\\.jpg|\\.png)$", strImageName);
        if (E) { // по-японски Э - это картина
            // только картинки
            System.out.println("Saving picture: " + strImageName + ", from: " +
                    strImageURL);

            try (InputStream in = new URL(strImageURL).openStream();
                 OutputStream os = new FileOutputStream(Images.getImageDestinationFolder() +
                         "/" + strImageName)) {

                byte[] buffer = new byte[4096];  // 4K
                int n = EOF;

                while ((n = in.read(buffer)) != EOF) {
                    os.write(buffer, 0, n);
                }
                os.close();  // закрываем буфер
                System.out.println("Picture Image Saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Skipping: " + strImageName);
        }
    }
}
