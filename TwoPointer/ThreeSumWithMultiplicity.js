var threeSumMulti = function(arr, target) {
arr.sort((a,b)=>a-b);
let mod=1000000007;
let count=0;
let n=arr.length;
    for(let i=0;i<n;i++){
        let left=i+1;
        let right=n-1;
        while(left<right){
            if(arr[i]+arr[left]+arr[right]===target&&arr[left]!==arr[right]){
                let x=1,y=1;
                let j=left+1,k=right-1;
                while(j<right&&arr[j]===arr[left]){
                    x++;
                    j++;
                }
                while(k>left&&arr[k]===arr[right]){
                    y++;
                    k--;
                };
                left=j;
                right=k;
                count=(count+x*y)%mod;
            }else if(arr[i]+arr[left]+arr[right]<target){
                left++;
            }else if(arr[i]+arr[left]+arr[right]>target){
                right--;
            }else{
                let len=(right-left)+1;
                count=(count+(len*(len-1)/2))%mod;
                break;
            }
        }
    }
return count;
};
const arr=[1,1,2,2,3,3,4,4,5,5];
const target=8;
const result=threeSumMulti(arr,target);
console.log(result);