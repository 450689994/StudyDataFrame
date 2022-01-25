package leecode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1-18
 */
public class _17_ClimbingStairs {
    //暴力递归
//    public static int climbStairs(int n) {
//        if(n == 2)  return 2;
//        if(n == 1)  return 1;
//        return climbStairs(n-1) + climbStairs(n-2);
//    }
//    private static Map<Integer, Integer> map = new HashMap<>();
//    //递归优化
//    public static int climbStairs(int n) {
//        if(map.containsKey(n))
//            return map.get(n);
//        if(n == 2)  return 2;
//        if(n == 1)  return 1;
//        int i = climbStairs(n - 1) + climbStairs(n - 2);
//        if(!map.containsKey(n))
//            map.put(n,i);
//        return i;
//    }

//    //斐波那契
//    public static int climbStairs(int n) {
//        if(n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        int num1 = 1;
//        int num2 = 2;
//        for (int i = 3; i < n; i++) {
//            int temp = num2;
//            num2 = num1 + num2;
//            num1 = temp;
//        }
//        return num1+num2;
//    }

    //动态规划(和上面一样)
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
