package sortowanie;

public class MergeSort {
	int[] arr;
	private int porownania;
	private int przepisania;
	private int zamiany;

	private int[] numbers;
	private int[] helper;

	private int number;

	public void sort(int[] values) {
		porownania = 0;
		przepisania = 0;
		zamiany = 0;

		numbers = new int[values.length];
		for (int i = 0; i < values.length; i++)
			this.numbers[i] = values[i];
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
			zamiany++;
		}
	}

	private void merge(int low, int middle, int high) {

		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
			przepisania++;
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
				
			}
			porownania++;
			przepisania++;
			
			k++;
		}
		while (i <= middle) {
			numbers[k] = helper[i];
			przepisania++;
			zamiany++;
			k++;
			i++;
		}
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
