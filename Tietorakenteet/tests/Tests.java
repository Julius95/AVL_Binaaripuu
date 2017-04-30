import static org.junit.Assert.*;

import org.junit.Test;

import AVLBinääriPuu.BinaryTree;

public class Tests {

	@Test
	public void Case3b() {
		BinaryTree t = new BinaryTree();
		t.insert(20);
        t.insert(4);
        t.insert(26);
        t.insert(3);
        t.insert(9);
        t.insert(21);
        t.insert(30);
        t.insert(2);
        t.insert(7);
        t.insert(11);
        t.insert(8);//Add 8 to inbalance
        int[] lista = t.preOrderArray(new int[11]);
        int[] oikea_jarjestys = {9,4,3,2,7,8,20,11,26,21,30};
        assertArrayEquals("case 3b failed", lista, oikea_jarjestys);
	}

	@Test
	public void Case3a(){
		BinaryTree t = new BinaryTree();
		t.insert(20);
		t.insert(4);
	    t.insert(26);
	    t.insert(9);
	    t.insert(21);
	    t.insert(3);
	    t.insert(30);
	    t.insert(2);
	    t.insert(7);
	    t.insert(11);
	    t.insert(15);
	    int[] lista = t.preOrderArray(new int[11]);
        int[] oikea_jarjestys = {9,4,3,2,7,20,11,15,26,21,30};
        assertArrayEquals("case 3a failed", lista, oikea_jarjestys);
	}

	@Test
	public void Case2a(){
		BinaryTree t = new BinaryTree();
		t.insert(20);
		t.insert(4);
		t.insert(26);
		t.insert(3);
		t.insert(9);
		t.insert(15);
	    int[] lista = t.preOrderArray(new int[6]);
        int[] oikea_jarjestys = {9,4,3,20,15,26};
        assertArrayEquals("case 2a failed", lista, oikea_jarjestys);
	}

	@Test
	public void Case2b(){
		BinaryTree t = new BinaryTree();
		t.insert(20);
		t.insert(4);
		t.insert(26);
		t.insert(3);
		t.insert(9);
		t.insert(8);
	    int[] lista = t.preOrderArray(new int[6]);
        int[] oikea_jarjestys = {9,4,3,8,20,26};
        assertArrayEquals("case 2b failed", lista, oikea_jarjestys);
	}

	@Test
	public void Case1a(){
		BinaryTree t = new BinaryTree();
		t.insert(20);
		t.insert(4);
		t.insert(15);
	    int[] lista = t.preOrderArray(new int[3]);
        int[] oikea_jarjestys = {15,4,20};
        assertArrayEquals("case 1a not working", lista, oikea_jarjestys);
	}

	@Test
	public void delete_case1(){
		BinaryTree t = new BinaryTree();
		t.insert(2);
		t.insert(1);
		t.insert(4);
		t.insert(5);
		t.insert(3);
		t.delete(1);
	    int[] lista = t.preOrderArray(new int[4]);
        int[] oikea_jarjestys = {4,2,3,5};
        assertArrayEquals("delete case 1 failed", lista, oikea_jarjestys);
	}

	@Test
	public void delete_case2(){
		BinaryTree t = new BinaryTree();
		t.insert(6);
		t.insert(2);
		t.insert(9);
		t.insert(1);
		t.insert(4);
		t.insert(8);
		t.insert(11);
		t.insert(3);
		t.insert(5);
		t.insert(7);
		t.insert(10);
		t.insert(12);
		t.insert(13);
		t.delete(1);
	    int[] lista = t.preOrderArray(new int[12]);
        int[] oikea_jarjestys = {6,4,2,3,5,9,8,7,11,10,12,13};
        assertArrayEquals("delete case 2 failed", lista, oikea_jarjestys);
	}

	@Test
	public void delete_case3(){
		BinaryTree t = new BinaryTree();
		t.insert(5);
		t.insert(2);
		t.insert(8);
		t.insert(1);
		t.insert(3);
		t.insert(7);
		t.insert(10);
		t.insert(4);
		t.insert(6);
		t.insert(9);
		t.insert(11);
		t.insert(12);
		t.delete(1);
	    int[] lista = t.preOrderArray(new int[11]);
        int[] oikea_jarjestys = {8,5,3,2,4,7,6,10,9,11,12};
        assertArrayEquals("delete case 3 failed", lista, oikea_jarjestys);
	}

	@Test
	public void insertion_case(){
		BinaryTree t = new BinaryTree();
		int numerot = 0, rand, raja = 500000;
        int [] taulukko = new int[500000];
        while(numerot<raja){//Arvotaan 500000 numeroa ja sijoitetaan puuhun
            do{
                rand = 1 + (int)(Math.random() * ((900000 - 1) + 1));
            }while(!t.insert(rand));
            taulukko[numerot] = rand;
            numerot++;
        }

        assertEquals("Osa puuhun sijoitetuista arvoista hävinnyt",taulukko.length, t.getSize());
        for(int i = 0; i<taulukko.length;i++){//Tarkistetaan, että kaikkien elementtien tasapaino on välillä -1<=X<=1
        	boolean tasapaino_arvo = t.find(taulukko[i]).getRoot().getBalance()<=1 &&
        			t.find(taulukko[i]).getRoot().getBalance()>=-1;
        	assertEquals(t.find(taulukko[i]).getRoot().getBalance() + "Puussa oleva arvo on epätasapainossa ", tasapaino_arvo, true);
        }
	}

}
