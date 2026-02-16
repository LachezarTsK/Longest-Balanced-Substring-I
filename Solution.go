
package main

const ALPHABET_SIZE = 26

func longestBalanced(input string) int {
    maxSizeBalancedSubstring := 0

    for i := range input {
        maxFrequency := 0
        distinctValues := 0
        frequency := make([]int, ALPHABET_SIZE)

        for j := i; j < len(input) && maxSizeBalancedSubstring < len(input) - i; j++ {
            frequency[input[j] - 'a']++
            maxFrequency = max(maxFrequency, frequency[input[j] - 'a'])

            if frequency[input[j] - 'a'] == 1 {
                distinctValues++
            }
            if maxFrequency*distinctValues == j - i + 1 {
                maxSizeBalancedSubstring = max(maxSizeBalancedSubstring, j - i + 1)
            }
        }
    }
    return maxSizeBalancedSubstring
}
