package com.u3206384.oneuldiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DiaryContentAdapter extends ArrayAdapter<DiaryContent> {
    ArrayList<DiaryContent> contents;

    public DiaryContentAdapter(Context context, int resource, ArrayList<DiaryContent> objects){
        super(context, resource, objects);
        contents = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }

        DiaryContent content = contents.get(position);

//        ImageView icon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
//        icon.setImageResource(R.mipmap.ic_launcher);

        TextView textDate = (TextView) convertView.findViewById(R.id.textDate);
        textDate.setText(content.getDate());

        TextView textTitle = (TextView) convertView.findViewById(R.id.textTitle);
        textTitle.setText(content.getTitle());

        return convertView;
    }

}
