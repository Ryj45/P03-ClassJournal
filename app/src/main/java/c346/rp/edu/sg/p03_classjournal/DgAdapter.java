package c346.rp.edu.sg.p03_classjournal;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DgAdapter extends ArrayAdapter {

    private ArrayList<Dg> dg;
    private Context context;
    private TextView tvWeekDisplay;
    private TextView tvDG;

    public DgAdapter(Context context, int resource, ArrayList<Dg> objects){
        super(context, resource, objects);
        dg = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_dg, parent, false);
        tvWeekDisplay = (TextView) rowView.findViewById(R.id.tvWeekDisplay);
        tvDG = (TextView)rowView.findViewById(R.id.tvDG);
        Dg currentDg = dg.get(position);
        tvWeekDisplay.setText("Week " + (position+1));
        tvDG.setText(currentDg.getGrade());

        return rowView;
    }
}
