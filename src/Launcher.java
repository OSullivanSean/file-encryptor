import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Launcher {

    public static void main(String[] args) throws IOException {
        long startTimestamp = System.currentTimeMillis();

        Map<String, Object> cliParams = getCliParams(args);

        String inputfile = (String) cliParams.get("file");
        String outputfile = (String) cliParams.get("output");
        boolean encrypt = (boolean) cliParams.get("encrypt");

        FileEncryptor fileEncryptor = new FileEncryptor(inputfile, outputfile, encrypt);

        fileEncryptor.launch();

        long finishTimestamp = System.currentTimeMillis();

        long duration = finishTimestamp - startTimestamp;
        System.out.println("Process took: " + duration + "ms");
        System.out.println("Done!");
    }

    private static Map<String, Object> getCliParams(String[] args) {
        if(args.length==0){
            printCliHelpAndClose();
        }

        Map<String, Object> cliParams = new HashMap<>();

        //default values
        cliParams.put("encrypt", true);

        for(String arg: args){
            if(arg.contains("file=")){
                cliParams.put("file", getFile(arg));
                continue;
            }

            if(arg.contains("output=")){
                cliParams.put("output", getFile(arg));
                continue;
            }

            if("-d".equals(arg)){
                cliParams.put("encrypt", false);
                continue;
            }
        }

        if(cliParams.get("file") == null){
            System.out.println("Failed to provide file...");
            printCliHelpAndClose();
        }

        if(cliParams.get("output") == null){
            cliParams.put("output", cliParams.get("file"));
        }

        return cliParams;
    }

    private static String getFile(String arg) {
        return arg.split("=")[1];
    }

    private static void printCliHelpAndClose() {
        System.out.println("TODO - CLI help");
        System.exit(0);
    }
}
