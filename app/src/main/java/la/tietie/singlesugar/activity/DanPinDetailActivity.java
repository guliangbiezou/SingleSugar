package la.tietie.singlesugar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.view.ScrollView_CanStop;

public class DanPinDetailActivity extends AppCompatActivity {

    LinearLayout center1;
    ScrollView_CanStop sv;
    Button left1,right1;
    ImageView back;
    Intent data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dan_pin_detail);
        data = getIntent();
        initView();
    }

    private void initView() {
        center1 = (LinearLayout) findViewById(R.id.ll_detail_center1);
        sv = (ScrollView_CanStop) findViewById(R.id.sv_dp_detail);
        left1 = (Button) findViewById(R.id.bt_detail_left1);
        right1 = (Button) findViewById(R.id.bt_detail_right1);
        sv.setLeftBt("图文介绍");
        sv.setRightBt("评论(0)");
        left1.setText("图文介绍");
        right1.setText("评论(0)");
        back = (ImageView)findViewById(R.id.iv_detail_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanPinDetailActivity.this, MainActivity.class);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        initHead();
    }

    private void initHead() {

        View head = LayoutInflater.from(this).inflate(R.layout.danping_detail_head,null);
        sv.addHead(head);


    }
}
