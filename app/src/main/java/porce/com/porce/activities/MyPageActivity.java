package porce.com.porce.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import porce.com.porce.R;
import porce.com.porce.fragments.MyPageFragment;

/**
 * マイページを紹介するActivity.
 */
public class MyPageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //floating action buttonの設定
        initFloatingActionButton();

        //MyPageFragmentの追加
        getFragmentManager().beginTransaction()
                .replace(R.id.container, MyPageFragment.newInstance()).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Floating action buttonの設定
     */
    private void initFloatingActionButton(){
        findViewById(R.id.floating_action_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyPageActivity.this, "本紹介", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.floating_action_find).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyPageActivity.this, "本探し", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
