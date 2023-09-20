var ContainerWithMostWater=function(height){
    let left=0;
    let right=height.length-1;
    let maxsize=0;
    while(left<right){
        let w=right-left;
        let h=Math.min(height[left],height[right]);
        let chara=w*h;
        maxsize=Math.max(maxsize,chara);
        if(height[left]<height[right]){
            left++;
        }else{
            right--;
        }
    }
    return maxsize;
};
const height=[1,8,6,2,5,4,8,3,7];
const result=ContainerWithMostWater(height);
console.log(result);