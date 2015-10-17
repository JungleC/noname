package ua.com.alc.alcotaste;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;

/**
 * Created by vanya on 16.10.2015.
 */
public class SearchActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
       // setupWindowAnimations();
    }
    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.transition.activity_close_search,
                R.transition.activity_animation_open_search_scale_alpha);
    }
}
