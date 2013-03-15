import java.util.*;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// figure out whether it is necessary to merge
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		if (newInterval == null) {
			return intervals;
		}
		boolean merge = false;//indicate whether merge happened
		int mergeStart = -1;
		int mergeEnd = intervals.get((intervals.size() - 1)).end;
		boolean nonOverlap = false;//indicate whether merge happened before
		ArrayList<Interval> result = new ArrayList<Interval>();
		boolean newInserted = false;//indicate whether newInterval inserted
		// ArrayList<Integer> mergePosition = new ArrayList<Integer>();
		for (int i = 0; i < intervals.size(); i++) {
			if (overlap(intervals.get(i), newInterval)) {
				if (merge == false) {
					mergeStart = Math.min(newInterval.start,
							intervals.get(i).start);
				}
				if (i == intervals.size() - 1) {
					mergeEnd = Math.max(newInterval.end, intervals.get(i).end);
					result.add(new Interval(mergeStart, mergeEnd));

				}
				merge = true;
			} else {
				if (merge == true) {
					if (nonOverlap == false) {
						mergeEnd = Math.max(newInterval.end,
								intervals.get(i - 1).end);
						result.add(new Interval(mergeStart, mergeEnd));
						merge = false;
						nonOverlap = true;
						result.add(intervals.get(i));

					}
				} else {
					if (nonOverlap == true) {// merge happened
						result.add(intervals.get(i));

					} else {// merge never happen
						if (newInserted == true) {
							result.add(intervals.get(i));
						} else {
							if (i == intervals.size() - 1) {
								if (newInterval.end < intervals.get(i).start) {
									result.add(newInterval);
									result.add(intervals.get(i));
									newInserted = true;
								} else {
									result.add(intervals.get(i));
									result.add(newInterval);
									newInserted = true;

								}
							} else {
								if (newInterval.end < intervals.get(i).start) {
									result.add(newInterval);
									result.add(intervals.get(i));
									newInserted = true;
								} else {
									result.add(intervals.get(i));

								}
							}
						}
					}
				}
			}
		}
		// System.out.print("start :" + start + "end: " + end);
		// System.out.print("start :" + mergeStart + "end: " + mergeEnd);

		return result;

	}

	public boolean overlap(Interval a, Interval b) {
		if ((b.start >= a.start && b.start <= a.end)
				|| (b.end >= a.start && b.end <= a.end)
				|| (a.start >= b.start && a.start <= b.end)
				|| (a.end >= b.start && a.end <= b.end)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		InsertInterval o = new InsertInterval();
		ArrayList<Interval> original = new ArrayList<Interval>();
		original.add(new Interval(2, 4));
		original.add(new Interval(5, 7));
		original.add(new Interval(8, 10));

		original.add(new Interval(11, 13));

		Interval newInterval = new Interval(3, 6);

		ArrayList<Interval> result = o.insert(original, newInterval);

	}
}


