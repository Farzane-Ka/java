package com.example.awtSample;


import org.w3c.dom.Node;

public class LinkedListTest {

    public static void main(String[] args) {
        // write your code here
        LinkedList linkedList=new LinkedList();
        linkedList.add(new LinkedList.Node("Hi"));
        linkedList.add(new LinkedList.Node("this"));
        linkedList.add(new LinkedList.Node("is"));
        linkedList.add(new LinkedList.Node("summer"));
        linkedList.print(linkedList.revers(linkedList.head()));

        LinkedList.Node head= linkedList.head();
        int length=0;
        LinkedList.Node current= head;
        LinkedList.Node middle=head;
        while (current.next()!=null){
            length++;
            System.out.println(current);
            if (length%2==0){
                middle=middle.next();
            }
            current=current.next();
        }
        if (length%2==1){
            middle=middle.next();
        }
        System.out.println("length of linkedList: "+ length);
        System.out.println("middle element: "+middle);
    }
}

class LinkedList{
    private Node head;
    private Node tail;
    public LinkedList(){
        this.head=new Node("head");
        this.tail=this.head;
    }
    public Node head(){
        return head;
    }
    public Node tail(){
        return tail;
    }
    public void add(Node node){
        tail.next=node;
        tail=node;
    }
    public boolean hasNext(Node node){
        if (node.next!=null)
            return true;
        else
            return false;
    }
    public int size(){
        Node current=this.head;
        int length=0;
        while (current.next!=null){
            length++;
        }
        return length;
    }
    public Node revers(Node node){
       Node prev=null;
       Node current=node;
       Node next=null;
       while(current!=null){
           next=current.next;
           current.next=prev;
           prev=current;
           current=next;
       }
       return prev;
    }
    public void print(Node node){
        System.out.println("reverse is: ");
        while (node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
    public static class Node{
        private Node next;
        private String data;
        public Node(String data){
            this.data=data;
        }
        public String data(){
            return this.data;
        }
        public Node next(){
            return this.next;
        }
        public void set(String data){
            this.data=data;
        }
        public void setNext(Node next){
            this.next=next;
        }
        public String toString(){
            return this.data;
        }
    }
}

