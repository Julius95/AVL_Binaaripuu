/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infix_postfix_calculator;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

/**
 *
 * @author Julius
 */
public class Main {

    //https://www.youtube.com/watch?v=rA0x7b4YiMI
    //https://www.youtube.com/watch?v=zOjsfgkWg6E

    private static char[] list;
    private static Stack s;
    private static Stack s2;

    private static void rakenna(char c){
        int c_value=value(c);
        int top_value=-1;
        if(!s2.isEmpty()){
            top_value=value((char)s2.peek());
        }
        if(c_value != 3){ //jos luettu merkki ei ole ')'
            while(!s2.isEmpty()){
                if(c_value>top_value){
                    break;
                }else{
                    if(top_value==4) //yritetään heittää '(' operaatio stackiin
                        break;
                    s.push(s2.pop());
                    if(!s2.isEmpty())
                        top_value=value((char)s2.peek());
                }
            }
            System.out.println("Pushed :" + c);
            s2.push(c);
        }
        else{ // Luettu merkki on ')'. Käsitellään sulkeet
            Iterator it2 = s2.iterator();
            System.out.print("Operator stack contents : ");
            while(it2.hasNext()){ //Printataan operaattori pinon sisältö
                System.out.print(it2.next()+" ");
            }
            System.out.println();

            top_value=value((char)s2.peek());//luetaan operaattori pinon päällimmäisin arvo
            while(top_value!=4){ //siirretään kamaa main stackiin niin kauan kunnes kohdataan '('
                System.out.println("Pushed -> "+s.push(s2.pop()) + " to main stack");
                top_value=value((char)s2.peek());
            }
            System.out.println("Deleted -> " + s2.pop() + " from operand stack"); //poistetaan '('
        }
    }

    public static int value(char c){
        int res = 0;
        switch(c){
            case('+'):
            case('-'):
                break;
            case('/'):
            case('*'):
                res=1;
                break;
            case('^'):
                res=2;
                break;
            case(')'):
                res=3;
                break;
            case('('):
                res=4;
        }
        return res;
    }

    public static void main(String[] args) {
        Calc calc = new Calc();
        s = new Stack();
        s2 = new Stack();

        //Testi lausekkeita

        //String lause = "2+(2*2)^2";// = 18
        //String lause = "(3*2)^2";// = 36
        //String lause = "3+5*1"; //= 8
        //String lause = "(3+4)*(5/2)"; //3,4,+,5,2,/,* = 14
        //String lause = "1^2*3-4+5/6/(7+8)"; // 1,2,^,3,*,4,-,5,6,/,7,8,+,/,+
        //String lause = "3+4*2/(1-5)"; //3,4,2,*,1,5,-,/,+ = 1
        //String lause = "1/2-3+4*5-6*7";
        //String lause = "(1+(2+3))"; //1,2,3,+,+
        //String lause = "((1+2)*(3+4))"; //12+34+* = 21
        //String lause = "((((((1+2)+3)+4)+5)+6)+7)"; //1 2 + 3 + 4 + 5 + 6 + 7 + = 28
        String lause = "2+2^2-0*3*2*4";
        //        System.out.println(calc.laske(lause));
        list = lause.toCharArray();
        for (char c : list){
            if(Character.isDigit(c)) //on numero
                s.push(c);
            else{ //on operaattori
                rakenna(c);
            }
        }
        System.out.println("\nSiirretään loput operaattorit pääpinoon\n------");
        while(!s2.isEmpty()){
            System.out.println("Pushed -> "+s.push(s2.pop()) + " to main stack");
        }
        for(int i = s.size()-1;i>-1;i--){
            s2.push(s.get(i));
        }
        System.out.println("------\n");
        Iterator it = s.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+",");
        }
        System.out.println("\nStack kopio:");
        Iterator it2 = s2.iterator();
        while(it2.hasNext()){
            System.out.print(it2.next()+",");
        }
        System.out.println();
        System.out.println("Result : " + calc.laske1(s2));

    }
    //System.out.println((int)Character.valueOf(c) + " " + (int)Character.valueOf((char)s2.firstElement()));
     //               System.out.println(c + " " + s2.firstElement() + " = " +Character.compare(c, (char)s2.firstElement()));

}
