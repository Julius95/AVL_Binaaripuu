import static org.junit.Assert.*;

import org.junit.Test;

import infix_postfix_calculator.Calc;

public class Calc_tests {

	//double digits, kirjaimet

	@Test
	public void calculations_positive_numbers() {
		Calc calc = new Calc();
		assertEquals(calc.laske("1+1"), 2);
		assertEquals(calc.laske("(1+2)*2"), 6);
		assertEquals(calc.laske("1+2*2"), 5);
		assertEquals(calc.laske("((((((1+2)+3)+4)+5)+6)+7)"), 28);
		assertEquals(calc.laske("((1+2)*(3+4))"), 21);
		assertEquals(calc.laske("2+2^2+0*3*2*4"), 6);
		assertEquals(calc.laske("(2+2^(2+2*2)-8)/2"), 29);
	}

	@Test
	public void calculations_negative_numbers() {
		Calc calc = new Calc();
		assertEquals(calc.laske("10--6"), 16);
		assertEquals(calc.laske("10-(-6)"), 16);
		assertEquals(calc.laske("-10-6"), -16);
		assertEquals(calc.laske("-6--10"), 4);
		assertEquals(calc.laske("2+2^2-0*3*(-2)*4"), 6);
		assertEquals(calc.laske("10/-2*-2"), 10);
		assertEquals(calc.laske("256/2-9456"), -9328);
	}

}
