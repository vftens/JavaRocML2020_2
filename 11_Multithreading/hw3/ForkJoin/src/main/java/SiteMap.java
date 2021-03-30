import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveTask;

import static java.lang.Math.random;

public class SiteMap extends RecursiveTask<String> {

    static final boolean debug = true;

    private String url;
    private static String startUrl;
    private static CopyOnWriteArraySet<String> allLinks = new CopyOnWriteArraySet<>();

    HashMap<String, SiteMap> mymap;
    int numCores = 8;

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
        if (numCores == 0) {
            return true;
        } else return false;
    }

    public boolean solve(int problem) {
        boolean boolresult;
        numCores = problem;
        if (problem_is_small()) {
            //directly solve problem
            //Main.frk();//new ForkJoinPool().invoke();

        } else {
	    /*
            split problem into independent parts
            fork new subtasks to solve each part
            join all subtasks
            compose result from subresults
	     */ //
            //new ForkJoinPool(numThreads).invoke(SiteMap);

        }
        boolresult = true;

        return true;//(MioResult) boolresult;
    }

    @Override
    protected String compute() {
        StringBuffer sb = new StringBuffer(url + "\n");
        Set<SiteMap> subTask = new HashSet<>();

        getManyChildren(subTask);
        for (SiteMap link : subTask) {
            try {
                sb.append(link.join());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    private void getManyChildren(Set<SiteMap> subTask) {
        Document doc;
        Elements elements;
        try {
            Thread.sleep(pause());

            if (debug) System.out.println(url);

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
            ignored.printStackTrace();
        }
    }
}
