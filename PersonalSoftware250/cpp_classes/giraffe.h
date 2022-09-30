#include <string>
#ifndef _giraffe
#define _giraffe
class Giraffe : public Animal
{
    public:
    Giraffe(); //Default ctor
    Giraffe(std::string a_name, std::string a_sound);
    void Speak();
    void Trick();

    private:
    std::string name;
    std::string sound;
};
#endif
