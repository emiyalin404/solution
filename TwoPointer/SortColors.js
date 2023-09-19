var SortColors=function(nums){
    for(let i=0;i<nums.length;i++){
        let left=i+1;
        let right=nums.length-1;
        while(left<=right){
            if(nums[i]>nums[left]){
                let temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
            }
            if(nums[i]>nums[right]){
                let temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
            }
            left++;
            right--;
        }
    }
};
const nums=[2,0,2,1,1,0];
const result=SortColors(nums);
console.log(nums);