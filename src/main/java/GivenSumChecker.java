import java.util.*;

public class GivenSumChecker {

	/**
	 * Given an unsorted array of nonnegative integers returns true
	 * if there is a continuous subarray which adds to a given number (target sum).
	 * @see SlidingWindowGivenSumChecker for more efficient implementation
	 * @param ints unsorted array of nonnegative integers
	 * @param target target sum
	 * @return
	 */
	public Boolean check(int[] ints, int target) {

		//store seen sums less than target
		LinkedHashSet<Integer> seenSums = new LinkedHashSet<>();

		for (int anInt : ints) { //O(n)

			//suppose that target in array fits requirements
			if(anInt == target) return true;

			//obviously all ints that larger than target won't work
			if(anInt > target) continue;

			//
			int addAnIntToTarget = target - anInt;

			if(seenSums.contains(addAnIntToTarget)) //O(1)
				return true;

			LinkedHashSet<Integer> newSeenSums = new LinkedHashSet<>();
			newSeenSums.add(anInt);
			for (Integer seenSum : seenSums) { //O(n)
				Integer newSeenSum = seenSum + anInt;

				if(!newSeenSums.contains(newSeenSum))
					newSeenSums.add(newSeenSum);
			}
			seenSums = newSeenSums;
		}

		return false;
	} //overall complexity = O(n^2)
}
