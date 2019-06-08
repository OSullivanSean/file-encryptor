public class EncryptionUtils {


    public String encrypt(String inputContents, String key) {
        return doWork(inputContents, key, 1);

    }

    public String decrypt(String inputContents, String key) {
        return doWork(inputContents, key, -1);
    }

    private String doWork(String inputContents, String key, int multiplier){

        String hashedKey = StringHasher.applySha256(key);

        int[] inputArr = getAsIntArr(inputContents);
        int[] keyArr = getAsIntArr(hashedKey);

        return applyTransformation(inputArr, keyArr, multiplier);
    }

    private int[] getAsIntArr(String inputContents) {
        int[] output = new int[inputContents.length()];

        char[] inputAsCharArr = inputContents.toCharArray();

        for(int i = 0; i < inputAsCharArr.length; i++){
            output[i] = (int)inputAsCharArr[i];
        }
        return output;
    }

    private String applyTransformation(int[] inputArr, int[] keyArr, int multiplier) {
        int[] outputIntArr = incrementInputArrIndexes(inputArr, keyArr, multiplier);
        char[] outputCharArr = getCharArrFromIntArr(outputIntArr);

        return new String(outputCharArr);
    }

    private int[] incrementInputArrIndexes(int[] inputArr, int[] keyArr, int multiplier) {
        int[] outputIntArr = new int[inputArr.length];
        int keyIndex = 0;

        for(int i = 0; i < inputArr.length; i++){
            if(keyIndex >= keyArr.length){
                keyIndex=0;
            }
            int newIndex = inputArr[i] + (keyArr[keyIndex] * multiplier);
            outputIntArr[i] = newIndex;
        }

        return outputIntArr;
    }

    private char[] getCharArrFromIntArr(int[] outputIntArr) {
        char[] outputCharArr = new char[outputIntArr.length];

        for(int i = 0; i < outputIntArr.length; i++){
            outputCharArr[i] = (char)outputIntArr[i];
        }
        return outputCharArr;
    }
}
