package edu.feicui.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_main)
    TextView mTextView;
    @BindView(R.id.btn_main1)
    Button mBtn;
    @BindView(R.id.btn_main2)
    Button mBtn2;
    Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder=ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_main1, R.id.btn_main2})
    public void OnClick(Button button) {
        switch (button.getId()) {
            case R.id.btn_main1:
                Toast.makeText(this, "click1--", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_main2:
                Toast.makeText(this, "click2--", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() { //解绑
        super.onDestroy();
        unbinder.unbind();
        Log.e("aaaa", "onDestroy------" );
    }
}
