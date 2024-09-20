package tree;

import java.util.*;
class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}
public class Tree {
    Node root;

    public Tree()
    {
        root=null;
    }

    void insert(int data)
    {
        root=insertaction(root,data);
    }

    Node insertaction(Node root,int data)
    {
        if(root==null)
        {
            root=new Node(data);
            return root;
        }
        if(data<root.data)
        {
            root.left=insertaction(root.left,data);
        }
        else if(data>root.data)
        {
            root.right=insertaction(root.right,data);
        }
        return root;

    }

    void delete(int key)
    {
        root=deleteaction(root,key);
    }

    Node deleteaction(Node root,int key)
    {
        if(root==null)
        {
            return root;
        }
        if(key<root.data)
        {
            root.left=deleteaction(root.left,key);
        }
        else if(key>root.data)
        {
            root.right=deleteaction(root.right,key);
        }
        else
        {
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            root.data=minValue(root.right);
            root.right=deleteaction(root.right,root.data);
        }
        return root;
    }

    public int minValue(Node root)
    {
        int minv=root.data;
        while(root.left!=null)
        {
            minv=root.left.data;
            root=root.left;
        }
        return minv;
    }

    void inorder()
    {
        inorderaction(root);
    }

    public void inorderaction(Node root)
    {
        if(root!=null)
        {
            inorderaction(root.left);
            System.out.println(root.data+" ");
            inorderaction(root.right);
        }
    }

    public static void main(String args[])
    {
        Tree tree=new Tree();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            tree.insert(sc.nextInt());
        }
        tree.inorder();
        int key=sc.nextInt();
        tree.delete(key);
        tree.inorder();
    }
}
