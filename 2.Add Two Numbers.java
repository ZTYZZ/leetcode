/*题目：

链接：https://leetcode.com/problems/add-two-numbers/description/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

*/

/*
解析：
作者知乎链接：https://www.zhihu.com/people/bing-mo-43-95/activities

解题思路：先把他当作两个普通的链表，进行相加，一个一个对应相加，很好实现。
		而在这题的难度是存在特殊的意义，即代表着两个数字的相加，这样的话就存在一个进位的问题。
		可以使用一个变量来存储进位，再加到下一位。
		
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head1,head2,head3;//两个临时变量
        head1=l1;
        head2=l2;
        head3=result;
        //进位值digit
        int digit=0;
        while(head1!=null&&head2!=null) {
            ListNode LNode = new ListNode(head1.val+head2.val+digit);

            //如果相加结果大于等于10（即出现进位），则将val取10的余数。并将进位值设成1
            if(LNode.val>=10){
                LNode.val=LNode.val%10;
                digit = 1;
            }
            
            else{
                //否则将数位归零
                digit=0;
            }
            
            head3.next = LNode;
            head1=head1.next;
            head2=head2.next;
            head3=head3.next;
            
            
            
            
        }
        //解决两个数位不想等的情况
        while(head1!=null){
            ListNode LNode = new ListNode(head1.val+digit);
            if(LNode.val>=10){
                LNode.val=LNode.val%10;
                digit = 1;
            }
            else{
                digit=0;//将数位归零
            }
            head3.next=LNode;
            head3=head3.next;
            head1=head1.next;
            
        }
        
        while(head2!=null){
            ListNode LNode = new ListNode(head2.val+digit);
            if(LNode.val>=10){
                LNode.val=LNode.val%10;
                digit = 1;
            }
            else{
                digit=0;//将数位归零
            }
            head3.next=LNode;
            head3=head3.next;
            head2=head2.next;
        }
        
        //最后一种情况，进位值仍然为1的时候
        if(digit==1){
            ListNode LNode = new ListNode(1);
            head3.next=LNode;
        }
        
        return result.next;
    }
}
