var removeDuplicates = function(nums) {
    let i = 0;
    for (let j = 1; j < nums.length; j++) {
        if (nums[i] !== nums[j]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i+1;
};
const nums = [0,0,1,1,1,2,2,3,3,4];
const result = removeDuplicates(nums);
console.log(nums)
console.log(result); // 输出去重后数组的长度

