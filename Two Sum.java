/*
题目：
链接：https://leetcode.com/problems/two-sum/description/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

/*
作者知乎：https://www.zhihu.com/people/bing-mo-43-95/activities

解析：

题目的意思就是，找出两个数，使得这两个加起来等于给定数字。只有一组这样的解，同时不能使用同一个元素两次。

一种解法是暴力搜索，这个都会，不赞成使用。

第二种方法思路：
与暴力方法不同，当我线性扫描数组时，如果能在O(1)的时间内找到，target-nums 的位置，那么就可以在O(n)的时间内找到，target-nums
解决问题。这就需要使用Map函数。（它可以通过键来找值，在O(1)的时间即可）

算法流程：
1.将数组里面的数据，通过键值对，来添加进Map中。
2.线性扫描，两个数相加，则输出。由于唯一性，不必考虑过多。


*/

class Solution {
	public int[] twoSum(int[] nums,int target) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		//实现声明一个数组，结果返回给调用者。
		int[] result = new int[2];
		//将数组里面导入map中
		for(int i = 0 ;i<nums.length;i++){
			map.put(nums[i],i);
		}
		//线性扫描，找出合理的值
		for(int i = 0;i<nums.length;i++){
			
			if(map.containsKey(target-nums[i])&&map.get(target-nums[i])!=i){
				
				//判断两个元素，较小的排在前面，较大的在后面。
                if(i>map.get(target-nums[i])){
                    result[0]=map.get(target-nums[i]);
                    result[1]=i;
                }
                else{
                    result[0]=i;
				    result[1]=map.get(target-nums[i]);
                }
				break;
			}
		}
        
        return result;
		
	}
}


