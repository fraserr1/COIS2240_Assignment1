import java.util.Scanner;

public class fiboSeriesRec {

	public fiboSeriesRec() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int s0 = 0;
		while (s0 < 1) {
			System.out.print("Input a positive integer number, n, for the Fibonacci series to n: ");
			try {
				s0 = s.nextInt();
				if (s0 < 1){
					System.out.println("Error: Enter a positive integer."); 
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Error: Invalid input\nEnter a positive integer.");
				s.next(); //https://stackoverflow.com/questions/3572160/how-to-handle-infinite-loop-caused-by-invalid-input-inputmismatchexception-usi
			}
		}
		System.out.println("answer: " + s0);

	}

}
