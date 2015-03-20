package ru.kpfu.itis.group408.marushkai.stack;

/**
 * Created by unlim_000 on 20.03.2015.
 */
public class BracketAnalyzer {
    private SuperStack<Character> stack;

    public BracketAnalyzer(ArrayStack<Character> arrayStack){
        this.stack = arrayStack;
    }

    public boolean check(String str){
        try {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                if (str.charAt(i) == '{') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                if (str.charAt(i) == '[') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                }
            }
        } catch (Exception e){
            System.out.println("Looks like null pointer... check pop() and peek() methods");
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
