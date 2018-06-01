package se.is.agriculturalequipment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
 * Created by iFirst on 12/20/16.
 */

public class MyAdapter extends BaseAdapter {

    private Context objContext;
    private String[] nameString, priceString;

    public MyAdapter(Context objContext, String[] nameString, String[] priceString) {
        this.objContext = objContext;
        this.nameString = nameString;
        this.priceString = priceString;
    }

    @Override
    public int getCount() {
        return nameString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view1 = objLayoutInflater.inflate(R.layout.listview_g200, viewGroup, false);

        TextView partNameTxtView = (TextView) view1.findViewById(R.id.txtPartName);
        partNameTxtView.setText(nameString[i]);

        TextView partPriceTxtView = (TextView) view1.findViewById(R.id.txtPartPrice);
        partPriceTxtView.setText(priceString[i]);

        return view1;
    }
}//Class.
