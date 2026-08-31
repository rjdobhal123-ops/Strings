public class Knuth_Morris_Prutt_algorithm {
    //Using simple naive approach
    public int findfirstOcuurence(String haystack, String needle){
        int n=haystack.length();
        int m=needle.length();

        for (int i = 0; i <= n-m; i++) {
            int j=0;
            while (j<m && haystack.charAt(i+j)==needle.charAt(j))
                j++;

            if (j==m)
                return i;
        }
        return -1;
    }


    //Using KMP algorithm
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();

            // Build LPS array for needle
            int[] lps = new int[m];

            int len = 0;
            int i = 1;

            while (i < m) {
                if (needle.charAt(i) == needle.charAt(len)) {
                    lps[i] = len + 1;
                    len++;
                    i++;
                } else {
                    if (len != 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }

            // KMP search
            i = 0;
            int j = 0;

            while (i < n) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;

                    if (j == m) {
                        return i - j;
                    }
                } else {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }

            return -1;
        }
    }


