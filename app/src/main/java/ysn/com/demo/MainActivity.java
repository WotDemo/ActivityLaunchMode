package ysn.com.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ysn.com.demo.page.AActivity;
import ysn.com.demo.widget.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static int mainActivityCount;

    @Override
    public String getTag() {
        return "test: " + MainActivity.class.getSimpleName() + mainActivityCount;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityCount++;
        setTitle(MainActivity.class.getSimpleName() + mainActivityCount);

        findViewById(R.id.main_activity_this).setOnClickListener(this);
        findViewById(R.id.main_activity_skip_a).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_activity_this:
                startActivity(MainActivity.class);
                break;
            case R.id.main_activity_skip_a:
                startActivity(AActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainActivityCount--;
    }
}
