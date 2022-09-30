// C (no pointers) Practicum
// SWEN-250
// Larry Kiser Feb. 13, 2018
//             New no pointers practicum without structs
// Revised Feb. 28, 2021 for 250-01 term 2205
// Revised Feb. 15, 2021 for 250-04 term 2215

#include <stdlib.h>
#include <stdio.h>
#include "cpracticum.h"
#include "unit_tests.h"

// Create a loop that goes to the end of the passed string that
// counts the number of parenthesis characters (both left and right)
// in the string.
// Return that number of left and right parentheses from this function.
//
// Return 0 if there are no parentheses in the string.
// Return 0 if the passed string is an empty string.
// Otherwise, return the number of parenthesis characters in the string.
//
// You are NOT allowed to use any library functions. You must write
// C code that determines whether or not each character is either a
// left or right parenthesis character.
// If you wish you can create a helper function that checks for parentheses.
// You could then call that function in your loop that searches the string.
// NOTE -- the plural of parenthesis is parentheses.
int count_number_of_parentheses( char mystring[] )
{
	int count = 0;
	int index = 0;

	if(mystring[0] == '\0'){
		return 0;
	}
	while(mystring[index] != '\0'){
		if(mystring[index] == ')' || mystring[index] == '('){
			count ++;
		}
		index++;
	}
	return count ;		// fix this -- incorrect value to allow the code to compile without warnings.
}

// For the passed string you must convert lower case letters abcdef to upper case letters.
// Do not change make any other changes to the array.
// For example a string "ab132 CD==" would become "AB123 CD==".
// Another example: "33abcdefgh" becomes "33ABCDEFgh".
// The string may be an empty string. If it is empty do nothing.
// Note that this means you are directly changing the characters in the passed string.
// Hint -- per the ASCII code chart an 'a' is 97 decimal and an 'A' is 65 decimal.
//         You can use that difference to convert from lower case to upper case.
void convert_a_to_f_to_upper_case( char mystring[] )
{
	int index = 0;
	while(mystring[index] != '\0'){
		if (mystring[index] >= 97 && mystring[index] <= 102){
			mystring[index] -= 32;
		}
		index++;
	}
}


// This function is implemented incorrectly. You need to correct it.
// It is supposed to total up the integers in the array.
// The number of entries to add up is the second parameter.
// It returns that total.
// NOTE -- you are required to correct this code. You are not allowed to completely rewrite it.
//         There are several errors in this routine. You must fix all errors. It is possible that the
//         unit tests may pass without all errors being corrected. Make sure that your corrected
//         code does not produce any warnings.
int fix_bad_code( int numbers[], int number_to_add )
{
	int i = 0;
	int total = 0 ;
	
	while ( i < number_to_add ){
		total += numbers[ i ] ;
		i++;
	}
	return total ;
}


// Only runs the unit tests.
int main( int argc, char *argv[] ) {

	// Execute unit tests
	return test() ;
}

