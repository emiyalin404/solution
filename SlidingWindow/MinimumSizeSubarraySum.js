var MinimumSizeSubarraySum=function(nums,target){
    let start=0;
    let sum=0;
    let min=Number.MAX_SAFE_INTEGER;
    for(let i=0;i<nums.length;i++){
        sum+=nums[i];
        while(sum>=target){
            min=Math.min(min,i-start+1);
            sum-=nums[start];
            start++;
        }   
    }
    if(min===Number.MAX_SAFE_INTEGER){
            return 0;
        }else{
            return min;
        }
};
const nums=[1,1,1,1,1,1,1,1];
const target=11;
const result=MinimumSizeSubarraySum(nums,target);
console.log(result);