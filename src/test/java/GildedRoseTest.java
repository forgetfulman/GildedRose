import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GildedRoseTest {

	@Test
	public void testConjuredItemQualityDegrades() {

		int conjuredQuality = 1;

		GildedRose.main(new String[]{""});

		for (int j = 0; j < 3 ; j++) {
			GildedRose.updateQuality();
		}

		for (Item i : GildedRose.getItems()) {
			System.out.println("[" + i.getName() + "] Quality: [" + i.getQuality() + "] Sell-in: [" + i.getSellIn() + "]");
			if ("Conjured Mana Cake".equals(i.getName())) {
				conjuredQuality = i.getQuality();
			}
		}

		assertTrue(conjuredQuality==0);
	}
}