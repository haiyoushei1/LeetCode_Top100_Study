package two_sum;

import java.util.HashMap;
import java.util.Map;

/*
题目大意，给出一个数组，一个目标值，返回数组中，和为目标值的两个数的数组下标
分析：该题可分为两个步骤，做减法获得另一个加数，在剩下的数组中找到这个数的下标
暴力查找可以用二分法，时间复杂度O(nlogn)
使用哈希表简化查找，时间复杂度为O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}  // 题解代码
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int index[] = new int[2];
        for(int i = 0; i < nums.length; i++)
            hashMap.put(nums[i], i);
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(hashMap.get(temp) != null && hashMap.get(temp) != i){
                index[0] = i;
                index[1] = hashMap.get(temp);
                break;
            }
        }
        return index;
    }
}  // 我的代码
/*
题解代码的精妙处：
正常思维就是我从这个点往后遍历数组。
我的代码是先构建哈希表，然后再从头做比较，这样就会遇到一个问题，会出现取相同加数（题中，一个数只能用一次）。
题解代码则是倒过来了，先判断能不能成，不能再把这个数放到哈希表，倒着往前面找，这样避免了一个数用两次。
 */