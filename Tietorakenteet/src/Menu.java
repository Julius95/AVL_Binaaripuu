/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class Menu {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        char select;
        BinaryTree tree = new BinaryTree();
//                tree.insert("H");
//                tree.insert("C");
//                tree.insert("D");
//                tree.insert("E");
//                tree.insert("A");
//                tree.insert("B");
//                tree.insert("L");
//                tree.insert("K");
//                tree.insert("M");
//                tree.insert("N");
        String data;
        do {
            System.out.println("\n\t\t\t1. Lisää avain.");
            System.out.println("\t\t\t2. Etsi avaimella.");
            System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
            System.out.println("\t\t\t4. lopetus ");
            System.out.println("\t\t\t5. Poista avaimella ");
            System.out.print("\n\n"); // tehdään tyhjiä rivejä
            select = Lue.merkki();
            switch (select) {
            case '1':
                System.out.println("Anna uusi avain (merkkijono)");
                data = new String(Lue.rivi());
                tree.insert(data);
                break;
            case '2':
                    System.out.println("Anna etsittävä avain (merkkijono)");
                    data = Lue.rivi();
                    if (tree.find(data)!=null){
                        System.out.println("Avain löytyi.");
                    }
                    else
                        System.out.println("Avainta ei löytynyt.");

                break;
            case '3':
                tree.preOrder();
                char h = Lue.merkki(); // pysäytetään kontrolli
                break;
            case '4':
                break;
            case '5':
                data = Lue.rivi();
                boolean res = tree.delete(data);
                if(res)
                {
                    System.out.println("Avain " + data + " poistettiin");
                }
                else
                    System.out.println("Poistettavaa avainta " + data + " ei löydy");
                break;
            case '6':
                tree.innerOrder();
            }
        }
        while (select != '4');
    }
}

