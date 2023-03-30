import java.io.*;
import java.util.*;

public class FindCategories{

    public static void main(String args[]){
        try {
            File file = new File("htmlFile.txt");
            if (!file.exists()) {
                System.out.println("Cannot find the file");
            } else {
                Scanner sc=new Scanner(file);
                while(sc.hasNextLine()){
                    String a=sc.nextLine();
                    if(a.contains("Top Categories")){
                        System.out.println(a.split(">"));

                        // if(a.contains("div>")){
                        //     break;
                        // }
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }    
    }
}