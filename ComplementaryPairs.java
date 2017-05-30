/**
 * 
 */

/**
 * @author imendoza
 *
 */
public class ComplementaryPairs {

	public static void main(String[] args) {
		int k = 8;

		int[] intArray1 = new int[]{4, 5, 6, 3, 1, 8, -7, -6, 7};
	    int[] intArray2 = new int[]{1, 2, 7, 5, 6, 3};
	    int[] intArray3 = new int[]{4, 5, 4, 3, 6, 8, -7, -6};
	    
	    System.out.println("Number of k="+k+" complementary pairs (intArray1): " + noOfComplementaryPairs(intArray1, k) +"\n");
	    System.out.println("Number of k="+k+" complementary pairs (intArray2): " + noOfComplementaryPairs(intArray2, k) +"\n");
	    System.out.println("Number of k="+k+" complementary pairs (intArray3): " + noOfComplementaryPairs(intArray3, k) +"\n");

	}
	
	
	public static int noOfComplementaryPairs(int arr[], int k) {
		int result = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			//Second for starts after 'i' because previous indexes have already been tested
		    for (int j = i + 1; j < arr.length; j++) {
		        if (arr[i] + arr[j] == k) {
                    result++;
                }
            }
        }
		//Need to duplicate the result, because every pair is twice k-complementary ("i,j" and "j,i")
        return result * 2;
	}

}
