var BinaryTreeZigzagLevelOrderTraversal=function(root){
   if(!root){
    return [];
   }
   const res=[],queue=[root];
   let levelSize,leftToRight=true;
   while(queue.length>0){
    levelSize=queue.length;
    const levelVals=[];
    while(levelSize>0){
        const currNode=queue.shift();
        if(leftToRight){
            levelVals.push(currNode.val);
        }else{
            levelVals.unshift(currNode.val);
        }
        if(currNode.left){
            queue.push(currNode.left);
        }
        if(currNode.right){
            queue.push(currNode.right);
        }
        levelSize--;
    }
    leftToRight=!leftToRight;
    res.push(levelVals);
   } 
   return res;
   
};
// 构建二叉树节点
function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}

// 创建根节点
let root = new TreeNode(3);

// 创建子节点并连接它们到根节点
root.left = new TreeNode(9);
root.right = new TreeNode(20);

root.right.left = new TreeNode(15);
root.right.right = new TreeNode(7);
let depth = BinaryTreeZigzagLevelOrderTraversal(root);
console.log(depth);