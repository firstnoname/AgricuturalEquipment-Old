package se.is.agriculturalequipment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by iFirst on 2/15/2017 AD.
 */

public class AdapterEstimated extends BaseAdapter {

    private Context objContext;
    private String[] nameString;
    private String[] repairPrice;

    public AdapterEstimated(Context objContext, String[] nameString, String[] repairPrice) {
        this.objContext = objContext;
        this.nameString = nameString;
        this.repairPrice = repairPrice;
    }

    @Override
    public int getCount() {
        return nameString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = objLayoutInflater.inflate(R.layout.listview_g200, parent, false);

        TextView tvPartName = (TextView) view.findViewById(R.id.txtPartName);
        TextView tvPrice = (TextView) view.findViewById(R.id.txtPartPrice);

        tvPartName.setText(nameString[position]);
        tvPrice.setText(repairPrice[position]);

        return view;
    }
}
