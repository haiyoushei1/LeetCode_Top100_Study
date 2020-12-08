package add_two_numbers;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
题目大意：提供两个非空链表，，两个链表时逆序如：789 ： 9 -> 8 -> 7;
每个节点只能存储一个数组。要求将两个数加在一起，输出
题解：
因为是倒序，直接相加，记录是否超过10。有意思的地方在，在一个链表末尾补零使两个链表相同。可以有效减少代码量
最后考虑下最高位进位问题。
小技巧：
在求和考虑进位的问题中可以考虑carry储存进位值，这样就不需要用flag去来回切换
 */

public class add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode();
        ListNode temp = sentry;
        int carry = 0;
        while((l1 != null) || (l2 != null)){
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int value = v1 + v2 + carry;
            carry = value > 9 ? 1 : 0;
            value = value % 10;
            temp.next = new ListNode(value);
            temp = temp.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry == 1){
            temp.next = new ListNode(1);
        }
        return sentry.next;
    }
}

