public class Item {
    private String name;
    private int sellIn;
    private int quality;
    private String itemType = "unknown";
    
    public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

    public Item(String name, int sellIn, int quality, String itemType) {
        this(name, sellIn, quality);
        this.itemType = itemType;
    }

	public void age() {
        sellIn--;
    }
    
	/* Generated getter and setter code */
    public String getName() {
		return name;
	}
	public int getSellIn() {
		return sellIn;
	}
	public int getQuality() {
		return quality;
	}
    public void setQuality(int quality) {
        this.quality = quality;
    }
    public String getItemType() {
        return itemType;
    }
}
