public class StringToInteger {
    // trim spaces
    
    public int atoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        int numOfDot = 0;
        boolean isPositive = true;
        boolean isDecimal = false;
        boolean isValid = true;
        int zeroASC = (int) '0';
        int nineASC = (int) '9';
        int i = 0;
        int result = 0;
        if (str.length() == 1 && (str.charAt(0) < zeroASC || str.charAt(0) > nineASC))
            return 0;
        if (str.charAt(0) == '-') {
            isPositive = false;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        for (int count = 1; i < str.length(); i++, count++) {
            char cur = str.charAt(i);
            if (cur < zeroASC || cur > nineASC)
                if (isDecimal)
                    break;
                else if (str.charAt(i) != '.')
                    break;
                else {
                    isDecimal = true;
                    continue;
                }
            if (!isDecimal) {
                if (count > 10 || (count == 10 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) == '9'))))
                    return (isPositive) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result = result * 10 + (int) cur - zeroASC;
                if (result < 0)
                    if (!isPositive)
                        return Integer.MIN_VALUE;
                    else 
                        return Integer.MAX_VALUE;
            }
        }
        if (!isPositive) {
            if (result == Integer.MIN_VALUE)
                return result;
            else
                return (-1) * result;
        }
        return result;
    }
}
