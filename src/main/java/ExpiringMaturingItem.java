/**
 * Created by christoph on 14/02/2017.
 */
public class ExpiringMaturingItem extends Item {

    private static int IN_DEMAND = 10;
    private static int SELLING_LIKE_HOT_CAKES = 5;

    public ExpiringMaturingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void age() {
        if (getSellIn() >= 0) {
            if (getQuality() < 50) {
                int rateOfIncrease = RateOfAgeing.SLOW.ordinal();
                if (getSellIn() <= IN_DEMAND) {
                    rateOfIncrease = (getSellIn() <= SELLING_LIKE_HOT_CAKES) ? RateOfAgeing.AS_FAST_AS_A_BANANA.ordinal() : RateOfAgeing.QUICKLY.ordinal();
                }
                setQuality(getQuality() + rateOfIncrease);
            }
        } else {
            setQuality(getQuality() - getQuality());
        }
        setSellIn(getSellIn() - 1);
    }
}
