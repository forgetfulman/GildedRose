public class MaturingItem extends StockableItem {



    public MaturingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void age() {
        if (getQuality() < 50) {
            if (getSellIn() < 0) {
                setQuality(getQuality() + RateOfAgeing.QUICKLY.ordinal());
            } else {
                setQuality(getQuality() + RateOfAgeing.SLOW.ordinal());
            }
        }
        setSellIn(getSellIn() - 1);
    }

}
