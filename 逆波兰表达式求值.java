class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> num = new Stack<>();
        for(int i = 0;i < tokens.length;i++) {
            if("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])) {
                int b = (int)Integer.valueOf(num.pop());
                int a = (int)Integer.valueOf(num.pop());
                if("+".equals(tokens[i])) {
                    int c = a + b;
                    num.push(String.valueOf(c));
                }else if ("-".equals(tokens[i])) {
                    int c = a - b;
                    num.push(String.valueOf(c));
                }else if ("*".equals(tokens[i])) {
                    int c = a * b;
                    num.push(String.valueOf(c));
                }else if ("/".equals(tokens[i])) {
                    int c = a / b;
                    num.push(String.valueOf(c));
                }
            }else {
                num.push(tokens[i]);
            }
        }
        return (int)Integer.valueOf(num.pop());
    }
}
