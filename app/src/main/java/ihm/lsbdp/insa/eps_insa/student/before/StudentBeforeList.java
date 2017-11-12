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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import ihm.lsbdp.insa.eps_insa.R;

public class StudentBeforeList extends Fragment {

    private LinkedHashMap<String, Sport> team = new LinkedHashMap<String, Sport>();
    private List<Sport> sportList = new ArrayList<Sport>();

    private SportExpandAdapter listAdapter;
    //https://www.survivingwithandroid.com/2013/01/android-expandablelistview-baseexpandablelistadapter.html
    private ExpandableListView expendSportList;

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
        // TO DO: check adapter notion on android

        loadData();

        expendSportList = (ExpandableListView) container.findViewById(R.id.expend_list_sport);
        listAdapter = new SportExpandAdapter(getContext(), sportList);
        if(listAdapter != null)
            expendSportList.setAdapter(listAdapter);
        else
            System.err.println("Error : liste Adapter !!!!");

        expendSportList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                Sport headerInfo = sportList.get(groupPosition);
                //display it or do something with it
                Toast.makeText(getContext(), headerInfo.getName(),
                        Toast.LENGTH_LONG).show();

                return false;
            }
        });
        

        return inflater.inflate(R.layout.activity_student_before_list, container, false);
    }

    private void loadData() {
        SportDetail sd = new SportDetail("blablahlkqsjdflkqjsdhflkqhjsdflkjqhsdflkjhqsldkfhqlksdfqjsdhflkqsdhfl\nsdhfq", "nulpart");
        Sport s = new Sport("Danse", "bla", sd);
        sportList.add(s);
    }
}
