var threeSum = function(nums) {
    nums.sort((a, b) => a - b); 
    let result=[];
    for(let i=0;i<nums.length;i++){
        if(i===0||i>0&&nums[i]!==nums[i-1]){
            let left=i+1;
            let right=nums.length-1;
            let sum=0-nums[i]
            while(left<right){
                 if(nums[left]+nums[right]===sum){
                result.push([nums[i],nums[left],nums[right]]);
                while(left<right&&nums[left]===nums[left+1]){
                    left++;
                }
                while(left<right&&nums[right]===nums[right-1]){
                    right--;
                }
                left++;
                right--;
            }else if(nums[left]+nums[right]<sum){
                left++;
            }else{
                right--;
            }
            }
           
        }
    }
    return result;
};
const nums=[-1,0,1,2,-1,4];
const result=threeSum(nums);
console.log(result);