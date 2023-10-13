var FindtheFirstKMissingPositiveNumbers=function(arr,k){
   for (let index = 0; index < arr.length; index++) {
    const element = arr[index];
    if(element<=k){
        k++;
    }else{
        break;
    }
   }
   return k;
};
const arr=[2,3,4,7,11];
const k=5;
const result=FindtheFirstKMissingPositiveNumbers(arr,k);
console.log(result);