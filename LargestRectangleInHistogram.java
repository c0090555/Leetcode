import java.util.*;
//maintain a stack where higher element is always greater or equal to the lower element
//LARGER element: we just need to push them to stack
//SMALLER element: (1).pop the stack until we can maintain the non-decreasing order.
//push the smaller element for m times,where m = number of popped elements
//(2).keep track of the maximum area that cause by those pop 

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function

		Stack<Integer> s = new Stack<Integer>();
		int i = 0;
		int max = 0;
		int counter = 0;
		while (i <= height.length - 1) {
			if (s.isEmpty() || height[i] >= s.peek()) {
				s.push(height[i]);
			} else {
				counter = 0;
				while (!s.isEmpty() && height[i] < s.peek()) {
					counter++;
					max = Math.max(s.pop() * counter, max);// track the maximum
															// area that cause
															// by those pop

				}
				for (int j = 1; j <= counter + 1; j++) {
					s.push(height[i]);// push back the smaller element for m
										// times
				}
			}
			i++;

		}

		counter = 0;
		for (i = 0; i <= height.length - 1; i++) {
			counter++;
			max = Math.max(s.pop() * counter, max);
		}
		return max;

	}
	// brute force approach - O(n)
		public int largestRectangleArea1(int[] height) {
			int n = height.length;
			int[] area = new int[n];
			for (int i = 0; i < n; i++) {
				int j = i;
				while (j >= 0 && height[j] >= height[i]) {// search left until we
															// find the first bar
															// lower than current
															// bar
					j--;
				}

				area[i] += i - j - 1;

				j = i;
				while (j < n && height[j] >= height[i]) {// search right until we
															// find the first bar
															// lower than current
															// bar
					j++;
				}
				area[i] = j - i - 1;

			}
			int max = 0;
			for (int k = 0; k < n; k++) {
				max = Math.max(max, height[k] * (area[k] + 1));
			}
			return max;
		}

		// stack approach - O(n)
		public int largestRectangleArea2(int[] height) {
			Stack<Integer> s = new Stack<Integer>();
			int n = height.length;
			int[] area = new int[n];
			for (int i = 0; i < n; i++) {
				while (!s.isEmpty() && height[i] <= height[s.peek()]) {//search left until we find the first bar lower than current bar
					s.pop();
				}
				int j = s.isEmpty() ? -1 : s.peek();
				area[i] += i - j - 1;
				s.push(i);
			}
			
			s=new Stack<Integer>(); //clean stack
			
			for(int i=n-1;i>=0;i--){
				while(!s.isEmpty()&&height[i]<=height[s.peek()]){//search right until we find the first bar lower than current bar
					s.pop();
				}
				int j=s.isEmpty()?n:s.peek();
				area[i]+=j-i-1;
				s.push(i);
			}
			
			int max=0;
			for(int i=0;i<n;i++){
				max=Math.max(max, height[i]*(area[i]+1));
			}
			return max;

		}

	public static void main(String[] args) {
		int[] a = { 4, 2 };
		LargestRectangleInHistogram o = new LargestRectangleInHistogram();
		System.out.println(o.largestRectangleArea(a));
	}
}
