package se.is.agriculturalequipment;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iFirst on 6/8/2018.
 */

class RecyclerGuideAdapterGX160 extends RecyclerView.Adapter<RecyclerGuideAdapterGX160.ViewHolder> {

        private int[] guideExplainsGX160 = {
                R.string.gx160_guide_engine,
                R.string.gx160_guide_starter,
                R.string.gx160_guide_fuel_tank,
                R.string.gx160_guide_air_filter,
                R.string.gx160_guide_carburetor,
                R.string.gx160_guide_cylinder_set,
                R.string.gx160_guide_ball_valve_switch_oil,
                R.string.gx160_guide_muffler,
                R.string.gx160_guide_switch_onoff,
                R.string.gx160_guide_coil,
                R.string.gx160_guide_fuel_tank_cap,
                R.string.gx160_guide_new_paint,
                R.string.gx160_guide_oil_tank_cap,
                R.string.gx160_guide_spark_plug
        };

        private int[] guideImageGX160L = {
                0,
                R.drawable.gx160_starter_change,
                R.drawable.gx160_fueltank_change,
                R.drawable.gx160_airfilter_change,
                R.drawable.gx160_carburetor_change,
                0,
                R.drawable.gx160_ballvalveswitchoil_change,
                R.drawable.gx160_muffler_change,
                R.drawable.gx160_switch_on_off_change,
                0,
                R.drawable.gx160_fueltankcap_change,
                R.drawable.gx160_new_paint_change,
                R.drawable.gx160_oil_filter_change,
                R.drawable.gx160_spark_plug_change,
        };

        private int[] guideImageGX160R = {
                0,
                R.drawable.gx160_starter_not,
                R.drawable.gx160_fueltank_not,
                R.drawable.gx160_airfilter_not,
                R.drawable.gx160_carburetor_not,
                0,
                R.drawable.gx160_ballvalveswitchoil_not,
                R.drawable.gx160_muffler_not,
                R.drawable.gx160_switch_on_off_not,
                0,
                R.drawable.gx160_fueltankcap_not,
                R.drawable.gx160_new_paint_not,
                R.drawable.gx160_oil_filter_not,
                R.drawable.gx160_spark_plug_not,
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
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Snackbar.make(view, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_adapter_gx160, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imgGuideL.setImageResource(guideImageGX160L[position]);
        holder.imgGuideR.setImageResource(guideImageGX160R[position]);
        holder.txtGuide.setText(guideExplainsGX160[position]);
    }


    @Override
    public int getItemCount() {
        return guideExplainsGX160.length;
    }
}
