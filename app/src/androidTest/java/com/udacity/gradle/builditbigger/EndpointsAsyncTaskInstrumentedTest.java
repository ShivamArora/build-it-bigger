package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskInstrumentedTest {
    public static final String TAG = EndpointsAsyncTaskInstrumentedTest.class.getSimpleName();
    @Rule
    public ActivityTestRule mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkAsyncTaskReturnsNonEmptyString(){
        String result = null;
        try {
            result = new EndpointsAsyncTask().execute(mActivityTestRule.getActivity()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "checkAsyncTaskReturnsNonEmptyString: "+result);
        Assert.assertFalse(TextUtils.isEmpty(result));
    }
}
