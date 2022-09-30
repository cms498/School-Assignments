#include <string> //string class
#include <iostream> //cout, cin ...
#include "animal.h"
#include "dog.h"
#include "cat.h"
#include "parrot.h"
#include "giraffe.h"

using namespace std; //so we don't have to say 'std::string' etc.


#define TEST_DOG
#define TEST_CAT
#define TEST_PARROT
#define TEST_GIRAFFE

int main()
{
    Animal generic("blank slate", "silence is golden");
    generic.Speak();
    generic.Trick();
    cout<<endl;

#ifdef TEST_DOG
    Dog fido("Rover", "Woof");
    fido.Speak();
    fido.Trick();
    cout<<endl;
    Animal* animal = new Animal("Old Yeller", "Bark and Bite");
    animal->Speak();
    animal->Trick();
    ((Dog*)animal)->Trick();
    cout<<endl;
#endif

#ifdef TEST_CAT
    Cat whiskers("Callie", "Meow");
    whiskers.Speak();
    whiskers.Trick();
    cout<<endl;
#endif

#ifdef TEST_PARROT
    Parrot polly("Polly", "Polly wants a cracker");
    polly.Speak();
    polly.Trick();
    cout << endl;
#endif

#ifdef TEST_GIRAFFE
    Giraffe geoff("Gerald", "Waaahhhaaaa");
    geoff.Speak();
    geoff.Trick();
    cout << endl;
#endif
    return 0;
}
