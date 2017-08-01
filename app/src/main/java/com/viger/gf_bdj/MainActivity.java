package com.viger.gf_bdj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabData();
    }

    private void initTabData() {
        List<TabItem> tabItemList = new ArrayList<TabItem>();
        tabItemList.add(new TabItem(R.drawable.main_bottom_essence_normal,
                R.drawable.main_bottom_essence_press, "精华"));
        tabItemList.add(new TabItem(R.drawable.main_bottom_newpost_normal,
                R.drawable.main_bottom_newpost_press, "新帖"));
        tabItemList.add(new TabItem(R.drawable.main_bottom_public_normal,
                R.drawable.main_bottom_public_press, "发布"));
        tabItemList.add(new TabItem(R.drawable.main_bottom_attention_normal,
                R.drawable.main_bottom_attention_press, "关注"));
        tabItemList.add(new TabItem(R.drawable.main_bottom_mine_normal,
                R.drawable.main_bottom_mine_press, "我"));
    }

    class TabItem {

        private int imageNormal;
        private int imagePress;
        private String title;

        public TabItem(int imageNormal, int imagePress, String title) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
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
    }

}
