var FindAllDuplicatesinanArray=function(nums){
let temp=[];
let result=new Array(nums.length+1).fill(0);
for(let i=0;i<nums.length;i++){
    result[nums[i]]++;
    if(result[nums[i]]>=2){
        temp.push(nums[i]);
    }
}
return temp;
};
const nums=[4, 3, 2, 7, 8, 2, 3, 1];
const result=FindAllDuplicatesinanArray(nums);
console.log(result);