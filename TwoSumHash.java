public class TwoSumHash {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null | numbers.length < 2)
            return null;
        int[] result = new int[2];
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++)
            hs.put(numbers[i], i + 1);
        for (int i = 0; i < numbers.length; i++) {
            Integer value = hs.get(target - numbers[i]);
            if (value != null && value != i + 1) {
                result[0] = (i + 1 < value) ? i + 1 : value;
                result[1] = (i + 1 > value) ? i + 1 : value;
                return result;
            }
        }
        return null;
    }
}
