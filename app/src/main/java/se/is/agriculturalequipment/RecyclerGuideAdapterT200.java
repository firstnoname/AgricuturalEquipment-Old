package se.is.agriculturalequipment;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iFirst on 6/9/2018.
 */

class RecyclerGuideAdapterT200 extends RecyclerView.Adapter<RecyclerGuideAdapterT200.ViewHolder> {

    private int[] guideExplainsT200 = {
            R.string.t200_guide_engine,
            R.string.t200_guide_starter,
            R.string.t200_guide_fuel_tank,
            R.string.t200_guide_control_switch,
            R.string.t200_guide_brush_cutter_blade,
            R.string.t200_guide_air_filter,
            R.string.t200_guide_carburetor,
            R.string.t200_guide_cylinder_set,
            R.string.t200_guide_ball_valve_switch_oil,
            R.string.t200_guide_muffler,
            R.string.t200_guide_gear_diver,
            R.string.t200_guide_main_pipe,
            R.string.t200_guide_switch_onoff,
            R.string.t200_guide_coil,
            R.string.t200_guide_fuel_tank_cap,
            R.string.t200_guide_new_paint,
            R.string.t200_guide_shaft,
            R.string.t200_guide_oil_tank_cap
    };

    private int[] guideImageT200L = {
            0,
            R.drawable.t200_starter_change,
            R.drawable.t200_fueltank_change,
            R.drawable.t200_controlswitch_change,
            R.drawable.t200_brushcutterblade_change,
            R.drawable.t200_airfilter_change,
            R.drawable.t200_carnurater_change,
            0,
            R.drawable.t200_ballvalveswitch_change,
            R.drawable.t200_muffler_change,
            R.drawable.t200_geardiver_change,
            R.drawable.t200_mainpipe_change,
            0,
            0,
            R.drawable.t200_fueltankcap_change,
            0,
            0,
            0
    };

    private int[] guideImageT200R = {
            0,
            R.drawable.t200_starter_not,
            R.drawable.t200_fueltank_not,
            R.drawable.t200_controlswitch_not,
            R.drawable.t200_brushcutterblade_not,
            R.drawable.t200_airfilter_not,
            R.drawable.t200_carnurater_not,
            0,
            R.drawable.t200_ballvalveswitch_not,
            R.drawable.t200_muffler_not,
            R.drawable.t200_geardiver_not,
            R.drawable.t200_mainpipe_not,
            0,
            0,
            R.drawable.t200_fueltankcap_not,
            0,
            0,
            0
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imgGuideL.setImageResource(guideImageT200L[position]);
        holder.imgGuideR.setImageResource(guideImageT200R[position]);
        holder.txtGuide.setText(guideExplainsT200[position]);
    }

    @Override
    public int getItemCount() {
        return guideExplainsT200.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgGuideL, imgGuideR;
        public TextView txtGuide;

        public ViewHolder(View itemView) {
            super(itemView);
            imgGuideL = (ImageView) itemView.findViewById(R.id.imgGuideL);
            imgGuideR = (ImageView) itemView.findViewById(R.id.imgGuideR);
            txtGuide = (TextView) itemView.findViewById(R.id.txtViewGuideExplain);

        }
    }
}
