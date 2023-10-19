var TopKFrequentElements=function(nums,k){
    let map=[];
    for(let m of nums){
        map[m]=(map[m]||0)+1;
    }
    const sort=Object.keys(map).sort((a,b)=>map[b]-map[a]);
    const list=[];
    console.log(sort);
   for(let i=0;i<k;i++){
    list.push(sort[i]);
   }
    return list;
};
const nums=[1,1,1,2,2,3];
const k=2;
const ans= TopKFrequentElements(nums,k);
console.log(ans);