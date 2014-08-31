public class 4Sum {
    private boolean sortId(Pair p1, Pair p2, int[] num, List<Integer> list) {
        if (p1 == p2)
            return false;
        int[] temp = new int[4];
        temp[0] = p1.id1;
        temp[1] = p1.id2;
        temp[2] = p2.id1;
        temp[3] = p2.id2;
        Arrays.sort(temp);
        for (int i = 1; i <= 3; i++) {
            if(temp[i] == temp[i - 1])
                return false;
        }
        for (int i = 0; i <= 3; i++) {
            temp[i] = num[temp[i]]; 
        }
        Arrays.sort(temp);
        list.add(temp[0]);
        list.add(temp[1]);
        list.add(temp[2]);
        list.add(temp[3]);
        return true;
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length == 0)
            return result;
        //Arrays.sort(num);
        TreeMap<Integer, LinkedList<Pair>> hm = new TreeMap<Integer, LinkedList<Pair>>();
        HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                if (hm.containsKey(sum))
                    hm.get(sum).add(new Pair(i, j));
                else {
                    LinkedList<Pair> list = new LinkedList<Pair>();
                    list.add(new Pair(i, j));
                    hm.put(sum, list);
                }
            }
        }
        for (Integer i : hm.keySet()) {
            if (i > target / 2)
                break;
            if (hm.containsKey(target - i)) {
                LinkedList<Pair> list1 = hm.get(i);
                LinkedList<Pair> list2 = hm.get(target - i);
                for (Pair pair1 : list1) {
                    for (Pair pair2: list2) {
                        List<Integer> oneResult = new LinkedList<Integer>();
                        if (!sortId(pair1, pair2, num, oneResult))
                            continue;
                        hs.add(oneResult);
                    }
                }
            }
        }
        for (List<Integer> list : hs)
            result.add(list);
        return result;
    }
    
    private class Pair {
        private int id1;
        private int id2;
        
        Pair(int id1, int id2) {
            this.id1 = id1;
            this.id2 = id2;
        }
    }
}
