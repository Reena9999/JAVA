import java.io.*;

public class FindCategories {

    public static void main(String args[]) {
        String s = "", a = "";
        int count = 0;

        try {
            File file = new File("htmlFile.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            while (br.readLine() != null) {
                a = br.readLine();
                if (a.contains("Top Categories")) {
                    count+=1;
                    continue;
                }
                if (count > 0) {                    
                    if (a.contains("<li ")) {
                        s = s + a+"\n";
                    }

                    else if (a.contains("/div>")) {
                        count = 0;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String[] m=s.split(">");
        
        String[] categories=new String[(m.length)/4];
        count=0;
        for (int i=2;i<m.length;i=i+4){
            categories[count]=m[i].substring(0,(m[i].length()-3));
            count++;
        }

        System.out.println("Top ten categories: ");
        for (int i=0;i<categories.length;i++){
                System.out.println(categories[i]);
        }

    }
}