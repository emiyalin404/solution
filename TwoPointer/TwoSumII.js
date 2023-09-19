var twoSum = function(numbers, target) {
       let n = numbers.length;
    for (let L = 0, R = n - 1; L < R; ) {
        let sum = numbers[L] + numbers[R];
        if (sum === target) {
            return [L + 1, R + 1];
        } else if (sum < target) {
            L++;
        } else {
            R--;
        }
    }
    return [-1, -1];
};
const numbers = [2, 7, 11, 15];
const target = 9;
const result = twoSum(numbers, target);
console.log(result); // 输出 [1, 2]