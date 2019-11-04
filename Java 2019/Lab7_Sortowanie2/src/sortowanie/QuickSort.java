package sortowanie;

public class QuickSort {
	int[] arr;
	private int porownania;
	private int przepisania;
	private int zamiany;
	private int length;

	public void sort(int[] inputArr) {
		porownania = 0;
		przepisania = 0;
		zamiany = 0;
		
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.arr = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		int pivot = arr[lowerIndex + (higherIndex - lowerIndex) / 2];
		while (i <= j) {
			porownania++;
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				i++;
				j--;
				przepisania += 3;
				zamiany++;
			}
		}
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	private void exchangeNumbers(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public int getPorownania() {
		return porownania;
	}

	public int getPrzepisania() {
		return przepisania;
	}

	public int getZamiany() {
		return zamiany;
	}

	
}
