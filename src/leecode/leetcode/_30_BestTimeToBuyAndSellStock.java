package leecode.leetcode;

/**
 * 1-24
 */
public class _30_BestTimeToBuyAndSellStock {
    //暴力循环（leetcode会超时）
//    public static int maxProfit(int[] prices) {
//        int maximum = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (maximum < prices[j] - prices[i]) {
//                    maximum = prices[j] - prices[i];
//                }
//            }
//        }
//        return maximum;
//    }

    //动态规划
    public static int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int maximum = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > maximum) {
                maximum = price - min;
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,4,1}));
    }
}
