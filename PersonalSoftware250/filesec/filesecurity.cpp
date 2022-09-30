#include "filesecurity.h"
#include <fstream> //File streams

//Default constructor
FileSecurity::FileSecurity()
{
    sourcePath = "";
}


//constructor with param
FileSecurity::FileSecurity(string filePath)
{
	sourcePath = filePath;
}

//Encode the sourceFile and put result in outputFile
bool FileSecurity::Encode()
{
	bool result = false;
	ifstream read_file(sourcePath);

	string outText = FileSecurity::CreateOutputFileName("_enc.txt") ;
	ofstream out_file(outText);
	char byte = 0;
	while (read_file.get(byte)) {
       		char characterEncoded = FileSecurity::EncodeByte(byte);
		out_file << characterEncoded;
    	}	

	out_file.close();
	read_file.close();
	return result;
}

//Decode the sourceFile and put result in outputFile
bool FileSecurity::Decode()
{
	bool result = false;
	ifstream read_file(sourcePath);

	string outText = FileSecurity::CreateOutputFileName("_dec.txt");
	ofstream out_file(outText);
	char byte = 0;

	while(read_file.get(byte)){
		char characterDecoded = FileSecurity::DecodeByte(byte);
		out_file << characterDecoded;		
	}	

	out_file.close();
	read_file.close();
	return result;
}

string FileSecurity::CreateOutputFileName(string append)
{
    string outputFile = sourcePath.substr(0, sourcePath.length() - 4);
    return outputFile.append(append);
}
//Basic encode
char FileSecurity::EncodeByte(char c)
{
    return c + 100;
}

//Basic decode
char FileSecurity::DecodeByte(char c)
{
    return c - 100;
}
