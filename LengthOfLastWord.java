public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        String[] tokens = s.split(" ");
        if (tokens.length == 0)
            return 0;
        String last = tokens[tokens.length - 1];
        if (last.equals("\\s+"))
            return 0;
        return last.length();
    }
}
