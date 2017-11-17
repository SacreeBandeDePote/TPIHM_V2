package ihm.lsbdp.insa.eps_insa.student.before;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by perewoulpy on 11/11/17.
 */

public class Sport {
    private String name;
    private String timeSlot;
    private String shortDescription;
    private String teacher;
    private int maxStudentSlot;
    private int minStudentSlot;
    private int takenStudentSlot;
    private LatLng location;


    public Sport(String name, String timeSlot, String shortDescription, String teacher, int maxStudentSlot, int minStudentSlot, LatLng location) {
        this.name = name;
        this.timeSlot = timeSlot;
        this.shortDescription = shortDescription;
        this.teacher = teacher;
        this.maxStudentSlot = maxStudentSlot;
        this.minStudentSlot = minStudentSlot;

        this.location = location;

        this.takenStudentSlot = 0;
    }

    public String getName() {
        return name;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getMaxStudentSlot() {
        return maxStudentSlot;
    }

    public int getMinStudentSlot() {
        return minStudentSlot;
    }

    public int getTakenStudentSlot() {
        return takenStudentSlot;
    }

    public LatLng getLocation() {
        return location;
    }

    public void subscribe() {
        takenStudentSlot++;
    }

    public String slotToString() {
        return "De "
                + this.getMinStudentSlot()
                + " à "
                + this.getMaxStudentSlot()
                + " (déjà " + this.getTakenStudentSlot() + " inscrits)";
    }
}
