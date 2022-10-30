#include "animal.h"
#include <iostream>
#include <string>

using namespace std;

class Dog: public Mammal {
    private:
        string _owner;
    public:
        Dog(): Mammal() {
            cout << "constructing Dog object" << endl;
        }
        Dog(string n, COLOR c, string o): Mammal(n,c) {
            _owner = o;
            cout << "constructing Dog object " << Animal::getName() <<
                " of " << Animal::getColor() << " colour" << endl;
        }

        void speak();
        void move();
        void eat();

        ~Dog() {
            cout << "destructing Dog object" << Animal::getName() << endl;
        }
};

class Cat: public Mammal {
    private:
        string _owner;
    public:
        Cat(): Mammal() {
            cout << "constructing Cat object" << endl;
        }
        Cat(string n, COLOR c, string o): Mammal(n,c) {
            _owner = o;
            cout << "constructing Cat object " << Animal::getName() <<
                " of " << Animal::getColor() << " colour" << endl;
        }

        void speak();
        void move();
        void eat();
    
        ~Cat() {
            cout << "destructing Cat object" << Animal::getName() << endl;
        }
};

class Lion: public Mammal {
    private:
        string _owner;
    public:
        Lion(): Mammal() {
            cout << "constructing Lion object" << Animal::getName() << endl;
        }
        Lion(string n, COLOR c, string o): Mammal(n,c) {
            _owner = o;
            cout << "constructing Lion object " << Animal::getName() <<
                " of " << Animal::getColor() << " colour" << endl;
        }

        void speak();
        void move();
        void eat();

        ~Lion() {
            cout << "destructing Lion object" << Animal::getName() << endl;
        }
};