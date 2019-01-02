import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raj on 1/2/2019.
 */
public class DiceRoll {

    public static void main(String[] args) {
        //diceRoll(3);
        diceSum(3, 7);
    }

    private static void diceRoll(int numOfDice) {
        diceRollHelper(numOfDice, new ArrayList<>());
    }

    private static void diceRollHelper(int availableDice, List<Integer> chosen) {
        if (availableDice == 0) {
            //print this combo
            System.out.println(chosen);
        } else {
            //availableDice left to Roll.  Let's roll one
            for(int i = 1; i <= 6; i++) {
                //choose
                chosen.add(i);
                //explore
                diceRollHelper(availableDice - 1, chosen);
                //unchoose
                chosen.remove(chosen.size() - 1);

            }
        }
    }

    private static void diceSum(int numOfDice, int desiredSum) {
        diceSumHelper(numOfDice, desiredSum, 0, new ArrayList<>());
    }

    private static void diceSumHelper(int availableDice, int desiredSum, int sumSoFar, List<Integer> chosen) {
        if (availableDice == 0 && sumSoFar == desiredSum) {
            //print this combo
            System.out.println(chosen);
        } else {
            //availableDice left to Roll.  Let's roll one
            for(int i = 1; i <= 6; i++) {
                int potentialMinimumSum = sumSoFar + i + 1*(availableDice - 1);
                int potentialMaximumSum = sumSoFar + i + 6*(availableDice - 1);
                if (potentialMinimumSum <= desiredSum && potentialMaximumSum >= desiredSum) {
                    //choose
                    chosen.add(i);
                    //explore
                    diceSumHelper(availableDice - 1, desiredSum, sumSoFar + i, chosen);
                    //unchoose
                    chosen.remove(chosen.size() - 1);
                }


            }
        }

    }
}
