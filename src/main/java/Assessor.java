import org.reflections.ReflectionUtils;
import static org.reflections.ReflectionUtils.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class Assessor {

    public static int assessItemQuality(Item item) {
        ItemAgeingPhaseCollection itemAgeingPhases = null;
        int itemMaxQuality = 0;
        try {
            Method ageingProfileProvider = getItemAgeingProfile(item.getItemType());
            itemAgeingPhases = (ItemAgeingPhaseCollection) ageingProfileProvider.invoke(new ItemAgingProfile(), item.getQuality());
            AgingProfile ageingProfile = ageingProfileProvider.getAnnotation(AgingProfile.class);
            itemMaxQuality = ageingProfile.maxQuality();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return itemAgeingPhases.tellMeThisItemsQuality(item, itemMaxQuality);
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
}
