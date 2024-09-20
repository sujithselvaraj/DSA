package queue;

import java.util.*;



class CircularQueue{
    int front;
    int rear;
    int size;
    int queue[];
    CircularQueue(int n)
    {
        queue= new int[n];
        front=-1;
        rear=-1;
        size=n;

    }

    void enqueue(int data)
    {
        if(((rear+1)%size)==front)
        {
            System.out.println("queue is full");
        }
        else if(front ==-1 && rear==-1)
        {
            //what if no elements is present
            front=rear=0;
            queue[rear]=data;

        }
        else {
            //what if queue is not full
            rear=(rear+1)%size;
            queue[rear]=data;

        }
    }


    void dequeue()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("queue is empty");

        }
        else if(front==rear) {
            //what if only one element in the queue
            front=rear=-1;

        }
        else {
            ///what if queue has an element and full

            front=(front+1)%size;
        }

    }
    void display()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("queue is empty");
        }
        else {
            System.out.println("elements in cqueue are");
            for(int i=front;i!=rear;i=(i+1)%size)
            {
                System.out.println(queue[i]);

            }
            System.out.println(queue[rear]);

        }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of cqueue");
        int n=sc.nextInt();
        CircularQueue circularQueue=new CircularQueue(n);
        System.out.println("Enter the elements in cqueue");
        for(int i=1;i<=n;i++)
        {
            circularQueue.enqueue(sc.nextInt());
        }
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.display();


    }
}

