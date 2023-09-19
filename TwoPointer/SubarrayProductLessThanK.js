var SubarrayProductLessThanK=function(nums,k){
let left=0;
    let right =1;
    let j=0;
    for(let i=0;i<nums.length;i++){
        right=right*nums[i];
        if(right>=k&&j<i){
            right/=nums[j];
            j++;
        }
        if(right<k){
            left+=i-j+1;
        }
    }
    return left;
};
const nums=[10,5,2,6];
const k=100;
const result=SubarrayProductLessThanK(nums,k);
console.log(result);