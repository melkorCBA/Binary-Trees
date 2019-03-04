package starcba;

public class Tree {
    public Node root;

    public void insert(int data) {
        Node newNode = new Node(data);
        Node parentNode = root, currentNode = root;
        if (currentNode == null) {
            root = newNode;
        } else {
            while (currentNode != null) {
                if (data >= currentNode.data) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                }
            }
            if (data >= parentNode.data) {
                parentNode.right = newNode;
            } else {
                parentNode.left = newNode;
            }
        }

    }


    public Node find(int key) {

        Node currentNode = this.root;

        while (currentNode.data != key) {
            if (currentNode.data >= key) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
            if (currentNode == null) return null;
        }

        return currentNode;
    }

    //LNR
    public void inOrderTraverse(Node localNode) {

        if (localNode != null) {
            inOrderTraverse(localNode.left);
            System.out.print(localNode.data + ", ");
            inOrderTraverse(localNode.right);
        } else {
            return;
        }
    }

    public void preOrdertTraverse() {
    }

    public void postorderTraverse() {
    }

    public void delete(int key) {
        Node parentNode, unNode;

        //find the node with parent Node;
        parentNode = unNode = root;
        while (unNode != null) {
            if (key == unNode.data) {
                break;

            } else if (key >= unNode.data) {
                parentNode = unNode;
                unNode = unNode.right;
            } else {
                parentNode = unNode;
                unNode = unNode.left;
            }
        }

        if (unNode != null) {

            //Case 1 - check - leaf Node
            if (unNode.right == null && unNode.left == null) {
                if (parentNode.right == unNode) {
                    parentNode.right = null;
                } else {
                    parentNode.left = null;
                }

            } else if (unNode.right == null) {
                //Case 2 -only left child
                if (unNode == root) {
                    //root?
                    root = unNode.left;
                } else {
                    if (parentNode.right == unNode) {
                        //deleting node - parents' right node
                        parentNode.right = unNode.left;
                    } else {
                        //deleting node - parents' left node
                        parentNode.left = unNode.left;
                    }

                }

            } else if (unNode.left == null) {
                //Case 3 - only right child
                if (unNode == root) {
                    //root?
                    root = unNode.right;
                } else {
                    if (parentNode.right == unNode) {
                        //deleting node - parents' right node
                        parentNode.right = unNode.right;
                    } else {
                        //deleting node - parents' left node
                        parentNode.left = unNode.right;
                    }
                }
            } else {

                Node[] successor = inOrderSuccessor(unNode.right, unNode, new Node[2]);
                //Case 4 -have both children
                if (unNode.right == successor[1]) {
                    //case 4.1 - successor-right child of the deleting node
                    if (unNode == root) {
                        //deleting root node
                        root = successor[1];
                        root.left = unNode.left;
                    } else
                        //successor-right child of the deleting node
                        if (parentNode.right == unNode) {
                            //deleting node - parent's right child
                            parentNode.right = successor[1];

                        } else {
                            //deleting node - parent's left child
                            parentNode.left = successor[1];
                        }

                    successor[1].left = unNode.left;


                } else {
                    ////Case 4.2 -  Successor is left descendant of right child of deleting node
                    //need to know the successor's parent
                    //successor[1].right=unNode.right;
                    successor[0].left = successor[1].right;
                    successor[1].right = unNode.right;


                    if (parentNode.right == unNode) {
                        //deleting node - parent's right child
                        parentNode.right = successor[1];

                    } else {
                        //deleting node - parent's left child
                        parentNode.left = successor[1];
                    }
                    successor[1].left = unNode.left;


                }


            }
        } else {
            System.out.println("No such item !!");
        }

    }

    public Node[] inOrderSuccessor(Node currentNode, Node parent, Node[] successorNodes) {

        //successorNodes[0] - successor's parent
        //successorNodes[1] - successor
        successorNodes[0] = parent;
        if (currentNode.left == null) {
            successorNodes[1] = currentNode;
            return successorNodes;
        }

        return inOrderSuccessor(currentNode.left, currentNode, successorNodes);
    }




}
