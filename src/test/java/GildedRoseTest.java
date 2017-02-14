import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GildedRoseTest {

	@Test
	public void testConjuredItemQualityDegrades() {

        int quality = 10;

        ConjuredItem cI = new ConjuredItem("Test Conjured Item", 1, quality);

        cI.age();
        quality = quality - RateOfAgeing.QUICKLY.ordinal();
        assertTrue(cI.getQuality() == quality);

        cI.age();
        quality = quality - RateOfAgeing.QUICKLY.ordinal();
        cI.age();
        quality = quality - RateOfAgeing.LIGHTNING.ordinal();
        assertTrue(cI.getQuality() == quality);
	}

    @Test
    public void testDegradingItemQualityDegrades() throws Exception {

	    int quality = 10;

        DegradingItem dI = new DegradingItem("Test Degrading Item", 1, quality);

        dI.age();
        quality = quality - RateOfAgeing.SLOW.ordinal();
        assertTrue(dI.getQuality() == quality);

        dI.age();
        quality = quality - RateOfAgeing.SLOW.ordinal();
        dI.age();
        quality = quality - RateOfAgeing.QUICKLY.ordinal();
        assertTrue(dI.getQuality() == quality);
    }

    @Test
    public void testExpiringMaturingItemMatures() throws Exception {

	    int quality = 0;

	    ExpiringMaturingItem eMI = new ExpiringMaturingItem("Test Expiring Maturing Item", 11, quality);

        eMI.age();
        quality = quality + RateOfAgeing.SLOW.ordinal();
        assertTrue(eMI.getQuality() == quality); // Test quality increased at normal rate

        eMI.age();
        quality = quality + RateOfAgeing.QUICKLY.ordinal();
        assertTrue(eMI.getQuality() == quality); // Test quality increased at accelerated rate

        eMI.age();
        quality = quality + RateOfAgeing.QUICKLY.ordinal();
        eMI.age();
        quality = quality + RateOfAgeing.QUICKLY.ordinal();
        eMI.age();
        quality = quality + RateOfAgeing.QUICKLY.ordinal();
        eMI.age();
        quality = quality + RateOfAgeing.QUICKLY.ordinal();
        eMI.age();
        quality = quality + RateOfAgeing.AS_FAST_AS_A_BANANA.ordinal(); // Test quality increased at fastest rate
        assertTrue(eMI.getQuality() == quality);
    }

    @Test
    public void testExpiringMaturingItemExpires() throws Exception {

        int quality = 0;

        ExpiringMaturingItem eMI = new ExpiringMaturingItem("Test Expiring Maturing Item", 0, quality);

        eMI.age();
        eMI.age();
        assertTrue(eMI.getQuality() == quality);
    }

    @Test
    public void testLegendaryItemNeverAges() throws Exception {

	    int quality = 80;

        LegendaryItem lI = new LegendaryItem("Test Legendary Item", 0, quality);

        lI.age();
	    assertTrue(lI.getQuality() == quality);
    }

    @Test
    public void testMaturingItemMatures() throws Exception {

	    int quality = 0;

	    MaturingItem mI = new MaturingItem("Test Maturing Item", 0, quality);

	    mI.age();
        quality = quality + RateOfAgeing.SLOW.ordinal();
        assertTrue(mI.getQuality() == quality);

        mI.age();
        quality = quality + RateOfAgeing.QUICKLY.ordinal();
        assertTrue(mI.getQuality() == quality);
    }
}