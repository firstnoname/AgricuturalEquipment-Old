package se.is.agriculturalequipment;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iFirst on 6/8/2018.
 */

public class RecyclerGuideAdapterGX35 extends RecyclerView.Adapter<RecyclerGuideAdapterGX35.ViewHolder> {

    private int[] guideExplainsGX35 = {
            R.string.gx35_guide_engine,
            R.string.gx35_guide_starter,
            R.string.gx35_guide_fuel_tank,
            R.string.gx35_guide_control_switch,
            R.string.gx35_guide_brush_cutter_blade,
            R.string.gx35_guide_air_filter,
            R.string.gx35_guide_carburetor,
            R.string.gx35_guide_cylinder_set,
            R.string.gx35_guide_ball_valve_switch_oil,
            R.string.gx35_guide_muffler,
            R.string.gx35_guide_gear_diver,
            R.string.gx35_guide_main_pipe,
            R.string.gx35_guide_switch_onoff,
            R.string.gx35_guide_coil,
            R.string.gx35_guide_fuel_tank_cap,
            R.string.gx35_guide_new_paint,
            R.string.gx35_guide_shaft,
            R.string.gx35_guide_oil_tank_cap,
            R.string.gx35_guide_spark_plug
    };

    private int[] guideImageGX35L = {
            0,
            R.drawable.gx35_starter_change,
            R.drawable.gx35_fueltank_change,
            R.drawable.gx35_controlswitch_change,
            R.drawable.gx35_brushcutterblade_change,
            R.drawable.gx35_airfilter_change,
            R.drawable.gx35_carburater_change,
            0,
            R.drawable.gx35_ballvalveswitch_change,
            R.drawable.gx35_muffler_change,
            R.drawable.gx35_geardiver_change,
            R.drawable.gx35_mainpipe_change,
            0,
            0,
            R.drawable.gx35_fueltankcap_change,
            0,
            0,
            0,
            R.drawable.gx35_sparkplug_change
    };

    private int[] guideImageGX35R = {
            0,
            R.drawable.gx35_starter_not,
            R.drawable.gx35_fueltank_not,
            R.drawable.gx35_controlswitch_not,
            R.drawable.gx35_brushcutterblade_not,
            R.drawable.gx35_airfilter_not,
            R.drawable.gx35_carburater_not,
            0,
            R.drawable.gx35_ballvalveswitch_not,
            R.drawable.gx35_muffler_not,
            R.drawable.gx35_geardiver_not,
            R.drawable.gx35_mainpipe_not,
            0,
            0,
            R.drawable.gx35_fueltankcap_not,
            0,
            0,
            0,
            R.drawable.gx35_sparkplug_not
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
        holder.imgGuideL.setImageResource(guideImageGX35L[position]);
        holder.imgGuideR.setImageResource(guideImageGX35R[position]);
        holder.txtGuide.setText(guideExplainsGX35[position]);
    }

    @Override
    public int getItemCount() {
        return guideExplainsGX35.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgGuideL, imgGuideR;
        public TextView txtGuide;

        public ViewHolder(View itemView){
            super(itemView);
            imgGuideL = (ImageView) itemView.findViewById(R.id.imgGuideL);
            imgGuideR = (ImageView) itemView.findViewById(R.id.imgGuideR);
            txtGuide = (TextView) itemView.findViewById(R.id.txtViewGuideExplain);
        }
    }

}
