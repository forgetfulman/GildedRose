/**
 * Created by christoph on 14/02/2017.
 */
public class ConjuredItem extends Item {



    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void age() {
        if (getQuality() > 0) {
            if (getSellIn() < 0) {
                setQuality(getQuality() - RateOfAgeing.LIGHTNING.ordinal());
            } else {
                setQuality(getQuality() - RateOfAgeing.QUICKLY.ordinal());
            }
        }
        setSellIn(getSellIn() - 1);
    }

}
