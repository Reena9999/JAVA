### PROBLEM STATEMENT
Create a menu-driven program that has the following menu options:
1. Enter a name
2. Search for a name
3. Remove a name
4. Show all names

*Note: The menu-driven program has to be made with the help of a do-while loop and switch-case statements.*

Constraints:
* The names collected must be stored in an array with a max length of 1024.
* The names in the array should be UNIQUE; no duplicate entries are expected!
* Provide necessary validations that the user enters only valid names that are not going to be repeated.
* Removing a name should not create empty space inside the array!

### SOLUTION 
*Description*  
There are four function:  
1. *readName*: adds a new name to the array. Before adding the name to the array, the function checks if the name already exists in the array. If it is contained in the array, it will not add the new name to the array.  
2. *searchName*: the function performs a simple linear search for the name. It has conditions checking if the array is empty and displays appropriate errors.    
3. *removeName*: the function performs a simple linear search. When we find the name we are looking for, all value succeeding that value is shifted to the left and the last value is made null. This is done to remove the name we are looking for and not leave a null value while doing so.
4. *displayName*: display elements of the elements

**FLOW CHART** 
![FlowChart drawio (1)](https://user-images.githubusercontent.com/118504536/217501264-a3011f18-e43d-47c2-accf-32f9739f51d6.png)


**SAMPLE OUTPUT**
```
--------------------------------------------------------------------------------------------------------------------
Enter:
 1 for Entering a name in the list.
 2 to search for a name in the list.
 3 to remove a name from the list.
 4 to display all the names in the list.

Enter your choice: 5
Invalid Input    
Enter y to continue process: n  

--------------------------------------------------------------------------------------------------------------------
Enter:  
 1 for Entering a name in the list.  
 2 to search for a name in the list.  
 3 to remove a name from the list.  
 4 to display all the names in the list.  

Enter your choice: 1  
Enter the name you wish to add: Reena  
Enter y to continue process: y  

Enter:  
 1 for Entering a name in the list.  
 2 to search for a name in the list.  
 3 to remove a name from the list.  
 4 to display all the names in the list.  

Enter your choice: 1  
Enter the name you wish to add: Meena  
Enter y to continue process: y  

Enter:  
 1 for Entering a name in the list.  
 2 to search for a name in the list.  
 3 to remove a name from the list.  
 4 to display all the names in the list.  

Enter your choice: 1  
Enter the name you wish to add: reena  

The name already exists. Cannot add name to the list.  

Enter y to continue process: y  

Enter:  
 1 for Entering a name in the list.  
 2 to search for a name in the list.  
 3 to remove a name from the list.  
 4 to display all the names in the list.  

Enter your choice: 1  
Enter the name you wish to add: Noori  
Enter y to continue process: y  

Enter:  
 1 for Entering a name in the list.  
 2 to search for a name in the list.  
 3 to remove a name from the list.  
 4 to display all the names in the list.  

Enter your choice: 4  

====================================================  
                Current List of Names
                
====================================================  
Reena  
Meena  
Noori  

Enter y to continue process: y

Enter:
 1 for Entering a name in the list.
 2 to search for a name in the list.
 3 to remove a name from the list.
 4 to display all the names in the list.

Enter your choice: 2
Enter the name you wish to search: noori

--------------------------------------------------  
noori is present in the list of names.

--------------------------------------------------  

Enter y to continue process: y

Enter:
 1 for Entering a name in the list.
 2 to search for a name in the list.
 3 to remove a name from the list.
 4 to display all the names in the list.

Enter your choice: 3
Enter the name you wish to remove: noori  
Enter y to continue process: y  

Enter:  
 1 for Entering a name in the list.  
 2 to search for a name in the list.   
 3 to remove a name from the list.  
 4 to display all the names in the list.  

Enter your choice: 4  

====================================================  
                Current List of Names   
                
====================================================  
Reena  
Meena  

Enter y to continue process: n  

--------------------------------------------------------------------------------------------------------------------
```
