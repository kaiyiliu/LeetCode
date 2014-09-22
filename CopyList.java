/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode itr = dummy;
        while (head != null) {
            if (hm.containsKey(head))
                itr.next = hm.get(head);
            else {
                itr.next = new RandomListNode(head.label);
                hm.put(head, itr.next);
            }
            
            if (head.random != null) {
                if (hm.containsKey(head.random))
                    itr.next.random = hm.get(head.random);
                else {
                    itr.next.random = new RandomListNode(head.random.label);
                    hm.put(head.random, itr.next.random);
                }
            }
            itr = itr.next;
            head = head.next;
        }
        return dummy.next;
    }
}
