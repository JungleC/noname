package ua.com.alc.alcotaste;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


/**
 * Created by vanya on 16.10.2015.
 */
public class SearchActivity extends AppCompatActivity  {
    MenuItem mSearchItem = null;
    MenuItem mSortItem = null;
    Menu mMenu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_search);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.transition.activity_animation_close_search,
                R.transition.activity_animation_open_search_scale_alpha);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mMenu =  menu;
        getMenuInflater().inflate(R.menu.nemu_search_activity, menu);
        mSearchItem = menu.findItem(R.id.action_search);
        MenuItemCompat.setOnActionExpandListener(mSearchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                if(item == mSearchItem) {
                    mMenu.setGroupVisible(R.id.group_delete,false);
                    return true;
                }
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                if(item == mSearchItem) {
                    mMenu.setGroupVisible(R.id.group_delete, true);
                    return true;
                }
                return false;
            }
        });

        /*View sortItemView = mSortItem.getActionView();
        YoYo.with(Techniques.Tada)
                .duration(700)
                .playOn(sortItemView);
        */
        return super.onCreateOptionsMenu(menu);
    }


}
