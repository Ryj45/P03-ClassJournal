package c346.rp.edu.sg.p03_classjournal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvDG;
    ArrayAdapter aaDG;
    ArrayList<Dg> dg;
    Button btnInfo, btnAdd, btnEmail;
    int requestCodeForModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEmail = (Button) findViewById(R.id.btnEmail);

        lvDG = (ListView) findViewById(R.id.lvDG);
        Intent i = getIntent();

        dg = (ArrayList<Dg>) i.getSerializableExtra("dg");

        aaDG = new DgAdapter(this, R.layout.row_dg, dg);
        lvDG.setAdapter(aaDG);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoIntent = new Intent(Intent.ACTION_VIEW);
                infoIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(infoIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                addIntent.putExtra("week", (dg.size()+1));
                startActivityForResult(addIntent,requestCodeForModule);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Hi faci, \nI am ...\nPlease see my remarks so far, thank you!" +
                        "\n\n";
                for (int i = 0; i < dg.size(); i++){
                    msg += "Week " + (i+1) + ": DG: " + dg.get(i).getGrade();
                }

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                emailIntent.putExtra(Intent.EXTRA_TEXT, msg);
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Choose an Email client: "));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(data != null){
                Dg newDg = (Dg) data.getSerializableExtra("dgAdd");
                dg.add(newDg);
                
                aaDG.notifyDataSetChanged();
            }
        }
    }
}
