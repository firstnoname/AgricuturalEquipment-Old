package se.is.agriculturalequipment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import se.is.agriculturalequipment.model.PartList;

/**
 * Created by iFirst-PC on 1/11/2560.
 */

public class ListviewAdapterSettingList extends BaseAdapter {

    private static Activity activity;
    ArrayList<PartList> mPartLists;
    private LayoutInflater inflater;

    public ListviewAdapterSettingList(ArrayList<PartList> mPartLists, Activity activity) {
        this.mPartLists = mPartLists;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mPartLists.size();
    }

    @Override
    public PartList getItem(int position) {
        return mPartLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mPartLists.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        v = inflater.inflate(R.layout.setting_partlist_layout, null);

        TextView txtName = (TextView) v.findViewById(R.id.txtName);
        TextView txtPrice = (TextView) v.findViewById(R.id.txtPrice);

        PartList partList = mPartLists.get(position);

        txtName.setText(partList.getPartname());
        txtPrice.setText(partList.getPartPrice());

        return v;
    }
}
