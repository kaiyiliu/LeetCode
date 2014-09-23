/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        HashMap<Integer, UndirectedGraphNode> hm = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashSet<Integer> isVisited = new HashSet<Integer>();
        
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(head.label, head);
        UndirectedGraphNode itr;
        q.offer(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode queueNode = q.poll();
            if (isVisited.contains(queueNode.label))
                continue;
                
            itr = hm.get(queueNode.label);    // guarantee to contain 
            isVisited.add(queueNode.label);
            
            for (UndirectedGraphNode element : queueNode.neighbors) {
                if (hm.containsKey(element.label))
                    itr.neighbors.add(hm.get(element.label));
                else {
                    UndirectedGraphNode aNode = new UndirectedGraphNode(element.label);
                    itr.neighbors.add(aNode);
                    hm.put(aNode.label, aNode);
                }
                q.offer(element);
            }
        }
        return head;
    }
}
