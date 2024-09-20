package linkedlist;


import java.util.*;



class Node
{
    int data;
    Node next;

    Node()
    {
        next=null;
    }
    Node(int x)
    {
        data=x;
        next=null;
    }
}
public class LinkedList {

    public void insert(Node head,int x)
    {
        Node newnode=new Node(x);

        if(head==null)
        {
            //if linked list is empty,create a new node
            head=newnode;
        }
        else
        {
            //if linked list is not empty,we need to traverse the list and goes to last node and create an node in it
            Node tmp=head;

            while(tmp.next!=null)
            {
                tmp=tmp.next;
            }
            tmp.next=newnode;
        }
    }

    void delete(Node head,int key ) {
        Node tmp=head;
        Node prev=null;
        if(tmp!=null && tmp.data!=key)
        {
            prev=tmp;
            tmp=tmp.next;
        }

        while(tmp != null && tmp.data != key)
        {
            prev = tmp;
            tmp = tmp.next;
        }
        if(tmp==null)
            return;

        prev.next=tmp.next;
    }

    void insertstart(Node head,int x)
    {
        Node newnode=new Node(x);
        newnode.next=head.next;
        head.next=newnode;
    }

    void display(Node head)
    {
        Node tmp=head.next;
        while(tmp.next!=null)
        {
            System.out.println(tmp.data+" ");
            tmp=tmp.next;
        }
        System.out.println(tmp.data);
    }

    void insertpos(Node head,int data,int pos)
    {
        Node newnode=new Node(data);
        Node tmp=head;
        int count=1;

        if(pos==1)
        {
            newnode.next=head;
            head=newnode;
            return;
        }
        while(tmp!=null && count<pos-1)
        {
            tmp=tmp.next;
            count++;
        }
        if(tmp!=null)
        {
            newnode.next=tmp.next;
            tmp.next=newnode;
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedList list=new LinkedList();
        Node head=new Node();
        int n=sc.nextInt();
        System.out.println("enter the elements in the linked list");
        for(int i=0;i<n;i++)
        {
            list.insert(head,sc.nextInt());
        }
        list.display(head);
        System.out.println("Enter the element to insert in the first position of node");
        int x=sc.nextInt();
        list.insertstart(head, x);
        list.display(head);

        System.out.println("Enter the value to be deleted");
        int key=sc.nextInt();
        list.delete(head,key);
        list.display(head);
    }

}

