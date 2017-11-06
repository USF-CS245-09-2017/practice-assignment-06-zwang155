
public class BinaryHeap {
	int[] arr;
	int size;

	public BinaryHeap() {
		arr = new int[10];
		size = 0;
	}

	// return the index of the parent of i
	// return -1 if it has no parent
	private int parent(int i) {
		if (i == 0)
			return -1;
		return (i - 1) / 2;
	}

	// return the index of smaller child of i
	// return -1 if it has no child
	private int small_child(int i) {
		int left = i * 2 + 1;
		if (left >= size)
			return -1;
		int right = i * 2 + 2;
		if (right < size && arr[left] > arr[right])
			return right;
		return left;
	}

	// grow size
	private void grow_size() {
		int[] new_arr = new int[arr.length * 2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;
	}

	// adds an int (or Integer) instance to the priority queue
	public void add(int d) {
		if (size == arr.length)
			grow_size();
		int index = size;
		int parent = parent(index);
		while (parent != -1 && d < arr[parent]) {
			arr[index] = arr[parent];
			index = parent;
			parent = parent(index);
		}
		arr[index] = d;
		size++;
	}

	// removes the highest priority item (the lowest number)
	// throw an exception if the priority queue is empty.
	public int remove() throws Exception {
		if (size == 0)
			throw new Exception("No Data");
		int data = arr[0];
		int d = arr[--size];
		int index = 0;
		int child = small_child(index);
		while (child != -1 && d > arr[child]) {
			arr[index] = arr[child];
			index = child;
			child = small_child(index);
		}
		arr[index] = d;
		return data;
	}
}
