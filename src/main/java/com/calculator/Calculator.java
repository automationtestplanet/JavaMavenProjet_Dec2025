package com.calculator;

public interface Calculator {
	/**
	 * Description: This method performs addition operation on two numbers and
	 * prints the results
	 * 
	 * @author Raju
	 * @param a
	 * @param b
	 */
	int addition(int a, int b);

	/**
	 * Description: This method performs subtraction operation on two numbers and
	 * prints the results
	 * 
	 * @param a
	 * @param b
	 * @return integer
	 */
	int subtraction(int a, int b);

	/**
	 * Description: This method performs multiplication operation on two numbers and
	 * prints the results
	 * 
	 * @param a
	 * @param b
	 */
	int multiplication(int a, int b);

	/**
	 * Description: This method performs Division operation on two numbers and
	 * prints the results
	 * 
	 * @param a
	 * @param b
	 */
	int division(int a, int b);

}
