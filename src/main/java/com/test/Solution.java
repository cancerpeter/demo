package com.test;

public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param height int整型一维数组
     * @return int整型
     */
    public int maxArea (int[] height) {
        // write code here
        int left = 0, right = height.length - 1;
        int ans = 0;
        while(left < right){
            if(height[left] < height[right]){
                int cur = (right - left) * height[left];
                ans = Math.max(cur, ans);
                left++;
            }else{
                int cur = (right - left) * height[right];
                ans = Math.max(cur, ans);
                right--;
            }
        }
        return ans;
    }


}
