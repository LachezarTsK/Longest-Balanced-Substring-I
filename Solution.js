
/**
 * @param {string} input
 * @return {number}
 */
var longestBalanced = function (input) {
    const ALPHABET_SIZE = 26;
    const ASCII_SMALL_CASE_A = 97;
    let maxSizeBalancedSubstring = 0;

    for (let i = 0; i < input.length; ++i) {
        let maxFrequency = 0;
        let distinctValues = 0;
        const frequency = new Array(ALPHABET_SIZE).fill(0);

        for (let j = i; j < input.length && maxSizeBalancedSubstring < input.length - i; ++j) {
            ++frequency[input.codePointAt(j) - ASCII_SMALL_CASE_A];
            maxFrequency = Math.max(maxFrequency, frequency[input.codePointAt(j) - ASCII_SMALL_CASE_A]);

            if (frequency[input.codePointAt(j) - ASCII_SMALL_CASE_A] === 1) {
                ++distinctValues;
            }
            if (maxFrequency * distinctValues === j - i + 1) {
                maxSizeBalancedSubstring = Math.max(maxSizeBalancedSubstring, j - i + 1);
            }
        }
    }
    return maxSizeBalancedSubstring;
};
