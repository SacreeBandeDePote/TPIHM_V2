package ihm.lsbdp.insa.eps_insa.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import ihm.lsbdp.insa.eps_insa.R;
import ihm.lsbdp.insa.eps_insa.student.after.StudentAfterActivity;
import ihm.lsbdp.insa.eps_insa.student.before.Sport;
import ihm.lsbdp.insa.eps_insa.student.before.StudentBeforeActivity;
import ihm.lsbdp.insa.eps_insa.teacher.TeacherActivity;

public class LoginActivity extends AppCompatActivity {

    EditText mEdit;
    String toTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEdit = (EditText) findViewById(R.id.login_input_ID);
        Sport.loadSport();
    }

    public void connect(View view) {
        toTest = mEdit.getText().toString();

        if (toTest.equals("sb")) {
            Intent intent = new Intent(this, StudentBeforeActivity.class);
            startActivity(intent);
        } else if (toTest.equals("sa")) {
            Intent intent = new Intent(this, StudentAfterActivity.class);
            startActivity(intent);
        } else if (toTest.equals("t")) {
            Intent intent = new Intent(this, TeacherActivity.class);
            startActivity(intent);
        } else {
            Snackbar.make(view, "Log in error", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }
}
