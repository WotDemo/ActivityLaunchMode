package ysn.com.demo.page;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ysn.com.demo.R;
import ysn.com.demo.widget.BaseActivity;

/**
 * @Author yangsanning
 * @ClassName CActivity
 * @Description 一句话概括作用
 * @Date 2019/7/25
 * @History 2019/7/25 author: description:
 */
public class CActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public String getTag() {
        return "test   " + CActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);
        setTitle(CActivity.class.getSimpleName());

        Button skip1 = findViewById(R.id.skip_activity_1);
        skip1.setText("创建 A");
        skip1.setOnClickListener(this);


        Button skip2 = findViewById(R.id.skip_activity_2);
        skip2.setVisibility(View.VISIBLE);
        skip2.setText("创建 B");
        skip2.setOnClickListener(this);

        Button skip3 = findViewById(R.id.skip_activity_3);
        skip3.setVisibility(View.VISIBLE);
        skip3.setText("创建 D");
        skip3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.skip_activity_1:
                startActivity(AActivity.class);
                break;
            case R.id.skip_activity_2:
                startActivity(BActivity.class);
                break;
            case R.id.skip_activity_3:
                startActivity(DActivity.class);
                break;
            default:
                break;
        }
    }
}
