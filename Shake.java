package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Shake extends Activity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shake);

        View loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        findViewById(R.id.pw).startAnimation(shake);
    }

}



shake.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout>
    <EditText android:id="@+id/pw" />
    <Button android:id="@+id/login" />
</LinearLayout>



anim/shake.xml
<?xml version="1.0" encoding="utf-8"?>
<translate
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:fromXDelta="0"
        android:toXDelta="10"
        android:duration="1000"
        android:interpolator="@anim/cycle_7" />
        
        
        
        
anim/cycle_7.xml
<?xml version="1.0" encoding="utf-8"?>
<cycleInterpolator
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:cycles="7" />
