#include <string>
#ifndef _cat
#define _cat
class Cat : public Animal
{
    public:
    Cat(); //Default ctor
    Cat(std::string a_name, std::string a_sound);
    void Speak();
    void Trick();

    private:
    std::string name;
    std::string sound;
};
#endif
