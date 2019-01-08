package concurrent.synchronizer.cylicbarrier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 测试CylicBarrier
 *
 * @author neo
 * 2019/1/8 12:07 PM
 */
public class TestCylicBarrier {

	private List<RedArmy> redArmyList;

	private ExecutorService executorService = Executors.newCachedThreadPool();

	private CyclicBarrier barrier;

	@BeforeEach
	void setUp() {
		barrier = new CyclicBarrier(4, () -> System.out.println("全军整合，开始长征，目标延安..."));
		redArmyList = new ArrayList<>(4);
		redArmyList.add(new RedArmy(1,barrier));
		redArmyList.add(new RedArmy(2,barrier));
		redArmyList.add(new RedArmy(3,barrier));
		redArmyList.add(new RedArmy(4,barrier));
	}

	@Test
	void test1() {
		redArmyList.forEach(e -> executorService.execute(e));

	}

	@AfterEach
	void tearDown() throws InterruptedException {
		TimeUnit.MINUTES.sleep(10);
	}
}
