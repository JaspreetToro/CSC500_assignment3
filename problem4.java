import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class problem4 
{
    static int element;
    public static void main(String args[])
    {
        inputnumber();
    }
    public static void inputnumber()
    {
        System.out.println("Please enter the number of elements: ");
        Scanner in = new Scanner(System.in);
        element = in.nextInt();
        if(element > 0)
        {
            routine();
        }
        else 
        {
            System.out.println("You have entered a negative number, Please try again: ");
            inputnumber();
        }
    }
    public static void routine()
    {
        System.out.println("Element you entered: "+element);
        ArrayList<Integer> array = new ArrayList<Integer>(); 
        for (int i =0; i<element; i++)
        {
            array.add(ThreadLocalRandom.current().nextInt(-(element), element));
        }
        System.out.println("Randomly generated elements between the range"+"["+element+","+"-"+element+"]: "+array);
        System.out.println("===================================");
        int size = array.size();
        ArrayList<Integer> first = new ArrayList<Integer>(); 
        ArrayList<Integer> second = new ArrayList<Integer>();
        for(int i=0; i< size; i++)
        {
            if(i < (size+1)/2)
            {
                first.add(array.get(i));
            }
            else
            {
                second.add(array.get(i));
            }
        }
        //System.out.println("Elements of the first divided part: "+first);
        //System.out.println("Elements of the second divided part: "+second);  
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i =0; i<first.size(); i++)
        {
             for(int j =i+1; j<first.size(); j++)
             {
                    if (first.get(i) > first.get(j))
                    {
                          count1++;
                    }
             }
        }
        //System.out.println("Number of Inversion in first half:"+count1);
        for (int i =0; i<second.size(); i++)
        {
             for(int j =i+1; j<second.size(); j++)
             {
                    if (second.get(i) > second.get(j))
                    {
                          count2++;
                    }
             }
        }
        //System.out.println("Number of Inversion in second half:"+count2);
        for (int i =0; i<first.size(); i++)
        {
             for(int j =0; j<second.size(); j++)
             {
                if(first.get(i)> second.get(j))
                {
                    count3++;
                }
             }
        }
        //System.out.println("Number of Inversions in the two different halves: "+count3);
        int total = count1+count2+count3;
        System.out.println("Total number of inversion: "+total);
        System.out.println("===================================");
        int low = 0, high = array.size()-1;
        int leftsum = Integer.MIN_VALUE, rightsum= Integer.MIN_VALUE;
        int mid = (int) Math.floor((low+high)/2);
        int sum = 0, crossleft=0, crossright=0;
        int crossmax =0;
        int maxleft = Integer.MIN_VALUE, maxright = Integer.MIN_VALUE, leftstart=0, rightstart=0, leftend=0, rightend=0;
        if(high == low)
        {
            System.out.println("Max Subarray Range: "+"["+low+","+high+"]");
            System.out.println("Maximum Subarray Sum: "+array.get(low));
        }
        else
        {
            for (int i =0; i<= mid; i++) 
            {
                for (int j =i; j<=mid; j++) 
                {
                    int tempSum = 0;
                    for (int k =i; k<=j; k++)
                    {
                         tempSum += array.get(k);
                         if (tempSum > maxleft)
                         {
                            maxleft = tempSum;
                            leftstart = i; leftend = j;
                         }
                    }    
                }       
            }
            for (int i =mid+1; i<= high; i++) 
            {
                for (int j =i; j<=high; j++) 
                {
                    int tempSum = 0;
                    for (int k =i; k<=j; k++)
                    {
                         tempSum += array.get(k);
                         if (tempSum > maxright)
                         {
                            maxright = tempSum;
                            rightstart = i; rightend = j;
                         }
                    }    
                }       
            }
            for(int i = mid; i>= low; i--)
            {
                sum = sum + array.get(i);
                if(sum > leftsum)
                {
                    leftsum = sum; 
                    crossleft = i; 
                }
            }
            sum = 0; 
            for(int j =mid+1; j<=high; j++)
            {
                sum = sum + array.get(j);
                if(sum > rightsum)
                {
                    rightsum = sum;
                    crossright = j;
                }
            }
            crossmax = leftsum + rightsum; 
            if(maxleft > maxright && maxleft > crossmax) 
            {
                System.out.println("Max Subarray Range: "+"["+leftstart+","+leftend+"]");
                System.out.println("Maximum Subarray Sum: "+maxleft);
            }
            else if (maxright > maxleft && maxright > crossmax)
            {
                System.out.println("Max Subarray Range: "+"["+rightstart+","+rightend+"]");
                System.out.println("Maximum Subarray Sum: "+maxright);
            }
            else
            {
                System.out.println("Max Subarray Range: "+"["+crossleft+","+crossright+"]");
                System.out.println("Maximum Subarray Sum: "+crossmax);  
            }
        }
    }
}
