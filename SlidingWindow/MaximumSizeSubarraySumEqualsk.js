var MaximumSizeSubarraySumEqualsk=function(arr,k){
let map=new Map();
let max=0;
let sum=0;
let result=[];
for(i=0;i<arr.length;i++){
    sum+=arr[i];
    if(sum===k){
        max=i+1;
        result=arr.slice(0,max);
    }
    if(map.has(sum-k)){
        let index=map.get(sum-k);
    if(i-index>max){
        max=i-index;
        result=arr.slice(index+1,i+1);
    }
    }
    if(!map.has(sum)){
        map.set(sum,i);
    }
}

return result;
};
const arr=[2, -1, 5, -2, 3];
const k=3;
const result=MaximumSizeSubarraySumEqualsk(arr,k);
console.log(result);