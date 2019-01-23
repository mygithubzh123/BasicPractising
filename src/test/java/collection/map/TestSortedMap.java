package collection.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * test SortedMap
 *
 * @author neo
 * 2019/1/21 11:25 AM
 */
public class TestSortedMap {

	SortedMap<String,Object> map = new TreeMap<>();

	@BeforeEach
	void setUp() {
		map.put("2",new Object());
		map.put("4",new Object());
		map.put("6",new Object());
		map.put("8",new Object());
	}
}
