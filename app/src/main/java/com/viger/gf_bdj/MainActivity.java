package com.viger.gf_bdj;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.viger.gf_bdj.pro.attention.view.AttentionFragment;
import com.viger.gf_bdj.pro.essence.view.EssenceFragment;
import com.viger.gf_bdj.pro.mine.view.MineFragment;
import com.viger.gf_bdj.pro.newpost.view.NewpostFragment;
import com.viger.gf_bdj.pro.publish.view.PublishFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;
    private List<TabItem> tabItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabData();
        initTabHost();
    }

    private void initTabData() {
        tabItemList = new ArrayList<TabItem>();
        tabItemList.add(new TabItem(R.drawable.main_bottom_essence_normal,
                R.drawable.main_bottom_essence_press, "精华", EssenceFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_newpost_normal,
                R.drawable.main_bottom_newpost_press, "新帖", NewpostFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_public_normal,
                R.drawable.main_bottom_public_press, "", PublishFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_attention_normal,
                R.drawable.main_bottom_attention_press, "关注", AttentionFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_mine_normal,
                R.drawable.main_bottom_mine_press, "我", MineFragment.class));
    }

    private void initTabHost() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        //去掉分隔线
        tabHost.getTabWidget().setDividerDrawable(null);
        for(int i=0;i<tabItemList.size();i++) {
            TabItem tabItem = tabItemList.get(i);
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(i+"");
            tabSpec.setIndicator(tabItem.getView());
            tabHost.addTab(tabSpec, tabItem.getClazz(), tabItem.getBundle());
            //tab按钮设置背景
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#11000000"));
            if(i == 0) {
                tabItem.setCheck(true);
            }
        }
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                int m = Integer.valueOf(s);
                for(int i=0;i<tabItemList.size();i++) {
                    tabItemList.get(i).setCheck(i == m);
                }
            }
        });
    }

    class TabItem {

        private int imageNormal;
        private int imagePress;
        private String title;
        private Class<? extends Fragment> fragmentClazz;
        private View view;
        private ImageView imageView;
        private TextView textView;
        private Bundle bundle;

        public TabItem(int imageNormal, int imagePress, String title, Class clazz) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClazz = clazz;
        }

        public Bundle getBundle() {
            if(bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("title", title);
            return bundle;
        }

        public void setBundle(Bundle bundle) {
            this.bundle = bundle;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public void setImageNormal(int imageNormal) {
            this.imageNormal = imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public void setImagePress(int imagePress) {
            this.imagePress = imagePress;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public Class getClazz() {
            return fragmentClazz;
        }
        public void setClazz(Class clazz) {
            this.fragmentClazz = clazz;
        }

        public void setCheck(boolean isChecked) {
            if(imageView != null) {
                if(isChecked) {
                    imageView.setImageResource(imagePress);
                }else {
                    imageView.setImageResource(imageNormal);
                }
            }
            if(textView != null) {
                if(isChecked) {
                    textView.setTextColor(Color.BLACK);
                }else {
                    textView.setTextColor(Color.GRAY);
                }
            }
        }

        public View getView() {
            if(this.view == null) {
                this.view = getLayoutInflater().inflate(R.layout.view_tab_indicator, null);
                this.imageView= this.view.findViewById(R.id.iv_tab);
                this.textView = this.view.findViewById(R.id.tv_tab);
                if(this.title == null || "".equals(this.title)) {
                    this.textView.setVisibility(View.GONE);
                }else {
                    this.textView.setVisibility(View.VISIBLE);
                }
                this.imageView.setImageResource(imageNormal);
                this.textView.setText(title);
            }
            return this.view;
        }
    }

}
