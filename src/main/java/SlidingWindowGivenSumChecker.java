import java.util.LinkedHashSet;

public class SlidingWindowGivenSumChecker {

	/**
	 * Given an unsorted array of nonnegative integers returns true
	 * if there is a continuous subarray which adds to a given number (target sum).
	 * Implementation using "Sliding Window"
	 * @param ints unsorted array of nonnegative integers
	 * @param target target sum
	 * @return
	 */
	public Boolean check(int[] ints, int target) {

		//current sum on window
		int currentSum = ints[0];

		//current start and end of the sliding window"
		int subarrayStart = 0;
		int subarrayEnd = 0;

		//sliding window until window == last element
		while(subarrayStart<ints.length && subarrayEnd<ints.length){ //Worst case - O(2*n) in case of window = last element

			//found subarray which adds to a target sum
			if(currentSum == target) return true;

			//sum is less => try to increase window
			if(currentSum < target)
			{
				//window reached the end of given array but sum still less than target?
				//=>false
				if(subarrayEnd==ints.length-1)
					return false;

				//increase window and calculate sum of new window
				subarrayEnd++;
				currentSum = currentSum + ints[subarrayEnd];
			}

			//sum is bigger => try to decrease window
			if(currentSum > target && subarrayStart < subarrayEnd+1){
				currentSum = currentSum - ints[subarrayStart];
				subarrayStart++;
			}
		}

		return false;
	} //overall complexity = O(2*n) as we only moving window, all operations inside loop are constant
}
