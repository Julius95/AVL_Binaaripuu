/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infix_postfix_calculator;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Julius
 */
public class Calc {

	private static Stack<String> number_stack;
    private static Stack<Character> operator_stack;
    private Stack<Integer> s; //laskenta säiliö

    public Calc(){
        s = new Stack<Integer>();
        number_stack = new Stack<String>();
        operator_stack = new Stack<Character>();
    }

    public int laske(String lauseke){
    	int res = 0;
    	char[] list = lauseke.toCharArray();
    	int index = 0;
    	boolean read_operand = false;
    	String input = "";
    	while(list.length>index){
    		System.out.println("char : " + list[index]);
    		if(Character.isDigit(list[index])){ //on numero
    			System.out.println("is number");
            	input += String.valueOf(list[index]);
            	read_operand = false;
            }else{ //on operaattori
            	System.out.println("input : " + input);
            	if(input.length()>0)
            		System.out.println("Pushing to numbers stack " + number_stack.push(input));
            	if(list[index]=='-' && (index==0 || read_operand))//Negatiivinen luku tulossa
            		input += "-";
            	else{
            		rakenna(list[index]);
            		input= new String("");
            	}
            	if(list[index]!=')')
            		read_operand = true;
            }
    		index++;
    	}
    	if(input.length()>0)
    		number_stack.push(input);
    	Iterator<String> it4 = number_stack.iterator();
    	System.out.println("\nNumberStack kopio:");
        while(it4.hasNext()){
            System.out.print(it4.next()+",");
        }
        System.out.println("\nStack kopio:");
        Iterator<Character> it3 = operator_stack.iterator();
        while(it3.hasNext()){
            System.out.print(it3.next()+",");
        }
//    	for (char c : list){
//            if(Character.isDigit(c)){ //on numero
//            	//String input = "lol";
//            	number_stack.push(String.valueOf(c));
//            }else{ //on operaattori
//                rakenna(c);
//            }
//        }
        System.out.println("\nSiirretään loput operaattorit pääpinoon\n------");
        while(!operator_stack.isEmpty()){
            System.out.println("Pushed -> "+number_stack.push(String.valueOf(operator_stack.pop())) + " to main stack");
        }
        Stack<String> infix = new Stack<String>();
        for(int i = number_stack.size()-1;i>-1;i--){
        	infix.push(number_stack.get(i));
        }
        System.out.println("------\n");
        Iterator<String> it = number_stack.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+",");
        }
        System.out.println("\nStack kopio:");
        Iterator<Character> it2 = operator_stack.iterator();
        while(it2.hasNext()){
            System.out.print(it2.next()+",");
        }
        System.out.println();
        res = laske1(infix);
        System.out.println("Result : " + res);
        s.clear();
        operator_stack.clear();
        number_stack.clear();
    	return res;
    }

    public int laske1(Stack<String> s2) {
        int res=0;
        int num1;
        int num2;
        char operaattori;
        while(!s2.empty()){
        	String input = s2.peek();
            if(input.length()>1 || value(input.charAt(0))==-1){
                System.out.println("Lisätään laskenta säiliöön numero : " + s.push(Integer.parseInt((s2.pop()))));
            }else{
            	operaattori = s2.pop().charAt(0); //Ota operaattori
            	num1 = (int)s.pop();//Ota eka numero
        		num2 = (int)s.pop();//Ota toinen numero
            	if(!s2.empty() && !Character.isDigit(s2.peek().charAt(0)) && operaattori == '-'){//Tarkista onko toista operaattoria heti seuraavaksi. Tarvitaan negatiivisten lukujen laskuun
			   		num1 = -num1;
			   		operaattori = s2.pop().charAt(0);
		   		}
            	s.push(this.tee_lasku(operaattori, num1, num2));
            }
        }
        res = (int)s.peek();
        return res;
    }

    private int tee_lasku(char operaattori, int num1, int num2){
    	int tulos=0;
    	switch(operaattori){
	        case('-'):
	            tulos = num2-num1;
	            System.out.println(num2 + "-" + num1 + "=" + tulos);
	            break;
	         case('+'):
	             tulos = num2+num1;
	             System.out.println(num2 + "+" + num1 + "=" + tulos);
	             break;
	         case('*'):
	             tulos = num2*num1;
	             System.out.println(num2 + "*" + num1 + "=" + tulos);
	             break;
	         case('/'):
	             tulos = num2/num1;
	             System.out.println(num2 + "/" + num1 + "=" + tulos);
	             break;
	         case('^'):
	             tulos = (int)Math.pow(num2, num1);
	             System.out.println(num2 + "^" + num1 + "=" + tulos);
	             break;
	         default:
	             System.out.println("EI VOITU TUNNISTAA KIRJAINTA : " + operaattori);
	    }
    	return tulos;
    }


    private void rakenna(char c){
    	int c_value=value(c);
        int top_value=-1;
        if(!operator_stack.isEmpty()){
            top_value=value((char)operator_stack.peek());
        }
        if(c_value != 3){ //jos luettu merkki ei ole ')'
            while(!operator_stack.isEmpty()){
                if(c_value>top_value){
                    break;
                }else{
                    if(top_value==4) //ollaan laittamassa '(' sulkeen alkua operaatio stackiin
                        break;
                    number_stack.push(String.valueOf(operator_stack.pop()));
                    if(!operator_stack.isEmpty())
                        top_value=value((char)operator_stack.peek());
                }
            }
            System.out.println("Pushed :" + c);
            operator_stack.push(c);
        }
        else{ // Luettu merkki on ')'. Käsitellään sulkeet
            Iterator<Character> it2 = operator_stack.iterator();
            System.out.print("Operator stack contents : ");
            while(it2.hasNext()){ //Printataan operaattori pinon sisältö
                System.out.print(it2.next()+" ");
            }
            System.out.println();

            top_value=value((char)operator_stack.peek());//luetaan operaattori pinon päällimmäisin arvo
            while(top_value!=4){ //siirretään kamaa main stackiin niin kauan kunnes kohdataan '('
                System.out.println("Pushed -> "+number_stack.push(String.valueOf(operator_stack.pop())) + " to main stack");
                top_value=value((char)operator_stack.peek());
            }
            System.out.println("Deleted -> " + operator_stack.pop() + " from operand stack"); //poistetaan '('
        }
    }

    private int value(char c){
        int res = -1;
        switch(c){
            case('+'):
            case('-'):
            	res=0;
                break;
            case('/'):
            case('*'):
                res=1;
                break;
            case('^'):
            case('√'):
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
}
