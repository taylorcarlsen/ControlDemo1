package edu.fvtc.controldemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myDebug";
    Button btnDisplay;
    Button btnClear;
    Button btnShow;
    CheckBox cbCheckbox;
    RadioButton rbRadioButton;
    ImageView imgFood;
    TextView textView;
    EditText editText;


    int[] imgIds = {-1, R.drawable.fish, R.drawable.shrimp, R.drawable.lobster};

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

        /*cbCheckbox.setOnCheckedChangeListener(this); //method at the activity level to run code below
        rbRadioButton.setOnCheckedChangeListener(this); //shares the same code as above*/

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick");
                textView.setText(editText.getText().toString());
                textView.setTextColor(getColor(R.color.colorWhite));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });

        cbCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int id = buttonView.getId();

                if(isChecked){
                    Log.d(TAG, id + " : Checked");
                }
                else{
                    Log.d(TAG, id + " : Not checked");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        Toast.makeText(this, "onCreateOptionsMenu",Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu); // puts xml into the menu

        /*
        menu.clear();

        MenuItem menuItem = menu.add(Menu.NONE, 1, Menu.NONE, "Fish");
        menuItem.setIcon(R.drawable.fish);

        menuItem.setShowAsActionFlags(menuItem.SHOW_AS_ACTION_WITH_TEXT | menuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem menuItem1 = menu.add(Menu.NONE, 2, Menu.NONE, "Shrimp");
        menuItem.setIcon(R.drawable.shrimp);

        MenuItem menuItem2 = menu.add(Menu.NONE, 3, Menu.NONE, "Lobster");
        menuItem.setIcon(R.drawable.lobster);
        */

        super.onPrepareOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        try
        {
            // get the id of the menu item selected
            int id = item.getItemId();

            imgFood.setImageResource(imgIds[id]);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public void ShowName(View v)
    {
        String format = getString(R.string.format);
        String name = String.format(format, TextUtils.htmlEncode(textView.getText().toString()));
        Log.d(TAG, name);
        Spanned spanned = Html.fromHtml(name, Html.FROM_HTML_MODE_LEGACY);
        textView.setText(spanned);
    }

    /*
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();

        if(isChecked){
            Log.d(TAG, id + " : Checked");
        }
        else{
            Log.d(TAG, id + " : Not checked");
        }
    }
*/
}

