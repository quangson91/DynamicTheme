package com.vnzit.dynamictheme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sh on 8/22/16.
 */
public abstract class BaseActivity extends AppCompatActivity{

    public static final int DARK_THEME = 0;
    public static final int LIGHT_THEME = 1;
    private static int sCurrentTheme = LIGHT_THEME;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyTheme();
    }

    protected void switchTheme() {
        if (sCurrentTheme == DARK_THEME) {
            sCurrentTheme = LIGHT_THEME;
        } else {
            sCurrentTheme = DARK_THEME;
        }
        finish();
        startActivity(new Intent(this, getClass()));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    protected void applyTheme() {
        switch (sCurrentTheme) {
            default:
            case LIGHT_THEME:
                setTheme(R.style.AppTheme_Light);
                break;
            case DARK_THEME:
                setTheme(R.style.AppTheme);
                break;
        }
    }
}
