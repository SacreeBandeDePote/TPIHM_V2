package ihm.lsbdp.insa.eps_insa.student.before;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import ihm.lsbdp.insa.eps_insa.R;

public class StudentBeforeActivity extends AppCompatActivity {

    Fragment frag;
    StudentBeforeList listFragment;
    StudentBeforeWish wishFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_before);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        Sport.loadSport();

        listFragment = StudentBeforeList.newInstance();
        wishFragment = StudentBeforeWish.newInstance();

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        frag = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                System.out.println("Switching to List");
                                frag = listFragment;
                                break;
                            case R.id.action_item2:
                                System.out.println("Switching to Wish");
                                frag = wishFragment;
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, frag);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        frag = listFragment;

        fragmentTransaction.add(R.id.frame_layout, frag);
        fragmentTransaction.commit();
    }
}
