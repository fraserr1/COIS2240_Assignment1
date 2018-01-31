import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = 0;
		while (n < 1) {
			System.out.print("Input a positive integer number, n, for the Fibonacci series to n: ");
			try {
				n = s.nextInt();
				if (n < 1) {
					System.out.println("Error: Enter a positive integer.");
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Error: Invalid input\nEnter a positive integer.");
				s.next();
			}
		}
		//fiboSeriesItr(n);
		fiboSeriesRec(n);

		System.out.println("The answer to the ultimate question is: " + n);
	}

	/**
	 * @param n
	 */
	public static void fiboSeriesItr(int n) {
		// TODO Auto-generated constructor stub
		System.out.print("Fibonacci series to " + n + ": ");
		Integer j = 1, k = 0, h;
		System.out.print(k + " ");
		for (Integer i = 0; i <= n; i++) {
			System.out.print(j + " ");
			h = j;
			j = j + k;
			k = h;
		}
		System.out.println();

	}

	/**
	 * @param n
	 */
	public static void fiboSeriesRec(int n){
		for (Integer i = 1; i <= n; i++){
			System.out.print(fiboNumberRec(i) + " ");
		}
		System.out.println();
	}
	/**
	 * @param n
	 * @return
	 */
	public static int fiboNumberRec(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			return (fiboNumberRec(n-1) + fiboNumberRec(n-2));
		}
	}

}
