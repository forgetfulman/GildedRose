import java.util.Stack;

public class ItemAgingProfile {

    private Stack<AgeingPhase> ageingProfile = new Stack<AgeingPhase>();

    @AgingProfile(profileType = "default")
    public ItemAgeingPhaseCollection getAgingProfileDefault(int quality) {
        ageingProfile.add(new AgeingPhase(-1,-2));
        ageingProfile.add(new AgeingPhase(0,-1));
        return new ItemAgeingPhaseCollection(ageingProfile);
    }

    @AgingProfile(profileType = "conjured")
    public ItemAgeingPhaseCollection getAgingProfileConjured(int quality) {
        ageingProfile.add(new AgeingPhase(-1,-4));
        ageingProfile.add(new AgeingPhase(0,-2));
        return new ItemAgeingPhaseCollection(ageingProfile);
    }

    @AgingProfile(profileType = "maturing")
    public ItemAgeingPhaseCollection getAgingProfileMaturing(int quality) {
        ageingProfile.add(new AgeingPhase(-1,2));
        ageingProfile.add(new AgeingPhase(0,1));
        return new ItemAgeingPhaseCollection(ageingProfile);
    }

    @AgingProfile(profileType = "expiring-maturing")
    public ItemAgeingPhaseCollection getAgingProfileExpiringMaturing(int quality) {
        ageingProfile.add(new AgeingPhase(-1,quality * -1));
        ageingProfile.add(new AgeingPhase(0,3));
        ageingProfile.add(new AgeingPhase(6,2));
        ageingProfile.add(new AgeingPhase(11,1));
        return new ItemAgeingPhaseCollection(ageingProfile);
    }

    @AgingProfile(profileType = "legendary", maxQuality = 80)
    public ItemAgeingPhaseCollection getAgingProfileLegendary(int quality) {
        ageingProfile.add(new AgeingPhase(0,0));
        return new ItemAgeingPhaseCollection(ageingProfile);
    }

}
