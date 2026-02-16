
public class Solution {

    private static final int ALPHABET_SIZE = 26;

    public int longestBalanced(String s) {
        char[] input = s.toCharArray();
        int maxSizeBalancedSubstring = 0;

        for (int i = 0; i < input.length; ++i) {
            int maxFrequency = 0;
            int distinctValues = 0;
            int[] frequency = new int[ALPHABET_SIZE];

            for (int j = i; j < input.length && maxSizeBalancedSubstring < input.length - i; ++j) {
                ++frequency[input[j] - 'a'];
                maxFrequency = Math.max(maxFrequency, frequency[input[j] - 'a']);

                if (frequency[input[j] - 'a'] == 1) {
                    ++distinctValues;
                }
                if (maxFrequency * distinctValues == j - i + 1) {
                    maxSizeBalancedSubstring = Math.max(maxSizeBalancedSubstring, j - i + 1);
                }
            }
        }
        return maxSizeBalancedSubstring;
    }
}
