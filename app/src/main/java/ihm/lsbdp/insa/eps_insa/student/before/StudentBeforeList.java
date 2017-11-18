/*
 * Copyright (c) 2017. Truiton (http://www.truiton.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Mohit Gupt (https://github.com/mohitgupt)
 *
 */

package ihm.lsbdp.insa.eps_insa.student.before;

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
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import net.cachapa.expandablelayout.ExpandableLayout;

import ihm.lsbdp.insa.eps_insa.R;

public class StudentBeforeList extends Fragment{

    public static StudentBeforeList newInstance() {
        StudentBeforeList fragment = new StudentBeforeList();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_student_before_list, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list_sport);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SportAdapter(recyclerView));

        return rootView;
    }

    private static class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder> {

        private static Sport[] sports = new Sport[2];

        private static final int UNSELECTED = -1;

        private RecyclerView recyclerView;
        private int selectedItem = UNSELECTED;

        public SportAdapter(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        @Override
        public SportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sport, parent, false);
            return new SportViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(SportViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return sports.length;
        }

        public class SportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
            private ExpandableLayout expandableLayout;
            private LinearLayout header;
            private TextView headerName;
            private TextView headerSlotTime;

            private TextView description;
            private TextView teacher;
            private TextView studentSlot;
            private Button addWish;
            private int position;

            public SportViewHolder(View itemView) {
                super(itemView);

                SportAdapter.this.loadData();

                header = (LinearLayout) itemView.findViewById(R.id.sport_header);
                header.setOnClickListener(this);

                headerName = (TextView) itemView.findViewById(R.id.sport_header_title);
                headerSlotTime = (TextView) itemView.findViewById(R.id.sport_header_slot);

                expandableLayout = (ExpandableLayout) itemView.findViewById(R.id.expandable_layout);
                expandableLayout.setInterpolator(new OvershootInterpolator());
                expandableLayout.setOnExpansionUpdateListener(this);

                description = (TextView) itemView.findViewById(R.id.description);
                teacher = (TextView) itemView.findViewById(R.id.teacher);
                studentSlot = (TextView) itemView.findViewById(R.id.slot);
                //sportMap = (MapView) itemView.findViewById(R.id.sportMap);

                addWish = (Button) itemView.findViewById(R.id.addWish);
                addWish.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        onClickButton(v);
                    }
                });
            }

            public void bind(int position) {
                this.position = position;
                header.setSelected(false);

                headerName.setText(SportAdapter.this.sports[position].getName());
                headerSlotTime.setText(SportAdapter.this.sports[position].getTimeSlot());

                description.setText("Description : " + SportAdapter.this.sports[position].getShortDescription());
                teacher.setText("Professeur : " + SportAdapter.this.sports[position].getTeacher());
                studentSlot.setText(SportAdapter.this.sports[position].slotToString());

                expandableLayout.collapse(false);
            }

            @Override
            public void onClick(View view) {
                SportViewHolder holder = (SportViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
                if (holder != null) {
                    holder.header.setSelected(false);
                    holder.expandableLayout.collapse();
                }

                if (position == selectedItem) {
                    selectedItem = UNSELECTED;
                } else {
                    header.setSelected(true);
                    expandableLayout.expand();
                    selectedItem = position;
                }
            }

            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout", "State: " + state);
                recyclerView.smoothScrollToPosition(getAdapterPosition());
            }

            public void onClickButton(View v) {
                sports[position].subscribe();
                studentSlot.setText(SportAdapter.this.sports[position].slotToString());
                addWish.setEnabled(false);

                Context context = v.getContext();
                CharSequence text = "Le sport" + sports[position].getName()+" a été ajouté à vos voeux avec succès!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(v.getContext(), text, duration);
                toast.show();
            }
        }

        private static void loadData() {
            sports[0] = new Sport("Tennis",
                    "Ven - 16h,18h",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a viverra metus, eu varius ex. Phasellus molestie leo non sapien semper dapibus.",
                    "Monsieur Bob Ho",
                    20,
                    15,
                    new LatLng(45.785503, 4.883437));
            sports[1] = new Sport("Basket",
                    "Ven - 16h,18h",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a viverra metus, eu varius ex. Phasellus molestie leo non sapien semper dapibus.",
                    "Monsieur Denis Chon",
                    20,
                    15,
                    new LatLng(45.785503, 4.883437));
        }
    }
}
