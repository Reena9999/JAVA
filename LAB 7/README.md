# QUESTION  
Create a new folder in git named 'Lab 7' for the following question and solve the following: create a flowchart and document the results, constraints, etc., in the README.md file for the lab.  

Given the famous iris dataset, find the 5-point summary [Mean, Median, Mode, Min, Max] for the attributes: SepalLengthCm, SepalWidthCm, PetalLengthCm, PetalWidthCm.  

Once the overall summary statistics have been calculated, identify the summary statistics for each Species of iris flower [Iris-setosa, Iris-versicolor, Iris-virginica].  

Present your results in the appropriate format and write the results in a file.  

# PROGRAM FLOW  
The contents of csv file is already in a 2 dimensional format. Using this we first create a 2 dimensional array of string that contain the contents of the file as each of it's elements.  

Once the 2D array is created, we extract each column seperately and generate the mean, median, mode, maximum and minimum value. These values are then written into a file.  

As we see that the different classes are all together and not randomly sort, we create an array 'indexes' that sort the last occurance of each of the various classes.     
indexes[0] store the last occurance of iris-setosa  
indexes[1] store the last occurance of iris-versicolor    
indexes[2] store the last occurance of iris-virginica 

With knowledge about where to stop and start  for each class, we extract the column values for each class, generate the statistics and write the findings into a file.  
  
Lastly, read the contents of the file a print it on the terminal.  

# FLOWCHART  


# OUTPUT  
Look at output.txt for the sample output of the program  