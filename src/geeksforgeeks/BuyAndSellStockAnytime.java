package geeksforgeeks;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BuyAndSellStockAnytime {

    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                total += prices[i + 1] - prices[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        BuyAndSellStockAnytime stock = new BuyAndSellStockAnytime();
        int[] arr = { 7, 1, 5, 6, 4 };
        //100, 180, 260, 310,40, 535, 695
        System.out.println(stock.maxProfit(arr));
    }
}
