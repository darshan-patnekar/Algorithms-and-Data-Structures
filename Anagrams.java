package Permutation;


public class Anagrams {
	static int count = 0;

	public static void inOrderPermutation(String s){
		inOrderPermutation("",s);
		System.out.println(count);
	}

	private static void inOrderPermutation(String prefix, String s) {
		int n = s.length();
		
		if(n==0){
			System.out.println(prefix);
			count++;
		}
		else{
			for(int i = 0; i < n; i++)
			{
				inOrderPermutation(prefix + s.charAt(i), s.substring(0, i)+ s.substring(i+1));
			}
		}
		
	}
	
	public static void main(String[] args) {
		inOrderPermutation("ABCDEFGHIJK");
	}
	
}
