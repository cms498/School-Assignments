#include <string>
#ifndef _dog
#define _dog
class Dog : public Animal
{
    public:
    Dog(); //Default ctor
    Dog(std::string a_name, std::string a_sound);
    void Speak();
    void Trick();

    private:
    std::string name;
    std::string sound;
};
#endif
