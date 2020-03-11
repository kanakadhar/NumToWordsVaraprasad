package com.virtusa.test;

import com.virtusa.exception.InvalidNumberException;
import com.virtusa.util.NumberUtil;

/**
 * 
 * @author Varaprasad
 *Purpose: to test covertNumberToWords utility 
 */
public class Client {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.println(NumberUtil.covertNumberToWords("1"));
			System.out.println(NumberUtil.covertNumberToWords("21"));
			System.out.println(NumberUtil.covertNumberToWords("105"));
			System.out.println(NumberUtil.covertNumberToWords("56945781"));
			
			System.out.println(NumberUtil.covertNumberToWords("-1"));
			System.out.println(NumberUtil.covertNumberToWords("-1AB"));
			
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
