package algorithm.dp;

public class KnapsackTopDown {
    private int[] profits;
    private int[] weights;
    private Integer[][] cache;

    public KnapsackTopDown(int[] profits, int[] weights) {
        this.profits = profits;
        this.weights = weights;
    }

    // top down
    public int solveKnapsack(int capacity) {
        cache = new Integer[profits.length][capacity+1];
        return helper(0, capacity, 0);
    }

    private int helper(int index, int capacity, int curProfits) {

        if (capacity < 0) {
            return 0;
        }

        if (index >= profits.length) {
            return 0;
        }

        if (cache[index][capacity] != null) {
            return cache[index][capacity];
        }

        // take current item
        int take = helper(index + 1, capacity - weights[index], curProfits + profits[index]);

        // skip current item
        int skip = helper(index + 1, capacity, curProfits);

        cache[index][capacity] = Math.max(take, skip);

        return cache[index][capacity];
    }

    public static void main(String[] args) {
        KnapsackTopDown k1 = new KnapsackTopDown(new int[]{1,6,10,16}, new int[]{1,2,3,5});
        System.out.println(k1.solveKnapsack(7));//22

        KnapsackTopDown k2 = new KnapsackTopDown(new int[]{60,50,30,70}, new int[]{5,3,4,2});
        System.out.println(k2.solveKnapsack(8));//120

        KnapsackTopDown k3 = new KnapsackTopDown(new int[]{60,100,120,80, 30}, new int[]{10,20,30,40, 50});
        System.out.println(k3.solveKnapsack(400));//390
    }


}
