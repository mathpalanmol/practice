package ary;


// Input:  digits[] = "121"
// Output: 3
// The possible decodings are "ABA", "AU", "LA"

public class CountPossibleDecodings {
    static char[] config = new char[26];

    public static void main(String[] args) {
        populate();

        int[] ary = {1, 2, 1};
        StringBuilder sb = new StringBuilder();
        for (Integer value : ary) {
            sb.append(value.toString());
        }
        // The possible decodings are "ABA", "AU", "LA"
        process("121", "");
    }

    private static void populate() {
        for (int i = 0; i < config.length; i++) {
            int val = 65 + i;
            config[i] = (char) val;
        }

    }

    static void process(String str, String output) {
        if (str.isEmpty()) {
            System.out.println("output: " + output);
            return;
        }
        process(str.substring(1),
                output + config[Integer.parseInt(String.valueOf(str.charAt(0))) - 1]);
        if (str.length() >= 2 && Integer.parseInt(str.substring(0,
                2)) <= 26)
            process(str.substring(2), output + config[Integer.parseInt(str.substring(0,
                    2)) - 1]);
    }

}
