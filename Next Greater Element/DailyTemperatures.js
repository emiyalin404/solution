var DailyTemperatures=function(temperatures){
    let stack=[];
    let res=new Array(temperatures.length).fill(0);;
    for(let i=0;i<temperatures.length;i++){
        while(stack.length>0&&temperatures[i]>temperatures[stack[stack.length-1]]){
            let index=stack.pop();
            res[index]=i-index;
        }
        stack.push(i);
    }
    return res;
};
const temperatures=[73,74,75,71,69,72,76,73];
const result=DailyTemperatures(temperatures);
console.log(result);