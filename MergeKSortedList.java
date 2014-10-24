public class MergeKSortedList {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		
		ListNode dummy = new ListNode(0);
		ListNode itr = dummy;
		while(!isDepleted(lists)) {
			int min = getSmallest(lists);
			for (int i = 0; i < lists.size(); i++) {
				ListNode cur = lists.get(i);
				if (cur == null)
					continue;
				if (cur.val == min) {
					itr.next = new ListNode(min);
					itr = itr.next;
					lists.set(i, cur.next);
				}
			}
		}
		return dummy.next;
	}
	
	private boolean isDepleted(List<ListNode> lists) {
		for (ListNode e : lists) {
			if (e != null)
				return false;
		}
		return true;
	}
	
	private int getSmallest(List<ListNode> lists) {
		int min = Integer.MAX_VALUE;
		for (ListNode e : lists) {
			if (e != null && e.val < min)
				min = e.val;
		}
		return min;
	}
}
