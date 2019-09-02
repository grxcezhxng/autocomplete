import java.lang.*;
import java.util.*;
import java.util.Comparator;
public class BinarySearchDeluxe {

    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	if (a == null || key == null || comparator == null) {
    		throw new java.lang.NullPointerException();
    	}
    	if (a.length == 0) {
    		return -1;
    	}
    	int l = 0;
    	int r = a.length - 1;
    	
    	while (l + 1 < r) {
    		int mid = l + (r - l)/2;
    		if (comparator.compare(key, a[mid]) <= 0) {
    			r = mid;
    		} else {
    			l = mid;
    		}
    	}
    	if (comparator.compare(key, a[l]) == 0) {
    		return l;
    	}
    	if (comparator.compare(key, a[r]) == 0) {
    		return r;
    	}
    	return -1;

    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	if (a == null || key == null || comparator == null) {
    		throw new java.lang.NullPointerException();
    	}
    	if (a == null || a.length == 0) {
    		return -1;
    	}
    	int l = 0;
    	int r = a.length - 1;
    	while (l + 1 < r) {
    		int mid = l + (r - l)/2;
    		if (comparator.compare(key, a[mid]) < 0) {
    			r = mid;
    		} else {
    			l = mid;
    		}
    	}
    	if (comparator.compare(key, a[r]) == 0) {
    		return r;
    	}
    	if (comparator.compare(key, a[l]) == 0) {
    		return l;
    	}
    	return -1;
    }
    
     // unit testing 
    public static void main(String[] args)   {
        //tests all methods 
        Term word1 = new Term("aa", 0); 
        Term word2 = new Term("ab", 0); 
        Term word3 = new Term("ab", 0); 
        Term word4 = new Term("ab", 0); 
        Term word5 = new Term("ad", 0); 
        Term[] a = {word1, word2, word3, word4, word5}; 
        Term key = new Term("ab", 0); 
        System.out.println(BinarySearchDeluxe_GZ.firstIndexOf(a, key, Term.byPrefixOrder(2))); 
        System.out.println(BinarySearchDeluxe_GZ.lastIndexOf(a, key, Term.byPrefixOrder(2))); 
    }
}