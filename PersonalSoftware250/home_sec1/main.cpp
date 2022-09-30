#include "HomeSecurity.h"
#include "Parser.h"

//A fixed size array of Room objects
    Room rooms[5];
int main(int argc, char** argv)
{

    if (argc < 2)
    {
        cout << "Please provide filename: syntax is './hs {filename}' "<<endl;
        return -1;
    }
    string file = argv[1];
    CSVParser p(file);
    //The following code will read all the text lines and parse the comma separated values into a vector
    //The LoadData method will be called to populate the room object with this data
    //ROOM,SID,HH:MM:SS,TYPE[,VALUE]
    vector<string> lines = p.ReadLines(); //Read all the lines of text into a vector object
    for (string s : lines)
    {
        if (s.length() == 0)
            continue;
        vector<string> data = p.ParseString(s);//Split each csv line into a new vector object
        int roomId = stoi(data[0]);
        rooms[roomId].LoadData(data);//Ask the method LoadData to take the vector array and populate the object
    }
    //cout<<"\nDone reading file\n";
    return 0;
}


