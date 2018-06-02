import java.util.ArrayList;
import java.util.Scanner;

public class Zaiche {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] humanInput = in.nextLine().split(", ");
		
		int[] field = new int[humanInput.length];
		
		for (int i = 0; i < field.length; i++) {
			field[i] = Integer.parseInt(humanInput[i]);
		}
		
		int position = 0, nextPosition = 1;
		int longestRun = Integer.MIN_VALUE;
		
		for (int startPosition = 0; startPosition < field.length; startPosition++) {
			for (int step = 1; step <= field.length; step++) {
				ArrayList<Integer> used = new ArrayList<>();
				position = startPosition;
				
				while(!used.contains(position)) {
					used.add(position);
					nextPosition = (position + step) % field.length;
					if(field[nextPosition] <= field[position]) {
						break;
					}
					
					position = nextPosition;
				}
				
				longestRun = Math.max(longestRun, used.size()); // used.size() == successful jumps
			}
		}
		System.out.println(longestRun);
	}
	
}
