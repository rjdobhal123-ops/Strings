public class Z_function_algorithm {
    //Naive Approach-> O(n^2)
    static int[] zFunction(String s) {
        int n = s.length();
        int[] z = new int[n];

        for (int i = 1; i < n; i++) {

            while (i + z[i] < n &&
                    s.charAt(z[i]) == s.charAt(i + z[i])) {

                z[i]++;
            }
        }

        return z;
    }



    //Optimized approach->O(n)
    // using left and right pointers
    static int[] z_Function(String s) {

        int n = s.length();
        int[] z = new int[n];

        int l = 0;
        int r = 0;

        for (int i = 1; i < n; i++) {

            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n &&
                    s.charAt(z[i]) == s.charAt(i + z[i])) {

                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }
}
