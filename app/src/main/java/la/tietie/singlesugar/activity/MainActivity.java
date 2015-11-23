package la.tietie.singlesugar.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.VolleyError;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.fragments.CategoryFragment;
import la.tietie.singlesugar.fragments.DanPingFragment;
import la.tietie.singlesugar.fragments.HomeFragment;
import la.tietie.singlesugar.fragments.ProfileFragment;
import la.tietie.singlesugar.utils.VolleyUtil;

public class MainActivity extends AppCompatActivity implements VolleyUtil.OnRequest {
    private RadioGroup radioGroup ;
    private RadioButton homeButton;
    private RadioButton danpingButton;
    private RadioButton categoryButton;
    private RadioButton profileButton;
    private Fragment lastFragment;
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        manager = getSupportFragmentManager();
        Fragment homeFragment = new HomeFragment();
        manager.beginTransaction().add(R.id.fragment_layout,homeFragment,"homeFragment").commit();
        lastFragment = homeFragment;
        homeButton.setChecked(true);
        turnFragment();

    }

    /**
     * chushihua11
     * 创建和添加fragment。
     */
    private void turnFragment() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.home_button:
                        manager.beginTransaction().hide(lastFragment).commit();
                        Fragment homeFragment = manager.findFragmentByTag("homeFragment");
                        if(homeFragment == null){
                            homeFragment = new HomeFragment();
                            manager.beginTransaction().add(R.id.fragment_layout,homeFragment,"homeFragment").commit();
                        }else{
                            manager.beginTransaction().show(homeFragment).commit();

                        }
                        lastFragment = homeFragment;
                        break;
                    case R.id.danping_button:
                        manager.beginTransaction().hide(lastFragment).commit();
                        Fragment danpingFragment = manager.findFragmentByTag("danpingFragment");
                        if(danpingFragment == null){
                            danpingFragment = new DanPingFragment();
                            manager.beginTransaction().add(R.id.fragment_layout,danpingFragment,"danpingFragment").commit();
                        }else{
                            manager.beginTransaction().show(danpingFragment).commit();
                        }
                        lastFragment = danpingFragment;
                        break;
                    case R.id.category_button:
                        manager.beginTransaction().hide(lastFragment).commit();
                        Fragment categoryFragment = manager.findFragmentByTag("categoryFragment");
                        if(categoryFragment == null){
                            categoryFragment = new CategoryFragment();
                            manager.beginTransaction().add(R.id.fragment_layout,categoryFragment,"categoryFragment").commit();
                        }else{
                            manager.beginTransaction().show(categoryFragment).commit();
                        }
                        lastFragment = categoryFragment;
                        break;
                    case R.id.profile_button:
                        manager.beginTransaction().hide(lastFragment).commit();
                        Fragment profileFragment = manager.findFragmentByTag("profileFragment");
                        if(profileFragment == null){
                            profileFragment = new ProfileFragment();
                            manager.beginTransaction().add(R.id.fragment_layout,profileFragment,"profileFragment").commit();
                        }else{
                            manager.beginTransaction().show(profileFragment).commit();
                        }
                        lastFragment = profileFragment;
                        break;
                }
            }
        });
    }

    /**
     * 初始化控件
     */
    private void initView() {
        radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup);
        homeButton = (RadioButton) this.findViewById(R.id.home_button);
        danpingButton = (RadioButton) this.findViewById(R.id.danping_button);
        categoryButton = (RadioButton) this.findViewById(R.id.category_button);
        profileButton = (RadioButton) this.findViewById(R.id.profile_button);
    }

    @Override
    public void response(String url, String response) {
    }

    @Override
    public void errorResponse(String url, VolleyError error) {

    }
}
