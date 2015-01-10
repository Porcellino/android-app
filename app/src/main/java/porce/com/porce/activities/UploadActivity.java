package porce.com.porce.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import porce.com.porce.R;

public class UploadActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        //upナビゲーション
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static Intent createIntent(Context context){
        Intent intent = new Intent(context, UploadActivity.class);
        return intent;
    }
}
