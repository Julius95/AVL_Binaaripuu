/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class BinaryTree {

    private Node root;

    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }
    public BinaryTree(){
        root = null;
    }
    public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    }

    public boolean insert(String aData){
        if(root==null){
            root = new Node(aData);
            return true;
        }
        else if(root.getData().compareTo(aData)>0)
        {
            if(root.left()!=null)
            {
                boolean res = root.left().insert(aData);
                this.recalculateHeight();
                return res;
            }
            else
            {
                BinaryTree b = new BinaryTree(aData);
                root.setLeft(b);
                this.recalculateHeight();
                return true;
            }
        }
        else
        {
            if(root.getData().equals(aData))//onko duplicate
                return false;
            else if(root.right() != null)
            {
                boolean res = root.right().insert(aData);
                this.recalculateHeight();
                return res;
            }
            else
            {
                BinaryTree b = new BinaryTree(aData);
                root.setRight(b);
                this.recalculateHeight(); //rekursiivinen
                return true;
            }
        }
    }

    public BinaryTree find(String aData){

        if(root==null)return null;
        if(root.getData().equals(aData))
        {
            return this;
        }
        else if(root.getData().compareTo(aData)>0)
        {
            if(root.left()!=null)
            {
                return root.left().find(aData);
            }
            else
            {
                return null;
            }
        }
        else
        {
            if(root.right() != null)
            {
                return root.right().find(aData);
            }
            else
            {
                return null;
            }
        }
    }

    public boolean delete(String aData)
    {
        if(root == null)return false;
        else
            return this.remove(aData, null);
    }

    private boolean remove(String aData,Node parent)
    {
        boolean res;
        if(this.root.getData().equals(aData))
        {
            if (root.left() != null && root.right() != null) { //kaksi lasta
                String temp = root.right().FindMin();
                root.right().remove(temp, root);
                root.setData(temp);
            }else if(parent == null){ //yritetään poistaa root jolla yksi lapsi tai ei yhtään lapsia
                if(root.left() != null || root.right() != null){ //jos rootilla edes yksi lapsi ei ole null
                    if(root.left()!=null)
                        root = root.left().root;
                    else
                        root = root.right().root;
                }else //Rootilla ei ole lapsia
                    root = null;
                return true;
            } else if (parent.left()!=null && parent.left().root==root) { //lapsi vasemmalla
                parent.setLeft(root.left() != null ? root.left() : root.right());
            } else if (parent.right() != null && parent.right().root == root) { //lapsi oikealla
                parent.setRight(root.left() != null ? root.left() : root.right());
            }
            this.recalculateHeight();
            return true;
        }
        else if(root.getData().compareTo(aData)>0)
        {
            if(root.left()!=null)
            {
                res = root.left().remove(aData, root);
                this.recalculateHeight();
                return res;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(root.right() != null)
            {
                res = root.right().remove(aData, root);
                this.recalculateHeight();
                return res;
            }
            else
            {
                return false;
            }
        }
    }

    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+','+ "Height of this node = " + root.getHeight() + ", Balance = " + root.getBalance());
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }
    }

    public void innerOrder(){
        if(root!=null){
            if(root.left()!=null)
                root.left().innerOrder();
            System.out.println(root.getData()+','+ "Height of this node = " + root.getHeight() + ", Balance = " + root.getBalance());
            if(root.right()!=null)
                root.right().innerOrder();
        }
    }

    public String FindMin() //Keep going left from a right sub-tree
    {
        if(root.left()==null)
            return root.getData();
        else
            return root.left().FindMin();
    }

    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }

    public void recalculateHeight()
    {
        int vasen = root.left()==null ? -1 : root.left().root.getHeight();
        int oikea = root.right()==null ? -1 : root.right().root.getHeight();
        root.setHeight(1+Math.max(vasen , oikea));
        root.setBalance(vasen-oikea);
        this.AVL_Check();
    }

    public void AVL_Check()
    {
        if(root.getBalance() <= 1 && root.getBalance() >= -1)
            return;
        if(root.getBalance()>1)
        {
            System.out.println("right Rotation");
            if(root.left().root.right()!=null && root.left().root.left()==null)
            {
                System.out.println("LeftRight rotation");
                leftRotation(root.left(), root.left().root.right());
            }
            rightRotation(this, root.left());
        }else{
            System.out.println("left Rotation");
            if(root.right().root.left()!=null && root.right().root.right()==null)
            {
                System.out.println("RightLeft rotation");
                rightRotation(root.right(), root.right().root.left());
            }
            leftRotation(this, root.right());
        }
    }

    public void rightRotation(BinaryTree Parent,BinaryTree LeftChild)
    {
        System.out.println("Parent : " + Parent.root.getData() + " LeftChild " + LeftChild.root.getData());
        String temp = Parent.root.getData();
        Parent.root.setData(LeftChild.root.getData());
        Parent.root.setLeft(LeftChild.root.left());
        LeftChild.root.setData(temp);
        LeftChild.setLeft(LeftChild.root.right());
        LeftChild.setRight(Parent.root.right());
        Parent.root.setRight(LeftChild);
        LeftChild.root.checkHeight();
        Parent.root.checkHeight();
    }

    public void leftRotation(BinaryTree Parent,BinaryTree RightChild)
    {
        System.out.println("Parent : " + Parent.root.getData() + " LeftChild " + RightChild.root.getData());
        String temp = Parent.root.getData();
        Parent.root.setData(RightChild.root.getData());
        Parent.root.setRight(RightChild.root.right());
        RightChild.setRight(RightChild.root.left());
        RightChild.setLeft(Parent.root.left());
        Parent.root.setLeft(RightChild);
        RightChild.root.setData(temp);
        RightChild.root.checkHeight();
        Parent.root.checkHeight();
    }

    public Node getRoot()
    {
        return root;
    }

}
