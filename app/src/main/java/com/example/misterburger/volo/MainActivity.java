package com.example.misterburger.volo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.misterburger.volo.Fragments.FirstFragment;
import com.example.misterburger.volo.Fragments.FlagOfFragment;
import com.example.misterburger.volo.Fragments.NewGameFragment;
// app:srcCompat="@android:drawable/ic_dialog_email" />

public class MainActivity extends AppCompatActivity {

    FirstFragment firstFragment;
    NewGameFragment newGameFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firstFragment = new FirstFragment();
        newGameFragment = new NewGameFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment,new FirstFragment())
                .commit();
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

    public void getFragment(FlagOfFragment flag) {
        switch (flag) {
            case FIRST_FRAGMENT:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment,firstFragment)
                        .commit();
                break;
            case NEW_GAME_FRAGMENT:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, newGameFragment)
                        .commit();
                break;
            case GAME_FRAGMENT:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new ClassFragment())
                        .commit();
                break;

        }
    }

}
