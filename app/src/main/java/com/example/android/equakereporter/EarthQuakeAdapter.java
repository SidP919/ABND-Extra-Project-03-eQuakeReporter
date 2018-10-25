package com.example.android.equakereporter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    public EarthQuakeAdapter(Context context, ArrayList<EarthQuake> earthQuakeArrayList) {
        super(context, 0, earthQuakeArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
            holder = new ViewHolder();
            holder.magTextView = listItemView.findViewById(R.id.earthQuakeListItem_textView_eMag);
            holder.placeTextViewA = listItemView.findViewById(R.id.earthQuakeListItem_textView_ePlaceA);
            holder.placeTextViewB = listItemView.findViewById(R.id.earthQuakeListItem_textView_ePlaceB);
            holder.dateTextView = listItemView.findViewById(R.id.earthQuakeListItem_textView_eDate);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        EarthQuake earthQuake = getItem(position);


        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String mag = decimalFormat.format(earthQuake != null ? earthQuake.geteMag() : 0.0);

        String place = earthQuake.getePlace();
        int indexOfOf = place.indexOf("of");
        String placeA;
        String placeB;
        if (indexOfOf == -1) {
            placeA = "Near the ";
            placeB = place;
        } else {
            placeA = place.substring(0, indexOfOf + 2);
            placeB = place.substring(indexOfOf + 3, place.length());
        }

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) holder.magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthQuake.geteMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        holder.magTextView.setText(mag);
        holder.placeTextViewA.setText(placeA);
        holder.placeTextViewB.setText(placeB);
        holder.dateTextView.setText(earthQuake.geteDate());

        return listItemView;
    }

    private int getMagnitudeColor(double v) {
        if (v > 10) {
            return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        } else if (v > 9) {
            return ContextCompat.getColor(getContext(), R.color.magnitude9);
        } else if (v > 8) {
            return ContextCompat.getColor(getContext(), R.color.magnitude8);
        } else if (v > 7) {
            return ContextCompat.getColor(getContext(), R.color.magnitude7);
        } else if (v > 6) {
            return ContextCompat.getColor(getContext(), R.color.magnitude6);
        } else if (v > 5) {
            return ContextCompat.getColor(getContext(), R.color.magnitude5);
        } else if (v > 4) {
            return ContextCompat.getColor(getContext(), R.color.magnitude4);
        } else if (v > 3) {
            return ContextCompat.getColor(getContext(), R.color.magnitude3);
        } else if (v > 2) {
            return ContextCompat.getColor(getContext(), R.color.magnitude2);
        } else {
            return ContextCompat.getColor(getContext(), R.color.magnitude1);
        }
    }

    static class ViewHolder {
        private TextView magTextView;
        private TextView placeTextViewA;
        private TextView placeTextViewB;
        private TextView dateTextView;
    }

}
