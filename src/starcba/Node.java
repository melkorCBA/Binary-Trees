package starcba;

public class Node {
    public int data; //key
    public Node right;
    public Node left;

    public Node(int data) {
        this.data = data;
    }

    public void printNode(){
        System.out.println(data);
    }
}
