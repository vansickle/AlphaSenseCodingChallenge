import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringFinder {


	public int find(String input) {

		//stores characters seen
		HashSet<Character> characters = new HashSet<>();

		//length of longest substring without repeating characters
		int maxLength = 0;

		char[] chars = input.toCharArray();

		for (char aChar : chars) {

			//already seen character
			if(characters.contains(aChar))
			{
				int length = characters.size();

				//check if current sequence length is max seen
				if(maxLength<length){
					maxLength = length;
				}

				//recreate character store and continue
				characters = new HashSet<>();
				characters.add(aChar);
				continue;
			}

			//not seen char before - just add to store
			characters.add(aChar);
		}

		return maxLength;
	}
}
