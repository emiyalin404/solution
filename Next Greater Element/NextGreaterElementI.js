var NextGreaterElementI=function(nums1,nums2){
    const map = new Map();
    const stack = [];
    const res = new Array(nums1.length).fill(-1);

    // for (const x of nums2) {
    //     while (stack.length > 0 && x > stack[stack.length - 1]) {
    //         map.set(stack.pop(), x);
    //     }
    //     stack.push(x);
    // }

    // for (let i = 0; i < nums2.length; i++) {
    //     const x = nums2[i];
    //     while (stack.length > 0 && x > stack[stack.length - 1]) {
    //         const top = stack.pop();
    //         map.set(top, x);
    //     }
    //     stack.push(x);
    // }

    // for (let i = 0; i < nums1.length; i++) {
    //     if (map.has(nums1[i])) {
    //         res[i] = map.get(nums1[i]);
    //     }
    // }

    // return res;

    // let map = new Map();
    // let stack = [];
    // let res = new Array(nums1.length).fill(-1);
    

    // let map = new Map();
    // let stack = [];
    // let res = new Array(nums1.length).fill(-1);
    console.log(res);
    for (let i = 0; i < nums2.length; i++) {
        while (stack.length > 0 && nums2[i] > stack[stack.length - 1]) {
            const top = stack.pop();
            map.set(top, nums2[i]);
        }
        stack.push(nums2[i]);
    }
    
    for (let i = 0; i < nums1.length; i++) {
        if (map.has(nums1[i])) {
            res[i] = map.get(nums1[i]);
        }
    }
    
    return res;
// };
//     for (let i = 0; i < nums2.length; i++) {
//         while (stack.length > 0 && nums2[i] > stack[stack.length - 1]) {
//             const top = stack.pop();
//             map.set(top, nums2[i]);
//         }
//         stack.push(nums2[i]);
//     }
    
//     for (let i = 0; i < nums1.length; i++) {
//         if (map.has(nums1[i])) {
//             res[i] = map.get(nums1[i]);
//         }
//     }
    
//     return res;
// };

    // let map=new Map();
    // let stack=[];
    // let res=new int[nums1.length];
    // for (let index = 0; index < nums1.length; index++) {
    //   while(stack.length!==0&&nums[index]>=nums1[stack.peek()]){
    //     map.set(stack.pop(),nums[index]);
    //   }
    //     stack.push(nums[index])
    // }
    // for (let i = 0; i < nums1.length; i++) {
    //     if(map.has(nums1[i])){
    //         res[i]=map.get(nums1[i]);
    //     }
        
    // }
    // return res;
};
const nums1=[4,1,2];
const nums2=[1,3,4,2];
const result=NextGreaterElementI(nums1,nums1);
console.log(result);