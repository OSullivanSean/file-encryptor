import java.io.IOException;

public class FileEncryptor {

    private String inputfile;
    private String outputfile;
    private boolean encrypt;
    private FileIO fileIO;
    private InputReader inputReader;
    EncryptionUtils encryptionUtils;
    private String key;

    public FileEncryptor(String inputfile, String outputfile, boolean encrypt) {
        this.inputfile = inputfile;
        this.outputfile = outputfile;
        this.encrypt = encrypt;
        fileIO = new FileIO();
        this.inputReader = new InputReader();
        this.encryptionUtils = new EncryptionUtils();
    }

    public void launch() throws IOException {
        key = inputReader.getKey();

        String inputContents = fileIO.read(inputfile);

        String outputContents;

        if(encrypt){
            outputContents = encryptionUtils.encrypt(inputContents, key);
        } else  {
            outputContents = encryptionUtils.decrypt(inputContents, key);
        }

        fileIO.write(outputContents, outputfile);
    }
}
