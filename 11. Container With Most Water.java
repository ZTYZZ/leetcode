/*
题目：
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

/*解析：
这题的难点在于英语。。。我来解释一下：给出n个正整数，所以会有n个点（1，a1）（2，a2）...这几个点与x轴做垂线，最后的效果就是如图所示

|  
|  |   
|  |  |
|  |  |
|  |  |
|　|  |
|__|__|_____________________
1  2  3 ....  ... ...  ... x

大概就是这样n条线，问最多能装多少水。

我们都知道，两个不一样高的挡板，装水取决于最矮的那个，所以我们从第一个桶开始算，累加到第n-1个桶。

*/


//题目实际要求的是，找出任意的两个竖线，它和x轴组成的水量最大。
//第一种方法：枚举出所有的两条线（肯定超时）
class Solution {
	public int maxArea(int[] height) {
		int water = 0;//将水设为0
		int maxWater = 0;//最大水量
		int minHeight = 0;
		for(int i = 0 ;i<height.length;i++){
			for(int j = i+1;j<height.lenght;j++){
				minHeight = height[i]>height[j]?height[j]:height[i];
				water = minHeight*(j-i);
				if(water>maxWater) 
					maxWater = water;
			}
			
		}
		return maxWater;
	}
}

//第二种方法（二分法）
//上面的方法，因为有了太多的重复比较，所以导致很慢。所以使用二分法能够减少很多次不必要的比较。
//主要方法，就是比较两个端点元素，记录minWater，再依次缩小，这是一种从两边向中间的查找。
class Solution {
	public int maxArea(int[] height){
		
		int start = 0;//起点
		int end = height.length-1;//终点
		int water = 0;//水量设置为0
		int maxWater = height[start]>height[end]?height[end]:height[start];//最大水量为0
        int minHeight = 0;
		
		while(start!=end){//只要两个元素还没有到相遇，就继续
		
		if(height[start]>height[end]){
			minHeight = height[end];
			end--;
		}
		else{
			minHeight = height[start];
			start++;
		}
			water = minHeight*(end-start+1);
			if(water>maxWater){
				maxWater = water;
			}
		}
		return maxWater;
	}
}

//题外话：在之前写的时候理解错误，下面是两个我理解错误写出来的代码。

//代码(这个理解错误）
class Solution {
	public int maxArea(int[] height) {
		//初始化
		int water = 0;
		//开始迭代
		for(int i = 0;i<height.length-1;i++){//迭代到倒数第二个元素
			water+=height[i]>height[i+1]?height[i+1]:height[i];//判断两个高度大小，去最小的元素
				
			}
		return water;
		}
	}
//上面的理解错误，题目的本来意思是找到最小的元素，然后*底就完了。
class Solution {
	public int maxArea(int[] height) {
		int water = 0;//将水设为0
		int minHeight = height[0];//假定最小元素为第1个元素
		for(int i = 1 ;i < height.length;i++){//找出最小元素。
			if(height[i]<minHeight) 
				minHeight = height[i];
		}
		water = (height.length-1)*minHeight;
		return water;
	}
}

//上面的理解还是有误。
	
