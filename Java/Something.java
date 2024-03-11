package Java;

/*

What is a Constructor?
-> It is a special method that is executed as soon as an object is created.

There are four types of area:-

1. Method Area
2. Stack Pool / Class Static Area : - 
3. Stack Area: - It is only used for the execution purpose. It works on the stacks principle.
4. Heap Area: - Every object is created in the heap area and all non-static members are loaded inside the object.

How does a code works?

So same as other language, the main method is executed first. 

A block of main method will be created inside the method area. 
Now if there are variable to be initialized, they are initialized in the stack pool.

There are two types of Initializer :-
1. SingleLine Initializer
2. MultiLine Initializer

OOPs:- 
1. Encapsulation: - Binding or warping the properties of an object in one class. Using private, public and protected keywords. To access the private methods/variable we use the getter and setter method. We can only access the private method/variable in the same class, to access them in another class we have to create an object for the following. 

Encapsulation is data hiding process with the verification and validation.
a. With data hiding
b. Without data hiding

Data Hiding: - It is a process fo restricting the direct access to the data member by providing indirect secure access via methods. WIth the help of data hiding we can provide 


2. Inheritance: - 
3. Polymorphism: -
4 .Abstraction: -

*/

/*

Code 1:

class staticInit {
    static int a = 10;
    static int b = 20;
    static int c;
    static {
        c = 100;
        System.out.println("From MLSI");
    }
    public static void main(String[] args) {
        System.out.println("From Main()");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("Main program exiting...");
    }
    static {
        c = 400;
    }
}

 */

/*
class StaticInit {
    static int a = Test();
    static int b = 20;
    static {
        System.out.println(a);
        System.out.println(b);
        b = 40;
    }
    public static void main(String [] args) {
        System.out.println(a);
        System.out.println(b);
        Test();
    }

    public static int Test() {
        System.out.println("Test method");
        return 30;
    }
}
*/


