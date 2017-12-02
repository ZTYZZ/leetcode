/*题目:
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

/*解析：

要想找到中位数，就必须知道中位数的概念。从小到大排序的一列数，取其中的中间的数，如果长度是偶数的话取中间的两个数/2
所以最重要，最核心的是：排序

如何将两个有序的数组，合并成一个有序的数组呢？
算法：顺序扫描，每次将较小的元素放进结果数组中,和两个链表相加的题有些类似，可以复习一下之前的。这题不难。

复杂度：O(n)

*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length+nums2.length];
        double median;
        //将数组1作为标准
        int i = 0;//数组1的临时变量
        int j = 0;//数组2的临时变量
        int count = 0;//结果数组的临时变量
        for( i = 0 ;i<nums1.length&&j<nums2.length;) {
            //将两者最小的数，放入目标数组
            if(nums1[i]>nums2[j]) {
                result[count++]=nums2[j++];
            }
            else{
                result[count++]=nums1[i++];
            }
        }
        //数组还有元素没有排好
        while(i<nums1.length){
            result[count++]=nums1[i++];
        }
        
        while(j<nums2.length) {
            result[count++]=nums2[j++];
        }

        //进行计算中位数
        if(result.length%2==0) {
            median=(result[result.length/2]+result[result.length/2-1])/2.0;
            
        }
        else {
            median = result[result.length/2];
        }
        
        return median;
    }
}