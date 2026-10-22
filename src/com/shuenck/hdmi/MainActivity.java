package com.shuenck.hdmi;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final String HDMI_PKG = "com.softwinner.awlivetv";
    private static final String HDMI_CLASS = "com.softwinner.awlivetv.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(new ComponentName(HDMI_PKG, HDMI_CLASS));
        startActivity(intent);
    }
}
