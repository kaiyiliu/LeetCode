public class LargestRectangle2 {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length < 1)
            return 0;
            
        int max = 0;
        Stack<Integer> st = new Stack<Integer>();
        
        for (int i = 0; i < height.length;) {
            if (st.empty() || height[i] >= height[st.peek()])
                st.push(i++);
            else {
                int cur_height = height[st.pop()];
                int cur_area = cur_height * (st.empty() ? i : i - 1 - st.peek());
                max = Math.max(max, cur_area);
            }
        }
        
        while (!st.empty()) {
            int cur_height = height[st.pop()];
            int cur_area = cur_height * (st.empty() ? height.length : height.length - 1 - st.peek());
            max = Math.max(max, cur_area);
        }
        return max;
    }
}
