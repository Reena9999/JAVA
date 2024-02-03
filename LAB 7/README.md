# PROBLEM STATEMENT  
Create a new folder in git named 'Lab 7' for the following question and solve the following: create a flowchart and document the results, constraints, etc., in the README.md file for the lab.  

Given the famous iris dataset, find the 5-point summary [Mean, Median, Mode, Min, Max] for the attributes: SepalLengthCm, SepalWidthCm, PetalLengthCm, PetalWidthCm.  

Once the overall summary statistics have been calculated, identify the summary statistics for each Species of iris flower [Iris-setosa, Iris-versicolor, Iris-virginica].  

Present your results in the appropriate format and write the results in a file.  

# SOLUTION
## PROGRAM DESCRIPTION
The contents of csv file is already in a 2 dimensional format. Using this we first create a 2 dimensional array of string that contain the contents of the file as each of it's elements.  

Once the 2D array is created, we extract each column seperately and generate the mean, median, mode, maximum and minimum value. These values are then written into a file.  

As we see that the different classes are all together and not randomly sort, we create an array 'indexes' that sort the last occurance of each of the various classes.     
indexes[0] store the last occurance of iris-setosa  
indexes[1] store the last occurance of iris-versicolor    
indexes[2] store the last occurance of iris-virginica 

With knowledge about where to stop and start  for each class, we extract the column values for each class, generate the statistics and write the findings into a file.  
  
Lastly, read the contents of the file a print it on the terminal.  

## FLOWCHART  
![Blank diagram](https://user-images.githubusercontent.com/118504536/231861954-39474c5e-08ab-4801-ac5c-16e4d03d5798.png)


## OUTPUT  
Look at output.txt for the sample output of the program  

```
-------------------------------------------------------------------------------------------
                                 GENERAL DESC
-------------------------------------------------------------------------------------------
                        Mean            Median          Mode            Min             Max
-------------------------------------------------------------------------------------------
SepalLengthCm           5.8433356       5.8             5.0             4.3             7.9
SepalWidthCm            3.0540001       3.0             3.0             2.0             4.4
PetalLengthCm           3.7586665       4.4             1.5             1.0             6.9
PetalWidthCm            1.198667        1.3             0.2             0.1             2.5


-------------------------------------------------------------------------------------------
                                 Iris-setosa
-------------------------------------------------------------------------------------------
                        Mean            Median          Mode            Min             Max
-------------------------------------------------------------------------------------------
SepalLengthCm           5.0060005       5.0             5.0             4.3             5.8
SepalWidthCm            3.418   3.4             3.4             2.3             4.4
PetalLengthCm           1.4639996       1.5             1.5             1.0             1.9
PetalWidthCm            0.24399994      0.2             0.2             0.1             0.6


-------------------------------------------------------------------------------------------
                                 Iris-versicolor
-------------------------------------------------------------------------------------------
                        Mean            Median          Mode            Min             Max
-------------------------------------------------------------------------------------------
SepalLengthCm           5.9360003       5.9             5.5             4.9             7.0
SepalWidthCm            2.77    2.8             3.0             2.0             3.4
PetalLengthCm           4.26    4.4             4.5             3.0             5.1
PetalWidthCm            1.3260001       1.3             1.3             1.0             1.8


-------------------------------------------------------------------------------------------
                                 Iris-virginica
-------------------------------------------------------------------------------------------
                        Mean            Median          Mode            Min             Max
-------------------------------------------------------------------------------------------
SepalLengthCm           6.5880003       6.5             6.3             4.9             7.9
SepalWidthCm            2.9739997       3.0             3.0             2.2             3.8
PetalLengthCm           5.5520005       5.6             5.1             4.5             6.9
```
