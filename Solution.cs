
using System;
using System.Collections.Generic;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;

    public int LongestBalanced(string input)
    {
        int maxSizeBalancedSubstring = 0;

        for (int i = 0; i < input.Length; ++i)
        {
            int maxFrequency = 0;
            int distinctValues = 0;
            int[] frequency = new int[ALPHABET_SIZE];

            for (int j = i; j < input.Length && maxSizeBalancedSubstring < input.Length - i; ++j)
            {
                ++frequency[input[j] - 'a'];
                maxFrequency = Math.Max(maxFrequency, frequency[input[j] - 'a']);

                if (frequency[input[j] - 'a'] == 1)
                {
                    ++distinctValues;
                }
                if (maxFrequency * distinctValues == j - i + 1)
                {
                    maxSizeBalancedSubstring = Math.Max(maxSizeBalancedSubstring, j - i + 1);
                }
            }
        }
        return maxSizeBalancedSubstring;
    }
}
