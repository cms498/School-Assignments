/* prime-number finding program
Originally by Norman Matloff, UC Davis
http://wwwcsif.cs.ucdavis.edu/~davis/40/gdb_Tutorial.htm
Modified by Mark Ardis, RIT, 11/1/2006

Will report a list of all primes which are less than
or equal to the user-supplied upper bound.
WARNING: There are bugs in this program! */

#include <stdio.h>

int primes[15];  /* primes[i] will be 1 if i is prime, 0 otherwise */
int upper_bound; /* check all numbers up through this one for primeness */


/* This function checks to see if the value inputted is prime
 * Parameters: int k which is the number being checked
 * Parameters: int primes[], which is an integet array where the values "primness" is stored
 * Output: None */
void check_prime(int k, int primes[]) {
  int j;

  /* the plan:  see if j divides k, for all values j which are
  themselves prime (no need to try j if it is nonprime), and
  less than or equal to sqrt(k) (if k has a divisor larger
  than this square root, it must also have a smaller one,
  so no need to check for larger ones) */
 
  j = 2;
  while (j * j <= k) {
    if (primes[j] == 1){
      if (k % j == 0)  {
        primes[k] = 0;
        return;
      } 
    } 
    j++;
  } 

  /* if we get here, then there were no divisors of K, so it is prime */
  primes[k] = 1;

}

//This function calls the check_prime function and is where the main functionality of the program is housed
//It takes no parameters and returns nothing
int main() {
  int i;

  printf("Enter upper bound:\n");
  scanf("%d", &upper_bound);
  primes[1] = 1;//number 1 and 2 are both prime, so we can set them automatically here
  primes[2] = 1;

  //while we are under our upper bound, check to see if the value is prime, if so, print a message
  for (i = 3; i <= upper_bound; i += 2) {
    check_prime(i, primes);
    if (primes[i]) {
      printf("%d is a prime\n", i);
    } 
  } 
  return 0;
}
