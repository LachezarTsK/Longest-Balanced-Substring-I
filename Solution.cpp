
#include <array>
#include <string>
#include <algorithm>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;

public:
    int longestBalanced(const string& input) const {
        int maxSizeBalancedSubstring = 0;

        for (int i = 0; i < input.size(); ++i) {
            int maxFrequency = 0;
            int distinctValues = 0;
            array<int, ALPHABET_SIZE> frequency{};

            for (int j = i; j < input.size() && maxSizeBalancedSubstring < input.size() - i; ++j) {
                ++frequency[input[j] - 'a'];
                maxFrequency = max(maxFrequency, frequency[input[j] - 'a']);

                if (frequency[input[j] - 'a'] == 1) {
                    ++distinctValues;
                }
                if (maxFrequency * distinctValues == j - i + 1) {
                    maxSizeBalancedSubstring = max(maxSizeBalancedSubstring, j - i + 1);
                }
            }
        }
        return maxSizeBalancedSubstring;
    }
};
