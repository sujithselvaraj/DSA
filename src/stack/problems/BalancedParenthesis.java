package stack.problems;

import java.util.*;
class Sstack{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Sstack(int max)
    {
        maxSize=max;
        stackArray =new char[maxSize];
        top=-1;
    }
    public void push(char j)
    {
        stackArray[++top]=j;
    }
    public char pop()
    {
        return stackArray[top--];
    }

    public boolean isEmpty()
    {
        return (top==-1);
    }

}
public class BalancedParenthesis {

    public static boolean balancedparanthsis(String inputStr)
    {
        Sstack stack=new Sstack(inputStr.length());
        char[] charArray = inputStr.toCharArray();


        for (int i = 0; i < charArray.length; i++) {

            char current = charArray[i];

            //check whether current is '(', '[' or '{'
            if (current == '{' || current == '[' || current == '(') {
                // push current to stack
                stack.push(current);
                continue;
            }
            // if stack is empty, return false
            if (stack.isEmpty()) {
                return false;
            }
            // use switch statement to pop element from stack and if it is '(', '[' or '{', return false
            char popChar;
            switch (current) {
                case ')':
                    popChar = (char) stack.pop();
                    if (popChar == '{' || popChar == '[')
                        return false;
                    break;

                case '}':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '[')
                        return false;
                    break;

                case ']':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String args[])
    {
        String inputStr;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a input String ");
        inputStr=sc.nextLine();
        if(balancedparanthsis(inputStr))
        {
            System.out.println("balanced");
        }
        else {
            System.out.println("not balanced");
        }
    }
}

