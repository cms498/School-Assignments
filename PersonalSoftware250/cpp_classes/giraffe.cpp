#include "animal.h"
#include "giraffe.h"
#include <iostream>

using namespace std;

Giraffe::Giraffe()
{
    //Doesn't do anything
}
Giraffe::Giraffe(std::string a_name, std::string a_sound)
{
        name = a_name;
        sound = a_sound;
}

void Giraffe::Speak()
{
    cout << "The animal " << name << " says " << sound << endl;
}

void Giraffe::Trick()
{
    cout << "I love my long neck" << endl;
}
