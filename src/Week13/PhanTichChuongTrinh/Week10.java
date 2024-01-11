import java.util.ArrayList;
import java.util.List;

public class Week10 {

    private String packageInfo = "";
    private List<String> importedLibraries = new ArrayList<>();
    private List<String> classNames = new ArrayList<>();
    private List<String> staticMethodSignatures = new ArrayList<>();

    private void processPackageInfo(String line) {
        String[] parts = line.trim().split(" ");
        for (int i = 0; i < parts.length; i++) {
            if ("package".equals(parts[i]) && i + 1 < parts.length) {
                packageInfo = parts[i + 1].replace(";", "");
                return;
            }
        }
    }

    private void processImportedLibraries(String line) {
        importedLibraries.add(line.trim().split(" ")[1].replace(";", ""));
    }

    private void processClassName(String line) {
        int startIndex = line.indexOf("class ") + 6;
        int endIndex = line.indexOf(" ", startIndex);
        if (endIndex != -1) {
            String className = line.substring(startIndex, endIndex).trim();
            String[] splitClassName = className.split("<");
            classNames.add(packageInfo + "." + splitClassName[0]);
        }
    }

    private String processMethodParameters(String paramStr) {
        if (paramStr.contains("...")) {
            return fixLibraryString(paramStr.replace("...", ""));
        }
        if (paramStr.contains("[]")) {
            int index = paramStr.indexOf("[]");
            return fixLibraryString(paramStr.replace("[]", "")) + paramStr.substring(index);
        }
        if (!paramStr.contains("<")) {
            return fixLibraryString(paramStr);
        }
        int index = paramStr.indexOf("<");
        String fixedParamStr = fixLibraryString(paramStr.substring(0, index)) + "<";
        String[] paramList = paramStr.substring(index + 1, paramStr.length() - 1).split(", ");
        for (int i = 0; i < paramList.length; i++) {
            if (i != 0) {
                fixedParamStr = fixedParamStr.concat(",");
            }
            if (paramList[i].startsWith("?")) {
                fixedParamStr = fixedParamStr.concat(paramList[i]);
            } else {
                fixedParamStr = fixedParamStr + fixLibraryString(paramList[i]);
            }
        }
        return fixedParamStr.concat(">");
    }

    private void processStaticMethod(String line) {
        if (line.contains("=")) {
            return;
        }
        int openParenIndex = line.indexOf("(");
        int closeParenIndex = line.indexOf(")", openParenIndex + 1);
        if (closeParenIndex == -1 || openParenIndex == -1) {
            return;
        }
        String methodName = line.substring(line.substring(0, openParenIndex)
                .lastIndexOf(" ") + 1, openParenIndex);
        if (closeParenIndex - openParenIndex == 1) {
            staticMethodSignatures.add(methodName.concat("()"));
            return;
        }

        String fixedMethodSignature = methodName + "(";
        String params = line.substring(openParenIndex + 1, closeParenIndex);
        String[] paramList = params.split(", ");
        for (int i = 0; i < paramList.length; i++) {
            if (i != 0) {
                fixedMethodSignature = fixedMethodSignature.concat(",");
            }
            String paramStr = paramList[i].substring(0,
                            paramList[i].lastIndexOf(" ")).replace("final ", "").trim();
            String param = processMethodParameters(paramStr);
            fixedMethodSignature = fixedMethodSignature.concat(param);
        }
        fixedMethodSignature = fixedMethodSignature.concat(")");
        staticMethodSignatures.add(fixedMethodSignature);
    }

    private String fixLibraryString(String str) {
        for (String lib : importedLibraries) {
            if (lib.endsWith("." + str)) {
                return lib;
            }
        }

        for (String className : classNames) {
            if (className.endsWith(str)) {
                return className;
            }
        }

        if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z' && str.length() > 1) {
            return "java.lang." + str;
        }
        return str;
    }

    private String preprocessFileContent(String fileContent) {
        StringBuilder sb = new StringBuilder(fileContent);
        int openParenIndex = sb.indexOf("(");
        while (openParenIndex != -1) {
            int closeParenIndex = sb.indexOf(")", openParenIndex);
            for (int i = closeParenIndex; i > openParenIndex; i--) {
                if (sb.charAt(i) == '\n') {
                    sb.deleteCharAt(i);
                }
            }
            openParenIndex = sb.indexOf("(", openParenIndex + 2);
        }
        return sb.toString();
    }

    private String removeComments(String fileContent) {
        StringBuilder sb = new StringBuilder(fileContent);
        int lineCommentIndex = sb.indexOf("//");
        while (lineCommentIndex != -1) {
            int newlineIndex = sb.indexOf("\n", lineCommentIndex);
            if (newlineIndex == -1) {
                sb.delete(lineCommentIndex, sb.length());
                break;
            }
            sb.delete(lineCommentIndex, newlineIndex);
            lineCommentIndex = sb.indexOf("//");
        }

        int blockCommentIndex = sb.indexOf("/*");
        while (blockCommentIndex != -1) {
            int blockCommentEndIndex = sb.indexOf("*/", blockCommentIndex);
            if (blockCommentEndIndex == -1) {
                break;
            }
            sb.delete(blockCommentIndex, blockCommentEndIndex + 3);
            blockCommentIndex = sb.indexOf("/*");
        }
        return sb.toString();
    }

    /**
     * Get All Functions.
     */
    public List<String> getAllFunctions(String fileContent) {
        String cleanedContent = removeComments(preprocessFileContent(fileContent));
        String[] lines = cleanedContent.replace("{", "{\n").split("\n");
        List<String> staticCode = new ArrayList<>();
        for (String line : lines) {
            if (line.startsWith("import")) {
                processImportedLibraries(line);
            } else if (line.startsWith("package")) {
                processPackageInfo(line);
            } else if (line.contains("class") || line.contains("enum")
                    || line.contains("interface")) {
                processClassName(line.replace("enum",
                        "class").replace("interface", "class"));
            } else if (line.contains("static")) {
                staticCode.add(line);
            }
        }
        staticCode.forEach(this::processStaticMethod);
        return staticMethodSignatures;
    }
}
