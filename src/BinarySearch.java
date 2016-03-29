import java.util.Scanner;

public class BinarySearch {

	/**
	 * 
	 * @param argv
	 */
	public static void main(String [] argv){
		BinarySearch bs = new BinarySearch();
		bs.start(-16, 16);
	}
	
	/**
	 * 
	 */
	public BinarySearch() {
	}

	/**
	 * 
	 * @param min
	 * @param max
	 */
	public void start(int min, int max){
		int median = Math.floorDiv(min+max, 2);
		message(median);
		Scanner s = new Scanner(System.in);
		String answer = s.next().toString();
		try {
			if(this.isPositive(answer)){
				if(max-min<2){
					guess(max);
					return;
				}
				start(median + 1, max);
			}else{
				if(max-min<2){
					guess(min);
					return;
				}
				start( min, median );
			}
		} catch (InvalidInputException e) {
			invalidAnswer(answer);
			start(min, max);
		}finally{
			s.close();
		}
	}

	/**
	 * 
	 * @param number
	 */
	public void guess(int number) {
		System.out.printf("The number is: %d!\n", number);
	}
	
	/**
	 * 
	 * @param number
	 */
	public void invalidAnswer(String answer) {
		System.out.printf("The answer provided: \"%s\", is invalid.\n", answer);
	}
	
	
	/**
	 * 
	 * @param number
	 */
	public void message(int number) {
		System.out.printf("Is the number greater than %d?(y/n)\n", number);
	}

	/**
	 * 
	 * @param answer
	 * @return
	 * @throws InvalidInputException 
	 */
	public boolean isPositive(String answer) throws InvalidInputException {
		answer = answer.toLowerCase();
		switch(answer){
			case "y":
			case "yes":
				return true;
			case "n":
			case "no":
				return false;
			default:
				throw new InvalidInputException("Unexpected input");
		}
	}
}
