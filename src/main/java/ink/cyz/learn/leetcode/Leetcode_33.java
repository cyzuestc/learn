package ink.cyz.learn.leetcode;

public class Leetcode_33 {

    public static void main(String[] args){
//        int[] arr = {4,5,6,7,0,1,2,3};
        int[] arr = {3,1};
        Leetcode_33 t = new Leetcode_33();
        t.search(arr,1);

    }
    public int search(int[] nums, int target) {
        search(nums,target,0,nums.length-1);
        System.out.println(res);
        return res;
    }
    int res = -1;

    public boolean search(int[] nums,int target,int i,int j){
        if (i==j && nums[i] == target){
            res = i;return true;
        }
        if (i>=j)return false;

        int m = (i+j)/2;
        int left = nums[i];
        int right = nums[j];
        int mid = nums[m];
        if (mid == target){
            res = m;return true;
        }if (left == target){
            res = i;
            return true;
        }if (right == target){
            res = j;
            return true;
        }
        if (target>mid){
            if (mid<left&&mid<right){
                return search(nums,target,m+1,j)||search(nums,target,i,m-1);
            }else {
                return search(nums,target,m+1,j);
            }
        }else {
            if (mid>left&&mid>right){
                return search(nums,target,m+1,j)||search(nums,target,i,m-1);
            }else {
                return search(nums,target,i,m-1);
            }
        }

    }

}
