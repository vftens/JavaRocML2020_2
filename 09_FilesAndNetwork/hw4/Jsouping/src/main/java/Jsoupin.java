//import java.sql.Connection;

public class Jsoupin {
    public boolean crawl(String url){
        try{
            Connection connection = Jsoup.connect(url);
            htmlDocument = connection.get();
            if (connection.response().statusCode() = 200){
                System.out.println("\nVisiting " + url);

            }
            if (!connection.response().contentType().contains("text/html")){
                System.out.println("Got something other than Html");
                return false;
            }
            return true;
        }
        catch (Exception ex){
            message = ex.getMessage();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    protected List<ClassDataBuilder> doInBackground(List<ClassDataBuilder>... params) {
        Document docTxt;
        List<ClassDataBuilder> classDataBuilder = new ArrayList<>();
        try {
            docTxt = Jsoup.connect("http://fs.to/video/films/?sort=popularity").get();
            titleTxt = docTxt.select(".b-poster-tile__title-full");
            titleList.clear();

            for (Element contents : titleTxt) {
                titleList.add(contents.text());
                Log.d("TITLE", contents.text());
            }
        } //...\\\
    }
}
