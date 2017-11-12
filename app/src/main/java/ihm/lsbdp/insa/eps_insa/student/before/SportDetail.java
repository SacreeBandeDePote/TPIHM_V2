package ihm.lsbdp.insa.eps_insa.student.before;

/**
 * Created by perewoulpy on 11/11/17.
 */

public class SportDetail {
    private String description;
    private String location;

    public SportDetail(String description, String location) {
        this.description = description;
        this.location = location;
    }

    public String getDescription() {

        return description;
    }

    public String getLocation() {
        return location;
    }
}
