public class AgeingPhase {

    public Integer getSellIn() {
        return sellIn;
    }

    public Integer getChangeRate() {
        return changeRate;
    }

    private Integer sellIn;
    private Integer changeRate;

    public AgeingPhase(Integer sellIn, Integer changeRate) {
        this.sellIn = sellIn;
        this.changeRate = changeRate;
    }

}
