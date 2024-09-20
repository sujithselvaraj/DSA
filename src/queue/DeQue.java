package queue;


import java.util.*;

public class DeQue {
    int queue[];
    int front;
    int rear;
    int size;

    DeQue(int n){
        front=-1;
        rear=-1;
        size=n;
        queue=new int[n];
    }

    void enqueuefront(int frontdata)
    {
        if((front==0 && rear==size-1)||(front==rear+1))
        {
            //what if queue is full
            System.out.println("overflow");
        }
        else if((front==-1) &&(rear==-1))
        {
            //what if queue is empty
            front=rear=0;
            queue[front]=frontdata;
        }
        else if(front==0)
        {
            //if front is occupied ,in the circular it is goes to the rear in circular way
            front=size-1;
            queue[front]=frontdata;
        }
        else {
            //
            front--;
            queue[front]=frontdata;
        }

    }
    void enqueuerear(int reardata)
    {
        if((front==0 && rear==size-1)||(front==rear+1))
        {
            //what if queue is full
            System.out.println("overflow");
        }
        else if(front==-1 && rear==-1)
        {
            //what if queue is empty
            front=rear=0;
            queue[rear]=reardata;
        }
        else if(rear==size-1)
        {
            //if the rear is assigned,the next value is stored into the 1st front position due to circular queue
            rear=0;
            queue[rear]=reardata;


        }
        else {
            rear++;
            queue[rear]=reardata;
        }

    }

    void display()
    {
//		for(int i=front;i!=rear;i=(i+1)%size)
//		{
//			System.out.println(queue[i]);
//		}

        int i=front;
        while(i!=rear)
        {
            System.out.println(queue[i]);
            i=(i+1)%size;
        }
        System.out.println(queue[rear]);


    }
    void getfront()
    {
        System.out.println(queue[front]);
    }

    void dequeuefront()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("empty queue");
        }
        else if(front==rear)
        {
            //what if only one element in queue
            front=rear-1;
        }
        else if (front==size-1)
        //what if the element is at the last of queue
        {
            front=0;
        }
        else {
            //normal if used for all
            front++;
        }
    }

    void dequeuerear()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("empty queue");
        }
        else if(front==rear)
        {
            front=rear-1;
            //if only one element in a queue
        }
        else if(rear==0)
        {
            //rear points to the first value and after deleting element in a queue it points to rear value in a queue due to circular
            rear=size-1;
        }
        else {
            rear--;
        }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        int n=5;
        DeQue dq=new DeQue(n);
        dq.enqueuefront(2);
        dq.enqueuefront(5);
        dq.enqueuerear(-1);
        dq.enqueuerear(0);
        dq.enqueuefront(7);
        dq.display();
        dq.getfront();
        dq.dequeuefront();
        dq.dequeuerear();
        dq.dequeuefront();
        dq.display();

    }
}
