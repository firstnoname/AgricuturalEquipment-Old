package se.is.agriculturalequipment;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iFirst on 6/9/2018.
 */

class RecyclerGuideAdapterTM31 extends RecyclerView.Adapter<RecyclerGuideAdapterTM31.ViewHolder> {

    private int[] guideExplainsTM31 = {
            R.string.tm31_guide_engine,
            R.string.tm31_guide_air_chamber,
            R.string.tm31_guide_seal_set,
            R.string.tm31_guide_adjust_set,
            R.string.tm31_guide_discharge_metal,
            R.string.tm31_guide_suction_metal,
            R.string.tm31_guide_piston_set,
            R.string.tm31_guide_starter_rope_reel,
            R.string.tm31_guide_pressure_gauge,
            R.string.tm31_guide_ball_valve_switch,
            R.string.tm31_guide_oil_filter,
            R.string.tm31_guide_new_paint,
            R.string.tm31_guide_oil_tank_cap
    };

    private int[] guideImageTM31L = {
            0,
            R.drawable.tm31_airchamber_change,
            0,
            R.drawable.tm31_adjustset_change,
            R.drawable.tm31_dischargemetal_change,
            R.drawable.tm31_suctionmetal_change,
            R.drawable.tm31_pistonset_change,
            R.drawable.tm31_starterropereel_change,
            R.drawable.tm31_pressuregauge_change,
            R.drawable.tm31_ballvalveswitch_change,
            0,
            0,
            0
    };

    private int[] guideImageTM31R = {
            0,
            R.drawable.tm31_airchamber_not,
            0,
            R.drawable.tm31_adjustset_not,
            R.drawable.tm31_dischargemetal_not,
            R.drawable.tm31_suctionmetal_not,
            R.drawable.tm31_pistonset_not,
            R.drawable.tm31_starterropereel_not,
            R.drawable.tm31_pressuregauge_not,
            R.drawable.tm31_ballvalveswitch_not,
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
        holder.imgGuideL.setImageResource(guideImageTM31L[position]);
        holder.imgGuideR.setImageResource(guideImageTM31R[position]);
        holder.txtGuide.setText(guideExplainsTM31[position]);
    }

    @Override
    public int getItemCount() {
        return guideExplainsTM31.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgGuideL, imgGuideR;
        public TextView txtGuide;

        public ViewHolder(View itemView){
            super(itemView);
            imgGuideR = (ImageView) itemView.findViewById(R.id.imgGuideR);
            imgGuideL = (ImageView) itemView.findViewById(R.id.imgGuideL);
            txtGuide = (TextView) itemView.findViewById(R.id.txtViewGuideExplain);
        }
    }
}
