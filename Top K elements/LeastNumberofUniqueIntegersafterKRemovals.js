var LeastNumberofUniqueIntegersafterKRemovals=function(arr,k){
    const map=[];
    for(let m of arr){
        map[m]=(map[m]||0)+1;
    }
    const sort=Object.keys(map).sort((a,b)=>map[a]-map[b]);
    console.log(sort);
    while(k){
        let val=map[sort[0]];
        if(val>k)break;
        k-=val;
        sort.shift();
    }
    return sort.length;
};
const arr=[4,3,1,1,3,3,2];
const k=3;
const ans=LeastNumberofUniqueIntegersafterKRemovals(arr,k);
console.log(ans);