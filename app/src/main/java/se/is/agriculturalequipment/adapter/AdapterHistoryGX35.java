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

/**
 * Created by BlackClover on 10/31/2017.
 */

public class AdapterHistoryGX35 extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<GX35> gx35Items;

    public AdapterHistoryGX35(Context context, List<GX35> gx35Items) {
        this.context = context;
        this.gx35Items = gx35Items;
    }

    @Override
    public int getCount() {
        return gx35Items.size();
    }

    @Override
    public Object getItem(int position) {
        return gx35Items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GX35 gx35 = gx35Items.get(position);
        TextView txtName;
        TextView txtBuyDate;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.listview_history, null);

        txtName = (TextView) view.findViewById(R.id.txtName);
        txtBuyDate = (TextView) view.findViewById(R.id.txtBuyDate);

        txtName.setText(gx35.getName());
        txtBuyDate.setText(gx35.getBuyDate());

        return null;
    }
}
