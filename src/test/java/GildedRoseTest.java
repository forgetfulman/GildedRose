import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void testConjuredItemQualityDegrades() {

		int quality = 10;

		Item cI = new Item("Test Conjured Item", 1, quality, "conjured");

		cI.age();
		cI.setQuality(Assessor.assessItemQuality(cI));
		quality = quality - 2;
		assertTrue(cI.getQuality() == quality);

		cI.age();
		cI.setQuality(Assessor.assessItemQuality(cI));
		quality = quality - 4;
		cI.age();
		cI.setQuality(Assessor.assessItemQuality(cI));
		quality = quality - 4;
		assertTrue(cI.getQuality() == quality);
	}

	@Test
	public void testDegradingItemQualityDegrades() throws Exception {

		int quality = 10;

		Item dI = new Item("Test Degrading Item", 1, quality, "default");

		dI.age();
		dI.setQuality(Assessor.assessItemQuality(dI));
		quality = quality - 1;
		assertTrue(dI.getQuality() == quality);

		dI.age();
		dI.setQuality(Assessor.assessItemQuality(dI));
		quality = quality - 2;
		dI.age();
		dI.setQuality(Assessor.assessItemQuality(dI));
		quality = quality - 2;
		assertTrue(dI.getQuality() == quality);
	}

	@Test
	public void testExpiringMaturingItemMatures() throws Exception {

		int quality = 0;

		Item eMI = new Item("Test Expiring Maturing Item", 12, quality, "expiring-maturing");

		eMI.age();
		eMI.setQuality(Assessor.assessItemQuality(eMI));
		quality = quality + 1;
		assertTrue(eMI.getQuality() == quality); // Test quality increased at normal rate

		eMI.age();
		eMI.setQuality(Assessor.assessItemQuality(eMI));
		quality = quality + 2;
		assertTrue(eMI.getQuality() == quality); // Test quality increased at accelerated rate

		eMI.age();
		eMI.setQuality(Assessor.assessItemQuality(eMI));
		quality = quality + 2;
		eMI.age();
		eMI.setQuality(Assessor.assessItemQuality(eMI));
		quality = quality + 2;
		eMI.age();
		eMI.setQuality(Assessor.assessItemQuality(eMI));
		quality = quality + 2;
		eMI.age();
		eMI.setQuality(Assessor.assessItemQuality(eMI));
		quality = quality + 2;
		eMI.age();
		eMI.setQuality(Assessor.assessItemQuality(eMI));
		quality = quality + 3; // Test quality increased at fastest rate
		assertTrue(eMI.getQuality() == quality);
	}

	@Test
	public void testExpiringMaturingItemExpires() throws Exception {

		int quality = 0;

		Item eMI = new Item("Test Expiring Maturing Item", 0, quality, "expiring-maturing");

		eMI.age();
		eMI.setQuality(Assessor.assessItemQuality(eMI));
		eMI.age();
		eMI.setQuality(Assessor.assessItemQuality(eMI));
		assertTrue(eMI.getQuality() == quality);
	}

	@Test
	public void testLegendaryItemNeverAges() throws Exception {

		int quality = 80;

		Item lI = new Item("Test Legendary Item", 0, quality, "legendary");

		lI.age();
		lI.setQuality(Assessor.assessItemQuality(lI));
		assertTrue(lI.getQuality() == quality);
	}

	@Test
	public void testMaturingItemMatures() throws Exception {

		int quality = 0;

		Item mI = new Item("Test Maturing Item", 1, quality, "maturing");

		mI.age();
		mI.setQuality(Assessor.assessItemQuality(mI));
		quality = quality + 1;
		assertTrue(mI.getQuality() == quality);

		mI.age();
		mI.setQuality(Assessor.assessItemQuality(mI));
		quality = quality + 2;
		assertTrue(mI.getQuality() == quality);
	}
}