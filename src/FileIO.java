import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class FileIO {

    public String read(String inputfile) throws IOException {
        System.out.println("Input File: " + inputfile);

        String contents = "";
        try(FileInputStream fileInputStream = new FileInputStream(inputfile)){
            int i;
            int available = fileInputStream.available();
            int currentProcessed = 0;
            int tenPercent = available/10;

            System.out.println("Bytes: " + available);

            System.out.println("|----------| Reading...");
            System.out.print("|");

            while((i = fileInputStream.read()) != -1){
                currentProcessed++;
                if(currentProcessed % tenPercent == 0){
                    System.out.print("-");
                }
                contents += (char) i;
            }

            System.out.print("|\n");
        }catch (IOException e){
                e.printStackTrace();
        }
        return contents;
    }

    public void write(String outputContents, String outputfile) throws IOException {
        System.out.println("Writing to output file: " + outputfile);
        new File(outputfile).createNewFile();//create file if not exists

        char[] contents = outputContents.toCharArray();

        try(FileOutputStream fileOutputStream = new FileOutputStream(outputfile)){
            for(char content: contents){
                fileOutputStream.write(content);
            }

            fileOutputStream.flush();
            fileOutputStream.close();
        }

    }
}
