var PermutationinString=function(s1,s2){
    if(s1.length>s2.length){
        return false;
    }
    let left=0;
    let map1=new Map();
    let map2=new Map();
    for(let i=0;i<s1.length;i++){
        let c1=s1.charAt(i);
        map1.set(c1,(map1.get(c1,0)||0)+1);
    }
    for(let right=0;right<s2.length;right++){
        let c2=s2.charAt(right);
        map2.set(c2,(map2.get(c2,0)||0)+1);
        if(right-left+1===s1.length){
            if (mapsAreEqual(map1, map2)) {
                return true;
            }
            let c=s2.charAt(left);
            map2.set(c,map2.get(c)-1);
            if(map2.get(c)===0){
                map2.delete(c);
            }
            left++;
        }
    }
    return false;
};
function mapsAreEqual(map1, map2) {
    for (const [key, value] of map1) {
        if (map2.get(key) !== value) {
            return false;
        }
    }
    return true;
}
const s1="ab";
const s2="eidbaooo";
const result=PermutationinString(s1,s2);
console.log(result);