package anagrams;


import java.util.*;

public class AnagramsBucket
{
	public static void anagrams(ArrayList<String> a)
	{
		Map<String, ArrayList<String>> h = new Hashtable<>();
		for(String s:a)
		{
			char[] array = s.toCharArray();
			Arrays.sort(array);
			String sortedString = String.valueOf(array);
			if(!h.containsKey(sortedString))
			{
				//adding new buckets
				ArrayList<String> value = new ArrayList<>();
				value.add(s);
				h.put(sortedString, value);
			}
			else
			{
				//add elements to existing buckets
				ArrayList<String> existingValue = h.get(sortedString);
				existingValue.add(s);
				h.put(sortedString, existingValue);
			}
		}
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		result.addAll(h.values());
		for(ArrayList<String> a1:result)
		{
			System.out.print(a1);
		}
	}
	
	public static void main(String[] args) 
	{
		ArrayList<String> a = new ArrayList<>();
		a.add("star");
		a.add("rats");
		a.add("ice");
		a.add("cie");
		a.add("arts");
		AnagramsBucket.anagrams(a);
	}
	
}