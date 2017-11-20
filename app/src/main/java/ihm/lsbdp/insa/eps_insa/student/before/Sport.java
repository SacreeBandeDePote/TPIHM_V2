package ihm.lsbdp.insa.eps_insa.student.before;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Sport> sports = new ArrayList<>();

    public static List<Sport> wishes = new ArrayList<>();

    public static void loadSport() {
        sports.add(new Sport("Tennis",
                "Ven - 16h,18h",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a viverra metus, eu varius ex. Phasellus molestie leo non sapien semper dapibus.",
                "Monsieur Bob Ho",
                20,
                15,
                new LatLng(45.785503, 4.883437))
                );
        sports.add(new Sport("Basket",
                "Ven - 16h,18h",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a viverra metus, eu varius ex. Phasellus molestie leo non sapien semper dapibus.",
                "Monsieur Denis Chon",
                20,
                15,
                new LatLng(45.785503, 4.883437))
                );
        sports.add(new Sport("HandBall",
                "Ven - 16h,18h",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a viverra metus, eu varius ex. Phasellus molestie leo non sapien semper dapibus.",
                "Jeff",
                24,
                20,
                new LatLng(45.785503, 4.883437))
        );
        sports.add(new Sport("Danse",
                "Lun - 18h,20h",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a viverra metus, eu varius ex. Phasellus molestie leo non sapien semper dapibus.",
                "Delphine Savel",
                15,
                10,
                new LatLng(45.785503, 4.883437))
        );
        sports.add(new Sport("Escalade",
                "Ven - 16h,18h",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a viverra metus, eu varius ex. Phasellus molestie leo non sapien semper dapibus.",
                "GuiGui Beslon",
                20,
                14,
                new LatLng(45.785503, 4.883437))
        );
    }

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

    public void subscribe(int index) {
        takenStudentSlot++;
        wishes.add(sports.get(index));
    }

    public void unsubscribe(int index) {
        takenStudentSlot--;
        wishes.remove(index);
    }

    public String slotToString() {
        return "De "
                + this.getMinStudentSlot()
                + " à "
                + this.getMaxStudentSlot()
                + " (déjà " + this.getTakenStudentSlot() + " inscrits)";
    }
}
