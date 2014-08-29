public class RestoreIP {
    // be careful of when can call the next substring
    // when you convert string to int, be careful of overflow
    
    private boolean isValid(String str) {
        if (str == null || str.length() == 0 || str.length() > 3)
            return false;
        if (str.charAt(0) == '0')
            return str.equals("0");
        if (Integer.parseInt(str) > 255)
            return false;
        return true;
    }
    
    public void restore(String str, int n, String[] ip, List<String> result) {
        if (n == 3) {
            if (isValid(str))
                result.add(ip[0] + "." + ip[1] + "." + ip[2] + "." + str);
            return;
        }
        int len = str.length();
        if (len > 1) {
            ip[n] = str.substring(0, 1);
            restore(str.substring(1), n + 1, ip, result);
        }
        if (len > 2 && isValid(str.substring(0, 2))) {
            ip[n] = str.substring(0, 2);
            restore(str.substring(2), n + 1, ip, result);
        }
        if (len > 3 && isValid(str.substring(0, 3))) {
            ip[n] = str.substring(0, 3);
            restore(str.substring(3), n + 1, ip, result);
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<String>();
        if (s == null || s.length() < 4 || s.length() > 12)
            return result;
        String[] ip = new String[3];
        restore(s, 0, ip, result);
        return result;
    }
}
