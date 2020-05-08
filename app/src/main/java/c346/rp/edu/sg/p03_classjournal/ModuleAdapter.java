package c346.rp.edu.sg.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {
    private ArrayList<Module> modules;
    private Context context;
    private TextView tvCode, tvModuleName;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        modules = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_module, parent, false);
        tvCode = (TextView)rowView.findViewById(R.id.tvCode);
        tvModuleName = (TextView) rowView.findViewById(R.id.tvModuleName);
        Module currentModule = modules.get(position);
        tvCode.setText(currentModule.getCode());
        tvModuleName.setText(currentModule.getModuleName());
        return rowView;
    }
}
