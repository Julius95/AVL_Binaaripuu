package AVLBinääriPuu;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julius
 */
public class Main {

    /**
     * @param args the command line arguments
     *///http://stackoverflow.com/questions/3955680/how-to-check-if-my-avl-tree-implementation-is-correct
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();

        //Eri testi tapaukset, jotka kopioitu stackoverflowsta

        //Tapaus 2A Lisätään 15

       t.insert(20);
        t.insert(4);
        t.insert(26);
        t.insert(3);
        t.insert(9);
        t.insert(15);//Insert 15
        //t.insert(6);
//		t.insert(2);
//		t.insert(9);
//		t.insert(1);
//		t.insert(4);
//		t.insert(8);
//		t.insert(11);
//		t.insert(3);
//		t.insert(5);
//		t.insert(7);
//		t.insert(10);
//		t.insert(12);
//		t.insert(13);
//		t.delete(1);
//        t.preOrder();
//        System.out.println("----------");
        t.innerOrder();
        t.preOrder();
        //System.out.println("get size " + t.getSize() + " " + t.find(2).getRoot().getBalance());

//        //Tapaus 3A Lisätään 15
//    	t.insert(20);
//        t.insert(4);
//        t.insert(26);
//        t.insert(9);
//        t.insert(21);
//        t.insert(3);
//        t.insert(30);
//        t.insert(2);
//        t.insert(7);
//        t.insert(11);
//        t.insert(15);//Insert 15
//        t.preOrder();


        //System.out.println("----------");

        //Tapaus 3B Lisätään 8
//        t.insert(20);
//        t.insert(4);
//        t.insert(26);
//        t.insert(3);
//        t.insert(9);
//        t.insert(21);
//        t.insert(30);
//        t.insert(2);
//        t.insert(7);
//        t.insert(11);
//        t.insert(8);
//        t.preOrder();
//        t.innerOrder();
    }

}
