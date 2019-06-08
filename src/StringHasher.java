import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

public class StringHasher {

    public static String applySha256(String input){
        String output = "";

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            output = hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }

        return output;
    }
}
