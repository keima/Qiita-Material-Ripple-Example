package net.pside.android.example.material;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Activity self = this;

    public static final int NUMBER_OF_BUTTONS = 3;

    int[] buttonIds = {
            R.id.button01,
            R.id.button02,
            R.id.button03,
    };

    private int[] resIds = {
            R.layout.activity_step1,
            R.layout.activity_step2,
            R.layout.activity_step3,
    };

    Button[] buttons = new Button[NUMBER_OF_BUTTONS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
            buttons[i] = (Button) findViewById(buttonIds[i]);
            buttons[i].setTag(i);
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("MainActivity", "Click");
                    startActivity(
                            PreviewActivity.createIntent(MainActivity.this, resIds[(Integer)view.getTag()])
                    );
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
