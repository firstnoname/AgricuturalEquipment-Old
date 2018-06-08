package se.is.agriculturalequipment;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BlackClover on 6/8/2018.
 */

class RecyclerGuideAdapter extends RecyclerView.Adapter<RecyclerGuideAdapter.ViewHolder> {

    private int[] guideExplainsG200 = {
            R.string.g200_guide_starter,
            R.string.g200_guide_cylinder
    };

    private int[] guideImageG200L = {
            0,
            R.drawable.g200_starter_change,
            R.drawable.g200_fueltank_change,
            R.drawable.g200_airfilter_change,
            R.drawable.g200_carburetor_change,
            0,
            R.drawable.g200_ballvalveswitchoil_change,
            R.drawable.g200_muffler_change,
            R.drawable.g200_switch_on_off_change,
            R.drawable.g200_fueltankcap_change,
            R.drawable.g200_new_paint_change,
            R.drawable.g200_oil_filter_change,
            R.drawable.g200_spark_plug_change,
    };

    private int[] guideImageG200R = {
            0,
            R.drawable.g200_starter_not,
            R.drawable.g200_fueltank_not,
            R.drawable.g200_airfilter_not,
            R.drawable.g200_carburetor_not,
            0,
            R.drawable.g200_ballvalveswitchoil_not,
            R.drawable.g200_muffler_not,
            R.drawable.g200_switch_on_off_not,
            R.drawable.g200_fueltankcap_not,
            R.drawable.g200_new_paint_not,
            R.drawable.g200_oil_filter_not,
            R.drawable.g200_spark_plug_not
    };

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgGuideL, imgGuideR;
        public TextView txtGuide;

        public ViewHolder(View itemView) {
            super(itemView);
            imgGuideL = (ImageView) itemView.findViewById(R.id.imgGuideL);
            imgGuideR = (ImageView) itemView.findViewById(R.id.imgGuideR);
            txtGuide = (TextView) itemView.findViewById(R.id.txtViewGuideExplain);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click Detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.imgGuideL.setImageResource(guideImageG200L[position]);
        //holder.imgGuideR.setImageResource(guideImageG200R[position]);
        holder.txtGuide.setText(guideExplainsG200[position]);
    }

    @Override
    public int getItemCount() {

        return guideExplainsG200.length;
    }
}
