var sortedSquares = function(nums) {
    let n=nums.length;
    let res = new Array(n);
    let left=0;
    let right=n-1;
    for(let i=n-1;i>=0;i--){
        if(Math.abs(nums[left])>=Math.abs(nums[right])){
            res[i]=nums[left]*nums[left];
            left++;
        }else{
            res[i]=nums[right]*nums[right];
            right--;
        }
    }
    return res;
};
const nums=[-4,-1,0,3,10];
const result=sortedSquares(nums);
console.log(result);