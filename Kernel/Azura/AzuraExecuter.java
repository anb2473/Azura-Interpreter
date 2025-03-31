package Kernel.Azura;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

class AzuraExecuter {
    private final LinkedList<String> tokenizedData;

    private final HashMap<String, Object> data;

    boolean endedAsError = false;

    AzuraExecuter(LinkedList<String> tokenizedData, HashMap<String, Object> parameters){
        this.tokenizedData = tokenizedData;
        this.data = parameters;
    }

    @SuppressWarnings({"unchecked"})
    void execute(){
        String tokenType = "";
        String statementType = "";
        boolean side = false;

        String var = "";
        String result = "";

        LinkedList<String> conditional = new LinkedList<>();

        boolean skipNextLetter = false;

        boolean countValues = true;

        for (String token : tokenizedData){
            for (int i = 0; i < token.length(); i++) {
                String letter = Character.toString(token.charAt(i));

                if (i == 0){
                        switch (letter){
                            case "(" -> {
                                if (!conditional.isEmpty()){
                                    if (Objects.equals(conditional.get(1), ":")) {
                                        if (!data.get(conditional.getFirst()).equals(data.get(conditional.getLast()))) {
                                            continue;
                                        }
                                    }

                                    if (Objects.equals(conditional.get(1), "!")) {
                                        if (data.get(conditional.getFirst()).equals(data.get(conditional.getLast()))) {
                                            continue;
                                        }
                                    }

                                    if (Objects.equals(conditional.get(1), "+:")) {
                                        if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                            if (((LinkedList<?>) data.get(conditional.getFirst())).size() < ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof Integer) {
                                            if ((int) data.get(conditional.getFirst()) < (int) (data.get(conditional.getLast()))) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof String) {
                                            if (((String) data.get(conditional.getFirst())).length() < ((String) (data.get(conditional.getLast()))).length()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof HashMap) {
                                            if (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() < ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                    }

                                    if (Objects.equals(conditional.get(1), "+")) {
                                        if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                            if (((LinkedList<?>) data.get(conditional.getFirst())).size() <= ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof Integer) {
                                            if ((int) data.get(conditional.getFirst()) <= (int) (data.get(conditional.getLast()))) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof String) {
                                            if (((String) data.get(conditional.getFirst())).length() <= ((String) (data.get(conditional.getLast()))).length()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof HashMap) {
                                            if (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() <= ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                    }

                                    if (Objects.equals(conditional.get(1), "-:")) {
                                        if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                            if (((LinkedList<?>) data.get(conditional.getFirst())).size() > ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof Integer) {
                                            if ((int) data.get(conditional.getFirst()) > (int) (data.get(conditional.getLast()))) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof String) {
                                            if (((String) data.get(conditional.getFirst())).length() > ((String) (data.get(conditional.getLast()))).length()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof HashMap) {
                                            if (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() > ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                    }

                                    if (Objects.equals(conditional.get(1), "-")) {
                                        if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                            if (((LinkedList<?>) data.get(conditional.getFirst())).size() >= ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof Integer) {
                                            if ((int) data.get(conditional.getFirst()) >= (int) (data.get(conditional.getLast()))) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof String) {
                                            if (((String) data.get(conditional.getFirst())).length() >= ((String) (data.get(conditional.getLast()))).length()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof HashMap) {
                                            if (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() >= ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                    }

                                    if (Objects.equals(conditional.get(1), "-=")) {
                                        if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                            if (((LinkedList<?>) data.get(conditional.getFirst())).size() > ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof Integer) {
                                            if ((int) data.get(conditional.getFirst()) > (int) (data.get(conditional.getLast()))) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof String) {
                                            if (((String) data.get(conditional.getFirst())).length() > ((String) (data.get(conditional.getLast()))).length()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof HashMap) {
                                            if (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() > ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                    }

                                    if (Objects.equals(conditional.get(1), "-")) {
                                        if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                            if (((LinkedList<?>) data.get(conditional.getFirst())).size() >= ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof Integer) {
                                            if ((int) data.get(conditional.getFirst()) >= (int) (data.get(conditional.getLast()))) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof String) {
                                            if (((String) data.get(conditional.getFirst())).length() >= ((String) (data.get(conditional.getLast()))).length()) {
                                                continue;
                                            }
                                        }
                                        if (data.get(conditional.getFirst()) instanceof HashMap) {
                                            if (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() >= ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                                continue;
                                            }
                                        }
                                    }
                                }

                                tokenType = letter;

                                if (token.contains(":")) statementType = ":";

                                else if (token.contains("@")) statementType = "@";

                                else if (token.contains("++")) statementType = "++";

                                else if (token.contains("--")) statementType = "--";

                                else if (token.contains("+:")) statementType = "+:";

                                else if (token.contains("-:")) statementType = "-:";

                                else if (token.contains("+")) statementType = "+";

                                else if (token.contains("-")) statementType = "-";

                                else if (token.contains("*")) statementType = "*";

                                else if (token.contains("/")) statementType = "/";

                                else if (token.contains("!")) statementType = "/";

                                continue;
                            }
                            case "{", "[" -> {
                                tokenType = letter;

                                continue;
                            }
                            case "<" -> {
                                tokenType = letter;

                                if (token.contains(":")) statementType = ":";

                                else if (token.contains("==")) statementType = "==";

                                else if (token.contains("-=")) statementType = "-=";

                                else if (token.contains("+=")) statementType = "+=";

                                else if (token.contains("-")) statementType = "-";

                                else if (token.contains("+")) statementType = "+";

                                else if (token.contains("!=")) statementType = "!=";

                                continue;
                            }
                        }
                }

                if (skipNextLetter) {
                    skipNextLetter = false;
                    continue;
                }

                switch (tokenType) {
                    case "(" -> {
                        switch (statementType) {
                            case ":" -> {
                                if (letter.equals(":")) {
                                    if (!side) {
                                        side = true;
                                        continue;
                                    }
                                }

                                if (!side) {
                                    var += letter;
                                    continue;
                                }

                                result += letter;

                                if (i + 1 == token.length()) {
                                    if (result.charAt(0) == '(')
                                        data.put(var, redefineValue(result));
                                    else
                                        if (result.charAt(result.length() - 1) == '}')
                                            data.put(var, redefineValue(result));
                                        else
                                            data.put(var, redefineValue(result.substring(0, result.length() - 1)));
                                    var = "";
                                    side = false;
                                    result = "";
                                }
                            }

                            case "++" -> {
                                if (!letter.equals("+")) {
                                    if (!letter.equals("("))
                                        var += letter;
                                } else {
                                    data.put(var, (int) data.get(var) + 1);
                                    var = "";
                                    skipNextLetter = true;
                                }
                            }

                            case "--" -> {
                                if (!letter.equals("-")) {
                                    if (!letter.equals("("))
                                        var += letter;
                                } else {
                                    data.put(var, (int) data.get(var) - 1);
                                    var = "";
                                    skipNextLetter = true;
                                }
                            }

                            case "+" -> {
                                if (!side) {
                                    if (!letter.equals("+")){
                                        var += letter;
                                    }
                                    else side = true;
                                } else {
                                    if (!letter.equals(")"))
                                        result += letter;

                                    if (i + 1 == token.length()) {
                                        Object nResult = redefineValue(result);

                                        if (data.get(var) instanceof Integer)
                                            data.put(var, (int) data.get(var) + (int) redefineValue((String) nResult));
                                        else if (data.get(var) instanceof String)
                                            data.put(var, data.get(var) + (String) redefineValue((String) nResult));
                                        else if (data.get(var) instanceof LinkedList)
                                            data.put(var, ((LinkedList<Object>) data.get(var)).addAll((LinkedList<Object>) redefineValue((String) nResult)));
                                        else if (data.get(var) instanceof HashMap){
                                            HashMap<Object, Object> resultMap = ((HashMap<Object, Object>) data.get(var));
                                            resultMap.putAll((HashMap<Object, Object>) redefineValue((String) nResult));
                                            data.put(var, resultMap);
                                        }

                                        var = "";
                                        result = "";
                                        side = false;
                                    }
                                }
                            }

                            case "-" -> {
                                if (!side) {
                                    if (!letter.equals("-")){
                                        if (!letter.equals("("))
                                            var += letter;
                                    }
                                    else side = true;
                                } else {
                                    if (!letter.equals(")"))
                                        result += letter;

                                    if (i + 1 == token.length()) {
                                        Object nResult = redefineValue(result);

                                        if (data.get(var) instanceof Integer)
                                            data.put(var, (int) data.get(var) - (int) redefineValue((String) nResult));
                                        else if (data.get(var) instanceof String)
                                            data.put(var, data.get(var) + (String) redefineValue((String) nResult));
                                        else if (data.get(var) instanceof LinkedList)
                                            data.put(var, ((LinkedList<Object>) data.get(var)).removeAll((LinkedList<Object>) redefineValue((String) nResult)));
                                        else if (data.get(var) instanceof HashMap){
                                            HashMap<Object, Object> resultMap = ((HashMap<Object, Object>) data.get(var));
                                            HashMap<Object, Object> removalMap = (HashMap<Object, Object>) redefineValue((String) nResult);
                                            for (Object key : resultMap.keySet()){
                                                if (removalMap.containsKey(key))
                                                    resultMap.remove(key);
                                            }
                                            data.put(var, resultMap);
                                        }

                                        var = "";
                                        result = "";
                                        side = false;
                                    }
                                }
                            }

                            case "/" -> {
                                if (!side) {
                                    if (!letter.equals("/")){
                                        if (!letter.equals("("))
                                            var += letter;
                                    }
                                    else side = true;
                                } else {
                                    if (!letter.equals(")"))
                                        result += letter;

                                    if (i + 1 == token.length()) {
                                        Object nResult = redefineValue(result);

                                        if (data.get(var) instanceof Integer)
                                            data.put(var, (int) data.get(var) / (int) nResult);
                                        else{
                                            System.err.println("Type Error in Division: " + token);
                                            endedAsError = true;
                                            return;
                                        }

                                        var = "";
                                        result = "";
                                        side = false;
                                    }
                                }
                            }

                            case "*" -> {
                                if (!side) {
                                    if (!letter.equals("*")){
                                        if (!letter.equals("("))
                                            var += letter;
                                    }
                                    else side = true;
                                } else {
                                    if (!letter.equals(")"))
                                        result += letter;

                                    if (i + 1 == token.length()) {
                                        Object nResult = redefineValue(result);

                                        if (data.get(var) instanceof Integer)
                                            data.put(var, (int) data.get(var) * (int) nResult);
                                        else if (data.get(var) instanceof String)
                                            data.put(var, ((String) data.get(var)).repeat((int) nResult));
                                        else{
                                            System.err.println("Type Error in Multiplication: " + token);
                                            endedAsError = true;
                                            return;
                                        }

                                        var = "";
                                        result = "";
                                        side = false;
                                    }
                                }
                            }
                        }
                    }

                    case "[" -> {
                        if (conditional.isEmpty()) {
                            while (true) {
                                AzuraCompiler compiler = new AzuraCompiler();
                                if (!compiler.executeString(token.replace("[", "").replace("]", ""), data)) {
                                    System.err.println("Error Executing Inline Code: " + token);
                                    endedAsError = true;
                                    return;
                                }
                                for (String compilerData : compiler.getData().keySet())
                                    try {
                                        data.put(compilerData, compiler.getData().get(compilerData));
                                    } catch (Exception _) {
                                    }
                            }
                        }

                        if (!countValues) {
                            if (i == token.length() - 1)
                                countValues = true;
                            continue;
                        }

                        if (Objects.equals(conditional.get(1), ":")) {
                            if (redefineValue(conditional.getLast()) instanceof LinkedList) {
                                for (Object entry : (LinkedList<Object>) redefineValue(conditional.getLast())) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    HashMap<String, Object> params = new HashMap<>(data);
                                    params.put(conditional.getFirst(), entry);
                                    if (!compiler.executeString(token.replace("[", "").replace("]", ""), params)) {
                                        System.err.println("Error Executing Inline Code: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try {
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        } catch (Exception _) {}
                                }
                                countValues = false;
                            } else if (redefineValue(conditional.getLast()) instanceof HashMap) {
                                for (Object entry : (((HashMap<Object, Object>) redefineValue(conditional.getLast()))).values()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    HashMap<String, Object> params = new HashMap<>(data);
                                    params.put(conditional.getFirst(), entry);
                                    if (!compiler.executeString(token.replace("[", "").replace("]", ""), params)) {
                                        System.err.println("Error Executing Inline Code: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try {
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        } catch (Exception _) {}
                                }
                                countValues = false;
                            } else if (redefineValue(conditional.getLast()) instanceof Integer) {
                                Object start = data.get(conditional.getFirst());
                                if (start == null) start = 0;

                                countValues = false;
                                if ((int) start < (int) redefineValue(conditional.getLast())){
                                    for (int num = (int) start; num < (int) redefineValue(conditional.getLast()); num++) {
                                        AzuraCompiler compiler = new AzuraCompiler();
                                        HashMap<String, Object> params = new HashMap<>(data);
                                        params.put(conditional.getFirst(), num);
                                        if (!compiler.executeString(token.replace("[", "").replace("]", ""), params)) {
                                            System.err.println("Error Executing Inline Code: " + token);
                                            endedAsError = true;
                                            return;
                                        }
                                        for (String compilerData : compiler.getData().keySet())
                                            try {
                                                data.put(compilerData, compiler.getData().get(compilerData));
                                            } catch (Exception _) {}
                                    }

                                    continue;
                                }

                                for (int num = (int) start; num > (int) redefineValue(conditional.getLast()); num--) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    HashMap<String, Object> params = new HashMap<>(data);
                                    params.put(conditional.getFirst(), num);
                                    if (!compiler.executeString(token.replace("[", "").replace("]", ""), params)) {
                                        System.err.println("Error Executing Inline Code: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try {
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        } catch (Exception _) {}
                                }
                            }
                        }

                        if (Objects.equals(conditional.get(1), "+")){
                            Object start = data.get(conditional.getFirst());
                            if (start == null) start = 0;

                            for (int num = (int) start; num > (int) redefineValue(conditional.getLast()); num--) {
                                AzuraCompiler compiler = new AzuraCompiler();
                                HashMap<String, Object> params = new HashMap<>(data);
                                params.put(conditional.getFirst(), num);
                                if (!compiler.executeString(token.replace("[", "").replace("]", ""), params)) {
                                    System.err.println("Error Executing Inline Code: " + token);
                                    endedAsError = true;
                                    return;
                                }
                                for (String compilerData : compiler.getData().keySet())
                                    try {
                                        data.put(compilerData, compiler.getData().get(compilerData));
                                    } catch (Exception _) {}
                            }

                            continue;
                        }

                        if (Objects.equals(conditional.get(1), "-")){
                            Object start = data.get(conditional.getFirst());
                            if (start == null) start = 0;

                            for (int num = (int) start; num < (int) redefineValue(conditional.getLast()); num++) {
                                AzuraCompiler compiler = new AzuraCompiler();
                                HashMap<String, Object> params = new HashMap<>(data);
                                params.put(conditional.getFirst(), num);
                                if (!compiler.executeString(token.replace("[", "").replace("]", ""), params)) {
                                    System.err.println("Error Executing Inline Code: " + token);
                                    endedAsError = true;
                                    return;
                                }
                                for (String compilerData : compiler.getData().keySet())
                                    try {
                                        data.put(compilerData, compiler.getData().get(compilerData));
                                    } catch (Exception _) {}
                            }

                            continue;
                        }

                        if (Objects.equals(conditional.get(1), "==") || Objects.equals(conditional.get(1), "!=")) {
                            System.err.println("Loop Error: Equivalency Comparison In For Loop");
                            endedAsError = true;
                            return;
                        }
                    }
                    case "{" -> {
                        if (conditional.isEmpty()) {
                            while (true) {
                                AzuraCompiler compiler = new AzuraCompiler();
                                if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                    System.err.println("Error executing for loop: " + token);
                                    endedAsError = true;
                                    return;
                                }
                                for (String compilerData : compiler.getData().keySet())
                                    try{
                                        data.put(compilerData, compiler.getData().get(compilerData));
                                    }
                                    catch(Exception _){}
                            }
                        }

                        if (Objects.equals(conditional.get(1), ":")) {
                            while (data.get(conditional.getFirst()).equals(data.get(conditional.getLast()))) {
                                AzuraCompiler compiler = new AzuraCompiler();
                                if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                    System.err.println("Error executing for loop: " + token);
                                    endedAsError = true;
                                    return;
                                }
                                for (String compilerData : compiler.getData().keySet())
                                    try{
                                        data.put(compilerData, compiler.getData().get(compilerData));
                                    }
                                    catch(Exception _){}
                            }
                        }

                        if (Objects.equals(conditional.get(1), "!")) {
                            while (!data.get(conditional.getFirst()).equals(data.get(conditional.getLast()))) {
                                AzuraCompiler compiler = new AzuraCompiler();
                                if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                    System.err.println("Error executing for loop: " + token);
                                    endedAsError = true;
                                    return;
                                }
                                for (String compilerData : compiler.getData().keySet())
                                    try{
                                        data.put(compilerData, compiler.getData().get(compilerData));
                                    }
                                    catch(Exception _){}
                            }
                        }

                        if (Objects.equals(conditional.get(1), "+:")) {
                            if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                while (((LinkedList<?>) data.get(conditional.getFirst())).size() >= ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof Integer) {
                                while ((int) data.get(conditional.getFirst()) >= (int) (data.get(conditional.getLast()))) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof String) {
                                while (((String) data.get(conditional.getFirst())).length() >= ((String) (data.get(conditional.getLast()))).length()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof HashMap) {
                                while (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() >= ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                        }

                        if (Objects.equals(conditional.get(1), "+")) {
                            if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                while (((LinkedList<?>) data.get(conditional.getFirst())).size() > ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof Integer) {
                                while ((int) data.get(conditional.getFirst()) > (int) (data.get(conditional.getLast()))) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof String) {
                                while (((String) data.get(conditional.getFirst())).length() > ((String) (data.get(conditional.getLast()))).length()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof HashMap) {
                                while (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() > ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                        }

                        if (Objects.equals(conditional.get(1), "-:")) {
                            if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                while (((LinkedList<?>) data.get(conditional.getFirst())).size() <= ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof Integer) {
                                while ((int) data.get(conditional.getFirst()) <= (int) (data.get(conditional.getLast()))) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof String) {
                                while (((String) data.get(conditional.getFirst())).length() <= ((String) (data.get(conditional.getLast()))).length()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof HashMap) {
                                while (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() <= ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                        }

                        if (Objects.equals(conditional.get(1), "-")) {
                            if (data.get(conditional.getFirst()) instanceof LinkedList) {
                                while (((LinkedList<?>) data.get(conditional.getFirst())).size() < ((LinkedList<?>) (data.get(conditional.getLast()))).size()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof Integer) {
                                while ((int) data.get(conditional.getFirst()) < (int) (data.get(conditional.getLast()))) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof String) {
                                while (((String) data.get(conditional.getFirst())).length() < ((String) (data.get(conditional.getLast()))).length()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                            if (data.get(conditional.getFirst()) instanceof HashMap) {
                                while (((HashMap<Object, Object>) data.get(conditional.getFirst())).size() < ((HashMap<Object, Object>) (data.get(conditional.getLast()))).size()) {
                                    AzuraCompiler compiler = new AzuraCompiler();
                                    if (!compiler.executeString(token.replace("{", "").replace("}", ""), data)){
                                        System.err.println("Error executing for loop: " + token);
                                        endedAsError = true;
                                        return;
                                    }
                                    for (String compilerData : compiler.getData().keySet())
                                        try{
                                            data.put(compilerData, compiler.getData().get(compilerData));
                                        }
                                        catch(Exception _){}
                                }
                            }
                        }

                        else {
                            System.err.println("Loop Error: Equals in for loop");
                            endedAsError = true;
                            return;
                        }
                    }
                    case "<" -> {
                        if (statementType.length() == 1) {
                            if (letter.equals(statementType)) {
                                side = true;
                                continue;
                            }
                        } else if (i + 1 < token.length()) {
                            if ((letter + token.charAt(i + 1)).equals(statementType)) {
                                skipNextLetter = true;
                                side = true;
                                continue;
                            }
                        }

                        if (!side) {
                            if (!letter.equals(">")){
                                var += letter;
                            }
                            continue;
                        }

                        result += letter;

                        if (i + 1 == token.length() - 1) {
                            conditional.clear();
                            conditional.add(var);
                            conditional.add(statementType);
                            conditional.add(result);
                            var = "";
                            result = "";
                            side = false;
                        }
                    }
                }
            }

            if (!tokenType.equals("<"))
                conditional.clear();
        }
    }

    @SuppressWarnings("unchecked")
    private Object redefineValue(String value){
        if (data.get(value) != null)
            return data.get(value);

        Object valueResult = value;

        try{
            return Integer.parseInt(value);
        }catch(NumberFormatException _){}

        if (value.equals("true")){
            return true;
        }

        if (value.equals("false")){
            return false;
        }

        if (value.charAt(0) == '{'){
            valueResult = new HashMap<>();

            StringBuilder var = new StringBuilder();
            StringBuilder result = new StringBuilder();

            boolean side = false;

            for (int j = 1; j < value.length(); j++){
                String listLetter = Character.toString(value.charAt(j));

                if (listLetter.equals(",") || listLetter.equals("}")){
                    ((HashMap<Object, Object>) valueResult).put(var.toString(), result.toString());
                    var = new StringBuilder();
                    result = new StringBuilder();
                    side = false;

                    continue;
                }

                if (listLetter.equals(":")){
                    side = true;
                    continue;
                }

                if (!side){
                    var.append(listLetter);
                    continue;
                }

                result.append(listLetter);
            }
        }
        else if (value.charAt(0) == '['){
            StringBuilder listItem = new StringBuilder();
            valueResult = new LinkedList<>();
            for (int j = 1; j < value.length(); j++){
                String listLetter = Character.toString(value.charAt(j));

                if (listLetter.equals(",") || listLetter.equals("]")){
                    ((LinkedList<Object>) valueResult).add(listItem.toString());
                    listItem = new StringBuilder();

                    continue;
                }

                listItem.append(listLetter);
            }
        }

        if (value.contains(".") && !value.contains("(") && !value.contains("<") && !value.contains("{")){
            int functionCallStage = 0;
            String functionName = "";
            StringBuilder parameterName = new StringBuilder();
            LinkedList<String> parameters = new LinkedList<>();
            StringBuilder desiredParameter = new StringBuilder();

            for (int j = 0; j < value.length(); j++){
                String letter = Character.toString(value.charAt(j));

                if (letter.equals(".")) {
                    functionCallStage++;
                    continue;
                }

                if (functionCallStage == 0) functionName += letter;

                else if (functionCallStage == 1) {
                    if (!letter.equals("[") && !letter.equals("]") && !letter.equals(" ")) {
                        if (letter.equals(",")) {
                            if (!parameterName.isEmpty()) {
                                parameters.add(parameterName.toString());
                                parameterName = new StringBuilder();
                            }
                        } else parameterName.append(letter);
                    }
                    continue;
                }

                if (functionCallStage == 2) {
                    desiredParameter.append(letter);
                }

                if (j + 1 == value.length()) {
                    AzuraCompiler compiler = new AzuraCompiler();

                    HashMap<String, Object> finalParamaters = new HashMap<>();
                    for (String parameter : parameters)
                        finalParamaters.put(parameter, data.get(parameter));

                    String executable = (String) data.get(functionName);
                    executable = executable.substring(0, executable.length() - 1).substring(1);

                    compiler.executeString(executable, finalParamaters);
                    if (desiredParameter.isEmpty()) {
                        return compiler.getData();
                    }

                    try{
                        return compiler.getData().get(desiredParameter.toString());
                    }catch(Exception _){}
                }
            }
        }

        return valueResult;
    }

    HashMap<String, Object> getData(){return data;}
}
