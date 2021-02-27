import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

import static java.lang.Math.random;

public class SiteMap extends RecursiveTask<String> {

    private String url;
    private static String startUrl;

    HashMap<String, SiteMap> mymap;
    int numCores = 0;

    public SiteMap(String url) {
        this.url = url.trim();
    }

    public SiteMap(String url, String startUrl) {
        this.url = url.trim();
        SiteMap.startUrl = startUrl.trim();
    }

    int pause() {
        return (int) (100 + (50 * random()));
    }

    boolean problem_is_small() {
        if (numCores <= 1) {
            return true;
        } else return false;
    }

    public MioResult solve(int problem) {
        boolean boolresult;
        numCores = problem;
        if (problem_is_small()) {
            //directly solve problem

        } else {
	    /*
            split problem into independent parts
            fork new subtasks to solve each part
            join all subtasks
            compose result from subresults
	     */

        }
        return boolresult;
    }

    @Override
    protected String compute() {
        StringBuffer sb = new StringBuffer(url + "\n");
        Set<SiteMap> subTask = new HashSet<>();

        getManyChildren(subTask);

        return null;
    }

    private void getManyChildren(Set<SiteMap> subTask) {
        Document doc;
        Elements elements;
        try {
            Thread.sleep(pause());
            doc = Jsoup.connect(url).get();
            elements = doc.select("a");
            for (Element el : elements) {
                String atribut = el.attr("abs:href");
                if (!atribut.isEmpty() && atribut.startsWith(startUrl) && !atribut.contains("#") &&
                        !allLinks.contains(atribut)) {
                    SiteMap mysiteMap = new SiteMap(atribut);
                    mysiteMap.fork();
                    subTask.add(mysiteMap);
                    allLinks.add(atribut);

                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException ignored) {

        }


    }
}
