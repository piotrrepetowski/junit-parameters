package example.junitparams;

public class ApplicationLogic {

    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isEmptyString(String input) {
        return input == null || input.trim().isEmpty();
    }
}
