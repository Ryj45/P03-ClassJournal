package c346.rp.edu.sg.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayAdapter aaModule;
    ArrayList<Module> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = (ListView)this.findViewById(R.id.lvModule);
        modules = new ArrayList<Module>();

        ArrayList<Dg> c347 = new ArrayList<Dg>();
        c347.add(new Dg("B"));
        c347.add(new Dg("C"));
        c347.add(new Dg("A"));
        modules.add(new Module("C347","Android Programming II", c347));

        ArrayList<Dg> c302 = new ArrayList<Dg>();
        c302.add(new Dg("A"));
        c302.add(new Dg("C"));
        modules.add(new Module("C302", "Web Services", c302));

        aaModule = new ModuleAdapter(this, R.layout.row_module, modules);
        lvModule.setAdapter(aaModule);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module selectedModule = modules.get(position);
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("moduleIndex", position);
                i.putExtra("code", selectedModule.getCode());
                i.putExtra("dg", selectedModule.getDg());
                startActivity(i);
            }
        });
    }
}
