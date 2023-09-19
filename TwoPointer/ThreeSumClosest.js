var threeSumClosest = function(nums, target) {
   nums.sort((a,b)=>a-b);
   let closesum=Infinity;
   let min=Infinity;
   for(let i=0;i<nums.length;i++){
    let left=i+1;
    let right=nums.length-1;
    while(left<right){
        let sum=nums[i]+nums[left]+nums[right];
        let diff=Math.abs(sum-target);
        if(diff<min){
            min=diff;
            closesum=sum;
        }
        if(sum<target){
            left++;
        }else{
            right--;
        }
    }
   }
   return closesum;
};
const nums=[-1,2,1,-4];
const target=1;
const result=threeSumClosest(nums,target);
console.log(result);