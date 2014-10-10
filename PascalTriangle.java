public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows < 1)
            return result;
        
        ArrayList<Integer> zeroList = new ArrayList<Integer>();
        zeroList.add(1);
        result.add(zeroList);
        
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> aList =  new ArrayList<Integer>();
            aList.add(1);
            
            List<Integer> parent = result.get(i-1);
            for (int j = 0; j < parent.size() - 1; j++) {
                aList.add(parent.get(j) + parent.get(j+1));
            }
            
            aList.add(1);
            result.add(aList);
        }
        return result;
    }
}
