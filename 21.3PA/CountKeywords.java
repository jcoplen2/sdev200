import java.util.*;
import java.io.*;

public class CountKeywords {
  public static void main(String[] args) throws Exception {  
    //console input instead of scanner
    if(args.length != 1) {
        System.out.println("CountKeywords <filename>");
        return;
    }

    //initialize file from console
   File file = new File(args[0]);   

   //check if file exsists
   if (!file.exists()) {
    System.out.println("File does not exist");
    return;
   }

   //count the number of keywords
   int keywordCount = countKeywords(file);
   System.out.println("The number of keywords is: " + keywordCount);
  }

  public static int countKeywords(File file) throws Exception {  
    // Array of all Java keywords + true, false and null
    String[] keywordString = {"abstract", "assert", "boolean", 
      "break", "byte", "case", "catch", "char", "class", "const",
      "continue", "default", "do", "double", "else", "enum",
      "extends", "for", "final", "finally", "float", "goto",
      "if", "implements", "import", "instanceof", "int", 
      "interface", "long", "native", "new", "package", "private",
      "protected", "public", "return", "short", "static", 
      "strictfp", "super", "switch", "synchronized", "this",
      "throw", "throws", "transient", "try", "void", "volatile",
      "while", "true", "false", "null"};

    Set<String> keywords = new HashSet<>(Arrays.asList(keywordString));
    int count = 0;    
    boolean inBlockComment = false;

    //read line by line instead of scanner
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    
    while ((line = reader.readLine()) != null) {
      //remove line comments
      if (!inBlockComment && line.contains("//")) {
        line = line.substring(0, line.indexOf("//"));
      }  

      //remove block comments
      while (true) {
        //are we in a block? does the line have a block? 
        if (!inBlockComment && line.contains("/*")) {
            //set control
            inBlockComment = true;
            //find the start and end
            int start = line.indexOf("/*");
            int end = line.indexOf("*/", start + 2);
            //same line?
            if (end != -1) {
                //remove
                line = line.substring(0, start) + line.substring(end + 2);
                //leave loop
                inBlockComment = false;
            } else { 
                //remove line
                line = line.substring(0, start);
                //reset loop
                inBlockComment = true;
                break;
            }
            }
            //if in a block comment 
            else if (inBlockComment) {
                //find the end of the block
                int end = line.indexOf("*/");
                //if ending on this line
                if (end != -1) {
                    //remove line
                    line = line.substring(end +2);
                    inBlockComment = false;
                }else {
                    //clear the line if we are still in a block
                    line = "";
                    //move to next line
                    break;
                }
                //break out of loop if nothing else to do
            } else {
                break;
            }
      }
      //remove strings inside double quotes 
      line = line.replaceAll("\"(\\\\.|[^\"\\\\])*\"", "");

      //split line into words
      String[] words = line.split("\\W+");
            for (String word : words) {
                if (keywords.contains(word)) {
                    count++;
    }
}
}
    return count;
  }
}

  