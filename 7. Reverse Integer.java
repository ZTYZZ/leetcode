/*
习题：
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/
/*
解析：

这题其实理解起来不难，题目要求逆序输出。
逆序输出不难，但是难点是32bit ，一旦溢出要返回0。那怎么判断溢出？

因为是32位的有符号的整数，最大的十进制就是-(2^31)-1 ~ 2^31 -1 



*/

/*
分解数位

%：分解成个位数字
/: 去除个位数字。
逆序数字就是：（分解个位数字之后）*10+个位数字

具体代码如下：

*/

class Solution {
    public int reverse(int x) {
        int digit = 0;
        int result = 0;
        int sybol=0;//带符号，0代表负号，1代表正号。
        
        //因为是x是带符号的，所以分情况讨论
        if(x>0) {
            sybol=1;
        }
        else {
            sybol=0;
            x = -x;
        }
        
        //对于溢出的问题进行处理
        if(x>=2147483647) {
            return 0;
        }

        while(x>0){
            digit = x % 10;
            //对于溢出的问题进行处理。
            if(result >2147483647/10.0)
                return 0;
            result = result*10+digit;
            x = x/10;
        }
        
        return (sybol==1)?result:-result;
    }
}

