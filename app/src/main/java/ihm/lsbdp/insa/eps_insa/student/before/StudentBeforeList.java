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
import android.widget.TextView;

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

    private static class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder> {
        private static String[] sport = {"Tennis", "Rugby", "Danse", "Escalade"};
        private static String[] detailList = {"Tennis", "Rugby", "Danse", "Escalade"};
        private static final int UNSELECTED = -1;

        private RecyclerView recyclerView;
        private int selectedItem = UNSELECTED;

        public SportAdapter(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sport, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return sport.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
            private ExpandableLayout expandableLayout;
            private TextView sport;
            private TextView detail;
            private int position;

            public ViewHolder(View itemView) {
                super(itemView);

                expandableLayout = (ExpandableLayout) itemView.findViewById(R.id.expandable_layout);
                expandableLayout.setInterpolator(new OvershootInterpolator());
                expandableLayout.setOnExpansionUpdateListener(this);
                sport = (TextView) itemView.findViewById(R.id.sport_header);

                sport.setOnClickListener(this);

                detail = (TextView) itemView.findViewById(R.id.detail);
            }

            public void bind(int position) {
                this.position = position;

                sport.setText(SportAdapter.this.sport[position]);

                sport.setSelected(false);

                detail.setText(SportAdapter.this.detailList[position]);
                expandableLayout.collapse(false);
            }

            @Override
            public void onClick(View view) {
                ViewHolder holder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
                if (holder != null) {
                    holder.sport.setSelected(false);
                    holder.expandableLayout.collapse();
                }

                if (position == selectedItem) {
                    selectedItem = UNSELECTED;
                } else {
                    sport.setSelected(true);
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

    private void loadData() {
    }
}
