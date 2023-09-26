var FruitIntoBaskets=function(fruits){
    let map=new Map();
    let start=0;
    let i=0;
    let max=0;
    for(i=0;i<fruits.length;i++){
        map.set(fruits[i],(map.get(fruits[i])||0)+1);
        while(map.size>2){
            max=Math.max(max,i-start);
            map.set(fruits[start],map.get(fruits[start])-1);
            if(map.get(fruits[start])===0){
                map.delete(fruits[start]);
            }
            start++;
        }
    }
    max=Math.max(max,i-start);
    return max;
};
const fruits=[1,2,1];
const result=FruitIntoBaskets(fruits);
console.log(result);