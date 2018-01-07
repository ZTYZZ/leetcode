/*
题目：
12. Integer to Roman
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

*/

/*
解析：
关于这道题，我不怎么喜欢，，，因为我不知道什么是罗马数字啊，，
罗马数字：  共有7个，I(1) V(5) X(10) L(50) C(100) D(500) M(1000)
			罗马数字没有0，与进位制无关。
			

*/

//代码：
//借鉴了一下网站上面的代码
//数组是降序排列
class Solution {
    public String intToRoman(int num) {
	    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuffer roman = new StringBuffer();//罗马数字
		for(int i = 0;i<values.length;i++) {//遍历整个数组
			while(num >=values[i]) {
				num -= values[i];
				roman.append(strs[i]);
			}
		}
		return roman.toString();
	

    }
}