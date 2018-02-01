import java.math.BigInteger;
import java.util.Scanner;

/* By Fraser Raney
 * 
 * COIS 2240 Assignment 1 
 * 
 * PURPOSE: 
 * This program displays the Fibonacci series up to the nth term given
 * by the user. The user is prompted to enter an nth term. The program also displays
 * the elapsed time needed to display the series for both iterative and recursive
 * functions which display the series to the user.
 * 
 * NOTE: The timing was calculated in nanoseconds since it was more exact,
 * however, for the purpose of comparison on the graphs, the times were
 * converted to milliseconds. That is, nanoseconds/1E06 = milliseconds.
 * As well, BigInteger threw an overflow error when calculating, n = 50 and n = 40 for 
 * the recursive function and thus the time for the recursive function at 
 * n = 50 and n = 40 needed to be calculated using System.currentTimeMillis().
 * */
public class Main {

	/**
	 * Data dictionary 
	 * s stores a scanner object to read user input 
	 * n stores a positive integer of the nth term of the series 
	 * start stores an Long initial time used to calculate elapsed time 
	 * finish stores a Long final time used to calculate elapsed time 
	 * time stores a BigInteger used to calculate elapsed time
	 */
	public static void main(String[] args) { // main loop
		Scanner s = new Scanner(System.in);
		Integer n = 0;
		Long start;
		Long finish;
		BigInteger time;
		// get user input with data validation loop for format and range
		while (n < 1) {
			System.out.print("Input a positive integer number, n, for the Fibonacci series to n: ");
			try {
				n = s.nextInt(); // read input integer
				if (n < 1) {
					System.out.println("Error: Enter a positive integer.");
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Error: Invalid input\nEnter a positive integer.");
				s.next(); // get next input
			}
		}
		s.close(); // close scanner object

		// display output to the user
		System.out.println("Fibonacci Iterative:");
		start = System.nanoTime(); // initial time
		fiboSeriesItr(n);
		finish = System.nanoTime(); // final time
		System.out.println("\nn = " + n + ": " + (finish - start));
		System.out.println("Fibonacci Recursive:");
		start = System.nanoTime(); // initial time
		if (n>30) // n=40,50: see note above
			start = System.currentTimeMillis(); 
		fiboSeriesRec(n);
		finish = System.nanoTime(); // final time
		if (n>30) //n=40,50: see note above
			finish = System.currentTimeMillis(); 
		// calculate the elapsed time
		time = BigInteger.valueOf(finish).subtract(BigInteger.valueOf(start));
		System.out.println("\nn = " + n + ": " + time.intValueExact());
	}

	/**
	 * fiboSeriesItr function: displays the terms of the Fibonacci series
	 * 
	 * @param n is an integer of the nth term of the series
	 */
	public static void fiboSeriesItr(int n) {
		System.out.print("Fibonacci series to " + n + ": ");
		BigInteger j = BigInteger.ONE, k = BigInteger.ZERO, h; // initialize BigInteger values
		System.out.print(k + " "); // print the first term
		for (Integer i = 1; i < n; i++) { 
			System.out.print(j + " "); // print the next term
			// calculate the next term
			h = j;
			j = j.add(k);
			k = h;
		}
		System.out.println();

	}

	/**
	 * fiboSeriesRec function: displays the terms of the Fibonacci series
	 * 
	 * @param n is an integer of the nth term of the series
	 */
	public static void fiboSeriesRec(int n) {
		System.out.print("Fibonacci series to " + n + ": ");
		// loop to get each term using the recursive function and print to console
		for (Integer i = 1; i <= n; i++) {
			System.out.print(fiboNumberRec(BigInteger.valueOf(i-1)) + " ");
		}
		System.out.println("");
	}

	/**
	 * fiboNumberRec function: calculates the nth term of the Fibonacci series
	 * using recursion
	 * 
	 * @param n is an BigInteger of the nth term of the series
	 * @return the function returns the sum of the n-2 and n-1 terms of the
	 *         series
	 */
	public static BigInteger fiboNumberRec(BigInteger n) {
		if (n == BigInteger.ZERO) { // terminating condition
			return BigInteger.ZERO;
		} else if (n == BigInteger.ONE) { // terminating condition
			return BigInteger.ONE;
		} else {
			return (fiboNumberRec(BigInteger.valueOf(n.intValueExact()-1)))
					.add(fiboNumberRec(BigInteger.valueOf(n.intValueExact()-2))); 
			//this is the nth term
		}
	}

}
