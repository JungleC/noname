package ua.com.alc.alcotaste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;

public class MainActivity extends AppCompatActivity {
    Drawer result = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        if (toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }
        result = new DrawerBuilder(this)
                //this layout have to contain child layouts
                .withRootView(R.id.drawer_container)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withSavedInstance(savedInstanceState)
                .build();
    }

}
