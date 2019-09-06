You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

```shell script
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```
题目大意：给定两个非空链表，链表的每个节点表示为一个正整数。数字以相反的顺序存储，每个节点包含一个数字。 按位相加两个中的数字并将其作为链接列表返回。  
解题思路：使用两个指针，分别遍历两个链表，遍历过程中计算进位、进位后的值。当链表的长度不一时，额外遍历较长的那个链表进行相同计算。