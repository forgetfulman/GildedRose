public abstract class StockableItem extends Item {

    public StockableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void age();
}
