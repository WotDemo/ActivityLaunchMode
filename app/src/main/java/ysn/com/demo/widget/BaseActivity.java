package ysn.com.demo.widget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * @Author yangsanning
 * @ClassName BaseActivity
 * @Description 一句话概括作用
 * @Date 2019/7/25
 * @History 2019/7/25 author: description:
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";
    public static final int REQUEST_CODE = 2020;

    /**
     * @return 日志tag
     */
    public abstract String getTag();

    public void showMessage(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    public void startActivityForResult(Class<?> cls) {
        startActivityForResult(new Intent(this, cls), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE:
                   showMessage(data.getStringExtra(EXTRA_DATA));
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(getTag(), "onNewIntent");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(getTag(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(getTag(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(getTag(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(getTag(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(getTag(), "onDestroy");
    }
}
