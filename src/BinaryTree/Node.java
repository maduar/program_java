package BinaryTree;

/**
 * Created by maduar on 2017/1/22.
 */
public class Node {


    private char data;
    private Node lchild;
    private Node rchild;

    public Node() {

    }

    public Node getLchild() {
        return lchild;
    }

    public Node getRchild() {
        return rchild;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public void setLchild(Node lchild) {
        this.lchild = lchild;
    }

    public void setRchild(Node rchild) {
        this.rchild = rchild;
    }


    public Node(char ch, Node rchild, Node lchild) {
        this.data = ch;
        this.rchild = rchild;
        this.lchild = lchild;
    }

    public String toString() {
        return "" + getData();
    }
}

