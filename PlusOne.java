public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null)
            return null;
        int i = digits.length - 1;
        digits[i]++;
        while (i > 0 && digits[i] == 10) {
            digits[i] = 0;
            digits[--i]++;
        }
        if (i == 0 && digits[0] == 10) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
