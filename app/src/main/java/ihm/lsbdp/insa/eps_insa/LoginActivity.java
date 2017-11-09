package ihm.lsbdp.insa.eps_insa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void connectStudentBefore(View view) {
        Intent intent = new Intent(this, StudentBeforeActivity.class);
        startActivity(intent);
    }

    public void connectStudentAfter(View view) {
        Intent intent = new Intent(this, StudentAfterActivity.class);
        startActivity(intent);
    }

    public void connectTeacher(View view) {
        Intent intent = new Intent(this, TeacherActivity.class);
        startActivity(intent);
    }
}
