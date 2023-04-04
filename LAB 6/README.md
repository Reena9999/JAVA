**QUESTION**  
Write a JAVA program that reads a file (text file) and finds the following details.  
1. Vowels and their count. Eg: [a:100, e:45, I:55, ..]  
2. Digits and their count. Eg: [0:1000, 1:10, 2:40, ...]  
3. Top Five repeated words and their count.  
4. Least Five repeated words and their count.  
5. Top Five repeated characters and their count.  
6. Least FIve repeated characters and their count. 
 
Note:  
* Use the file attached.  
* Use functions to implement the six functions asked.  
* Pass the file content to the functions and return the values accordingly.  
* No Global variables are allowed to be used.  

Additional Task [htmlFile.txt]:  
You have been given an HTML file; from the HTML File, identify the Top categories, display it to the user, and write the content to the file.  

**FLOWCHART**  
Main program flow:
![1](https://user-images.githubusercontent.com/118504536/228758688-abe76fb9-8191-429d-afa3-2e67f1605397.png)  

countVowels(File file):    
![2](https://user-images.githubusercontent.com/118504536/228758916-46e8705f-3483-492d-8729-6e39f0bc247a.png)  

countDigits:    
![3](https://user-images.githubusercontent.com/118504536/228763769-13f54504-8def-445a-bd2a-b06ec0346adf.png)  

RepeatingWords:        
![4](https://user-images.githubusercontent.com/118504536/228767364-2df14772-83c8-4a4b-95a8-afeead376dc6.png)  

RepeatingCharacters:     
![Blank diagram](https://user-images.githubusercontent.com/118504536/228774238-f3e3a170-cbf0-4929-a691-e1f7fb73dca7.png)  

Additional task flowchart:  
![Blank diagram](https://user-images.githubusercontent.com/118504536/229729588-040d4eef-e72b-4429-9770-dfc065975fa8.png)  

**SAMPLE OUTPUT**   
\---------------------------------------------  
                Vowel Count  
\---------------------------------------------  
                a       :       357  
                e       :       504  
                i       :       360  
                o       :       260  
                u       :       107  
\---------------------------------------------  


\---------------------------------------------    
                Digit Count    
\---------------------------------------------  
                0       :       6  
                1       :       6  
                2       :       7  
                3       :       4  
                4       :       2  
                5       :       4  
                6       :       2  
                7       :       4  
                8       :       2  
                9       :       0  
\---------------------------------------------  


\---------------------------------------------  
        Most occuring characters  
\---------------------------------------------  
                e       :       504  
                i       :       360  
                a       :       357  
                t       :       337  
                n       :       334  
\---------------------------------------------  


\---------------------------------------------  
        Least occuring characters  
\---------------------------------------------  
                z       :       2  
                j       :       2  
                q       :       3  
                x       :       15  
                k       :       18  
                w       :       51  
\---------------------------------------------  


\---------------------------------------------  
        Five most occurring Words  
\---------------------------------------------  
        and     :       34  
        of      :       32  
        the     :       25  
        to      :       25  
        in      :       16  
\---------------------------------------------  


\---------------------------------------------  
        Least five occurring Words  
\---------------------------------------------  
        reliability     :       1  
        efficiency      :       1  
        advancements    :       1  
        technological   :       1    
        continued       :       1  
\---------------------------------------------  

ADDITIONAL TASK OUTPUT:  

Top ten categories:   
Political Pulse  
Mumbai News  
Pune News  
Bollywood News  
India News  
Lifestyle News   
Mobile &amp; Tabs  
Gadgets  
Food &amp; Wine  
Fitness  
