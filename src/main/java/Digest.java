import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

//FIXME No comments, should be at least comments to describe the purpose of the class
public abstract class Digest {

	//FIXME without any size limitations and eviction strategy could become memory usage problem
	//So maximum size + some strategy like LRU or at least use SoftReferences
	private Map<byte[], byte[]> cache = new HashMap<byte[], byte[]>();

	public byte[] digest(byte[] input) {
		//FIXME should check input for null & empty
		//although it depends on contract and may not break anything I'd prefer to add checks

		byte[] result = cache.get(input);

		//FIXME Double-checked locking is generally considered as anti-pattern nowadays
		//I'd rather use ConcurrentHashMap.computeIfAbsent or synchronize the whole method
		if (result == null) {
			synchronized (cache) {
				result = cache.get(input);
				if (result == null) {
					try {
						result = doDigest(input);
						cache.put(input, result);
					}
					catch (RuntimeException ex) //FIXME should catch specific exception, not just base class
					{
						//FIXME should initialize logger as static field (and usually use class as logger name)
						//FIXME log exception with stack trace as well
						LoggerFactory.getLogger("Digest").error(
								"Unable to make digest"
						);
						//FIXME should translate exception rather than just propagate
						throw ex;
					}
				}
			}
		}
		return result;
	}

	//FIXME I'd say that it violates Single-Responsibility Principle and prefer composition-over-inheritance
	//so it would be separate: a class responsible for Cache and an interface for issuing Digests
	protected abstract byte[] doDigest(byte[] input);
}