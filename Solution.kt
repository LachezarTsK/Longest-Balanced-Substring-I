
import kotlin.math.max

class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
    }

    fun longestBalanced(input: String): Int {
        var maxSizeBalancedSubstring = 0

        for (i in input.indices) {
            var j = i
            var maxFrequency = 0
            var distinctValues = 0
            val frequency = IntArray(ALPHABET_SIZE)

            while (j < input.length && maxSizeBalancedSubstring < input.length - i) {
                ++frequency[input[j] - 'a']
                maxFrequency = max(maxFrequency, frequency[input[j] - 'a'])

                if (frequency[input[j] - 'a'] == 1) {
                    ++distinctValues
                }
                if (maxFrequency * distinctValues == j - i + 1) {
                    maxSizeBalancedSubstring = max(maxSizeBalancedSubstring, j - i + 1)
                }
                ++j
            }
        }
        return maxSizeBalancedSubstring
    }
}
