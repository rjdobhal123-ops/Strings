public class Rabin_Karp {
    public static int repeatedStringMatch(String a, String b) {
        StringBuilder repeated=new StringBuilder(a);
        int count=1;

        //increase length of a uptill length of b
        while (repeated.length()<b.length()) {
            repeated.append(a);
            count++;
        }

        //Check current Repetition
        if (rabinKarp(repeated.toString(), b))
            return count;

        //One additional repetition is also necessary
        repeated.append(a);
        count++;

        if (rabinKarp(repeated.toString(), b))
            return count;

        return -1;
    }

    private static boolean rabinKarp(String text, String pattern) {
        int n=text.length();
        int m=pattern.length();

        if (m>n)
            return false;

        long base=26;
        long highestpower=1;
        for (int i = 1; i < m; i++) {
            highestpower*=base;
        }

        long patternHash=0;
        for (int i = 0; i < m; i++) {
            patternHash=patternHash*base+(pattern.charAt(i)-'a'+1);
        }

        long windowHash=0;
        for (int i = 0; i < m; i++) {
            windowHash=windowHash*base+(text.charAt(i)-'a'+1);
        }

        //Check every window of size of pattern in text
        for (int i = 0; i <=n-m; i++) {
            if (patternHash==windowHash){
                if (text.substring(i, i+m).equals(pattern))
                    return true;
            }
            if (i<n-m){
                int outgoing=text.charAt(i)-'a'+1;
                int incoming=text.charAt(i+m)-'a'+1;
                windowHash=(windowHash-outgoing*highestpower)*base+incoming;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd","cdabcdab"));
    }
}
