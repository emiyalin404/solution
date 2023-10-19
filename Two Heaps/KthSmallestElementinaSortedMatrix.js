var KthSmallestElementinaSortedMatrix=function(matrix,k){
    let result=[]
    for(let i=0;i<matrix.length;i++){
        for(let [index,value] of matrix[i].entries()){
            result.push(value);
        }
    }
    return result.sort((a,b)=>a-b)[k-1];
};
const matrix=[[1,5,9],[10,11,13],[12,13,15]];
const k=8;
const input=KthSmallestElementinaSortedMatrix(matrix,k);
console.log(input);