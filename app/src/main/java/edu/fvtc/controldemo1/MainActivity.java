package edu.fvtc.controldemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "myDebug";
    Button btnDisplay;
    Button btnClear;
    Button btnShow;
    CheckBox cbCheckbox;
    RadioButton rbRadioButton;
    ImageView imgFood;
    TextView textView;
    EditText editText;


    int[] imgIds = {-1, R.drawable.fish, R.drawable.lobster, R.drawable.shrimp, R.drawable.shrimp1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.println(Log.DEBUG, TAG, "The activity_main Loaded...");
        Log.d(TAG, "More Logging....");

        Toast.makeText(MainActivity.this, "App Loaded", Toast.LENGTH_LONG).show();

        btnDisplay = findViewById(R.id.btnDisplay);
        btnClear = findViewById(R.id.btnClear);
        btnShow = findViewById(R.id.btnShow);
        cbCheckbox = findViewById(R.id.cbCheckbox);
        rbRadioButton = findViewById(R.id.rbRadioButton);
        imgFood = findViewById(R.id.imgFood);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick");
                textView.setText(editText.getText().toString());
                textView.setTextColor(getColor(R.color.colorWhite));
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
