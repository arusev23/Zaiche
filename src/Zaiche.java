import java.util.Arrays;
import java.util.Scanner;

public class Zaiche {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] humanInput = in.nextLine().split(", ");
		
		int[] field = new int[humanInput.length];
		for (int i = 0; i < field.length; i++) {
			field[i] = Integer.parseInt(humanInput[i]);
		}
		
		int startPosition = 0;
		int longestRun = Integer.MIN_VALUE;
		int currentRun = 1;
		
		for (int index = 0; index < field.length; index++) {
			for (int jump = 1; jump < field.length; jump++) {
				currentRun = 1;
				int currentIndex = index;
				
				int nextIndex = currentIndex + jump;
				while(nextIndex < 0) {
					nextIndex+=field.length;
				}
				
				while(field[nextIndex] > field[currentIndex] && (nextIndex != index)) {
					currentRun++;
					currentIndex = nextIndex;
					nextIndex = currentIndex + jump;
					while(nextIndex < 0) {
						nextIndex += field.length;
					}
					while(nextIndex > field.length-1) {
						nextIndex -= field.length;
					}
					
				}
				longestRun = Math.max(longestRun, currentRun);
			}
			
		}
		longestRun = Math.max(longestRun, currentRun);
		System.out.println(longestRun);
	}
}
