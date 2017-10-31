package se.is.agriculturalequipment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.model.GX35;
import se.is.agriculturalequipment.model.TM31;

/**
 * Created by BlackClover on 10/31/2017.
 */

public class AdapterHistoryTM31 extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<TM31> tm31Items;

    public AdapterHistoryTM31(Context context, List<TM31> tm31Items) {
        this.context = context;
        this.tm31Items = tm31Items;
    }

    @Override
    public int getCount() {
        return tm31Items.size();
    }

    @Override
    public Object getItem(int position) {
        return tm31Items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TM31 edtTM31 = tm31Items.get(position);
        TextView txtName;
        TextView txtBuyDate;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.listview_history,null);

        txtName = (TextView) view.findViewById(R.id.txtName);
        txtBuyDate = (TextView) view.findViewById(R.id.txtBuyDate);

        txtName.setText(edtTM31.getName());
        txtBuyDate.setText(edtTM31.getBuyDate());

        return view;
    }
}
