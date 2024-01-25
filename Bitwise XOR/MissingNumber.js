var MissingNumber=function(nums){
  let ans=nums.length;
    for(let i=0;i<nums.length;i++){
        ans^=i;
        ans^=nums[i];
  }
  return ans;
};
const nums=[3,0,1];
const result=MissingNumber(nums);
console.log(result);