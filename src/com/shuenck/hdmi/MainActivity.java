package com.shuenck.hdmi;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final String HDMI_PKG = "com.softwinner.awlivetv";
    private static final String HDMI_CLASS = "com.softwinner.awlivetv.MainActivity";
    private static final String HDMI_SOURCE = "HDMI2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(new ComponentName(HDMI_PKG, HDMI_CLASS));
        intent.putExtra("input_source", HDMI_SOURCE);
        startActivity(intent);
    }
}
