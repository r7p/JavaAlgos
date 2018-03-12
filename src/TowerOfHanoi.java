/**
 * To move numDisks from tower S(source) to D(Destination) using I(Intermediate) tower:
 * 1. Move numDisks-1 Disks from S to I
 * 2. Move remaining largest disk from S to D
 * 3. Move numDisks-1 from I to D using above process
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        moveDisks(3, 'S', 'I', 'D');
    }

    private static void moveDisks(int numDisks, char fromTower, char intermediateTower, char toTower) {
        if (numDisks == 1) {
            System.out.println("Move Disk 1 from " + fromTower + " to " + toTower);
        } else {
            //move numDisks-1 to intermediate tower from fromTower
            moveDisks(numDisks-1, fromTower, toTower, intermediateTower);
            System.out.println("Move Disk " + numDisks + " from " + fromTower + " to " + toTower);
            moveDisks(numDisks-1, intermediateTower, fromTower, toTower);
        }
    }
}
