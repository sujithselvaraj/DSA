package queue;


import java.util.*;

public class Queue {

    int front;
    int rear;
    int size;
    int a[];
    Queue(int n){
        front=-1;
        rear=-1;
        size=n;
        a=new int[n];

    }

    void enqueue(int data) {
        if(rear==size-1) {
            System.out.println("queue full");

        }
        else if(front==-1 && rear==-1){
            front=rear=0;
            a[rear]=data;
        }
        else {
            rear++;
            a[rear]=data;
        }
    }


    void dequeue()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("queue overflow");
        }
        else if(front==rear){
            front=rear=-1;

        }
        else {

            front++;}

    }

    void display()
    {
        System.out.println("elements in the queue are");
        for(int i=front;i<rear+1;i++) {
            System.out.println(a[i]);
        }
    }

    public static void  main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of queue");
        int n=sc.nextInt();

        Queue queue=new Queue(n);
        System.out.println("enter the elements in a queue");
        for(int i=0;i<n;i++) {
            queue.enqueue(sc.nextInt());

        }

        queue.dequeue();
        queue.display();


    }


}

