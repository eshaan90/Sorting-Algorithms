import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//overriding compare method to keep count of no. of comparison
class Insertionsort_Comparator implements Comparator<Integer> {
 @Override
 public int compare(Integer a, Integer b) {
     InsertionSort.comparisons++;
     if(a > b) {
         return 1;
     }
     else if(a <= b) {
         return -1;
     }
     return 0;
 }
}

public class InsertionSort {

	public static long comparisons = 0;
	public static Comparator<Integer> comp = new Insertionsort_Comparator();
	public static void main(String[] args) {
		// to store input
    	List<Integer> list = new ArrayList<Integer>();
    	
    	// to read the input from stdin
    	Scanner input = new Scanner(System.in);
		int n = 0;
		String[] s = input.nextLine().split(" ");
		n = Integer.parseInt(s[1].replaceAll( "[^0-9]" ,""));
		
		for(int i=0;i<n;i++)
    		list.add(input.nextInt());
		input.close();

		long start_time=System.currentTimeMillis();

		for (int i = 1; i < n; i++) {
			int value = list.get(i);
			int j = i - 1;
			while (j >= 0 && comp.compare(list.get(j),value)==1) {
				
				list.set(j + 1, list.get(j));
				j = j - 1;
				
			}
			list.set(j + 1, value);
			
		}
		long End_time=System.currentTimeMillis();
		
		//calculation of total runtime
				long total_time= End_time - start_time;
   
		//sorted output print
				for(int k =0; k < list.size() ; k++)
					System.out.println(list.get(k));
				// print runtime and comparisons to output
				System.err.println("runtime," + total_time);
				System.err.println("comparisons," + comparisons);
	
	
	}
	
}
