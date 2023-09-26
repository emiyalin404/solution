var LongestSubstringwithAtMostTwoDistinctCharacters=function(s){
    let map=new Map();
    let start=0;
    let max=0;
    let i=0;
    for(i=0;i<s.length;i++){
      let c=s.charAt(i);
      map.set(c,(map.get(c)||0)+1);
      while(map.size>2){
        let startChar=s.charAt(start);
        map.set(startChar,map.get(startChar)-1);
        max=Math.max(max,i-start);
        if(map.get(startChar)===0){
            map.delete(startChar);
        }
        start++;
      }
      
    }
    max=Math.max(max,i-start);
    return max;
};
const s="ccaabbb";
const result=LongestSubstringwithAtMostTwoDistinctCharacters(s);
console.log(result);