// https://leetcode.com/problems/longest-substring-without-repeating-characters/
#include <iostream>
#include <string>
#include <map>

using namespace std;

class Solution {
public:
	// best solution
	// int lengthOfLongestSubstring(string s) {
	// 	int left = 0, len = 0;
	// 	map<char, int> dict;
	// 	for (int right = 0; right < s.size(); right++) {
	// 		if (dict.find(s[right]) != dict.end()) {
	// 			left = max(left, dict[s[right]] + 1);
	// 		}
	// 		dict[s[right]] = right;
	// 		len = max(len, right - left + 1);
	// 	}
	// 	return len;
	// }

	// my solution
	
    int lengthOfLongestSubstring(string s) {
    	if (s.empty()) return 0;
    	int windowStart = 0;
    	int windowSize = 1;
    	string window = s.substr(windowStart, windowSize);
    	cout << "Window is " << window << endl;
    	size_t size = s.size();
    	for (int i = 1; i < size; i++) {
    		size_t found = window.find_first_of(s[i]);
    		if (found != string::npos) {
    			cout << "Position of " << s[i] << " is " << found << endl;
    			i += found;
    			cout << "Window start is " << (windowStart += found+1) << endl;
    			window = s.substr(windowStart, windowSize);
    			while (!allUnique(window)) {
    				++i;
    				window = s.substr(++windowStart, windowSize);
    			}
    			cout << "Window is " << window << endl;
    		} else {
    			cout << "Symbol " << s[i] << " not found" << endl;
    			window = s.substr(windowStart, ++windowSize);
    			cout << "Window is " << window << endl;
    		}
    	}
        return windowSize;
    }

    bool allUnique(string s) {
    	bool arr[128] = {false};
    	for (unsigned int i = 0; i < s.size(); i++) {
    		int val = s[i];
    		if (arr[val]) {
    			return false;
    		} else {
    			arr[val] = true;
    		}
    	}
    	return true;
    }
};

int main(int argc, char const *argv[])
{
	Solution s;
	string s1("ggububgvfk");
	cout << s.lengthOfLongestSubstring(s1) << endl;
	return 0;
}