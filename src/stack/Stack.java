package stack;

import java.util.*;

public class Stack {

    int top;
    int size;
    int a[];
    Stack(int n){
        top=-1;
        size=n;
        a=new int[n];
    }

    void push(int data) {
        if(top >= size-1)
            System.out.println("overflow");
        else
        {
            top++;
            a[top]=data;
        }
    }

    void pop() {
        if(top==-1){
            System.out.println("stack empty");}
        else {
            System.out.println("the poped element is "+a[top]);
            top--;
        }
    }

    void display()
    {
        System.out.println("elements in stack are");
        for(int i=top;i>=0;i--)
        {
            System.out.println(a[i]);
        }
    }


    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of stack");
        int  n=sc.nextInt();
        Stack stack=new Stack(n);
        System.out.println("enter the elements of stack");
        for(int i=0;i<n;i++) {
            stack.push(sc.nextInt());
        }
        stack.pop();
        stack.display();
    }

}

/*

1. reversal of a string
2. infix postfix
3. balanced parenthesis

*/