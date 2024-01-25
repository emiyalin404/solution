var CountingBits=function(n){
    let list=new Array(n + 1).fill(0);
    for(let i=0;i<=n;i++){
        let a=i;
        while(a>0){
            list[i]+=a&1;
            a>>=1;
        }
    }
    return list;
};
const n=2;
const result=CountingBits(n);
console.log(result);