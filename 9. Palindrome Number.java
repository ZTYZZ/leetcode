/*习题：
Determine whether an integer is a palindrome. Do this without extra space.

*/

/*解析:
这道题是判断整数是不是回文数，而且明确规定了不要用额外的空间，所以就不能够用数组 或者字符串来转换。

换一种思路，对于整形数字来说，如果她是回文数的话，那么他的逆序和正序的大小是一样的！由此就可以转化为之前做的题。

但是有几种情况需要特殊考虑：
1. 负数  应视作false
2. 溢出的情况 应视作false

代码如下
*/
class Solution {
    public boolean isPalindrome(int x) {
        /*和之前的内容一样，关于数字的回文，会更加简单，因为只要判断他的逆序是否相等
        但是需要注意：
        1.负数的处理
        2.溢出处理
        */
        int temp = x;
        int digit = 0;
        int result = 0;
        boolean flag = true;
        //负数处理
        if(temp<0){
            flag=false;
        }
        //逆序处理
        else{
            while(temp>0){
                digit = temp%10;
                //溢出的处理
                if(result>Integer.MAX_VALUE/10||result==Integer.MAX_VALUE/10&&digit>Integer.MAX_VALUE%10) {
                    flag=false;
                    break;
                }
                else {
                    result = result*10+digit;
                }
                temp /= 10;
            }
        }
        //判断是否一致
        if(result!=x) {
            flag = false;
        }
        return flag;
    }
}