public class ContainerWithWater {
    public int maxArea(int[] height) {
        int area = 0;
        if (height == null)
            return area;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int h = Math.min(height[i], height[j]);
            int l = j - i;
            area = Math.max(area, h * l);
            if (h == height[i])
                i++;
            else
                j--;
        }
        return area;
    }
}
