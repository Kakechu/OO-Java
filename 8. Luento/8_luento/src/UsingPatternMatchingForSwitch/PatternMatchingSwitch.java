package UsingPatternMatchingForSwitch;

public class PatternMatchingSwitch {

    public static void main(String[] args) {
        testFormatterPatternSwitch();
    }

    static void testFormatterPatternSwitch() {
        Object[] testCases = {42, 42L, 42.0, "Hello, World!", new Object()};
        for (Object testCase : testCases) {
            String result = formatterPatternSwitch(testCase);
            System.out.println("Input: " + testCase + " -> Output: " + result);
        }
    }

    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> "unknown type";
        };
    }
}
