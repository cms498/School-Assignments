/*
 * Skeleton implementation for the activity to parse and print
 * CSV formatted files read from standard input.
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "csv.h"
#include "unit_tests.h"


/*
 * Returns true iff the character 'ch' ends a field. That is, ch is end of file,
 * a comma, or a newline.
 */

bool is_end_of_field(int ch) {
	return (ch == ',') || (ch == '\n') || (ch == EOF) || (ch == '\r') ;
}

/*
 * Return the minimum of two integers.
 */

int min(int x, int y) {
	return x < y ? x : y ;
}

/*
 * Read the next field from standard input. Returns the value of getchar() that
 * stopped (terminated) the field.
 */

int get_field(f_string field) {
	int index = 0;
	int ch = 0;
	for(ch = getchar(); is_end_of_field(ch) == false; ch = getchar()){
		field[index] = ch;
		index++;
	}
	field[index] = '\0';
	return ch;

}

/*
 * Read in a CSV line. No error checking is done on the number of fields or
 * the size of any one field.
 * On return, the fields have been filled in (and properly NUL-terminated), and
 * nfields is the count of the number of valid fields.
 * nfields == 0 means end of file was encountered.
 */

csv_line get_line() {
	csv_line line; //csv_line struct called line
	int i = 0; // keeps track of index for the field array
	line.nfields = 0; // keeps track of # of fields

	int breakchar = get_field(line.field[i]); // used to recude lines of code
	i++; // move to next index

	if(breakchar == ','){ // if that index is a comma that means we had a field before and a field after
		line.nfields += 2; // therefore we can increase the fieldcount by 2
	}

	while(breakchar != '\n' && breakchar != EOF){// basic loop structure in problem statement
		breakchar = get_field(line.field[i]);
		i++;
		if(breakchar == ','){
			line.nfields++;
		}
	}
	return line;
}

/*
 * Print a CSV line, associating the header fields with the
 * data line fields.
 * The minimum of the number of fields in the header and the data
 * determines how many fields are printed.
 */

void print_csv(csv_line header, csv_line data) {
	int min_val = min(header.nfields, data.nfields);
	for(int i = 0; i < min_val; i++){
		printf("%s = %s\n", header.field[i], data.field[i]);
	}
}

/*
 * Driver - read a CSV line for the header then read and print data lines
 * until end of file.
 */

int main( int argc, char *argv[] ) {
	csv_line header ;
	csv_line current ;

	// LLK additional if statement to execute unit tests if program
	// name contains "test".
	if ( strstr( argv[0], "test" ) )
		return test() ;

	header = get_line() ;
	current = get_line() ;

	while ( current.nfields > 0 ) {
		print_csv(header, current) ;
		current = get_line() ;
	}

	return 0 ;
}
