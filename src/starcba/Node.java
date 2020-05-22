package starcba;

public class Node {
    public int data; //key
    public Node right;
    public Node left;

    public Node(int data) {
        this.data = data;
    }

    public void printNode(){
        System.out.println("element: "+this);
        System.out.println("left child: "+left);
        System.out.println("left child: "+right);
    }
}
