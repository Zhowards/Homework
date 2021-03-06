package comp2011.a1;
import java.util.Arrays;

/**
 * 
 * @author Yixin Cao (September 11, 2021)
 *
 * A better implementation of insertion sort.
 * 
 * The ith major iteration of insertion sort puts element a[i] to its correct position.
 * Your algorithm should use *binary search* to find the position of the first element 
 * that is greater than (> not >=) a[i], or i if there does exist such an element.
 * 
 * Read the {@code Element} class carefully before you start.
 * It uses an extra field *originalPos* to store the index of this element in the input.
 * When an element is output, originalPos is printed in parentheses.
 * 
 * If your implementation is correct, elements of the same value should respect their original order,
 * e.g., for input {1.25, 0, 1.25, 2.5, 10, 2.5, 1.25, 5, 2.5}, the output should be  
 * [0.0 (1), 1.25 (0), 1.25 (2), 1.25 (6), 2.5 (3), 2.5 (5), 2.5 (8), 5.0 (7), 10.0 (4)].
 */
public class Sorting { // Please change!
	/*
	 * Each element has a double value and the original position in the input array. 
	 */
	static class Element {
	    private int originalPos;
	    double value;
	    public Element(int i, double v) {
	        originalPos = i; 
	        value = v;
	    }
	    public String toString() {
	        return (String.valueOf(value)) + " (" + String.valueOf(originalPos) + ")";
	    }
	}
    
    /**
     * VERY IMPORTANT.
     * 
     * I've discussed this question with the following students:
     *     1. 
     *     2. 
     *     3. 
     *     ... 
     * 
     * I've sought help from the following Internet resources and books:
     *     1. 
     *     2. 
     *     3. 
     *     ... 
     * 
     * Running time: O( n*n  ) in worst case.   
     */ 
    public static void insertionSort(Element[] a) {
        // 
		int i, j, n = a.length;
		for(i=1; i<n; i++){
			// a[pos] is the first element that is greater than a[i]
			Element key = a[i];
			int pos = binarySearch(a, i, key); 
			for(j=i; j>pos; j--){
				a[j] = a[j-1];
			}
			if( j!=i ) a[j] = key;
		}
    }
	// return the position of the first element that is greater than e
	// Runing time: O(log n)
	public static int binarySearch(Element[] a, int k, Element e){
		int res = k;
		int low = 0, high = k-1, m;
		while( low <= high ){
			m = low + (high-low)/2;
			if( e.value < a[m].value ){
				res = m;
				high = m-1;
			}else{
				low = m+1;
			}
		}
		return res;
	}
    
    // The original insertion sort is copied for your reference.
    public static void insertionSort(int[] a) {
        int i, j, key, n = a.length;
        for (i = 1; i < n; i++) {
            key = a[i];
            for (j = i - 1; j >= 0; j--) {
                if (a[j] <= key) break;     
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }
    
    // The binary search algorithm is copied for your reference.
    public static int binarySearch(int[] a, int key) {
        int n = a.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] > key) high = mid - 1;
            else if (a[mid] < key) low = mid + 1; 
        }
        return -1;
    }
    
    public static void main(String[] args) {
        double input[] = {1.25, 0, 1.25, 2.5, 10, 2.5, 1.25, 5, 2.5}; // try different inputs.
        int n = input.length;
        Element[] a = new Element[n];
        for (int i = 0; i < input.length; i++) 
            a[i] = new Element(i, input[i]);
        
        System.out.println("Original: " + Arrays.toString(a));
        insertionSort(a);
        System.out.println("After sorted: " + Arrays.toString(a));
    }
}

