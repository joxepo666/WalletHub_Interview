/**
 * 
 */

/**
 * @author imendoza
 *
 */
public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Is palindrome: "+isPalindrome("1221") +"\n"); //Palindrome
		System.out.println("Is palindrome: "+isPalindrome("Arenera")+"\n");//Palindrome
		System.out.println("Is palindrome: "+isPalindrome("arenero")+"\n");// NOT Palindrome
		System.out.println("Is palindrome: "+isPalindrome("1121")+"\n");//NOT Palindrome
		System.out.println("Is palindrome: "+isPalindrome("reconocer")+"\n");//Palindrome
		System.out.println("Is palindrome: "+isPalindrome("salar")+"\n");//NOT Palindrome
		
	}
	
	
	
	public static boolean isPalindrome(String str){
		String reverseStr = new StringBuilder(str).reverse().toString();
		System.out.println("Input: "+str);
		System.out.println("Reverse: "+reverseStr);
		// Ignore caps. 
		return str.equalsIgnoreCase(reverseStr);
	}

}
