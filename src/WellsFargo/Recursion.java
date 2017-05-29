package WellsFargo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rpatel on 5/18/17.
 */
public class Recursion {

    public static void main(String[] args) {
        Recursion rc = new Recursion();
        Branch mainBranch = rc.getMainBranch();
        int totalFlowers = rc.getTotalFlowers(mainBranch);
        System.out.println("Total flowers are " + totalFlowers);
    }

    public int getTotalFlowers(Branch branch) {
        int totalFlowers = branch.getNumberOfFlowers();
        if (branch.getChildBranches() != null) {
            for (Branch b: branch.getChildBranches()) {
                totalFlowers += getTotalFlowers(b);
            }
        }
        return totalFlowers;
    }

    /**
     *        |-- b2 (2)
     * b1(7) -|-- b3 (4) ----|---b5(1)
     *        |              |---b6(2)
     *        |---b4 (0) ---b7 (3) --- b8 (1)
     *
     * @return
     */
    public Branch getMainBranch() {
        Branch b8 = new Branch() {
            @Override public int getNumberOfFlowers() {
                return 1;
            }

            @Override public List<Branch> getChildBranches() {
                return null;
            }
        };
        Branch b7 = new Branch() {
            @Override public int getNumberOfFlowers() {
                return 3;
            }

            @Override public List<Branch> getChildBranches() {
                return Arrays.asList(b8);
            }
        };

        Branch b4 = new Branch() {
            @Override public int getNumberOfFlowers() {
                return 0;
            }

            @Override public List<Branch> getChildBranches() {
                return Arrays.asList(b7);
            }
        };

        Branch b5 = new Branch() {
            @Override public int getNumberOfFlowers() {
                return 1;
            }

            @Override public List<Branch> getChildBranches() {
                return null;
            }
        };

        Branch b6 = new Branch() {
            @Override public int getNumberOfFlowers() {
                return 2;
            }

            @Override public List<Branch> getChildBranches() {
                return null;
            }
        };

        Branch b3 = new Branch() {
            @Override public int getNumberOfFlowers() {
                return 4;
            }

            @Override public List<Branch> getChildBranches() {
                return Arrays.asList(b5, b6);
            }
        };

        Branch b2 = new Branch() {
            @Override public int getNumberOfFlowers() {
                return 2;
            }

            @Override public List<Branch> getChildBranches() {
                return null;
            }
        };

        Branch b1 = new Branch() {
            @Override public int getNumberOfFlowers() {
                return 7;
            }

            @Override public List<Branch> getChildBranches() {
                return Arrays.asList(b2, b3, b4);
            }
        };

        return b1;
    }

}
