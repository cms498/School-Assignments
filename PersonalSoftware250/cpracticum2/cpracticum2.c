// C pointers practicum 2 with malloc and free
// SWEN-250 Term 2215
// Larry Kiser March 24, 2022

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "cpracticum2.h"
#include "unit_tests.h"


// Compare two arrays of integers that are terminated by the special
// value of -1 (the -1 says this is the end of the array)
//
// NOTE -- you are NOT allowed to use an index value in your solution.
//         You cannot use "pfirst + index" or "pfirst[index]" syntax.
//         Pro-Tip: use work pointers.
//
// Return 0 if the two arrays are identical. You must confirm that all values are the same!
// Return 1 if they are not the same length.
// Return 2 if one or more values are different but they are the same length.
// return 3 if either pointer is NULL.
int compare_arrays( int *pfirst, int *psecond )
{
	int pfirstLength = 0;
	int psecondLength = 0;
	int *pfirstWork = pfirst;
	int *psecondWork = psecond;
	if(pfirst == NULL || psecond == NULL){
		return 3;
	} else {
		while(*pfirstWork != -1){
			pfirstLength++;
			pfirstWork++;
		}
		while(*psecondWork != -1){
			psecondLength++;
			psecondWork++;
		}
		if(pfirstLength != psecondLength){
			return 1;
		}
		pfirstWork = pfirst;
		psecondWork = psecond;
		while(*psecondWork != -1){
			if(*psecondWork != *pfirstWork){
				return 2;
			}
			psecondWork++;
			pfirstWork++;
		}	
	}
	return 0;
}

// The first time this is called it returns the number passed in the value parameter.
// The second time it returns the sum of the previous value and the current value parameter.
// Each time after that it returns the sum of all previous values and the current value.
// Successive calls passing in 7, 2, and 3 would return 7 first time, 9 the second time,
// and 12 on the third time.
int sum_each_number( int value )
{
	static int result = 0;
	if(result != value){
		result += value;
	}
	return result;
}

// This function is implemented incorrectly. You need to correct it.
//
// When fixed it changes the third character in the passed string to 'A'.
// It returns returns 1 on success.
// It returns 0 if the passed string is NULL or is an empty string.
// If the passed string is not empty you can assume it has at least three characters.
//
// NOTE -- you are NOT allowed to use an index value in your solution.
//         You cannot use "pstring + index" or "pstring[index]" syntax.
//         You can use the increment and decrement operators (++ and --).
//         You can move the pointer with code like this: p += 4 which moves the pointer 4 positions.
//
int fix_bad_code( char *pstring )
{
	 

	// Pro-Tip: add code here to check for a NULL pointer to avoid a crash
	
	if ( sizeof( pstring ) == 0 || pstring == NULL || *pstring == '\0')
		return 0 ; 
	else {
		pstring += 2 ; 
		*pstring = 'A' ;
	}
	return 1 ;
}


// Create a new key_value_pair struct by allocating space on the help (use malloc).
// Here is a copy of the struct from cpracticum2.h for your convenience:
	// struct for create_copy function
	//struct key_value_pair
	//{   
    //	char *key ; 
    //	char *value ;
	//} ;
// You will also need to malloc space for the key and value strings
// in your malloc'd struct. You must malloc the exact amount of space
// needed for the key and the value string. Copy the passed key and
// value strings into this struct you created.
// Return this struct that you created.
//
// NOTE -- at the end of the unit tests the space you malloc'd for
//         the key, value, and the key_value_pair struct will be freed.
//         This code is at the bottom of unit_tests.c.
// NOTE -- If your code is incorrect you will get a severe error. If you cannot
//         get it to work without crashing comment out your code and return NULL.
// NOTE -- you are allowed to use strcpy.
// NOTE -- The passed key and value strings are valid and not empty. You do
//         not have to test the key and value strings for NULL or empty.
struct key_value_pair *create_key_value ( char *key, char *value )
{
	struct key_value_pair  *map = malloc(sizeof(struct key_value_pair));
	map -> key = malloc(strlen(key) + 1);
	map -> value = malloc(strlen(value) + 1);
	strcpy(map -> key, key);
	strcpy(map -> value, value);
	return map ;			// tells unit tests to not free the returned struct.	
}
