/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/

/*解析：
题目的意思就是找出最长的回文子串。如果有重复出现的，输出任意一个回文的就可以。
也就是最终的结果有两个条件。1.回文 2.子串

*/

/*第一种方法（最后一个案例超时）：完全是按照最普通的想法来实现的，其复杂度有点高，外层n轮 内层最大n轮 判断回文数是n轮
在最坏的时候是O(n^3)*/

class Solution {
    public String longestPalindrome(String s) {
        String result=s.substring(0,1);
        //现找子串
        for(int i = 0 ;i<s.length();i++) {
            for(int j = i+1;j<s.length();j++) {
                if(isPalin(s,i,j)&&result.length()<j+1-i){
                    result=s.substring(i,j+1);
                }
                
            }
        }
        return result;
        
    }
    //判断是不是回文数
    public boolean isPalin(String s,int i,int j) {
        boolean flag = true;
        while(i<j) {
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}

/*第二种方法：
想一下回文的概念是什么？那就是正序和逆序一样，
所以这个方法就是从每一个元素为中心，找他的回文数，结果成功，但是还是不够理想，复杂度有O(n^2)

暂时还不知道怎么改进，先放着吧！
*/class Solution {
    public String longestPalindrome(String s) {
        String result=s.substring(0,1);
        System.out.println(result);
        //找到以每一个元素为中心,或者以两个元素的的回文数
        int start;
        int end;
        for(int i =0;i<s.length();i++){
            start = i-1;
            end = i+1;
            //情况1：以本元素为中心的回文数
            while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){

                if(end-start+1>result.length())
                    result=s.substring(start,end+1);

                start--;
                end++;
            }

            //情况2：以本元素和下一个元素为中心的回文数
            start = i;
            end = i+1;
            while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){

                if(end-start+1>result.length())
                    result=s.substring(start,end+1);            
                start--;
                end++;
            }
        }
        
        return result;
        
        
    }
}
