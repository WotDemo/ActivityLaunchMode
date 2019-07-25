package ysn.com.demo.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ysn.com.demo.MainActivity;
import ysn.com.demo.R;
import ysn.com.demo.widget.BaseActivity;

/**
 * @Author yangsanning
 * @ClassName DActivity
 * @Description 一句话概括作用
 * @Date 2019/7/25
 * @History 2019/7/25 author: description:
 */
public class DActivity extends BaseActivity implements View.OnClickListener {

    private static int dActivityCount;

    @Override
    public String getTag() {
        return "test   " + DActivity.class.getSimpleName() + dActivityCount;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);
        dActivityCount++;
        setTitle(DActivity.class.getSimpleName() + dActivityCount);

        Button skip1 = findViewById(R.id.skip_activity_1);
        skip1.setText("创建自己");
        skip1.setOnClickListener(this);

        Button skip2 = findViewById(R.id.skip_activity_2);
        skip2.setVisibility(View.VISIBLE);
        skip2.setText("创建 B");
        skip2.setOnClickListener(this);

        Button skip3 = findViewById(R.id.skip_activity_3);
        skip3.setVisibility(View.VISIBLE);
        skip3.setText("关闭自己");
        skip3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.skip_activity_1:
                startActivityForResult(DActivity.class);
                break;
            case R.id.skip_activity_2:
                startActivityForResult(BActivity.class);
                break;
            case R.id.skip_activity_3:
                Intent intent = new Intent();
                intent.putExtra(EXTRA_DATA, "我是D");
                setResult(RESULT_OK, intent);
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dActivityCount--;
    }
}
