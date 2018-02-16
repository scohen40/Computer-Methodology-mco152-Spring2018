package cohen.change;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingMachineTest {

	@Test
	public void testChange() {
		// given
		Change c = new Change(3.72);

		// when
		int q = c.getQuarters();

		// then
		assertEquals(14, q);

	}

	@Test
	public void testVendingMachine() {
		// given
		Change c = VendingMachine.pay(1.5, 3);

		// when
		int q = c.getQuarters();

		// then
		assertEquals(6, q);
	}
}
