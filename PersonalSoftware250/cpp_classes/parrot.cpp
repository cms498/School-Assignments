#include "animal.h"
#include "parrot.h"
#include <iostream>

using namespace std;

Parrot::Parrot()
{
    //Doesn't do anything
}
Parrot::Parrot(std::string a_name, std::string a_sound)
{
        name = a_name;
        sound = a_sound;
}

void Parrot::Speak()
{
    cout << "The animal " << name << " says " << sound << endl;
}

void Parrot::Trick()
{
    cout << "I can talk all day long, I love sailing on ships" << endl;
}
