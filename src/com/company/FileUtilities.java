package com.company;
import java.io.*;
import java.util.ArrayList;

public class FileUtilities {
    public void validate(String input) {
        String regexLineTab = "[\\n\\r]";
        String regexSpaceTab = "[\\040]";
        String regexNotZeroStart = "[1-9][0-9]+";
        ArrayList<String> matchingInputs = new ArrayList<>();
        String[] splitString = input.split(regexLineTab);

        for(int i=0;i<splitString.length;i++){
            String[] splitString2 = splitString[i].split(regexSpaceTab);
            for(int j=0;j<splitString2.length;j++){
                if (splitString2[j].matches(regexNotZeroStart)) {
                    matchingInputs.add(splitString2[j]);
                   }
                else{
                System.out.println("line: "+(i+1)+" element: "+splitString2[j]+" excluded");}
            }

        }
      System.out.println("Valid elements are:\n"+matchingInputs);
    }
    public void writeToFile(String canonicalFilename, String text)
            throws IOException
    {
        File file = new File (canonicalFilename);
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(String.valueOf(text));
        out.close();
    }
    public int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }
}
