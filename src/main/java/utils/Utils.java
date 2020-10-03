package utils;

import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;

public class Utils {
	public static List<Integer> suiteFibonacci(int n) {
		int nbr1 = 0, nbr2 = 1, response = 0;
		List<Integer> myList = new ArrayList<Integer>();

		while (response < n) {
			response = nbr1 + nbr2;
			nbr1 = nbr2;
			nbr2 = response;
			myList.add(response);
		}

		return myList;
	}

	
	public static BigInteger factorielleGrandNombre(int n) {
	    BigInteger produit = BigInteger.ONE;
	    BigInteger mul = BigInteger.ONE;
	    for (int i = 1; i <= n; i++ , mul = mul.add(BigInteger.ONE))
	        produit = produit.multiply(mul);
	    return produit;
	}
}
