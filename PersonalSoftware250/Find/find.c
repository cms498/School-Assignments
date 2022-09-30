/*
 * Implementation of functions that find values in strings.
 *****
 * YOU MAY NOT USE ANY FUNCTIONS FROM <string.h>
 *****
 */

#include <stdlib.h>
#include <stdbool.h>

#include "find.h"

#define NOT_FOUND (-1)	// integer indicator for not found.

/*
 * Return the index of the first occurrence of <ch> in <string>,
 * or (-1) if the <ch> is not in <string>.
 */
int find_ch_index(char string[], char ch) {
	int index = 0;
	while(string[index] != '\0'){
		if(string[index] == ch){
			return index;
		}
		index++;
	}
	return NOT_FOUND ;	// placeholder
}

/*
 * Return a pointer to the first occurrence of <ch> in <string>,
 * or NULL if the <ch> is not in <string>.
 *****
 * YOU MAY *NOT* USE INTEGERS OR ARRAY INDEXING.
 *****
 */
char *find_ch_ptr(char *string, char ch) {
	char *string_copy = string;
	while(*string_copy != '\0'){
		if(*string_copy == ch){
			return string_copy;
		}
		string_copy++;
	}		
	return NULL ;	// placeholder
}

/*
 * Return the index of the first occurrence of any character in <stop>
 * in the given <string>, or (-1) if the <string> contains no character
 * in <stop>.
 */
int find_any_index(char string[], char stop[]) {
	int i;
	int j;
	for(i = 0; string[i] != '\0'; i++){
		for(j = 0; stop[j] != '\0'; j++){
			if(string[i] == stop[j]){
				return i;
			}
		}
	}
	return NOT_FOUND ;	// placeholder
}

/*
 * Return a pointer to the first occurrence of any character in <stop>
 * in the given <string> or NULL if the <string> contains no characters
 * in <stop>.
 *****
 * YOU MAY *NOT* USE INTEGERS OR ARRAY INDEXING.
 *****
 */
char *find_any_ptr(char *string, char *stop) {
	char *string_copy = string;
	char *stop_copy = stop;
	char *distance_pointer = stop;
	while(*string_copy != '\0'){
		while(*stop_copy != '\0'){
			if(*string_copy == *stop_copy){
				return string_copy;
			}
			stop_copy++;
		}
		int dist = 0;
		dist = stop_copy - distance_pointer;
		stop_copy -= dist;
		string_copy++;
	}
	return NULL ;	// placeholder
}

/*
 * Return a pointer to the first character of the first occurrence of
 * <substr> in the given <string> or NULL if <substr> is not a substring
 * of <string>.
 * Note: An empty <substr> ("") matches *any* <string> at the <string>'s
 * start.
 *****
 * YOU MAY *NOT* USE INTEGERS OR ARRAY INDEXING.
 *****
 */
char *find_substr(char *string, char* substr) {
	char *string_copy = string; //pointer copy for string
	char *sub_copy = substr; //pointer copy for substring

	if (*sub_copy == '\0'){
		return string; //checks to see if the substr is "", as stated in directions
	}

	while (*string != '\0'){ // while the string still have characters in it, not copy as nothing is being changed
		if (*string == *substr){ // if the chars match
			string_copy = string;
			sub_copy = substr;
			string_copy++;
			sub_copy++;
			while(*string_copy == *sub_copy){ // loops until they dont makes or the sub_copy is ""
				if (*sub_copy == '\0'){
					return string;
				}
				string_copy++;
				sub_copy++;
				if (*sub_copy == '\0'){
					return string;
				}
			}		
		}
		string++; // moves to next char in the string for substrings
	}
	return NULL ;	// placeholder
}
