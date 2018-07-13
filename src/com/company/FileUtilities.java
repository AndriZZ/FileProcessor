package com.company;

import java.io.*;

public class FileUtilities {
    public static void Validate(String input) {
        String regex2 = "[\\n\\r]";
        String regex3 = "[\\040]";
        String regex4 = "[1-9][0-9]+";
        String[] splitString = input.split(regex2);
        for (String string : splitString) {
            // System.out.println(string);
            String[] splitString2 = string.split(regex3);
            for (String string2 : splitString2) {
                if (string2.matches(regex4)) System.out.println(string2);

                //System.out.println("line "+string+"element "+string2+" excluded");
            }
        }
    }
    public static void writeFile(String canonicalFilename, String text)
            throws IOException
    {
        File file = new File (canonicalFilename);
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(String.valueOf(text));
        out.close();
    }
    public static int countLines(String filename) throws IOException {
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
