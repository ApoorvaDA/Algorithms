/*
Description:

Count the number of prime numbers less than a non-negative number, n.

Hint:

1. Let's start with a isPrime function. 
To determine if a number is prime, we need to check if it is not divisible by any number less than n. 
The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers up to n would be O(n2). Could we do better?

2. As we know the number must not be divisible by any number > n / 2, we can immediately cut the total iterations half by dividing only up to n / 2. 
Could we still do better?

3. Let's write down all of 12's factors:

2 × 6 = 12
3 × 4 = 12
4 × 3 = 12
6 × 2 = 12
As you can see, calculations of 4 × 3 and 6 × 2 are not necessary. 
Therefore, we only need to consider factors up to √n because, 
if n is divisible by some number p, then n = p × q and since p ≤ q, we could derive that p ≤ √n.
*/

public class Solution{
	public int countPrimes(int n){
		int count = 0;
		for (int i=1; i<n ;i++ ) {
			if (isPrime(n)) {
				count++;
			}
		}
		return count;
	}

	public boolean isPrime(int n){
		if (n<=1) {
			return false;
		}
		for (int i=2; i*i < n ;i++ ) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}

/* Another Solution*/
/*
It is called the Sieve of Eratosthenes algorithm. In the boolean array m, m[n] means the number n. 
Thus for each time, if m[n] is a prime, we need to delete all the multiple of m[n]. 
And finally, the remaining numbers are primes.
*/
public class Solution{
	public int countPrimes(int n){
  		boolean[] m = new boolean[n];
    	int count = 0;
    	for (int i=2; i<n; i++) {
        	if (m[i])
        	    continue;
             
        	count++;
        	for (int j=i; j<n; j=j+i)
        	    m[j] = true;
        	}
         
        return count;
    }    
}        