#include <stdio.h>
#include <iostream>

#include "filesecurity.h"
using namespace std;

int main(int argc, char** argv)
{
	if(argc < 2 || (strcmp(argv[1], "-e") != 0 && strcmp(argv[1], "-d") != 0 ) || argv[2] == NULL){
		cout << "Usage:" << endl;
		cout << "filesec -e|-d [filename]" << endl;
		return 0;	
	}
	FileSecurity sec = FileSecurity(argv[2]);
	if(strcmp(argv[1], "-e") == 0){
		sec.Encode();
	} else {
		sec.Decode();
	}
	return 0;
}
