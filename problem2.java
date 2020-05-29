import java.util.*;

public class problem2 
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
		System.out.println("Elements of the array are: "+array);
		int low = 0, high = array.size()-1;
		problem2 obj = new problem2();
		int result = obj.findMax(array, low, high);
		System.out.println("The maximum element in the array is: "+result);
	}
	public static int findMax(ArrayList<Integer> array, int low, int high)
	{
		
		if(low == high)
		{
			return array.get(low);
		}
		int leftlargest = findMax(array, low, (int) Math.floor((low + high)/2));
		int rightlargest = findMax(array, (int) Math.floor((low+high)/2)+1, high);
		return Math.max(leftlargest, rightlargest);
	}
}
