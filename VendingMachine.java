import java.util.Random;
//import java.lang.Character;

public class VendingMachine {
    public static double totalSales;
    private VendingItem[][][] grid;
    private int freeChance;
    private Random rand;

    public VendingMachine() {
        totalSales = 0;
        grid = new VendingItem[6][3][5];
        rand = new Random();
        restock();
        freeChance = 0;

    }

    public VendingItem vend(String code) {
        char charArr[] = code.toCharArray();
        char rowCode = charArr[1];

        int nRow = Character.getNumericValue(rowCode) 
            - Character.getNumericValue('A');
        // cannot call methods to a primitive object. 

        int nCol = Character.getNumericValue(charArr[1]);
        // find nCol

        VendingItem item = grid[nRow][nCol][0];
        if(item != null) {
            for(int i = 0; i < grid[nRow][nCol].length-1; i++) {
                    grid[nRow][nCol][i] = grid[nRow][nCol][i+1];
                }
            return item;
        } else {
            System.out.println("Out of order");
            return null;
        }
    }

    private boolean free() {
        boolean isFree = rand.nextInt(100) < freeChance;
        if(!isFree) {
            freeChance = freeChance + 1;
        } else {
            freeChance = 0;
        }
        return isFree;
    }

    public void restock() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                for(int k = 0; k < grid[i][j].length; k++) {
                    VendingItem itemList[] = VendingItem.values();
                    int r = rand.nextInt(itemList.length);
                    VendingItem name = itemList[r];
                    grid[i][j][k] = name;
                }
            }
        }
    }

    public static double getTotalSales() {
        return 0.0;
    }

    public int getNumberOfItems() {
        return 0;
    }

    public double getTotalValue() {
        return 0.0;
    }

    public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("----------------------------------------------------------"
        + "------------\n");
    s.append("                            VendaTron 9000                "
        + "            \n");
    for (int i = 0; i < grid.length; i++) {
        s.append("------------------------------------------------------"
            + "----------------\n");
        for (int j = 0; j < grid[0].length; j++) {
            VendingItem item = grid[i][j][0];
            String str = String.format("| %-20s ",
                (item == null ? "(empty)" : item.name()));
            s.append(str);
        }
        s.append("|\n");
    }
    s.append("----------------------------------------------------------"
        + "------------\n");
    s.append(String.format("There are %d items with a total "
        + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
    s.append(String.format("Total sales across vending machines "
        + "is now: $%.2f.%n", getTotalSales()));
    return s.toString();
}

}   