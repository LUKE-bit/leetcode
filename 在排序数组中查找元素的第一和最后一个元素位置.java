class Solution {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int left = 0,right = length - 1;
     
        while(left <= right) {
            int middle = (left+right)/2;
            if(target < nums[middle]) {
                right = middle - 1;
            }else if(target > nums[middle]) {
                left = middle + 1;
            }else {
                int begin = middle;
                int end = middle;
                for(int i = middle-1;i>=0;i--) {
                    if(i==0&&nums[i]==target) {
                        begin = 0;
                        break;
                    }
                    if(nums[i]!=target) {
                        begin = i + 1;
                        break;
                    }
                }
                for(int j = middle + 1;j<=length;j++) {
                    if(j==length) {
                        end = length - 1;
                        break;
                    }
                    if(nums[j]!=target) {
                        end = j - 1;
                        break;
                    }
                    
                }
                int[] ans = new int[]{begin,end};
                return ans;
            }
        }
        return new int[]{-1,-1};
    }
}


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        } 
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
