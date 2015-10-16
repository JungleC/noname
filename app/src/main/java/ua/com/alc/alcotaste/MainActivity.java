package ua.com.alc.alcotaste;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import ua.com.alc.alcotaste.Fragments.FragmentMain;
import ua.com.alc.alcotaste.Fragments.FragmentSearch;
import android.app.Fragment;
import android.app.FragmentManager;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;

public class MainActivity extends AppCompatActivity
        implements FragmentMain.OnFloatingActionButtonListener {

    private static  int sOnBackPressCounter = 0;

    Drawer result = null;
    FragmentManager fragmentManager = null;

    public void onFloatingActionButtonClick() {
        Fragment fragment = new FragmentSearch();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                .replace(R.id.frame_container, fragment)
                 .addToBackStack("myStack")
                .commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }


        result = new DrawerBuilder(this)
                 .withRootView(R.id.drawer_container)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withSavedInstance(savedInstanceState)
                .build();


        Fragment fragment = new FragmentMain();
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment)
                .addToBackStack("myStack")
                .commit();
    }

    @Override
    public void onBackPressed()
    {
        sOnBackPressCounter++;
        if(sOnBackPressCounter == 2){
           super.onBackPressed();
        }
        fragmentManager.popBackStack();

    }
}
