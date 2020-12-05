package cs3310finalproblem1;

/*
    S. Renee Eller
    CS 3310 Section 2 
    Final Problem 1 

    Time Complexity: O(n) 
    Memory Complexity: O(1)
 */
public class CS3310FinalProblem1
{

    public static void main(String[] args)
    {
        int [] a = {-3, -1, 6, -3, -1, 1, 8, -5};
        System.out.println("Array:");
        for (int index: a)
        {
            System.out.print(index + "      ");
        }    
        System.out.println();
        System.out.println("Maximum contiguous sum of this array is :");
        System.out.println(maximumSubArraySum(a));
    } 
  
    public static int maximumSubArraySum(int a[]) 
    {  
        int currentMaximum = Integer.MIN_VALUE; 
        int endMaximum = 0; 
  
        for (int i = 0; i < a.length; i++) 
        { 
            endMaximum = endMaximum + a[i]; 
            if (endMaximum < 0)
            {
                endMaximum = 0;                 
            }            
            else if (currentMaximum < endMaximum)
            {
                currentMaximum = endMaximum;     
            }    
        } 
        return currentMaximum; 
    }         

}
