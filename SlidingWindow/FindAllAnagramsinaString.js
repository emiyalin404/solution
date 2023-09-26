var FindAllAnagramsinaString=function(s,p){
    let ans=[];
    if(s.length<p.length){
        return ans;
    }
    let map1=new Map();
    let map2=new Map();
    for(let i=0;i<p.length;i++){
        map1.set(p.charAt(i),(map1.get(p.charAt(i))||0)+1);
        map2.set(s.charAt(i),(map2.get(s.charAt(i))||0)+1);
    }
    if(mapsAreEqual(map2,map1)){
        ans.push(0);
    }
    let l=0,r=p.length;
    while(r<s.length){
        let ac=s.charAt(r++);
        map2.set(ac,(map2.get(ac)||0)+1);
        let di=s.charAt(l++);
        map2.set(di,map2.get(di)-1);
        if(map2.get(di)===0){
            map2.delete(di);
        }
        if(mapsAreEqual(map2,map1)){
            ans.push(l);
        }
    }
    return ans;
};
function mapsAreEqual(map1, map2) {
    if (map1.size !== map2.size) {
        return false;
    }
    for (let [key, value] of map1) {
        if (!map2.has(key) || map2.get(key) !== value) {
            return false;
        }
    }
    return true;
}
const s="cbaebabacd";
const p="abc";
const result=FindAllAnagramsinaString(s,p);
console.log(result);