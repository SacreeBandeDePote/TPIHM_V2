package ihm.lsbdp.insa.eps_insa.student.before;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import ihm.lsbdp.insa.eps_insa.R;

/**
 * Created by perewoulpy on 12/11/17.
 */

public class SportExpandAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Sport> sportList;

    public SportExpandAdapter(Context context, List<Sport> sportList) {
        this.context = context;
        this.sportList = sportList;
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public SportDetail getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.sport, parent, false);
        }

        TextView sportName = (TextView) v.findViewById(R.id.sport_name);
        TextView sportShortDesc = (TextView) v.findViewById(R.id.sport_short_desc);

        Sport cat = sportList.get(groupPosition);

        sportName.setText(cat.getName());
        sportShortDesc.setText(cat.getShortDescription());

        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.sport_detail, parent, false);
        }

        TextView sportDescr = (TextView) v.findViewById(R.id.sport_detail_desc);
        TextView sportLoc = (TextView) v.findViewById(R.id.sport_detail_location);

        SportDetail det = sportList.get(groupPosition).getDetail();

        sportLoc.setText(det.getLocation());
        sportDescr.setText(det.getDescription());

        return v;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
