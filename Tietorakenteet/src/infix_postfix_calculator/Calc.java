/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infix_postfix_calculator;

import java.util.Stack;

/**
 *
 * @author Julius
 */
public class Calc {

    private Stack s; //laskenta säiliö

    public Calc(){
        s = new Stack();
    }

    public int laske(Stack s2) {
        int res=0;
        int num1;
        int num2;
        int tulos;
        char c;
        while(!s2.empty()){
            if(Character.isDigit((char)s2.peek())){
                System.out.println("Lisätään laskenta säiliöön numero : " + s.push(Character.getNumericValue((char)s2.pop())));
            }else{
               c = (char)s2.pop();
               num1 = (int)s.pop();
               num2 = (int)s.pop();
               switch(c){
                   case('-'):
                       tulos = num2-num1;
                       System.out.println(num2 + "-" + num1 + "=" + tulos);
                       s.push(tulos);
                       break;
                    case('+'):
                        tulos = num2+num1;
                        System.out.println(num2 + "+" + num1 + "=" + tulos);
                        s.push(tulos);
                        break;
                    case('*'):
                        tulos = num2*num1;
                        System.out.println(num2 + "*" + num1 + "=" + tulos);
                        s.push(tulos);
                        break;
                    case('/'):
                        tulos = num2/num1;
                        System.out.println(num2 + "/" + num1 + "=" + tulos);
                        s.push(tulos);
                        break;
                    case('^'):
                        tulos = (int)Math.pow(num2, num1);
                        System.out.println(num2 + "^" + num1 + "=" + tulos);
                        s.push(tulos);
                        break;
                    default:
                        System.out.println("EI VOITU TUNNISTAA KIRJAINATA : " + c);
               }
            }
        }
        res = (int)s.peek();
        return res;
    }
}
