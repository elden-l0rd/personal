#include <iostream>
using namespace std;
class A{
    protected:
      int a,b;
    public:
      A(int x, int y) {
        a=x;
        b=y;
      }
      virtual void print();
};
class B: public A {
  private:
    float p,q;
  public:
    B(int m, int n, float u, float v) :A(m,n) {
      p=u;
      q=v;
    }
    B():A(0,0) {
      p=q=0;
    }
    void input(float a, float v);
    virtual void print(float);
};
void A::print(void) {
  cout << "A values: " << a << " " << b << "\n";
}
void B::input(float x, float y) {
  p=x;
  q=y;
}
//int doubleIt(A a) {return a.a*a.a;}

int main() {
  A a1(10,20), *ptr;
  B b1;
  b1.input(7.5, 3.142);
  ptr = &a1;
  ptr->print();
  ptr = &b1;
  ptr->print();
}

// #include <iostream>
// using namespace std;
// class A {
//     protected:
//         int a,b;
//     public:
//         A() {
//             a=3;
//             b=4;
//         }
//         A(int x, int y) {
//             a=x;
//             b=y;
//         }
// };

// class B: public A {
//     private:
//         float p,q;
//     public:
//         B(int m, int n, float u, float v) {
//             p=u;
//             q=v;
//         }
//         B() {
//             p=q=0;
//         }
// };

// class C: B {
//     public:
//         void print() {
//             cout << "C values: " << a << " " << b << "\n";
//         }
// };

// int main() {
//     C cl;
//     cl.print();
// }