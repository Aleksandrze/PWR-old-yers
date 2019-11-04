
public class a12a {
	public static void longestForward(int[] arr) {
		int subLength = 1; //последующая Длина
		int longest = 1; //самый длинный
		int indexStart = 0;
		int indexEnd = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1] - 1)// We need to check if the current is equal to the next
			{
				subLength++;// if it is we increment
				if (subLength > longest)// we assign the longest and new bounds
				{
					longest = subLength;
					indexStart = i + 2 - subLength;// make sure the index start is correct
					indexEnd = i + 2;
				}

			} else
				subLength = 1;// else re-initiate the straight length
		}

		for (int i = indexStart; i < indexEnd; i++)// print the sequence
			System.out.print(arr[i] + ", ");
	}

	public static void main(String[] args) {

		// Test arrays
		int[] arrC = { 9, 5, 2, 3, 4, 5,8 };
		int[] arrA = { 1, 2, 3, 4, 5, 7 };
		int[] arrB = { 7, 6, 5, 4, 1, 2 };
		int[] arr = { 3, 6, 5, 1, 9, 3, 2, 3, 4, 5, 1 };

		longestForward(arr);

	}

}
