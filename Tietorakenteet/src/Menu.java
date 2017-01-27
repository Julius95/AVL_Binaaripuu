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
            System.out.println("\n\t\t\t1. Lis�� avain.");
            System.out.println("\t\t\t2. Etsi avaimella.");
            System.out.println("\t\t\t3. K�y puu l�pi esij�rjestyksess�.");
            System.out.println("\t\t\t4. lopetus ");
            System.out.println("\t\t\t5. Poista avaimella ");
            System.out.print("\n\n"); // tehd��n tyhji� rivej�
            select = Lue.merkki();
            switch (select) {
            case '1':
                System.out.println("Anna uusi avain (merkkijono)");
                data = new String(Lue.rivi());
                tree.insert(data);
                break;
            case '2':
                    System.out.println("Anna etsitt�v� avain (merkkijono)");
                    data = Lue.rivi();
                    if (tree.find(data)!=null){
                        System.out.println("Avain l�ytyi.");
                    }
                    else
                        System.out.println("Avainta ei l�ytynyt.");

                break;
            case '3':
                tree.preOrder();
                char h = Lue.merkki(); // pys�ytet��n kontrolli
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
                    System.out.println("Poistettavaa avainta " + data + " ei l�ydy");
                break;
            case '6':
                tree.innerOrder();
            }
        }
        while (select != '4');
    }
}

