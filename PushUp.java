package com.example.android.apis.view;

// Need the following import to get access to the app resources, since this
// class is in a sub-package.
import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ViewFlipper;


public class PushUp extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_2);
        ViewFlipper mFlipper;
        mFlipper = ((ViewFlipper) this.findViewById(R.id.flipper));
        
        mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_up_in));
        
        mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_up_out));
        
        mFlipper.startFlipping();
    }
}



pushup.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout>
    <ViewFlipper android:id="@+id/flipper"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:flipInterval="2000"
        android:layout_marginBottom="20dip" >
                <TextView
                        android:text="@string/animation_2_text_1"/>
                <TextView
                        android:text="@string/animation_2_text_2"/>
                <TextView
                        android:text="@string/animation_2_text_3"/>
                <TextView
                        android:text="@string/animation_2_text_4"/>
    </ViewFlipper>
</LinearLayout>



anim/push_up_in.xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
	<translate
            android:fromYDelta="100%p"
            android:toYDelta="0"
            android:duration="300"/>
	<alpha
            android:fromAlpha="0.0"
            android:toAlpha="1.0"
            android:duration="300" />
</set>




anim/push_up_in.xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
	<translate
            android:fromYDelta="0"
            android:toYDelta="-100%p"
            android:duration="300"/>
	<alpha
            android:fromAlpha="1.0"
            android:toAlpha="0.0"
            android:duration="300" />
</set>
