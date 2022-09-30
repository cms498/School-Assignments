/*
 * Implementation of the read_data module.
 *
 * See read_data.h for a description of the read_data function's
 * specification.
 *
 * Note that the parameter declarations in this module must be
 * compatible with those in the read_data.h header file.
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "read_data.h"

// Reads the three fields from lines such as W$1349$1.414$ into
// local variables using getchar().
// Converts the two numeric fields to numbers using atoi for the
// integer fields and atof for the double.
// Using a correctly defined set of parameters (use pointers) pass
// those values back to the program that called this function.
void read_data(char *cp, int *ip, double *dp) {
	int ch = 0;
	char str[25];
	int index = 0;

	ch = getchar();
	*cp = ch;
	ch = getchar();
	ch = getchar();

	while(ch != '$'){
		str[index] = ch;
		index++;
		ch = getchar();
	}
	str[index] = '\0';
	*ip = atoi(str);
	
	for(int clear = 0; clear < 25; clear++){
		str[clear] = ' ';
	}

	ch = getchar();
	index = 0;
	while(ch != '$'){
		str[index] = ch;
		index++;
		ch = getchar();
	}
	str[index] = '\0';
	*dp = atof(str);

	return ;
}
