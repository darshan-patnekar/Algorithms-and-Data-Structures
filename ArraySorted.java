class ArraySorted
{
	public int isSorted(int[] A, int index)
	{
		if(index-2<0)
		{
			return 1;
		}
		else
		{
		    return(A[index-1]<A[index-2])?0:isSorted(A,index-1);
			
		}
	}

	public static void main(String[] args) 
	{
		ArraySorted s = new ArraySorted();
		int []numbers = {1,2,3,4,5,7};
		int result = s.isSorted(numbers, 6);
		if (result ==1)
		{
		    System.out.println("Sorted");
		}
		else
		{
		    System.out.println("Not Sorted");
		}
	}
}