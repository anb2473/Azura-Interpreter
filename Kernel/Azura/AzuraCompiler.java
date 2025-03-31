package Kernel.Azura;

import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;


public class AzuraCompiler {
    private static String fileData;
    private static String filePath;

    private HashMap<String, Object> data;

    public boolean execute(@NotNull String path, HashMap<String, Object> parameters) {
        if (path.split("\\.").length != 2){
            System.err.println("Invalid Path: " + path);
            return false;
        }

        if (!Objects.equals(path.split("\\.")[1], "aura")){
            System.err.println("Invalid Path Extension: " + path.split("\\.")[1]);
            return false;
        }

        filePath = path;

        if (parameters == null) parameters = new HashMap<>();

        try {
            fileData = parse();
        } catch (IOException e) {
            System.err.println("Error reading file: \"" + filePath + "\", check that file exists and is not a directory");
            return false;
        }

        LinkedList<String> tokenizedData = tokenize();

        AzuraExecuter executer = new AzuraExecuter(tokenizedData, parameters);
        executer.execute();

        if (executer.endedAsError) return false;

        data = executer.getData();

        return true;
    }

    public boolean executeString(String auraFile, HashMap<String, Object> parameters) {
        if (parameters == null) parameters = new HashMap<>();

        fileData = auraFile;

        LinkedList<String> tokenizedData = tokenize();

        AzuraExecuter executer = new AzuraExecuter(tokenizedData, parameters);
        executer.execute();

        if (executer.endedAsError) return false;

        data = executer.getData();

        return true;
    }

    @org.jetbrains.annotations.NotNull
    private static String parse() throws IOException {
        StringBuilder result = new StringBuilder();

        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) result.append(st);

        return result.toString();
    }

    private static @NotNull LinkedList<String> tokenize(){
        LinkedList<String> tokenizedData = new LinkedList<>();

        String tokenType = "";
        StringBuilder token = new StringBuilder();

        boolean inToken = false;

        int startIndx = 0;

        for (int i = 0; i < fileData.length(); i++) {
            char letter = fileData.charAt(i);

            if (String.valueOf(letter).equals(" ")) continue;

            if (tokenType.isEmpty() && !inToken){
                if (letter == '{' || letter == '[' || letter == '<' || letter == '('){
                    startIndx = i;

                    tokenType = String.valueOf(letter);

                    token.append(letter);

                    inToken = true;
                }

                continue;
            }

            token.append(letter);

            if (!tokenType.isEmpty()){
                if (letter == '}' || letter == ']' || letter == ')' || letter == '>'){
                    if (isValidMatchFound(tokenType, startIndx, i)) continue;

                    if (tokenType.equals("(")){
                        if (letter != ')'){
                            continue;
                        }
                    }
                    if (tokenType.equals("{")){
                        if (letter != '}'){
                            continue;
                        }
                    }
                    if (tokenType.equals("<")){
                        if (letter != '>'){
                            continue;
                        }
                    }
                    if (tokenType.equals("[")){
                        if (letter != ']'){
                            continue;
                        }
                    }

                    tokenType = "";

                    tokenizedData.add(token.toString());

                    token = new StringBuilder();

                    inToken = false;
                }
            }
        }

        return tokenizedData;
    }

    private static boolean isValidMatchFound(String letter, int indx, int i) {
        int numOfInners = 0;

        char mismatchLetter = ' ';
        if (Objects.equals(letter, "{")) mismatchLetter = '}';
        if (Objects.equals(letter, "(")) mismatchLetter  = ')';
        if (Objects.equals(letter, "<")) mismatchLetter = '>';
        if (Objects.equals(letter, "[")) mismatchLetter = ']';

        for (int g = 0; g < fileData.length() - i - 1; g++) {
            char remainingLetter = fileData.charAt(g + i + 1);

            if (String.valueOf(remainingLetter).equals(letter)){
                numOfInners++;
                continue;
            }

            if (remainingLetter == mismatchLetter){
                numOfInners--;
                if (numOfInners < 0){
                    if (g != indx) return true;
                    break;
                }
            }
        }
        return false;
    }

    public Object getValue(String value){
        if (data.get(value) == null){
            System.err.println("Value not found: make sure value is in global space, and is properly assigned");
            return null;
        }

        return data.get(value);
    }

    public HashMap<String, Object> getData(){
        if (data == null){
            System.err.println("Failed to execute file");
            return null;
        }
        if (data.isEmpty()){
            System.err.println("No data: make sure data is in global space and is properly assigned");
            return null;
        }

        return data;
    }
}
