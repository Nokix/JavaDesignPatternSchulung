package flyweight.verlag;

import java.util.Date;

public class Verlag {
    private final String verlag;
    private final Date verlagBeginningYear;
    private final String verlagLocation;

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
}
