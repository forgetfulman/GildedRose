import java.util.Stack;

public class ItemAgeingPhaseCollection {

    private Stack<AgeingPhase> ageingPhases = new Stack<AgeingPhase>();

    public ItemAgeingPhaseCollection(Stack<AgeingPhase> ageingProfile) {
        this.ageingPhases = ageingProfile;
    }

    public int tellMeThisItemsQuality(Item item, int itemMaxQuality) {
        while (ageingPhases.size() > 1 && ageingPhases.peek().getSellIn() > item.getSellIn()) {
            ageingPhases.pop();
        }
        AgeingPhase currentAgeingPhase = ageingPhases.peek();
        int newItemQuality = item.getQuality() + currentAgeingPhase.getChangeRate();

        return isItemQualityInRange(newItemQuality, itemMaxQuality) ?
                item.getQuality() + currentAgeingPhase.getChangeRate() : itemQualityBoundary(newItemQuality, itemMaxQuality);
    }

    private boolean isItemQualityInRange(int newItemQuality, int itemMaxQuality) {
        return newItemQuality < itemMaxQuality && newItemQuality >= 0;
    }

    private int itemQualityBoundary(int newItemQuality, int itemMaxQuality) {
        return newItemQuality < 0 ? 0 : itemMaxQuality;
    }

}
