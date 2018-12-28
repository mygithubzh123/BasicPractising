package bitset;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

public class TestBitSet {
	
	private BitSet bitset = new BitSet(8);
	
	@BeforeEach
	public void setup(){
		bitset.set(4);
		bitset.set(5);
		bitset.set(8);
	}
	
	@Test
	public void test(){
		System.out.println(bitset);
	}
}
