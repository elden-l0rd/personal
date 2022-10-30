#include <iostream>
#include <string>

using namespace std;

enum COLOR { Green, Blue, White, Black, Brown };

class Animal {
    private:
        string _name;
        COLOR _color;
    
    public :
        Animal() : _name("unknown") {
        cout << "constructing Animal object "<< _name << endl;
        }
        Animal(string n, COLOR c) {
            _name = n;
            _color = c;
            string color[5] = {"Green", "Blue", "White", "Black", "Brown"};
            cout << "constructing Animal object " <<_name <<" of " << color[c] << " colour" <<endl;
        }
        virtual ~Animal() {
            cout << "destructing Animal object "<< _name << endl;
        }

        virtual void speak() = 0;
        virtual void move() = 0;

        string getName();
        COLOR getColor();

};

class Mammal: public Animal {
    public:
        Mammal(): Animal() {
            cout << "constructing Mammal object" << endl;
        }
        Mammal(string n, COLOR c): Animal(n,c) {
            cout << "constructing Mammal object " << Animal::getName() <<
                    " and of " << Animal::getColor() << " colour" << endl;
        }
        ~Mammal() {
            cout << "destructing Mammal object" << endl;
        }

        virtual void move() = 0;
        virtual void speak() = 0;
        virtual void eat() = 0;
};