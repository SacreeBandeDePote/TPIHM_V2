package ihm.lsbdp.insa.eps_insa.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ihm.lsbdp.insa.eps_insa.R;
import ihm.lsbdp.insa.eps_insa.student.before.StudentBeforeActivity;

public class TeacherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
    }

    public void slotLauncher(View view) {
        Intent intent = new Intent(this,SlotTeacherActivity.class);
        startActivity(intent);
    }
}
