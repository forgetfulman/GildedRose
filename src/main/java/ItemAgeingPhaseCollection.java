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
        int newItemQuality = determineNewItemQuality(item, currentAgeingPhase);

        return isItemQualityInRange(newItemQuality, itemMaxQuality) ?
                newItemQuality : tellMeWhichItemLimitReached(newItemQuality, itemMaxQuality);
    }

    private boolean isItemQualityInRange(int newItemQuality, int itemMaxQuality) {
        return newItemQuality < itemMaxQuality && newItemQuality >= 0;
    }

    private int tellMeWhichItemLimitReached(int newItemQuality, int itemMaxQuality) {
        return newItemQuality < 0 ? 0 : itemMaxQuality;
    }

    private int determineNewItemQuality(Item item, AgeingPhase currentAgeingPhase) {
        return item.getQuality() + currentAgeingPhase.getChangeRate();
    }

}
