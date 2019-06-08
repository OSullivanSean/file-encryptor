import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {
        long startTimestamp = System.currentTimeMillis();

        String inputfile;
        String outputfile;

        if(args.length < 2) {
            System.out.println("please provide file and outputFile: [file] [outputfile]");
            System.exit(-1);
        }

        inputfile = args[0];
        outputfile = args[1];
        boolean encrypt = false;

        if(args.length == 3 && "-e".equals(args[2])){
            encrypt = true;
        }
        FileEncryptor fileEncryptor = new FileEncryptor(inputfile, outputfile, encrypt);

        fileEncryptor.launch();

        long finishTimestamp = System.currentTimeMillis();

        long duration = finishTimestamp - startTimestamp;
        System.out.println("Process took: " + duration + "ms");
        System.out.println("Done!");
    }
}
