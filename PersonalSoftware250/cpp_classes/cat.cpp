#include "animal.h"
#include "cat.h"
#include <iostream>

using namespace std;

Cat::Cat()
{
    //Doesn't do anything
}
Cat::Cat(std::string a_name, std::string a_sound)
{
        name = a_name;
        sound = a_sound;
}

void Cat::Speak()
{
    cout << "The animal " << name << " says " << sound << endl;
}

void Cat::Trick()
{
    cout << "I can sleep all day" << endl;
}
