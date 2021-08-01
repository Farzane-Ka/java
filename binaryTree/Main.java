package com.example.awtSample;


import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(3);

        binaryTree.traverseInorder(binaryTree.root);
        binaryTree.breadthFirstSearch();
    }
}
class BinaryTree{
    Node root;
    class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value=value;
            left=null;
            right=null;
        }
    }
    private Node addRecursively(Node current,int data){
        if (current==null){
            return new Node(data);
        }
        if (current.value > data){
            current.left=addRecursively(current.left,data);
        }
        if (current.value < data) {
            current.right = addRecursively(current.right, data);
        }
        else {// the node already exists
            return current;
        }
        return current;
    }
    public void add(int data){
        root=addRecursively(root,data);
    }

    public void traverseInorder(Node node){
        if (node==null){
            return;
        }
        traverseInorder(node.left);
        System.out.print(node.value+" ");
        traverseInorder(node.right);
    }

    public void breadthFirstSearch(){
        if (root==null){
            return;
        }
        Queue<Node> nodes=new LinkedList<>();
        nodes.add(root);
        System.out.println("\nBreadth search: ");
        while (!nodes.isEmpty()){
             Node node=nodes.remove();
            System.out.print(node.value+" ");
            if (node.left!=null)
                 nodes.add(node.left);
            if (node.right!=null)
                 nodes.add(node.right);

        }
    }

}
