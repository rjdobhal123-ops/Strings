public class Count_Palindrome {
    public int reccountPalindromes(String s) {
        char[] selected=new char[5];
        int[] dp=new int[s.length()];
        return subsequences(0, 0, s, s.length(), selected, dp);
    }

    public int subsequences(int index, int len, String s, int n, char[] selected, int[] dp){
        if (len==5){
            if (checkPalindrome(selected))
                return 1;
            return 0;
        }
        if (index>=n)
            return 0;
        if (dp[index]!=-1)
            return dp[index];

        int ignore=subsequences(index+1, len, s, n, selected, dp);
        selected[len]=s.charAt(index);
        int take=subsequences(index+1, len+1, s ,n, selected, dp);
        return dp[index]=ignore+take;
    }

    private boolean checkPalindrome(char[] selected) {
        return selected[0] == selected[4] && selected[1] == selected[3];
    }



    //Another method
    public int countPalindromes(String s) {

        int MOD = 1_000_000_007;
        int n = s.length();

        long[][] left = new long[10][10];
        long[][] right = new long[10][10];

        long[] rightFreq = new long[10];

        // Initially everything is on the right
        for (int i = n - 1; i >= 0; i--) {
            int x = s.charAt(i) - '0';

            for (int j = 0; j < 10; j++) {
                right[x][j] += rightFreq[j];
            }

            rightFreq[x]++;
        }

        long[] leftFreq = new long[10];

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int x = s.charAt(i) - '0';

            // Remove current character from right
            rightFreq[x]--;

            // Remove pairs starting with current character
            for (int j = 0; j < 10; j++) {
                right[x][j] -= rightFreq[j];
            }

            // Count:
            // left[a][b] * right[b][a]
            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {
                    ans = (ans + left[a][b] * right[b][a]) % MOD;
                }
            }

            // Add current character to left
            for (int j = 0; j < 10; j++) {
                left[j][x] += leftFreq[j];
            }

            leftFreq[x]++;
        }

        return (int) ans;
    }
}
