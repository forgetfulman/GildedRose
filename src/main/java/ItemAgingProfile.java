import java.util.Stack;

public class ItemAgingProfile {

    private Stack<AgeingPhase> ageingProfile = new Stack<AgeingPhase>();

    @AgingProfile(profileType = "default")
    public Stack<AgeingPhase> getAgingProfileDefault(int quality) {
        ageingProfile.add(new AgeingPhase(-1,-2));
        ageingProfile.add(new AgeingPhase(0,-1));
        return ageingProfile;
    }

    @AgingProfile(profileType = "conjured")
    public Stack<AgeingPhase> getAgingProfileConjured(int quality) {
        ageingProfile.add(new AgeingPhase(-1,-4));
        ageingProfile.add(new AgeingPhase(0,-2));
        return ageingProfile;
    }

    @AgingProfile(profileType = "maturing")
    public Stack<AgeingPhase> getAgingProfileMaturing(int quality) {
        ageingProfile.add(new AgeingPhase(-1,2));
        ageingProfile.add(new AgeingPhase(0,1));
        return ageingProfile;
    }

    @AgingProfile(profileType = "expiring-maturing")
    public Stack<AgeingPhase> getAgingProfileExpiringMaturing(int quality) {
        ageingProfile.add(new AgeingPhase(-1,quality * -1));
        ageingProfile.add(new AgeingPhase(0,3));
        ageingProfile.add(new AgeingPhase(6,2));
        ageingProfile.add(new AgeingPhase(11,1));
        return ageingProfile;
    }

    @AgingProfile(profileType = "legendary", maxQuality = 80)
    public Stack<AgeingPhase> getAgingProfileLegendary(int quality) {
        ageingProfile.add(new AgeingPhase(0,0));
        return ageingProfile;
    }

}