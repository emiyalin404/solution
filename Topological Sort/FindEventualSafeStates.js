var FindEventualSafeStates=function(graph){
    let n=graph.length;
    let revGraph={};
    let inDegree=new Array(n).fill(0)
    for(let i=0;i<n;i++){
        for(let x of graph[i]){
            if(!revGraph[x]){
                revGraph[x]=[]
            }
            revGraph[x].push(i)
            inDegree[i]++
        }
    }

    let queue=[]
    let result=[]
    for(let i=0;i<n;i++){
        if(inDegree[i]==0){
            queue.push(i)
        }
    }
    while(queue.length){
        let current=queue.shift()
        result.push(current)
        let neighour=revGraph[current]
        if(neighour){
            for(let x of neighour){
                inDegree[x]--
                if(inDegree[x]==0){
                    queue.push(x)
                }
            }
        }
    }
    return result.sort((a,b)=>a-b)
}
const graph=[[1,2],[2,3],[5],[0],[5],[],[]];
const ans=FindEventualSafeStates(graph);
console.log(ans);