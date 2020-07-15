import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Images {

    private static String IMAGE_DESTINATION_FOLDER = "images";

    public static void main(String[] args) throws IOException {

        String strURL = "https://lenta.ru";  // с главной страницы

        Document document = Jsoup
                .connect(strURL)
                .maxBodySize(0)
                .get();  // любой размер скачиваемого

        Elements imageElements = document.select("img"); // выбираем с тегом

        Download dd = new Download();

        for (Element imageElement : imageElements) { // https://jsoup.org/cookbook/extracting-data/working-with-urls
            String strImageURL = imageElement.attr("abs:src");
            dd.downloadImage(strImageURL);
        }
    }

    public static String getImageDestinationFolder() {
        return IMAGE_DESTINATION_FOLDER;
    }
}