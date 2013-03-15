import java.util.*;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Hashtable<Wrapper, Integer> areaHash = new Hashtable<Wrapper, Integer>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int w = Math.abs(i - j);
				int h = Math.min(height[i], height[j]);
				Wrapper temp = new Wrapper(h, w);
				if (areaHash.containsKey(temp)) {
					return areaHash.get(temp);
				}
				int result = w * h;
				if (result > max) {
					max = result;
				}

				areaHash.put(temp, max);
			}

		}

		return max;
	}

	public double calculateArea(int m, int am, int n, int an) {
		if (am == 0 || an == 0) {
			return 0;
		}
		double area = Math.min(m, n) * Math.abs(m - n);
		return area;
	}

	class Wrapper {
		int width;
		int height;

		public Wrapper(int h, int w) {
			height = h;
			width = w;
		}
	}

}
