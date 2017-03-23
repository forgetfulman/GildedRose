import org.reflections.ReflectionUtils;
import static org.reflections.ReflectionUtils.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class Assessor {

    public static int assessItemQuality(Item item) {
        Stack<AgeingPhase> itemAgeingProfile = null;
        int itemMaxQuality = 0;
        try {
            Method ageingProfileProvider = getItemAgeingProfile(item.getItemType());
            itemAgeingProfile = (Stack<AgeingPhase>) ageingProfileProvider.invoke(new ItemAgingProfile(), item.getQuality());
            AgingProfile ageingProfile = ageingProfileProvider.getAnnotation(AgingProfile.class);
            itemMaxQuality = ageingProfile.maxQuality();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        while (itemAgeingProfile.size() > 1 && itemAgeingProfile.peek().getSellIn() > item.getSellIn()) {
            itemAgeingProfile.pop();
        }

        return calculateNewItemQuality(item.getQuality(), itemAgeingProfile.peek().getChangeRate()) > itemMaxQuality ?
                itemMaxQuality : calculateNewItemQuality(item.getQuality(), itemAgeingProfile.peek().getChangeRate());
    }

    private static Method getItemAgeingProfile(String itemType) {
        HashMap<String,Method> ageingProfileProviders = new HashMap<String, Method>();
        for (Method method : getAgeingProfileProviders()) {
            AgingProfile ageingProfile = method.getAnnotation(AgingProfile.class);
            ageingProfileProviders.put(ageingProfile.profileType(), method);
        }
        return ageingProfileProviders.containsKey(itemType) ? ageingProfileProviders.get(itemType) : ageingProfileProviders.get("default");
    }

    private static Set<Method> getAgeingProfileProviders() {
        return ReflectionUtils.getAllMethods(ItemAgingProfile.class,
                withModifier(Modifier.PUBLIC), withPrefix("getAgingProfile"), withAnnotation(AgingProfile.class));
    }

    private static int calculateNewItemQuality(int currentItemQuality, int changeRate) {
        return currentItemQuality + changeRate < 0 ? 0 : currentItemQuality + changeRate;
    }
}
