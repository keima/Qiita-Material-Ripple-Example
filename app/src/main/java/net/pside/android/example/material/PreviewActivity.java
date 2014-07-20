package net.pside.android.example.material;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.util.Log;

public class PreviewActivity extends Activity {
    private static final String TAG = PreviewActivity.class.getName();

    private enum ArgsKey {
        RES_ID,
    }

    private int mResId;

    public static Intent createIntent(Context context, @LayoutRes int resId) {
        Intent intent = new Intent(context, PreviewActivity.class);
        intent.putExtra(ArgsKey.RES_ID.toString(), resId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mResId = getIntent().getIntExtra(ArgsKey.RES_ID.toString(), -1);

        if (mResId == -1) {
            Log.d(TAG, "ResId is not defined");
            finish();
            return;
        }

        setContentView(mResId);
    }
}
