**SOLUTION**  
*Description*  
There are four function:  
1. *readName*: adds a new name to the array. Before adding the name to the array, the function checks if the name already exists in the array. If it is contained in the array, it will not add the new name to the array.  
2. *searchName*: the function performs a simple linear search for the name. It has conditions checking if the array is empty and displays appropriate errors.    
3. *removeName*: the function performs a simple linear search. When we find the name we are looking for, all value succeeding that value is shifted to the left and the last value is made null. This is done to remove the name we are looking for and not leave a null value while doing so.
4. *displayName*: display elements of the elements

*Flow Chart*  
![FlowChart drawio (1)](https://user-images.githubusercontent.com/118504536/217501264-a3011f18-e43d-47c2-accf-32f9739f51d6.png)


**SAMPLE OUTPUT**
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
