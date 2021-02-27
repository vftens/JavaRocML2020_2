import java.util.HashMap;

import static java.lang.Math.random;

public class SiteMap {

    HashMap<String, SiteMap> mymap;

    public SiteMap(String s) {

    }

    int pause(){
        return (int) (100+(50*random()));
    }

    boolean problem_is_small() {
        return;
    }

    MioResult solve(MioProblem problem) {
        boolean boolresult;
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

}
