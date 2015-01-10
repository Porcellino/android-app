package porce.com.porce.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import porce.com.porce.R;
import porce.com.porce.fragments.UploadDetailFragment;

public class UploadDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_detail);

        //upナビゲーション
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //UploadFragmentの追加
        getFragmentManager().beginTransaction()
                .replace(R.id.container, UploadDetailFragment.newInstance("test", "test")).commit();
    }

    public static Intent createIntent(Context context){
        Intent intent = new Intent(context, UploadDetailActivity.class);
        return intent;
    }
}
