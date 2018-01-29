import java.util.Scanner;

public class Main {

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
				s.next(); // https://stackoverflow.com/questions/3572160/how-to-handle-infinite-loop-caused-by-invalid-input-inputmismatchexception-usi
			}
		}
		//fiboSeriesItr(n);
		//fiboSeriesRec(n);

		System.out.println("The answer to the ultimate question is: " + n);
		}
	public static void fiboSeriesItr(int n) {
		// TODO Auto-generated constructor stub
	}
	public static void fiboSeriesRec(int n) {
		// TODO Auto-generated constructor stub
	}

}
