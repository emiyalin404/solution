var IntervalListIntersections=function(firstList,secondList){
    let merged;
    let i=0,j=0;
    while(i<firstList.length()&&j<secondList.length()){
        let current=firstList[i];
        let second=secondList[i];
        if(current[0]<=second[0]&&current[1]>=second[0]){
            merged.push([second[0],Math.min(current[1],second[1])] );
        }else if(current[0]<=second[1]&&second[0]>=current[0]);
        merged.push([current[0],Math.min(current[1],second[1])] );          
    }
};
const firstList=[[0,2],[5,10],[13,23],[24,25]];
const secondList=[[1,5],[8,12],[15,24],[25,26]];
const result=IntervalListIntersections(firstList,secondList);
console.log(result);