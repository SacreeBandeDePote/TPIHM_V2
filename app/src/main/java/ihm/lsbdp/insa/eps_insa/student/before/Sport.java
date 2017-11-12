package ihm.lsbdp.insa.eps_insa.student.before;

/**
 * Created by perewoulpy on 11/11/17.
 */

public class Sport {
    private String name;
    private String shortDescription;

    private SportDetail detail;

    public Sport(String name, String shortDescription, SportDetail detail) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.detail = detail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public SportDetail getDetail() {

        return detail;
    }

    public String getName() {

        return name;
    }
}
