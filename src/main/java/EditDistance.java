// EditDistance.java
// Narasimha Reddy Putta

public class EditDistance {
    // Method to calculate edit distance
    public static int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // If first string is empty, insert all characters of second string
                } else if (j == 0) {
                    dp[i][j] = i; // If second string is empty, insert all characters of first string
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // If last characters are the same, ignore last char
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],  // Replace
                            Math.min(dp[i - 1][j],  // Remove
                                    dp[i][j - 1])); // Insert
                }
            }
        }

        return dp[m][n];
    }

    // Main method to take input from command line and display results
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java EditDistance string1 string2");
            return;
        }

        String str1 = args[0];
        String str2 = args[1];

        int distance = editDistance(str1, str2);

        System.out.println("Narasimha Reddy Putta");
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("Edit Distance: " + distance);
    }
}
