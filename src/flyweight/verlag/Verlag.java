package flyweight.verlag;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Verlag {
    private final String verlag;
    private final Date verlagBeginningYear;
    private final String verlagLocation;
    private static Map<String, Verlag> cache = new HashMap<>();

    protected Verlag(String verlag, Date verlagBeginningYear, String verlagLocation) {
        this.verlag = verlag;
        this.verlagBeginningYear = verlagBeginningYear;
        this.verlagLocation = verlagLocation;
    }

    public String getVerlag() {
        return verlag;
    }

    public Date getVerlagBeginningYear() {
        return verlagBeginningYear;
    }

    public String getVerlagLocation() {
        return verlagLocation;
    }

    public static Verlag getVerlag(String verlag, Date verlagBeginningYear, String verlagLocation) {
        if (!cache.containsKey(verlag)) {
            cache.put(verlag, new Verlag(verlag, verlagBeginningYear, verlagLocation));
        }
        return cache.get(verlag);
    }
}
