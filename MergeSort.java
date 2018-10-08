/*
 * Java Program to Implement Merge Sort
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
 

//overriding compare method to keep count of no. of comparison
class MergeSort_Comparator implements Comparator<Integer> {
@Override
public int compare(Integer a, Integer b) {
   MergeSort.comparisons++;
   if(a > b) {
       return 1;
   }
   else if(a <= b) {
       return -1;
   }
   return 0;
}
}

/* Class MergeSort */
public class MergeSort 
{
	public static long comparisons = 0;
	public static Comparator<Integer> comp = new MergeSort_Comparator();
    /* Merge Sort function */
    public static void sort(List<Integer> list, int low, int high) 
    {
        int N = high - low;         
        if (N <= 1) 
            return; 
        int mid = low + N/2; 
        // recursively sort 
        sort(list, low, mid); 
        sort(list, mid, high); 
        // merge two sorted subarrays
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) 
        {
        
            if (i == mid)  
                temp[k] = list.get(j++);
            else if (j == high) 
                temp[k] = list.get(i++);
            else if (comp.compare(list.get(i), list.get(j))==1) 
                temp[k] = list.get(j++);
            else 
                temp[k] = list.get(i++);
        }    
        for (int k = 0; k < N; k++) 
            list.set(low+k, temp[k]);         
    }
    /* Main method */
    public static void main(String[] args) 
    {

    	
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
		
   
 		
       
         /* Call method sort */
		long start_time = System.currentTimeMillis();
         sort(list, 0, n);
         long end_time = System.currentTimeMillis();
       
		//calculation of total runtime
 		long total_time=end_time-start_time;
	   
		//sorted output print
 		for(int k =0; k < list.size() ; k++)
			System.out.println(list.get(k));
         
 		// print runtime and comparisons to output
 		System.err.println("runtime," + total_time);
 		System.err.println("comparisons," + comparisons);
      
     
    }    
}
