/*
题目：

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

/*
解析：
这道题我是没有思路的，完全不知道怎么做，想过用数组存储，但是还是不太清楚。

后来看过别人的思路，发现这种题，就相当于找规律，其实和他的那个之字形没多大关系

先看一下：假设行数为4
0      6      12
1    5 7   11 13
2  4   8 10   14
3      9      15

这就是所谓的之字形排布，
假设行数为row（从0开始）那么每行的间隔：
第0行和最后一行：总间隔 = 2row（2*3=6）
其余行：第一个元素与第二个元素的间隔：总间隔-2row     第二个元素与第三个元素：2row 之后依次类推。。。

找出这个规律之后，就不难了。。
需要注意的是，需要用一个flag来记录，其余行中不同间隔的转换，每轮循环别忘了恢复flag的值。
不懂得话，具体看代码：
*/

class Solution {
    public String convert(String s, int numRows) {
        int flag = 1;
        int row = 0; //行数从0开始计数。
        int confirm = 2*(numRows-1);
        int part = confirm;//设置间隔,初始是2（行数-1）
        //新建一个结果字符串
        String result = "";
        
        //针对一些特殊的情况
        //行数为1
        if(numRows==1) {
            return s;
        }

        while(row<numRows) {
            //第0行和最后一行，特殊照顾！
            if(row==0||row==numRows-1) {
                for(int i = row;i<s.length();i+=confirm) {
                    result += s.charAt(i);
                }
                row++;
            }
            //其余行
            else {
                
				for(int i = row ;i<s.length();i+=part) {
					result +=s.charAt(i);
					if(flag==1){
						part=confirm-2*row;
						flag=0;
					}
					else {
						part=2*row;
						flag=1;
					}
                
				}
            row++;//行数++
            flag=1;//每次要恢复flag的值
            }
        }
        return result;
    }
}