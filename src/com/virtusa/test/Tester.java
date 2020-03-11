package com.virtusa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.virtusa.exception.InvalidNumberException;
import com.virtusa.util.NumberUtil;

/**
 * 
 * @author Varaprasad
 * Purpose: test cases to test method covertNumberToWords with unit testing
 */
public class Tester {
	
	@Test
	public void testNumberToWords() {
		String expected = "one";
		try {
			String actual = NumberUtil.covertNumberToWords("1");
			assertEquals(expected, actual);
			
			expected = "twenty one";
			actual = NumberUtil.covertNumberToWords("21");
			assertEquals(expected, actual);
			
			expected = "one  hundred five";
			actual = NumberUtil.covertNumberToWords("105");
			assertEquals(expected, actual);
			
			expected = "fifty six million nine  hundred fourty five thousand seven  hundred eighty one";
			actual = NumberUtil.covertNumberToWords("56945781");
			assertEquals(expected, actual);
			
			
			expected = "negative one";
			actual = NumberUtil.covertNumberToWords("-1");
			assertEquals(expected, actual);
			
//			expected = "";
//			actual = NumberUtil.covertNumberToWords("1");
//			
//			expected = "";
//			actual = NumberUtil.covertNumberToWords("1");
			
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * If InvalidNumberException arises then this test case will pass. Means if we pass invalid number as input we are ensuring exception is thrown.
	 * @throws InvalidNumberException
	 */
	@Test(expected = InvalidNumberException.class)
	public void testInvalidNumber() throws InvalidNumberException{
		System.out.println("In testInvalidNumber");
		System.out.println(NumberUtil.covertNumberToWords("1AB"));
//		String expected
//		String actual = NumberUtil.covertNumberToWords("1");
//		assertEquals(expected, actual);
	}
	

}
