import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class problem1 
{
	public static void main(String args[])
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the number of elements in your ArrayList: ");
		int n = in.nextInt();
		System.out.println("Please enter the elements in your ArrayList: ");
		for(int i = 0; i<n; i++)
		{

            int userInput = in.nextInt(); 
            array.add(userInput); 
        }
		System.out.println("Elements user entered: "+array);
		Collections.sort(array);
		System.out.println("Sorted Array: "+array);
		System.out.println("Please choose the element from the above array which you want to search ");
        int key = in.nextInt();
		problem1 ob = new problem1(); 
		int low = 0; int high = array.size()-1;
		int result = ob.binarySearch(array, key, low, high); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
	}
	public static int binarySearch(ArrayList<Integer> array, int key, int low, int high)
	{
		if(low > high)
		{
			return -1;
		}
		int p = low + (int) Math.floor((high - low) / 3);
		int q = high - (int) Math.floor((high - low) / 3);
		if(key == array.get(p))
		{
			return p; 
		}
		else if (key == array.get(q))
		{
			return q;
		}
		else if (key < array.get(p))
		{
			return binarySearch(array, key, low, p-1);
		}
		else if (key > array.get(q))
		{
			return binarySearch(array, key, q+1, high);
		}
		else 
			return binarySearch(array, key, p+1, q-1);
	}
}
