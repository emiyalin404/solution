class ListNode {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}
var ReorderList = function(head) {
    if(!head||!head.next) return;
    const nodearr=[];
    let cur=head;
    while(cur){
        nodearr.push(cur);
        cur=cur.next;
        nodearr[nodearr.length-1].next=null;
    }
    let begin=0,end=nodearr.length-1;
    cur=null;
    while(begin<end){
        if(cur){
            cur.next=nodearr[begin];
        }
        nodearr[begin].next=nodearr[end];
        cur=nodearr[end];
        begin++;
        end--;
        if(begin==end){
            cur.next=nodearr[begin];
        }
    }
    return head;
};
const head = new ListNode(1);
const second = new ListNode(2);
const third = new ListNode(3);
const fourth = new ListNode(4);

head.next = second;
second.next = third;
third.next = fourth;
fourth.next = null;

const result = ReorderList(head);
console.log(result);
