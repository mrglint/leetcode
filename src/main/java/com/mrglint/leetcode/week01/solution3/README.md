Given a string, find the length of the longest substring without repeating characters.

Example 1:
```shell script
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3.
```
Example 2:
```shell script
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

Example 3:
```shell script
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

题目大意：给定一个字符串，返回该字符串中最长的不重复子串的长度。如"abcabcbb"，则结果为3；"bbbb"，则结果为1  
解题思路：通过滑动窗口的思路来解决，定义两个指针from、to，分别指向窗口的头部、尾部。在遍历字符串的过程中，
利用一个长度256的数组记录越过的字符在窗口中的个数（以为ASCII码有256个），指针to不断的右移，并更新窗口大小。
如果出现重复字符那么收缩窗口大小（通过右移from指针来完成窗口收缩）。直到from指针遍历到字符串最后一个字符，结束遍历。
此时窗口大小即为连续不重复字符的个数。