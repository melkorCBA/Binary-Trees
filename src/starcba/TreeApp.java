package starcba;

public class TreeApp {

    public static void main(String[] args) {
        Tree newTree=new Tree();
        newTree.insert(50);
        newTree.insert(75);
        newTree.insert(62);
        newTree.insert(87);
        newTree.insert(77);
        newTree.insert(93);
        newTree.insert(79);
        newTree.inOrderTraverse(newTree.root);
        System.out.println(" ");
        newTree.delete(93);
        newTree.inOrderTraverse(newTree.root);

    }
}
