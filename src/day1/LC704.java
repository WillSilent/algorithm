package day1;

public class LC704 {

    // 我的答案(还需对代码进行优化)
    public int pivotIndex1(int[] nums) {
        int len = nums.length;
        int totalSum = 0;
        for(int i = 0; i < len; i++) {
            totalSum += nums[i];
        }

        int leftSum = 0;
        int rightSum = totalSum - nums[0];
        if(leftSum == rightSum) {
            return 0;
        }

        for(int i = 1; i < len; i++) {

            leftSum = leftSum + nums[i-1];
            rightSum = rightSum - nums[i];

            if(leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    // official
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

}
