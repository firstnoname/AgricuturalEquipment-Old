package se.is.agriculturalequipment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.model.G200;

/**
 * Created by BlackClover on 10/28/2017.
 */

public class AdapterHistoryG200 extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<G200> g200Items;

    public AdapterHistoryG200(Context context, List<G200> g200Items) {
        this.context = context;
        this.g200Items = g200Items;
    }

    @Override
    public int getCount() {
        return g200Items.size();
    }

    @Override
    public Object getItem(int position) {
        return g200Items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        G200 mG200 = g200Items.get(position);
        TextView txtName;
        TextView txtBuyDate;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.listview_history, null);

        txtName = (TextView) view.findViewById(R.id.txtName);
        txtBuyDate = (TextView) view.findViewById(R.id.txtBuyDate);

        txtName.setText(mG200.getName());
        txtBuyDate.setText(mG200.getBuyDate());
        return view;
    }
}
