#BIG INTEGER:
##Purpose:
The purpose of the BigInt class is to solve a very large integer problem using short methods that work together to solve the operations of add, subtract multiply, divide, and modulus.
<img width="1193" alt="Screenshot 2023-01-07 at 5 49 01 PM" src="https://user-images.githubusercontent.com/91344736/211173287-1fd1b08e-a553-46c5-a0b0-859242e80908.png">
##Description:
1.Implement the BigInt(String) constructor that will check to see if the input String is a valid number. If it is a valid number it will store that number in an ArrayList instance variable. You will store each of the BigInt digits as Charaters in the ArrayList. If the argument String is not a valid number the constructor will throw a BigIntException class object that extends the RuntimeException class. 

2.Implement four additional methods in the BigInt class.

+ compareTo(BigInt):int - BigInt

- This method will return a

o 1 if the value stored in the calling object is greater than the value stored in the argument object

o -1 if the value stored in the calling object is less than the value stored in the argument object

o 0 if the value stored in the calling object is equal to the value stored in the argument object

+ equals(BigInt):boolean - BigInt

- This method will return a

o true if the value stored in the calling object is equal to the value stored in the argument object

o false if the value stored in the calling object is not equal to the value stored in the argument object

+ toString():String - BigInt

- This method will return a String representation of the BigInt's value

+ clone():BigInt- BigInt

- This method will return the reference to a new BigInt object that is a copy of the calling BigInt. Ensure that you do a "deep" copy and not a reference copy of the instance variables.
##How to use:
1.Download the zip file
2.Import project to Eclipse
3.Run the code.
