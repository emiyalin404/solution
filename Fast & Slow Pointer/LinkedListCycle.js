class ListNode {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

function hasCycle(head) {
    let fast = head;
    let slow = head;
    while (fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow === fast) {
            return true;
        }
    }
    return false;
}

// 创建链表
const head = new ListNode(3);
const second = new ListNode(2);
const third = new ListNode(0);
const fourth = new ListNode(-4);

head.next = second;
second.next = third;
third.next = fourth;
fourth.next = second; // 添加一个循环

const result = hasCycle(head);
console.log(result); // 应该返回 true，因为链表中存在循环

// var LinkedListCycle=function(head){
// let fast=head;
// let last=head.next;
// while(fast!==null&&fast.next!=null){
//     last=last.next;
//     fast=fast.next;
//     if(fast===last){
//         return true;
//     }
// }
// return false;
// };
// class ListNode {
//     constructor(val) {
//         this.val = val;
//         this.next = null;
//     }
// }

// const head = new ListNode(3);
// const second = new ListNode(2);
// const third = new ListNode(0);
// const fourth = new ListNode(-4);

// head.next = second;
// second.next = third;
// third.next = fourth;
// fourth.next = second; // 添加一个循环

// const result = hasCycle(head);
// console.log(result); // 应该返回 true，因为链表中存在循环





