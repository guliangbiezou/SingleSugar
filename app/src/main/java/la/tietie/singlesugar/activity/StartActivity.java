package la.tietie.singlesugar.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.utils.Share;

public class StartActivity extends AppCompatActivity {

    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        translate();
    }

    private void translate() {

        isFirst = Share.getBoolean("isFirst", true);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(isFirst) {
                    Share.putBoolean("isFirst",true);
                    Intent intent = new Intent(StartActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(StartActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        },2400);

    }
}
