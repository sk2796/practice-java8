public class GoldmanSachs {
    public static void main(String[] args) {
        // Given a string with {, }, and *, where * can be {, }, or empty, validate if the expression is balanced.
        String str = "{{}{{{*}}";
        boolean isValid = validateExpression(str);
        System.out.println(isValid);

    }

    private static boolean validateExpression(String str) {
        int openCount = 0;
        int starCount = 0;

        for (char c : str.toCharArray()) {
            if (c == '{') {
                openCount++;
            } else if (c == '}') {
                if (openCount > 0) {
                    openCount--;
                } else if (starCount > 0) {
                    starCount--;
                } else {
                    return false; // Unmatched closing brace
                }
            } else if (c == '*') {
                starCount++;
            }
        }

        // After processing, we can use stars to balance any remaining open braces
        return openCount <= starCount;
    }
}
