public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> result = new LinkedList<String>();
        if (strs == null || strs.length == 0)
            return result;
            
        HashMap<String, LinkedList<String>> hm = new HashMap<String, LinkedList<String>>();
        for (String e : strs) {
            char[] charArray = e.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (hm.containsKey(sortedStr)) {
                hm.get(sortedStr).add(e);
            } else {
                LinkedList<String> newList = new LinkedList<String>();
                newList.add(e);
                hm.put(sortedStr, newList);
            }
        }
        
        for (LinkedList<String> list : hm.values()) {
            if (list.size() > 1)
                result.addAll(list);
        }
        return result;
    }
}
