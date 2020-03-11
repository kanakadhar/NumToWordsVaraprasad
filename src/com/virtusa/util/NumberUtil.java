package com.virtusa.util;

import com.virtusa.constants.Constants;
import com.virtusa.exception.InvalidNumberException;

/**
 * 
 * @author Varaprasad
 * Purpose: To have utilities related to numbers
 */
public class NumberUtil {
	private NumberUtil() {//Its private. So that no one can create object for this class
		
	}
	
	/**
	 * To find given input is number or not
	 * @param strNumber
	 * @return
	 */
	public static boolean isNumber(String strNumber) {
		try {
			
			if(strNumber == null) {
				return false;
			}
			Integer.parseInt(strNumber);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * To process the number which is less than thousand
	 * @param number
	 * @return
	 */
	private static String processLessThanThousand(int number) { //Its a private method to be utilised only with in this class
		String current = Constants.EMPTY;
		if(number % Constants.NUM_HUNDRED < Constants.NUM_TWENTY) { 
			current = Constants.NUM_NAMES[number % Constants.NUM_HUNDRED];
			number /= Constants.NUM_HUNDRED;
		}else {
			current = Constants.NUM_NAMES[number % Constants.NUM_TEN];
			number /= Constants.NUM_TEN;
			
			current = Constants.TEN_NAMES[number % Constants.NUM_TEN] + current;
			number /= Constants.NUM_TEN;
		}
		
		if(number == Constants.NUM_ZERO) return current;
		return Constants.NUM_NAMES[number] + Constants.HUNDRED+current;
	}
	
	
	/**
	 * To convert the given number into words
	 * @param strNumber
	 * @return
	 * @throws InvalidNumberException
	 */
	public static String covertNumberToWords(String strNumber)throws InvalidNumberException {
		
		int number = Constants.NUM_ZERO;
		int place = Constants.NUM_ZERO;
		String current = Constants.EMPTY;
		String prefix = Constants.EMPTY;
		
		if(!isNumber(strNumber)) {
			throw new InvalidNumberException(strNumber+ Constants.NOT_A_NUMBER);
		}
		
        number = Integer.parseInt(strNumber);
		
		if(number == Constants.NUM_ZERO) return Constants.ZERO;
		
		if(number < Constants.NUM_ZERO) {
			number = -number;
			prefix = Constants.NEGATIVE;
		}
		
		do {
			int n = number % Constants.NUM_THOUSAND;
			
			if(n != Constants.NUM_ZERO) {
				String belowThousand = processLessThanThousand(n);
				current = belowThousand + Constants.SPL_NAMES[place]  + current;
			}
			place++;
			number /= Constants.NUM_THOUSAND;
		}while(number > Constants.NUM_ZERO);
		return (prefix + current).trim();
	}
	
}
