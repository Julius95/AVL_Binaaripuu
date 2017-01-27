
public class Node {
    private int data;
    private BinaryTree left;
    private BinaryTree right;
    private int height;
    private int balance;

    public Node(int value) {
        data = value;
        left = right = null;
        checkHeight();
    }
    public  Node (int value, BinaryTree left, BinaryTree right) {
        data = value;
        this.left = left;
        this.right = right;
        checkHeight();
    }
    public int getData() {
        return data;
    }
    public void setData(int s)
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
