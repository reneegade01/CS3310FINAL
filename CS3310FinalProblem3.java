package cs3310finalproblem3;
/*
    S. Renee Eller
    CS 3310 Section 2
    Final Problem 4 
    Time Complexity: O(n^3)
    Memory Complexity: O(n)
 */
public class CS3310FinalProblem3 
{

    public static void main(String[] args)
    {
        int arr[][] = new int[][] { { 0, 2, -1, -4, 25 },
                                    { -8, 3, 8, 2, 1 },
                                    { 3, -8, 11, 1, 2 },
                                    { -4, -1, 7, -6 } };
       
        System.out.println("The maximum of this rectangle is: " + maxSumRectangle(arr));
        
    }
    
    private static int maxSumRectangle(int[][] arr)
    {
        int n = arr.length;
        int preSum[][] = new int[n + 1][n];
 
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                preSum[i + 1][j] = preSum[i][j] + arr[i][j];
            }
        }
 
        int maxSum = -1;
        int minSum = Integer.MIN_VALUE;
        int negRow = 0, negCol = 0;
        int rStart = 0, rEnd = 0, cStart = 0, cEnd = 0;
        for (int rowStart = 0; 
             rowStart < n; 
             rowStart++) 
        {
            for (int row = rowStart; row < n; row++) 
            {
                int sum = 0;
                int curColStart = 0;
                for (int col = 0; col < n; col++) 
                {
                    sum += preSum[row + 1][col]
                           - preSum[rowStart][col];
                    if (sum < 0)
                    {
                        if (minSum < sum)
                        {
                            minSum = sum;
                            negRow = row;
                            negCol = col;
                        }
                        sum = 0;
                        curColStart = col + 1;
                    }
                    else if (maxSum < sum) 
                    {
                        maxSum = sum;
                        rStart = rowStart;
                        rEnd = row;
                        cStart = curColStart;
                        cEnd = col;
                    }
                }
            }
        }

        if (maxSum == -1)
        {
            System.out.println("From row " + negRow
                               + " to row " + negRow);
            System.out.println("From column " + negCol
                               + " to column " + negCol);
            System.out.println(); 
        }
        else
        {
            System.out.println("From row " + rStart
                               + " to row " + rEnd);
            System.out.println("From column " + cStart
                               + " to column " + cEnd);
        }
        return maxSum == -1 ? minSum : maxSum;
    }    
    
}
