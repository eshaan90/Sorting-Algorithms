
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


//overriding compare method to keep count of no. of comparison
class HeapSort_Comparator implements Comparator<Integer> {
@Override
public int compare(Integer a, Integer b) {
 HeapSort.comparisons++;
   if(a > b) {
       return 1;
   }
   else if(a <= b) {
       return -1;
   }
   return 0;
}
}
public class HeapSort {

	public static long comparisons = 0;
	public static Comparator<Integer> comp = new HeapSort_Comparator();
	
	public static void main(String[] args) {

		// to store input
		List<Integer> list = new ArrayList<Integer>();

		// to read the input from stdin
		Scanner input = new Scanner(System.in);
		int n = 0;
		String[] s = input.nextLine().split(" ");
		n = Integer.parseInt(s[1].replaceAll("[^0-9]", ""));

		for (int i = 0; i < n; i++)
			list.add(input.nextInt());
		input.close();

		long start_time=System.currentTimeMillis();

		heap_sort(list, n);
		
		long End_time=System.currentTimeMillis();
		//sorted output print
		for(int k =0; k < list.size() ; k++)
			System.out.println(list.get(k));
		
		//calculation of total runtime
		long total_time= End_time - start_time;
		// print runtime and comparisons to output
		System.err.println("runtime," + total_time);
		System.err.println("comparisons," + comparisons);

	}

	public static void heap_sort(List<Integer> list, int n) {
		int size = n;

		
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(i, list, size);
		}

		for (int i = n - 1; i >= 0; i--) {
			int temp = list.get(0);
			list.set(0, list.get(i));
			list.set(i, temp);

			// reduce the heap window by 1
			size = size - 1;

			// call max heapify on the reduced heap
			heapify(0, list, size);
		}
	}

	private static int left_index(int i) {
		return 2 * i + 1;
	}

	private static int right_index(int i) {
		return 2 * i + 2;
	}

	private static void heapify(int i, List<Integer> list, int size) {
		int key = i;

		int leftchild = left_index(i);
		if (leftchild < size && comp.compare(list.get(leftchild), list.get(key))==1 ){
			key = leftchild;
		}

		int rightchild = right_index(i);
		if (rightchild < size && comp.compare(list.get(rightchild), list.get(key))==1  ) {
			key = rightchild;
		}

		if (key != i) {
			int swap = list.get(i);
			list.set(i, list.get(key));
			list.set(key, swap);

			// Recursively heapify the affected sub-tree
			heapify(key, list, size);
		}
	}

}
