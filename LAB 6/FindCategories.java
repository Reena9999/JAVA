import java.io.*;
import java.util.*;

public class FindCategories {

    public static void main(String args[]) {
        String s = "", a = "";
        int count = 0;

        try {
            File file = new File("htmlFile.txt");
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                while (sc.hasNext()) {
                    a = sc.nextLine();
                    if (a.contains("html")) {
                        count += 1;
                    }
                    if (count >0) {
                        if (a.contains("div>")) {
                            count = 0;
                        } else if (a.contains("<li ")) {
                            s = s + a;
                        }
                        else{
                            s = s + a;
                        }
                    }
                }
                sc.close();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(s);
    }
}