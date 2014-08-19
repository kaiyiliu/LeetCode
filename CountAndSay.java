public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 0)
            return null;
        if (n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        char[] number = countAndSay(n - 1).toCharArray();
        char pre = number[0];
        int sum = 1;
        for (int i = 1; i < number.length; i++) {
            char cur = number[i];
            if (cur != pre) {
                sb.append("" + sum);
                sb.append(pre);
                pre = cur;
                sum = 1;
            } else {
                sum++;
            }
        }
        sb.append("" + sum);
        sb.append(pre);
        return sb.toString();
    }
}
