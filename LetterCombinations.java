public class LetterCombinations {
    private void helper(int cur, String digits, String[] dict, StringBuilder sb, List<String> result) {
        if (cur == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int index = Character.getNumericValue(digits.charAt(cur));
        if (index == 0 || index == 1) {
            helper(cur + 1, digits, dict, sb, result);
            return;
        }
        String line = dict[index];
        for (int i = 0; i < line.length(); i++) {
            sb.append(line.charAt(i));
            helper(cur + 1, digits, dict, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        if (digits == null)
            return result;
        StringBuilder sb = new StringBuilder();
        String[] dict = new String[10];
        dict[2] = "abc";
        dict[3] = "def";
        dict[4] = "ghi";
        dict[5] = "jkl";
        dict[6] = "mno";
        dict[7] = "pqrs";
        dict[8] = "tuv";
        dict[9] = "wxyz";
        helper(0, digits, dict, sb, result);
        return result;
    }
}
