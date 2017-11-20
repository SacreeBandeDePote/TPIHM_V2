package ihm.lsbdp.insa.eps_insa.teacher;

/**
 * Created by benjiros on 20/11/2017.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

import ihm.lsbdp.insa.eps_insa.R;

public class SlotTeacherList extends Fragment{
    RecyclerView view_listStudent;
    StudentAdapter studentAdapter;

    public static SlotTeacherList newInstance() {
        SlotTeacherList fragment = new SlotTeacherList();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_slot_teacher, container, false);

        view_listStudent = (RecyclerView) rootView.findViewById(R.id.list_student);
        view_listStudent.setLayoutManager(new LinearLayoutManager(getContext()));

        studentAdapter = new StudentAdapter(view_listStudent);

        view_listStudent.setAdapter(studentAdapter);

        return rootView;
    }

    private static class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

        private static List<Student> students = Student.students;

        private static final int UNSELECTED = -1;

        private RecyclerView recyclerView;
        private int selectedItem = UNSELECTED;

        public StudentAdapter(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        @Override
        public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.student, parent, false);
            return new StudentViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(StudentViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return students.size();
        }

        public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
            private ExpandableLayout expandableLayout;
            private TextView name;
            private TextView lastName;


            public StudentViewHolder(View itemView) {
                super(itemView);



                expandableLayout = (ExpandableLayout) itemView.findViewById(R.id.expandable_layout);
                expandableLayout.setInterpolator(new OvershootInterpolator());
                expandableLayout.setOnExpansionUpdateListener(this);

                name = (TextView) itemView.findViewById(R.id.name);
                lastName = (TextView) itemView.findViewById(R.id.lastName);

            }

            public void bind(int position) {

                name.setText(StudentAdapter.this.students.get(position).getName());
                lastName.setText(StudentAdapter.this.students.get(position).getLastName());



                expandableLayout.collapse(false);
            }

            @Override
            public void onClick(View view) {
                StudentViewHolder holder = (StudentViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
                if (holder != null) {
                    holder.expandableLayout.collapse();
                }

                if (position == selectedItem) {
                    selectedItem = UNSELECTED;
                } else {
                    expandableLayout.expand();
                    selectedItem = position;
                }
            }


            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout", "State: " + state);
                recyclerView.smoothScrollToPosition(getAdapterPosition());
            }


        }
    }

}
