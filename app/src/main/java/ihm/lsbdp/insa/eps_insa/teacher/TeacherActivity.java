package ihm.lsbdp.insa.eps_insa.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ihm.lsbdp.insa.eps_insa.R;
import ihm.lsbdp.insa.eps_insa.student.before.StudentBeforeActivity;

public class TeacherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        String  itemArray [] = new String[54];
        for(int i=1;i<itemArray.length+1;i++)
        {
            itemArray[i-1]="Semaine "+String.valueOf(i);
        }
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_dropdown_item_1line,itemArray);
        spin.setAdapter(adapter);
    }

    public void slotLauncher(View view) {
        Intent intent = new Intent(this,SlotTeacherActivity.class);
        startActivity(intent);
    }
}
