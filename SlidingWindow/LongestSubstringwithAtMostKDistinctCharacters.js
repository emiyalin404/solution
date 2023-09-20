// var LongestSubstringwithAtMostKDistinctCharacters=function(s,k){
    // if(s===null||s.length===0||k===0){
    //     return 0;
    // }
    // let left=0;
    // let maxlength=0;
    // let map=new Map();
    // for(let i=0;i<s.length;i++){
    //     let c=s.charAt(i);
    //     map.set(c,(map.get(c)||0)+1);
    //     while(map.size>k){
    //         let leftChar=s.charAt(left);
    //         map.set(leftChar,map.get(leftChar)-1);
    //         if(map.get(leftChar)===0){
    //             map.delete(leftChar);
    //         }
    //         left++;
    //     }
    //     maxlength=Math.max(maxlength,i-left+1);
    // }
    // return maxlength;
// };
var LongestSubstringwithAtMostKDistinctCharacters=function(s,k){
   if(s===null||s.length===0||k===0){
    return 0;
   }
   let left=0;
   let maxlength=0;
   let map=new Map();
   for(let i=0;i<s.length;i++){
    let c=s.charAt(i);
    map.set(c,(map.get(c)||0)+1);
    while(map.size>k){
        let leftChar=s.charAt(left);
        map.set(leftChar,map.get(leftChar)-1);
        if(map.get(leftChar)===0){
            map.delete(leftChar);
        }
        left++;
    }
    maxlength=Math.max(maxlength,i-left+1);
   }
   return maxlength;
};
const s="eceba";
const k=2;
const result=LongestSubstringwithAtMostKDistinctCharacters(s,k);
console.log(result);