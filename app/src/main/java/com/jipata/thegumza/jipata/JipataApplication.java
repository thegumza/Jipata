package com.jipata.thegumza.jipata;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Thegumza on 8/15/2016.
 */
public class JipataApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getResources().getString(R.string.font))
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

}
