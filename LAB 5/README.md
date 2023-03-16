**QUESTION**  
Create a student class, that will store the details of the Student  
* Reg. No.  
* Name  
* Email  
* Phone  
* Class  
* Department   

The class will have a constructor to initialize the values of the Student and a method to print the Details of the Student.  

In the main-method class, create an array of Student Class to hold maximum details of 100 Students.  
In the menu-driven program, the menu options will have  

_**Add a student**_    
Adds the details of 1 student to the array of Student  

_**Search for a student**_   
Search for the details of a student from the array of Student  
(Optional) Searching can be done with Name & Register Number  

_**Display all students**_      
Displays the details of all students  

Note: Make use of functions to implement the menu options  

Extension (Optional):  
Save the details of each student in a file, with his name with the help of a method in student class, when the student is getting created.  

**FLOWCHART**   
Main Flow of control  

![main](https://user-images.githubusercontent.com/118504536/225352002-c8e5f9e9-c7d8-4d58-8a7e-26a50a05456f.png)  

Functions control flow:  
1. AddStudent() represented as AS connector  
![addStudent](https://user-images.githubusercontent.com/118504536/225360660-061c4a94-92e0-4384-b5bc-b758c95a14fa.png)

2. SearchStudent() represented as SS connector  
![SearchStudent](https://user-images.githubusercontent.com/118504536/225360728-c373b573-0bb2-4941-af47-1d09036ab312.png)

3. DisplayStudent() represented as DS connector  
![DisplayStudent](https://user-images.githubusercontent.com/118504536/225360780-6190634e-54e3-4dcf-afd7-5296dc9b9c91.png)

Validating Function:  
1. isDigit() represented as ID  
![isDigit](https://user-images.githubusercontent.com/118504536/225515363-fe6025e2-ef06-4eec-b786-908af1a9ec36.png)
  
2. checkReg() represented as CR    
![CheckRegisterNum](https://user-images.githubusercontent.com/118504536/225515971-df8dfe5d-f3f0-407b-b3ab-af6c20afe318.png)  

3. checkEmail() represented as CE   
![CheckEmail](https://user-images.githubusercontent.com/118504536/225516061-68ecf787-fd63-4b87-a53c-973c75274152.png)

4. checkPhone() represented as CP  
![CheckPhone](https://user-images.githubusercontent.com/118504536/225516111-3bc53b8f-5ae7-4bfc-991b-e6eb01c3db92.png)

5. checkClass() represented as CC  
![checkClass](https://user-images.githubusercontent.com/118504536/225516148-2ac711a8-f67d-4350-902e-8c06d7dbf53f.png)

**SAMPLE OUTPUT**  
\=========================================================  
                          WELCOME    
\=========================================================  
                   Enter Exit to execution    
\---------------------------------------------------------    
Enter  
1. To Add a student  
2. To search of a student  
3. Display all students  
1      
\---------------------------------------------------------    
Enter your name: Reena  
Enter your register number: 22122144  
Enter your email id: reena.a@msds.christuniveristy.in  
  
Invalid domain in email  

Enter your email id: reena.a@msds.christuniversity.in   
Enter your phone number: 95335588254  

Required 10 digits in the phone number  

Enter your phone number: 9535588254   
Enter your class: 2 MSDS B  
Enter your department: Data Science  
\---------------------------------------------------------  
Enter 1 if you wish to store details in a file:  
1  
\---------------------------------------------------------    
Enter  
1. To Add a student  
2. To search of a student  
3. Display all students  
3    
\---------------------------------------------------------    
\=========================================================    
          All students in our database:  
\=========================================================  
Reena  
\=========================================================  
Enter  
1. To Add a student  
2. To search of a student  
3. Display all students  
exit  
\---------------------------------------------------------  
                         BYE  
\---------------------------------------------------------  
