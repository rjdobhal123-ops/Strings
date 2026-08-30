
public class Count_and_Say {
    public static String countAndSay(int n) {
        StringBuilder s=new StringBuilder("1");
        for (int k = 2; k <=n; k++) {
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                int j = i;
                while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                int len = j - i;
                result.append(len);
                result.append(s.charAt(i));
                i = j;
            }
            s=result;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }


}
