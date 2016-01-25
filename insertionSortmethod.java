//Insertion sort method

void insertionSort()
{

   int valueToInsert;
   int holePosition;
   int i;

   int intArray[MAX] = {4,6,3,2,1,9,7};
  
   // loop through all numbers 
   for(i = 1; i < MAX; i++)
   { 
      // select a value to be inserted. 
      valueToInsert = intArray[i];
		
      // select the hole position where number is to be inserted 
      holePosition = i;
		
      // check if previous no. is larger than value to be inserted 
      while (holePosition > 0 && intArray[i-1] > valueToInsert)
      {
         intArray[holePosition] = intArray[holePosition-1];
         holePosition--;
         
      }

      if(holePosition != i)
      {
         // insert the number at hole position 
        intArray[holePosition] = valueToInsert;   
      }
   }  
}