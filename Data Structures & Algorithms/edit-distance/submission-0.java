class Solution {
    public int minDistance(String word1, String word2) {
        int R = word1.length();
        int C = word2.length();

        int[][] dp = new int[R + 1][C + 1];

        /*
          ""m o n e y
        ""0 1 2 3 4 5
        m 1 0 1 2 3 4
        o 2 1 0 1 2 3
        n 3 2 1 0 1 2
        k 4 3 2 1 2 3
        e 5 4 3 2 1 2
        y 6 5 4 3 2 1
        s 7 6 5 4 3 2
        */

        for (int i = 0; i <= R; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= C; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                //System.out.println((i-1)+" "+(j-1)+" "+word1.charAt(i - 1)+" "+word2.charAt(j - 1));
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

       /* for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/

        return dp[R][C];
    }
}
