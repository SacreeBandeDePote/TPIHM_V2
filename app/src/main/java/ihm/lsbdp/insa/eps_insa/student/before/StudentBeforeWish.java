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

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

import ihm.lsbdp.insa.eps_insa.R;

public class StudentBeforeWish extends Fragment {

    RecyclerView view_listSport;
    SportAdapter sportAdapter;

    public static StudentBeforeWish newInstance() {
        StudentBeforeWish fragment = new StudentBeforeWish();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_student_before_wish, container, false);

        view_listSport = (RecyclerView) rootView.findViewById(R.id.wish_sport);
        view_listSport.setLayoutManager(new LinearLayoutManager(getContext()));

        sportAdapter = new SportAdapter(view_listSport);

        view_listSport.setAdapter(sportAdapter);

        return rootView;
    }

    private static class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder> {

        private static final int UNSELECTED = -1;
        private static List<Sport> sports = Sport.wishes;
        private RecyclerView recyclerView;
        private int selectedItem = UNSELECTED;

        public SportAdapter(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        @Override
        public SportAdapter.SportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.wish, parent, false);
            return new SportAdapter.SportViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(SportAdapter.SportViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return sports.size();
        }

        public class SportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
            private ExpandableLayout expandableLayout;
            private LinearLayout header;
            private TextView headerName;
            private TextView headerSlotTime;
            private TextView rank;

            private TextView description;
            private TextView teacher;
            private TextView studentSlot;
            private Button delWish;
            private int position;

            public SportViewHolder(View itemView) {
                super(itemView);

                header = (LinearLayout) itemView.findViewById(R.id.wish_header);
                header.setOnClickListener(this);

                headerName = (TextView) itemView.findViewById(R.id.wish_header_title);
                headerSlotTime = (TextView) itemView.findViewById(R.id.wish_header_slot);
                rank = (TextView) itemView.findViewById(R.id.rank);

                expandableLayout = (ExpandableLayout) itemView.findViewById(R.id.wish_expandable_layout);
                expandableLayout.setInterpolator(new OvershootInterpolator());
                expandableLayout.setOnExpansionUpdateListener(this);

                description = (TextView) itemView.findViewById(R.id.wish_description);
                teacher = (TextView) itemView.findViewById(R.id.wish_teacher);
                studentSlot = (TextView) itemView.findViewById(R.id.wish_slot);
                //sportMap = (MapView) itemView.findViewById(R.id.sportMap);

                delWish = (Button) itemView.findViewById(R.id.delWish);
                delWish.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        onClickButton(v);
                    }
                });
            }

            public void bind(int position) {
                this.position = position;
                header.setSelected(false);

                headerName.setText(SportAdapter.this.sports.get(position).getName());
                headerSlotTime.setText(SportAdapter.this.sports.get(position).getTimeSlot());
                Log.d("test rank", ""+position);
                int r = position+1;
                rank.setText(""+r);

                description.setText("Description : " + SportAdapter.this.sports.get(position).getShortDescription());
                teacher.setText("Professeur : " + SportAdapter.this.sports.get(position).getTeacher());
                studentSlot.setText(SportAdapter.this.sports.get(position).slotToString());

                expandableLayout.collapse(false);
            }

            @Override
            public void onClick(View view) {
                SportAdapter.SportViewHolder holder = (SportAdapter.SportViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
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
                SportAdapter.SportViewHolder holder = (SportAdapter.SportViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
                if (holder != null) {
                    holder.header.setSelected(false);
                    holder.expandableLayout.collapse();
                }
                selectedItem = UNSELECTED;

                sports.get(position).unsubscribe(position);
                //studentSlot.setText(SportAdapter.this.sports.get(position).slotToString());
            }
        }
    }
}
