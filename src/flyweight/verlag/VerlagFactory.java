package flyweight.verlag;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class VerlagFactory {
    private static Map<String, Verlag> cache = new HashMap<>();

    public static Verlag getVerlag(String verlag, Date verlagBeginningYear, String verlagLocation) {
        if (!cache.containsKey(verlag)) {
            cache.put(verlag, new Verlag(verlag, verlagBeginningYear, verlagLocation));
        }
        return cache.get(verlag);
    }
}
