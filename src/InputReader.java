import java.io.Console;

public class InputReader {

    private Console console;

    public InputReader(){
        this.console = System.console();
    }

    public String getKey() {
        console.printf("Key:\n");
        return new String(console.readPassword());
    }
}
