package ihm.lsbdp.insa.eps_insa.teacher;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ihm.lsbdp.insa.eps_insa.R;

public class listEleveActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_eleve);

        mListView = (ListView) findViewById(R.id.student_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(listEleveActivity.this,
                android.R.layout.simple_list_item_1, prenoms);
        mListView.setAdapter(adapter);
    }

}
