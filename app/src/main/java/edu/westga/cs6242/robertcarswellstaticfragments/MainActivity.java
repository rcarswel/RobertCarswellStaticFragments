package edu.westga.cs6242.robertcarswellstaticfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements DataEntryFragment.DataEntryListener,
        DataDisplayFragment.DataDisplayListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataEntry(Double number1, Double number2) {
        DataDisplayFragment displayFragment = (DataDisplayFragment)
                getSupportFragmentManager().findFragmentById(R.id.dataDisplayFragment);
        displayFragment.setNumber1(number1);
        displayFragment.setNumber2(number2);
        displayFragment.multiply();
        displayFragment.displayProduct();
    }

    @Override
    public void onDataDisplay(Double number1, Double number2) {
        DataAdditionFragment additionFragment = (DataAdditionFragment)
                getSupportFragmentManager().findFragmentById(R.id.dataAdditionFragment);
        additionFragment.setNumber1(number1);
        additionFragment.setNumber2(number2);
        additionFragment.addition();
        additionFragment.displayAddition();
    }
}
