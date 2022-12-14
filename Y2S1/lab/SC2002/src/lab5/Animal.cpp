#include <iostream>
#include <string>

using namespace std ;

enum COLOR { Green, Blue, White, Black, Brown } ;

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

        void speak() const {
            cout << "Animal speaks "<< endl;
        }

        //void move() const { }
        virtual void move() = 0; //Q3.2 (4)

        string getName() {
            return _name;
        }

        string getColor() {
            string colour[5] = {"Green", "Blue", "White", "Black", "Brown"};
            return colour[_color];
        }

};

class Mammal: public Animal {
    public:
        Mammal() {
            cout << "constructing Mammal object " << Animal::getName() << endl;
        }
        Mammal(string n, COLOR c): Animal(n, c) {
            cout << "constructing Mammal object " << Animal::getName() << endl;
        }

        void eat() const {
            cout << "Mammal eat " << endl;
        }

        void move() override {
            cout << "Mammal moves" << endl;
        }
        virtual ~Mammal() {
            cout << "destructing Mammal object " << Animal::getName() << endl;
        }
};

class Dog: public Mammal {
    private:
        string _owner;
    
    public:
        Dog(): Mammal() {
            _owner = "NTU_student";
            cout << "constructing Dog object " << Animal::getName() << " with owner: " << _owner << endl;
        }

        Dog(string n, COLOR c, string o): Mammal(n,c) {
            _owner = o;
            cout << "constructing Dog object " << Animal::getName() << " whose owner is: " << _owner << endl;
        }

        ~Dog() {
            cout << "destructing Dog object " << Animal::getName() << endl;
        }

        void speak() {
            cout << "WOOF WOOF" << endl;
        }

        void move() override {
            cout << "*doggo does zoomies*" << endl;
        }

};


int main() {
    
    // Q3.1 Object instantiation
    // Animal a("animal_1", White);
    // a.speak();


    // Q3.2 (1) Inheritance
    // Mammal b("mammal_1", Green);
    // b.speak();


    // Q3.2 (2)
    // Dog c("doggie_1", Blue, "NTU_student");
    // c.speak();


    // Q3.2 (3)
    // Dog *ptr = new Dog("doggie_2", Blue, "NTU_student");
    // ptr->speak();
    // delete ptr;
    // --- or --- ///
    // Dog d("doggie_2", Blue, "NTU_student");
    // Dog *ptr = &d;
    // ptr->speak();

    // Q3.2 (4)
    // Dog *ptr = new Dog("doggie_3", Brown, "NTU_student");
    // ptr->move();
    // delete ptr;

    // Q3.3 Polymorphism
    // Animal *animalPtr = new Dog("Lassie", White, "Andy");
    // animalPtr->speak();
    // animalPtr->move();
    // delete animalPtr;
    /* for delete animalPtr to work, have to declare ~Animal and ~Mammal
        virtual eg. virtual ~Animal() {...}
        (Because) warning: delete called on 'Animal' that is abstract but has
        non-virtual destructor
    */
    Dog dogi("Lassie", White, "Andy");
    Mammal *aniPtr = &dogi;
    Mammal &aniRef = dogi;
    Mammal aniVal = dogi;

    aniPtr->speak();
            aniRef.speak();
                    aniVal.speak();
    // Additional destructing messages from ~Mammal and ~Animal from aniVal

    cout << "Program exiting …. "<< endl;
    return 0;
}