package WellsFargo;

import java.util.List;

/**
 * Created by rpatel on 5/18/17.
 */
public interface Branch {
    int getNumberOfFlowers();
    List<Branch> getChildBranches();
}
