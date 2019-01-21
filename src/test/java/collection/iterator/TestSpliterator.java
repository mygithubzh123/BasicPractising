package collection.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * 测试spliterator
 *
 * @author neo
 * 2019/1/11 11:49 AM
 */
public class TestSpliterator {

	private List<String> strings = new ArrayList<>();

	@BeforeEach
	void setup(){
		for(int i=0;i<10;i++){
			strings.add(String.valueOf(i+100));
		}
	}


	@Test
	void test1() {
		Spliterator<String> spliterator = strings.spliterator();
		spliterator.tryAdvance(System.out::println);
		System.out.println("========================");
		System.out.println(spliterator.estimateSize());
		spliterator.forEachRemaining(System.out::println);
		System.out.println("========================");
		System.out.println(spliterator.characteristics());

		System.out.println(spliterator.tryAdvance(System.out::println));
	}

	@Test
	void test2() {
		Spliterator<String> spliterator = strings.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		spliterator.forEachRemaining(System.out::println);
		System.out.println("=========================");
		spliterator1.forEachRemaining(System.out::println);
	}

	@Test
	void test3() {
		Spliterator<String> s = strings.spliterator();
		if (s.hasCharacteristics(Spliterator.ORDERED)) {
			System.out.println("ORDERED");
		}
		if (s.hasCharacteristics(Spliterator.DISTINCT)) {
			System.out.println("DISTINCT");
		}
		if (s.hasCharacteristics(Spliterator.SORTED)) {
			System.out.println("SORTED");
		}
		if (s.hasCharacteristics(Spliterator.SIZED)) {
			System.out.println("SIZED");
		}
		if (s.hasCharacteristics(Spliterator.CONCURRENT)) {
			System.out.println("CONCURRENT");
		}
		if (s.hasCharacteristics(Spliterator.IMMUTABLE)) {
			System.out.println("IMMUTABLE");
		}
		if (s.hasCharacteristics(Spliterator.NONNULL)) {
			System.out.println("NONNULL");
		}
		if (s.hasCharacteristics(Spliterator.SUBSIZED)) {
			System.out.println("SUBSIZED");
		}
	}
}
