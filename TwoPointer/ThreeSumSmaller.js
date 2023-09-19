var threeSumSmaller=function(nums,target){
    nums.sort((a,b)=>a-b);
    let count=0;
    for(let i=0;i<nums.length-2;i++){
        let left=i+1;
        let right=nums.length-1;
        while(left<right){
            if(nums[i]+nums[left]+nums[right]<target){
                count +=right-left;
                left++;
            }else{
                right--;
            }
        }
    }
return count;
};
const nums=[-2,0,1,3];
const target=2;
const result =threeSumSmaller(nums, target);
console.log(result);