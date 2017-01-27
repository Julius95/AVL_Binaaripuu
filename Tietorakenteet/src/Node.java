/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Node {
    private String data;
    private BinaryTree left;
    private BinaryTree right;
    private int height;
    private int balance;

    public Node(String value) {
        data = new String(value);
        left = right = null;
        checkHeight();
    }
    public  Node (String value, BinaryTree left, BinaryTree right) {
        data = new String(value);
        this.left = left;
        this.right = right;
        checkHeight();
    }
    public String getData() {
        return data;
    }
    public void setData(String s)
    {
        data = s;
    }
    public BinaryTree left() {
        return left;
    }
    public BinaryTree right() {
        return right;
    }
    public void setLeft(BinaryTree tree) {
        left = tree;
    }
    public void setRight(BinaryTree tree) {
        right = tree;
    }

    public int checkHeight() //rekursiivinen
    {
        int vasen = left==null ? -1 : left.getRoot().checkHeight();
        int oikea = right==null ? -1 : right.getRoot().checkHeight();
        this.height = 1+Math.max(vasen , oikea);
        this.balance = vasen-oikea;
        return height;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int i)
    {
        balance = i;
    }
}
