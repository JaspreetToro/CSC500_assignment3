import java.util.*;

public class problem3 
{
	public static void main(String args[])
	{
		int length; 
		Scanner input = new Scanner(System.in);
		System.out.println("How many elements you want in the array: ");
		length = input.nextInt();
		System.out.println("Please eneter the elements in the array: ");
		int arr[] = new int[length];
		for(int counter=0; counter < length; counter++)
		{
			arr[counter] = input.nextInt();
		}
		input.close();
		int low = 0, high = arr.length -1;
		System.out.println("Elements of the array are: ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		problem3 obj = new problem3();
		int result = obj.findMajority(arr, low, high);
		if(result == -1)
		{
			System.out.println("Majority Element: "+"null");
		}
		else 
		{
			System.out.println("Majority Element: "+result);
		}
	}
	public static int findMajority(int[] arr, int low1, int high1)
	{
		int mid = (int)Math.floor((low1+high1)/2);
		if(low1 == high1)
		{
			return arr[low1];
		}
		int leftMajority = findMajority(arr, low1, mid);
		int rightMajority = findMajority(arr, mid+1, high1);
		if(leftMajority == rightMajority)
		{
			return leftMajority;
		}
		int leftcount = 0,rightcount =0;
		int low = 0; int high = arr.length-1;
		for (int i = low; i <= high; i++)
		{
			if(arr[i] == leftMajority)
			{
				leftcount++;
			}
			else if (arr[i] == rightMajority)
			{
				rightcount++;
			}
		}
		int half = (int) Math.floor(arr.length/2);
		if(leftcount > half)
		{
			return leftMajority;
		}
		if(rightcount > half)
		{
			return rightMajority;
		}
		else 
			return -1;
	}
}
