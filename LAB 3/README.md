**QUESTION**  
Create a java program that performs the following operation:    
The program should collect an integer array from the user    
After the array is entered, you need to create a menu of items   
Find the Mean Value    
Find the Median Value    
Find the Mode Value     

From the user-given array.    
The program should have a minimum of 3 functions apart from the main function; each of the functions implements the Mean, Median, and Mode computation by accepting the array user has entered as a parameter and returning the value as a result. From the main method, you will display the result.

**PROGRAM PSEUDO CODE**     
The contains four main functions:   
  
*create a global variable 'length' that store the total number of enter elements   
  
*FUNCTION readArray()*:     
&nbsp; * create an integer array of a large size  
&nbsp; * create an infinte loop  
&ensp; *read user input  
&ensp; * check if the input is equal to 'exit'.   
&emsp; If it is:    
&emsp; &emsp; -set 'length' as the total number of times you executed the infinte loop    
&emsp; &emsp; -exit the infinite loop     
&emsp; otherwise:    
&emsp; &emsp; -continue    
&ensp; *check if the input is an integer.   
&emsp; If it is:    
&emsp; &emsp;-add value to your array  
&emsp; otherwise:    
&emsp; &emsp; -print an appropriate error message.    

*FUNCTION Mean(int array[])*:  
&nbsp; *iterate through the non-null elements of the array recieved through the parameters  
&nbsp; *add the iterating values      
&nbsp; *return the total sum divided by 'length'  

*FUNCTION Median(int array[])*:  
&nbsp; *sort the array recieved through the parameters    
&nbsp; *return the middle value of the array ('length'/2)    

*FUNCTION Mode(int array[])*:  
&nbsp; *create an array countArray[] with size equal to 'length'  
&nbsp; *iterate through the value of the array recieved through the parameters and count how many times that value occurs in the array. Store the count in countArray.  
&nbsp; *find the maximum count value in countArray  
&nbsp; *return the value in 'array' corresponding to the maximum count value obtained.    

**FLOW CHART**    
![lab2 drawio](https://user-images.githubusercontent.com/118504536/219005942-5941a714-a15c-4926-ba6c-4e41dd24d9d5.png)  

**SAMPLE OUTPUT**      

Enter exit when cued to enter values to stop entering values in the array.    
   
Enter a value: 1      

Enter a value: 2    

Enter a value: 2    

Enter a value: 3    

Enter a value: 0    

Enter a value: 7    

Enter a value: r   

----------------------------    
     Enter only numbers    
----------------------------    


Enter a value: 5    

Enter a value: 7    

Enter a value: exit    


ENTER EXIT TO STOP EXECUTING THIS PROGRAM    

Enter    
 1 to find the mean.    
 2 to find the median.    
 3 to find the mode.      
1    

----------------------------    
         Mean: 3.38      
----------------------------      

Enter    
 1 to find the mean.    
 2 to find the median.    
 3 to find the mode.    
2    

----------------------------    
         Median: 2    
----------------------------    
 
Enter      
 1 to find the mean.      
 2 to find the median.      
 3 to find the mode.      
3        

----------------------------      
         Mode: 2      
----------------------------      

Enter    
 1 to find the mean.    
 2 to find the median.    
 3 to find the mode.    
4    

----------------------------    
        Invalid Input!    
----------------------------     

Enter    
 1 to find the mean.    
 2 to find the median.    
 3 to find the mode.    
reena    

----------------------------    
     Enter only numbers    
----------------------------    

Enter      
 1 to find the mean.     
 2 to find the median.      
 3 to find the mode.      
 exit      
 
----------------------------      
            BYE!      
----------------------------      
