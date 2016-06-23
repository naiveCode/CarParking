This is a basic implementation for developing a parking lot system.
The nearest vacant slot is filled first.
Able to tell registration number of cars based oon color
Able to tell slot in which car is present based on registration number
JUnit test cases included
Two approach followed, 
1. more efficient in terms of time but will take more space
  Using a min heap to store the empty slots in the parking lot
  A hashmap to store the car slots based on registation number
  A Hashmap to store registration number and car slot based on the color of the car
2. A basic approach which will store the cars in a arraylist,
  everytime an insert is needed, Everytime you need to output car detail based on colour or registration number, 
  you search in the list from the start, more practical since it is less complex and in real world scenario
  there won't be a very big parking 
