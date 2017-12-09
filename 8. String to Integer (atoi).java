/*

习题：
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

*/

/*解析
本题考察的东西就是看你思考的全不全面，而且他还没有说具体的规则，我说一下它判定的规则，分为几种情况
1.空串
2.数字之前有空格如：“  123”
3.带符号的字符串 如：“+123”
4.在数字中间夹杂字符或者空格 如：“  —12 33”  将要输出 -12 后面舍弃
5.存在溢出问题，这个我在写的时候就很迷茫。下面主要说明这个问题。

因为是int类型的，所以占4个字节，记住 最大的最小的是 -(2^31)-1 ~ 2^31 -1（有一位是符号位，还有一个数字是0）
判断溢出的条件就是，有两种可能，1.结果>最大位/10 2.结果=最大位/10 并且 digit>最大位%10  只有这两种可能，因为一个数位的变化就是增加或者减少10。

代码如下:
*/
class Solution {
	public int myAtoi(String str) {
        int sybol = 1;//符号显示
        int index=0;//索引位置
        int digit;//记录每一位
        int result=0;//记录结果
        //1.空串

        if(str.length()==0){
            return 0;
        }
        //2.带有空格进行移除
        while(str.charAt(index)==' ') {
            index++;
        }
        //3.正数负数
        if(str.charAt(index)=='+'||str.charAt(index)=='-') {
           
            if(str.charAt(index)=='-') {
                sybol=0;
            }
            index++;
        }

        
        //4.逐一扫描
        for(int i = index;i<str.length();i++) {
            digit=str.charAt(i)-'0';
            //如果是数字
            if(digit>=0&&digit<=9){
                //判断溢出
                if(Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE %10 < digit)
                    return sybol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                
                result = result*10+digit;
                
            }
            //如果中途是空格
            else if(digit==' '-'0'){
                break;
            }
            //如果是非数字非空隔，即为字符
            else{
                break;
            }
        }
        System.out.println(result);
        //如果是负数
        if(sybol==0) {
            result = -result;
        }
        
        return result;
	}
}