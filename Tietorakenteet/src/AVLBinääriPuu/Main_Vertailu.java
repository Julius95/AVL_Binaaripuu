package AVLBin‰‰riPuu;
import java.util.TreeSet;

public class Main_Vertailu {

	//Verrataan omaa toteutusta java collectionin Treeset toteutukseen
	public static void main(String[] args) {

		BinaryTree t = new BinaryTree();

		//Arvotaan sijoitettavat luvut
        int numerot = 0, rand, raja = 500000;
        int [] taulukko = new int[499999];
        while(numerot<raja-1){
            do{
                rand = 1 + (int)(Math.random() * ((900000 - 1) + 1));
            }while(!t.insert(rand));
            taulukko[numerot] = rand;
            numerot++;
        }


        t = new BinaryTree();
        TreeSet tree = new TreeSet();

        long A1, A2, B1, B2;

        //Aloitetaan A osuus/////////////////////
        A1 = System.currentTimeMillis();
        for(int i : taulukko){
            tree.add(i);
        }
        for(Object i : tree){}
        A2 = System.currentTimeMillis();


        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
        }

        //Aloitetaan B osio//////////////////
        B1 = System.currentTimeMillis();
        for(int i : taulukko){
            t.insert(i);
        }
        t.innerOrder();
        B2 = System.currentTimeMillis();

        System.out.println("A Lopputulos : " + (A2-A1) + " B : " + (B2-B1));
    }

}
