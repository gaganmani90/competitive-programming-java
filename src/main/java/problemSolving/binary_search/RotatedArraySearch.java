package problemSolving.binary_search;

import org.junit.Assert;

public class RotatedArraySearch {
    int rotatedIndex = 0;

    public boolean searchBoolean(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return helper(nums, low, high, target);
    }

    private boolean helper(int[] nums, int low, int high, int target){
        if(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return true;
            }else{
                return helper(nums,low,mid-1,target) || helper(nums,mid+1,high,target);
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        //boundary condition
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        rotatedIndex = rotationIndex(nums);

        if (nums[rotatedIndex] == target) {
            return rotatedIndex;
        } else {
            if (rotatedIndex == 0) {
                return binarySearch(0, nums.length - 1, target, nums);
            } else if (nums[0] > target) {
                return binarySearch(rotatedIndex, nums.length - 1, target, nums);
            } else {
                return binarySearch(0, rotatedIndex - 1, target, nums);
            }
        }

    }

    private int binarySearch(int lo, int hi, int target, int[] arr) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                if (arr[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * returns rotated array index
     *
     * @param nums
     * @return
     */
    private int rotationIndex(int[] nums) {
        int loIndex = 0;
        int n = nums.length;
        int hiIndex = n - 1;

        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] < nums[n - 1]) {
            return 0;
        }

        while (loIndex < hiIndex) {
            int mid = (loIndex + hiIndex) / 2;
            int midValue = nums[mid];
            if (mid < n - 1 && nums[mid + 1] < midValue) {
                return mid + 1;
            } else if (mid > 0 && nums[mid - 1] > midValue) {
                return mid;
            } else if (nums[loIndex] < midValue) {
                loIndex = mid + 1;
            } else if (nums[hiIndex] > midValue) {
                hiIndex = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        RotatedArraySearch rotatedArraySearch = new RotatedArraySearch();
        Assert.assertEquals(true, rotatedArraySearch.searchBoolean(new int[]{2,5,6,0,0,1,2}, 0));
        Assert.assertEquals(false, rotatedArraySearch.searchBoolean(new int[]{2,5,6,0,0,1,2}, 3));

        rotatedArraySearch = new RotatedArraySearch();
        Assert.assertEquals(3, rotatedArraySearch.rotationIndex(new int[]{2, 5, 6, 0, 0, 1, 2}));
        Assert.assertEquals(3, rotatedArraySearch.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));

        rotatedArraySearch = new RotatedArraySearch();
        Assert.assertEquals(4, rotatedArraySearch.rotationIndex(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Assert.assertEquals(3, rotatedArraySearch.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));

        rotatedArraySearch = new RotatedArraySearch();
        Assert.assertEquals(0, rotatedArraySearch.rotationIndex(new int[]{1, 3}));
        Assert.assertEquals(1, rotatedArraySearch.search(new int[]{1, 3}, 3));

        rotatedArraySearch = new RotatedArraySearch();
        Assert.assertEquals(0, rotatedArraySearch.rotationIndex(new int[]{1}));
        Assert.assertEquals(0, rotatedArraySearch.search(new int[]{1}, 1));

        Assert.assertEquals(3, rotatedArraySearch.rotationIndex(new int[]{4, 5, 6, -1, 0, 1, 2}));
        Assert.assertEquals(1, rotatedArraySearch.rotationIndex(new int[]{4, 0, 1, 2}));
        Assert.assertEquals(3, rotatedArraySearch.rotationIndex(new int[]{4, 5, 6, 1}));
        Assert.assertEquals(0, rotatedArraySearch.rotationIndex(new int[]{1, 2}));

    }
}
