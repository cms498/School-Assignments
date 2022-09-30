#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>

#define FALSE (0)
#define TRUE  (1)

int main() {
	int tot_chars = 0 ;	/* total characters */
	int tot_lines = 0 ;	/* total lines */
	int tot_words = 0 ;	/* total words */
	
	int prev_char = '\0';

	for(int ch = getchar(); ch != EOF; ch = getchar()){
		//if at the end of a line, increase line count by one
		if(ch == '\n'){
			tot_lines++;
		}

		//if the prevvious character is not a space and the next one is, increace word count
		if(!isspace(prev_char) && isspace(ch)){
			tot_words++;
		}

		//set the prev char to the current char, increase char count by one
		prev_char = ch;
		tot_chars++;
	}

	printf("%3d%3d%4d\n", tot_lines, tot_words, tot_chars);

	return 0 ;
}
