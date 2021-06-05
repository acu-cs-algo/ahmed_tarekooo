**
 ** Java Program to Implement Euclid GCD Algorithm
 **/
 
import java.util.Scanner;
 
/* Class EuclidGcd */
public class EuclidGcd    
{
    /* Function to calculate gcd */
    public long gcd(long p, long q)
    {
        if (p % q == 0)
            return q;
        return gcd(q, p % q);
    }
    /* Main function */
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Euclid GCD Algorithm Test\n");
        /* Make an object of EuclidGcd class */
        EuclidGcd eg = new EuclidGcd();
 
        /* Accept two integers */
        System.out.println("Enter two integer numbers\n");
        long n1 = scan.nextLong();
        long n2 = scan.nextLong();
        /* Call function gcd of class EuclidGcd */
        long gcd = eg.gcd(n1, n2);
        System.out.println("\nGCD of "+ n1 +" and "+ n2 +" = "+ gcd);
    }
}