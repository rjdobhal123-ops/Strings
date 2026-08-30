import java.util.Stack;

public class Valid_Parentheses {
    //Using Stack
    // T.C-> O(N) and S.C.-> O(N)
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='(')
                st.push(ch);
            else if(ch==')'){
                if(!st.isEmpty() && st.peek()=='(')
                    st.pop();
                else
                    st.push(ch);
            }

        }
        return st.size();
    }


    //Using two variables
    // T.C-> O(N) and S.C.-> O(1)
    public int minAddToMakeValidOptimal(String s) {
        int open=0;
        int add=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='(')
                open++;
            else if(ch==')'){
                if(open>0)
                    open--;
                else
                    add++;
            }

        }
        return open+add;
    }
}
