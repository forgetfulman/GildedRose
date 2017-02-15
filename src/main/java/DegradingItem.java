/**
 * Created by christoph on 14/02/2017.
 */
public class DegradingItem extends Item {



    public DegradingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void age() {
        if (getQuality() > 0) {
            if (getSellIn() < 0) {
                setQuality(getQuality() - RateOfAgeing.QUICKLY.ordinal());
            } else {
                setQuality(getQuality() - RateOfAgeing.SLOW.ordinal());
            }
        }
        setSellIn(getSellIn() - 1);
    }

}
