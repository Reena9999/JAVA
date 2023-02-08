
**PROBLEM STATEMENT**
You are supposed to create a menu-driven program that has the following menu options:
1. Enter a name
2. Search for a name
3. Remove a name
4. Show all names

*Note*:
The menu-driven program has to be made with the help of a do-while loop and switch-case statements.

*Constraints*:
1. The names collected must be stored in an array with a max length of 1024.
2. The names in the array should be UNIQUE; no duplicate entries are expected!
3. Provide necessary validations that the user enters only valid names that are not going to be repeated.
4. Removing a name should not create empty space inside the array!
5. Format your results properly!!

**SOLUTION**
*Description*

*Flow Chart*
![Alt text](https://drive.google.com/file/d/10QCVWwcu1iCo3UkAC2IKQ6EsBV-RJ9_O/view?usp=share_link "a title")


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