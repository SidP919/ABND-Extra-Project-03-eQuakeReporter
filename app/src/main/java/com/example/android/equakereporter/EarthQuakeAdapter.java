package com.example.android.equakereporter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    public EarthQuakeAdapter(Context context, ArrayList<EarthQuake> earthQuakeArrayList) {
        super(context, 0, earthQuakeArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
            holder = new ViewHolder();
            holder.magTextView = listItemView.findViewById(R.id.earthQuakeListItem_textView_eMag);
            holder.placeTextView = listItemView.findViewById(R.id.earthQuakeListItem_textView_ePlace);
            holder.dateTextView = listItemView.findViewById(R.id.earthQuakeListItem_textView_eDate);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        EarthQuake earthQuake = getItem(position);

        holder.magTextView.setText("" + earthQuake.geteMag());
        holder.placeTextView.setText(earthQuake.getePlace());
        holder.dateTextView.setText(earthQuake.geteDate());

        return listItemView;
    }

    static class ViewHolder {
        private TextView magTextView;
        private TextView placeTextView;
        private TextView dateTextView;
    }

}
