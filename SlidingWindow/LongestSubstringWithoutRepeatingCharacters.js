var LongestSubstringWithoutRepeatingCharacters=function(s){
// let start=0;
// let max=0;
// let map=new Map();
// let i =0;
// for(i=0;i<s.length;i++){
//     let startchar=s.charAt(i);
//     map.set(startchar,(map.get(startchar)||0)+1);
//     while(map.size>1){
//         let c=s.charAt(start);
//         map.set(c,map.get(c)-1);
//         max=Math.max(max,i-start+1);
//         if(map.get(c)===0){
//             map.delete(c);
//         }
//         start++;
//     }
// }
// max=Math.max(max,i-start+1);
// return max;
// };
let start = 0;
let max = 0;
let map = new Map();
let i = 0;
for (i = 0; i < s.length; i++) {
    let char = s.charAt(i);
    if(map.has(char)&&map.get(char)>=start){
        start=map.get(char)+1;
    }
    map.set(char,i);
    max=Math.max(max,i-start+1);
    
}
return max;

};
const s="abcabcbb";
const result=LongestSubstringWithoutRepeatingCharacters(s);
console.log(result);