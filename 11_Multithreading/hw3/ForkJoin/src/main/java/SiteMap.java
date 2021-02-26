import java.util.HashMap;

public class SiteMap {

    HashMap<String, SiteMap> mymap;

    public SiteMap(String s) {

    }

    boolean problem_is_small(){
        return ;
    }

    MioResult solve(MioProblem problem) {
        boolean boolresult;
        if (problem_is_small()) {
            //directly solve problem
        }
	else {
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
