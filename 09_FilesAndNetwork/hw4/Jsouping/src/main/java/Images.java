import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Images {

    private static String IMAGE_DESTINATION_FOLDER = "Images";

    public static void main(String[] args) throws IOException {

        String strURL = "https://lenta.ru";

        Document document = Jsoup
                .connect(strURL)
                .maxBodySize(0)
                .get();

        Elements imageElements = document.select("img");

        for (Element imageElement : imageElements) {
            String strImageURL = imageElement.attr("abs:src");
            downloadImage(strImageURL);
        }

    }

    private static void downloadImage(String strImageURL) {

        String strImageName =
                strImageURL.substring(strImageURL.lastIndexOf("/") + 1);
        // Если есть расширения .jpg или .png - сохраняем
        if (strImageName.contains(".jpg") || strImageName.contains(".png")) {

            System.out.println("Saving: " + strImageName + ", from: " + strImageURL);

            try (InputStream in = new URL(strImageURL).openStream()) {

                byte[] buffer = new byte[4096];
                int n = -1;

                OutputStream os =
                        new FileOutputStream(IMAGE_DESTINATION_FOLDER + "/" + strImageName);

                while ((n = in.read(buffer)) != -1) {
                    os.write(buffer, 0, n);
                }
                os.close();
                System.out.println("Image saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Skipping: " + strImageName);
        }
    }
}