import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FirsrtClass {

    public static void main(String[] args) throws Exception {
//тест коммент

        String inputPath = "C:\\1.txt";
        File input = new File(inputPath);
        Scanner scanner = new Scanner(input);
        ArrayList <String> patternList = new ArrayList<>();
        patternList.add("^//");
        patternList.add("\\/\\*");
        patternList.add("\\*\\/");
        ArrayList<String> inputString = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        while (scanner.hasNextLine())
            {
             inputString.add(scanner.nextLine());
            }
        Boolean flag = true;
        for (int i = 0; i < inputString.size(); i++)
            {

                for (int q = 0 ; q < patternList.size(); q++)
                    {
                        Pattern pattern = Pattern.compile(patternList.get(q));
                        Matcher matcher = pattern.matcher(inputString.get(i));
                        if (matcher.find())
                           {
                               flag = false;
                           }
                    }
                     if (flag == true)
                        res.add(inputString.get(i));
                      else flag = true;

            }
//if
/* if */
        ArrayList<String> word = new ArrayList<>();
        word.add("if");
        word.add("else");
        word.add("public");
        word.add("pattern");

       ArrayList<counter> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < word.size(); i++)
        {
             for (int q = 0; q < res.size(); q ++)
             {
                 Pattern pattern = Pattern.compile(word.get(i));
                 Matcher matcher = pattern.matcher(res.get(q));
                 while (matcher.find())
                 {
                    count++;
                 }

             }
            result.add(new counter(count, word.get(i)));

        }

        for (int out = result.size() - 1; out >= 1; out--)
         {
               for (int in = 0; in < out; in++)

               {
                   if (result.get(in).count < result.get(in+1).count)
                   {
                       ArrayList<counter> test= new ArrayList<>();
                       test.add(result.get(in));
                       result.set(in,result.get(in+1));
                       result.set(in+1,test.get(0));
                   }
               }



         }

       for (int i =0 ; i <result.size(); i++)
       {
           System.out.println(result.get(i).name + " " + result.get(i).count);
       }



    }
}
