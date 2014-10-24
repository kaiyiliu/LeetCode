public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0)
			return num2;
		if (num2 == null || num2.length() == 0)
			return num1;
		
		StringBuilder sb1 = new StringBuilder(num1);
		StringBuilder sb2 = new StringBuilder(num2);
		int dotIndex1 = sb1.indexOf(".");
		int dotIndex2 = sb2.indexOf(".");
		int dotRev = 0;
		if (dotIndex1 != -1) {
			dotRev += sb1.length() - 1 - dotIndex1;
			sb1 = sb1.deleteCharAt(dotIndex1);
		}
		if (dotIndex2 != -1) {
			dotRev += sb2.length() - 1 - dotIndex2;
			sb2 = sb2.deleteCharAt(dotIndex2);
		}
		int len1 = sb1.length();
		int len2 = sb2.length();
		int[] res = new int[len1 + len2];
		
		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				int product = Character.getNumericValue(sb1.charAt(i)) * Character.getNumericValue(sb2.charAt(j));
				addNum(i + j + 1, res, product);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Integer e : res) {
		    sb.append(e);
		}
		
		if (dotRev > 0) {
			sb.insert(sb.length() - 1 - dotRev, '.');
		}
		
		int start = 0;
		while (start < sb.length() - 1) {
			if (sb.charAt(start) != '0' || sb.charAt(start + 1) == '.')
				break;
			start++;
		}
		return sb.substring(start);
		
	}
	
	private void addNum(int index, int[] res, int num) {
		while (num > 0) {
			int curSum = res[index] + num % 10;
			res[index] = curSum % 10; 
			num = num / 10 + curSum / 10;
			index--;
		}
	}
}
