/*
题目：
链接；https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

/*
作者知乎链接：https://www.zhihu.com/people/bing-mo-43-95/activities

解析：
此题统计的是最长不重复子串的长度，由于没有让输出最长子串，所以会简单一些。

第一种解法：枚举出所有的不重复子串，需要两层循环O(n^2)，同时还需要剔除所有的重复子串，这里就很不不好实现了
，既要时间 还需要空间，所以这种暴力列举的方法暂且放一放，想都不要想。


*/

/*第二种解法：HashMap （最后一个案例超时）

解析：

找这种不重复的最长子串，要从第一个元素找，找到重复的为止，而且由于不确定性与随机性，
找到一个不重复的子串以后，要从第二个位置找起，比如：abcdaeb  这个子串，先找到第一个不重复子串：abcd 之后，不能从d（3）之后找下一个
而是要从b（1）开始，寻找下一个。
从这里开始就有很多中实现方法了，我用的是一种HashMap方法来寻找不重复子串，代码见下面。

 复杂度分析：有两层循环构成，总次数是n + n-1 + n-2+...+0  所以复杂度有O(n^2)，这是一个不好的算法。
 
 改进：问题出现在哪里呢？

*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //记录当前不重复元素的最大值
        int maxLen = 0;
        int i,j;
        //建立一个HashMap，用来记录当前最大子串
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();

        //逐一扫描元素,开始寻找
        for(i =0;i<s.length();i++) {
            //从当前元素的下一个寻找不重复的元素。
            charMap.put(s.charAt(i),i);
            for(j = i+1;j<s.length();j++) {
               //如果charMap中有这个元素，那么此次查找的以i为首的最大子列结束。
                if(charMap.containsKey(s.charAt(j))) {
                   //更新最大长度
                    maxLen=Math.max(maxLen,j-i);
                    break;
                }
                else{
                    charMap.put(s.charAt(j),j);
                }
                
           }
            //完成一轮将当前最大子串清空，并重新更新最大长度。
            maxLen=Math.max(maxLen,j-i);
            charMap.clear();
        }
        
        return maxLen;
    }
}

/*第三种方法，改进第一种方法。
第二种方法，为什么这么慢呢？因为原本已经添加进charMap里面的元素，在最后的时候clear了，然后有得重新添加。
导致了重复计算。

这时候，我们不再删去全部，而是要将charMap里面的元素向右移动一位，（可以用删掉charMap第一位来得到）,还有一个需要注意的就是，要确保加入新元素，不会造成重复，从而不断删除首个元素直到没有重复。

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //记录当前不重复元素的最大值
        int maxLen = 0;
        int i,j=0;//用j来表示，要删除元素的位置
        //建立一个HashMap，用来记录当前最大子串
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();

        //逐一扫描元素,开始寻找
        for(i =0;i<s.length();i++) {
            while(charMap.containsKey(s.charAt(i))) {
                //更新最大长度
                maxLen=Math.max(maxLen,charMap.size());
                //确保没有重复的元素才能加入新元素
                charMap.remove(s.charAt(j++));
            }
            
            charMap.put(s.charAt(i),i);

                
        }
        //针对最后一个元素，重新更新最大长度。
        maxLen=Math.max(maxLen,charMap.size());

        
        return maxLen;
    }
}