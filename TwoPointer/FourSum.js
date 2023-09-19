var fourSum = function(nums, target) {
    let qlist = [];
    nums.sort((a, b) => a - b); // 对数组进行排序

    for (let i = 0; i < nums.length - 3; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue; // 跳过重复元素
        }

        for (let j = i + 1; j < nums.length - 2; j++) {
            if (j > i + 1 && nums[j] === nums[j - 1]) {
                continue; // 跳过重复元素
            }

            let left = j + 1;
            let right = nums.length - 1;

            while (left < right) {
                const sum = nums[i] + nums[j] + nums[left] + nums[right];

                if (sum === target) {
                    qlist.push([nums[i], nums[j], nums[left], nums[right]]);
                    while (left < right && nums[left] === nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] === nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    return qlist;
};
// var FourSum=function(nums,target){
//     let qlist=[];
//     for(let i=0;i<nums.length-3;i++){
//         if(i>0&&nums[i]===nums[i-1]){
//             continue;
//         }
//         for(let j=i;j<nums.length-2;j++){
//             if(j>i&&nums[j]===nums[j-1]){
//                 continue;
//             }
//             let left=j+1;
//             let right=nums.length-1;
//             while(left<right){
//                 let sum=nums[i]+nums[j]+nums[left]+nums[right];
//                 if(sum<target){
//                     left++;
//                 }else if(sum>target){
//                     right--;
//                 }else{
//                     qlist.push([nums[i],nums[j],nums[left],nums[right]]);
//                     while(left<right&&nums[left]===nums[left+1]){
//                         left++;
//                     };
//                     while(left<right&&nums[right]===nums[right-1]){
//                         right--;
//                     }
//                     left++;
//                     right--;
//                 }
//             }
//         }
      
//     }  return qlist;
// };
const nums=[1,0,-1,0,-2,2];
const target=0;
const result=FourSum(nums,target);
console.log(result);