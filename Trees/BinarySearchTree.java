package Trees;

/*
Average Case for Searching, Insertion, and Deletion: Logarithmic. Worst Case: Linear.

Other Trees (same average time complexities, but better (logarithmic) worst cases.
B-Tree -         Used for storage backend (e.g. HDD) since requires less reads to disk.
Red-Black Tree - Used when more insertions/deletions relative to lookups.
AVL Tree -       Used when more lookups relative to insertions/deletions.
*/

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        }
        else {
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;

                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    public void levelOrderTraversal(Node focusNode) {
        if (focusNode == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(focusNode);

        while (!q.isEmpty()) {
            focusNode = q.poll();
            System.out.println(focusNode);
            if (focusNode.leftChild != null) {
                q.add(focusNode.leftChild);
            }
            if (focusNode.rightChild != null) {
                q.add(focusNode.rightChild);
            }
        }
    }

    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    public void preOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }

    public void postOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;

        while(focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            }
            else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public boolean remove(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        while (focusNode.key != key) {
            parent = focusNode;

            if (key < focusNode.key) {
                isLeftChild = true;
                focusNode = focusNode.leftChild;
            } else {
                isLeftChild = false;
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return false;
            }
        }
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        }

        else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.rightChild;
            }
        }
        else {
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root) {
                root = replacement;
            }
            else if (isLeftChild) {
                parent.leftChild = replacement;
            }
            else {
                parent.rightChild = replacement;
            }
            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.rightChild;

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }

    public static void main(String[] args) {
        BinarySearchTree theTree = new BinarySearchTree();

        theTree.addNode(1, "A");
        theTree.addNode(2, "B");
        theTree.addNode(3, "C");
        theTree.addNode(4, "D");
        theTree.addNode(5, "E");
        theTree.addNode(100, "F");

        theTree.remove(1);
        theTree.addNode(101, "Z");
        System.out.println(theTree.findNode(3));

        System.out.println("---");
        theTree.inOrderTraversal(theTree.root);
        System.out.println("---");
        theTree.levelOrderTraversal(theTree.root);
    }
}

class Node {
    int key;
    String name;
    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has key " + key;
    }
}