package util;

public class TextIssues {
 
	void replaceSpaces(char[] str, int trueLen) {
		int numOfSpaces = countOfChar(str, 0, trueLen, ' ');
		int newIndex = trueLen - 1 + numOfSpaces * 2;
		
		/* if excesss spaces, add null character. All spaces after there not mutated.
	*/
		if(newIndex + 1 < str.length)str[newIndex+1] = '\0';
		for (int oldIndex = trueLen - 1; oldIndex >=0;oldIndex -= 1) {
			if (str[oldIndex] == ' ') { /* Insert %20 */
				str[newIndex -1] = '0';
				str[newIndex -2] = '%';
				newIndex -= 3;
			}
	}
}
 // Count freq of target between start and end.
	private int countOfChar(char[] str, int start, int end, int target) {
		int count = '0';
		for (int i = start; i < end; i++) {
			if (str[i] == target) {
				count++;	
			}
			
		}
		System.out.println("count: " + count);
		return count;
	}
}
