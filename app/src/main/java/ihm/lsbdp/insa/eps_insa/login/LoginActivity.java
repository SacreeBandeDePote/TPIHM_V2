package ihm.lsbdp.insa.eps_insa.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ihm.lsbdp.insa.eps_insa.R;
import ihm.lsbdp.insa.eps_insa.student.after.StudentAfterActivity;
import ihm.lsbdp.insa.eps_insa.student.before.Sport;
import ihm.lsbdp.insa.eps_insa.student.before.StudentBeforeActivity;
import ihm.lsbdp.insa.eps_insa.teacher.TeacherActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Sport.loadSport();
    }

    public void connectStudentBefore(View view) {
        Intent intent = new Intent(this,StudentBeforeActivity.class);
        startActivity(intent);
    }

    public void connectStudentAfter(View view) {
        Intent intent = new Intent(this,StudentAfterActivity.class);
        startActivity(intent);
    }

    public void connectTeacher(View view) {
        Intent intent = new Intent(this,TeacherActivity.class);
        startActivity(intent);
    }
}
