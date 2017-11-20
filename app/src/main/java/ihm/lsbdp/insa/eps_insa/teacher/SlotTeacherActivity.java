package ihm.lsbdp.insa.eps_insa.teacher;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ihm.lsbdp.insa.eps_insa.R;

public class SlotTeacherActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_teacher);
    }

    public void slotLauncher(View view) {
        Intent intent = new Intent(this,listEleveActivity.class);
        startActivity(intent);
    }

}
