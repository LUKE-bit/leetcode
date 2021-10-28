class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1 = new Stack<>();
        if(s.length() % 2 != 0) {
            return false;
        }
        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }
        for(int i = 0;i < s.length();i++) {
            char l = s.charAt(i);
            if(l == '(' || l == '{' || l == '[') {
                s1.push(l);
            }else {
                if(s1.isEmpty()) {
                    return false;
                }
                while(!s1.isEmpty()) {
                    char c = s1.pop();
                    boolean flag = false;
                    switch(c) {
                        case '(' :
                            if(l != ')') return false;
                            else flag = true;
                            break;
                        case '{' :
                            if(l != '}') return false;
                            else flag = true;
                            break;
                        case '[' :
                            if(l != ']') return false;
                            else flag = true;
                            break;
                    } 
                    if(flag) {
                        break;
                    } 
                }
            }
        }
        if(s1.isEmpty()) {
            return true;
        }
        return false;
    }
}


//代码随想录
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }
}
