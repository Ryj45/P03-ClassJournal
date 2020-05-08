package c346.rp.edu.sg.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    TextView tvWeek;
    RadioGroup rgGrade;
    RadioButton rbGrade;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        rgGrade = (RadioGroup)findViewById(R.id.rgGrade);
        int selectButtonId = rgGrade.getCheckedRadioButtonId();
        rbGrade = (RadioButton)findViewById(selectButtonId);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        tvWeek = (TextView)findViewById(R.id.tvWeek);

        Intent addIntent = getIntent();
        String week = "Week" + addIntent.putExtra("week", 0);

        tvWeek.setText(week);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dg dgAdd = new Dg((String)rbGrade.getText());
                Intent addBack = new Intent();
                addBack.putExtra("dgAdd", dgAdd);
                setResult(RESULT_OK, addBack);
                finish();
            }
        });
    }
}
