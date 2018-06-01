package se.is.agriculturalequipment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.model.User;

/**
 * Created by BlackClover on 11/2/2017.
 */

public class AdapterUserList extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    private List<User> userItems;

    public AdapterUserList(Context context, List<User> userItems) {
        this.userItems = userItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userItems.size();
    }

    @Override
    public User getItem(int position) {
        return userItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = userItems.get(position);
        TextView txtNameUser;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.listview_user, null);

        txtNameUser = (TextView) v.findViewById(R.id.txtNameUser);
        txtNameUser.setText(user.getNameUser());


        return v;
    }
}
