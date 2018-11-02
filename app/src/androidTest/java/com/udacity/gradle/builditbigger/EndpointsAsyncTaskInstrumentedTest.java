package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskInstrumentedTest {
    public static final String TAG = EndpointsAsyncTaskInstrumentedTest.class.getSimpleName();
    @Rule
    public ActivityTestRule mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkAsyncTaskReturnsNonEmptyString(){
        String result = new EndpointsAsyncTask().doInBackground(mActivityTestRule.getActivity());
        Log.i(TAG, "checkAsyncTaskReturnsNonEmptyString: "+result);
        assertNotNull(result);
    }
}
