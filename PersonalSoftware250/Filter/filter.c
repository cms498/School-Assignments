/*
 * Implementation of functions that filter values in strings.
 *****
 * YOU MAY NOT USE ANY FUNCTIONS FROM <string.h> OTHER THAN
 * strcpy() and strlen()
 *****
 */

#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#include "filter.h"

#define NUL ('\0')

/*
 * YOU MAY FIND THIS FUNCTION USEFUL.
 * Return true if and only if character <c> is in string <s>.
 */
//static bool includes(char c, char *s) {
//	while( *s && c != *s ) {
//		s++ ;
//	}
//	return c == *s ;
//}

/*
 * YOU MAY ALSO FIND THIS FUNCTION USEFUL.
 * Return true if and only if string <pre> is a prefix of string <s>.
 */
static bool prefix(char *s, char *pre) {
	while( *pre && *s == *pre ) {
		s++ ;
		pre++ ;
	}
	return *pre == NUL ;
}

/*
 * Copy <string> to <result> while removing all occurrences of <ch>.
 */
void filter_ch_index(char string[], char result[], char ch) {
	int index = 0;
	int result_index = 0;
	while(string[index] != NUL){
		if(string[index] != ch){
			result[result_index] = string[index];
			result_index++;
		}
		index++;
	}
	result[result_index] = NUL;
}

/*
 * Return a pointer to a string that is a copy of <string> with
 * all occurrences of <ch> removed. The returned string must occupy
 * the least possible dynamically allocated space.
 *****
 * YOU MAY *NOT* USE INTEGERS OR ARRAY INDEXING.
 *****
 */
char *filter_ch_ptr(char *string, char ch) {
	char *p_copy = malloc(strlen(string) + 1);
	char *p = p_copy;
	while(*string != NUL){
		if (*string != ch){
			*p = *string;
			p++;
		}
		string++;
	}
	*p = NUL;
	p = malloc(strlen(string) + 1);
	strcpy(p, p_copy);
	free(p_copy);
	return p;
}

/*
 * Copy <string> to <result> while removing all occurrences of
 * any characters in <remove>.
 */
void filter_any_index(char string[], char result[], char remove[]) {
	int string_index = 0;
	int result_index = 0;
	int remove_index = 0;
	
	for(string_index = 0; string[string_index] != NUL; string_index++){
		for(remove_index = 0; remove[remove_index] != NUL; remove_index++){
			if(string[string_index] == remove[remove_index]){
				break;	
			}
		}
		if(remove_index == strlen(remove)){
			result[result_index] = string[string_index];
			result_index++;	
		}
	}
	result[result_index] = NUL;
}

/*
 * Return a pointer to a copy of <string> after removing all
 * occurrrences of any characters in <remove>.
 * The returned string must occupy the least possible dynamically
 * allocated space.
 *****
 * YOU MAY *NOT* USE INTEGERS OR ARRAY INDEXING.
 *****
 */
char *filter_any_ptr(char *string, char* remove) {
	char *p_copy = malloc(strlen(string) + 1);
	char *p = p_copy;
	char *remove_pointer;

	while(*string != NUL){
		remove_pointer = remove;
		while(*remove_pointer != NUL){
			if(*string == *remove_pointer){
				break;	
			} else {
				remove_pointer++;
			}
		}
		if(*remove_pointer == NUL){
			*p = *string;
			p++;
		}
		string++;
	}
	*p = NUL;
	p = malloc(strlen(p_copy) + 1);
	strcpy(p, p_copy);
	free(p_copy);
	return p;
}

/*
 * Return a pointer to a copy of <string> after removing all
 * occurrrences of the substring <substr>.
 * The returned string must occupy the least possible dynamically
 * allocated space.
 *****
 * YOU MAY *NOT* USE ARRAY INDEXING.
 *****
 */
char *filter_substr(char *string, char* substr) {
	char *p_copy = malloc(strlen(string) + 1);
	char *p = p_copy;
	char *substr_pointer = substr;
	int counter = 0;
	
	while(*string != NUL){
		counter = 0;
		substr_pointer = substr;
		if(prefix(string, substr)){
			while(*substr_pointer != NUL){
				counter++;
				substr_pointer++;
			}
			string += counter;
		} else {
			*p = *string;
			string++;
			p++;
		}
	}
	*p = NUL;
	p = malloc(strlen(p_copy) + 1);
	strcpy(p, p_copy);
	free(p_copy);
	return p;
}
