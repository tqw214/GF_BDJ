package com.viger.gf_bdj.pro.mine.view;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.base.view.BaseFragment;
import com.viger.gf_bdj.pro.mine.view.navigation.MineNavigationBuilder;

/**
 * Created by Administrator on 2017/8/1.
 */

public class MineFragment extends BaseFragment {

    private LinearLayout layout_default;

    @Override
    protected int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initContentView(View viewContent) {
        initToolBar(viewContent);
        layout_default = viewContent.findViewById(R.id.layout_default);
        layout_default.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }

    private void initToolBar(View view) {
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.main_essence_title)
                .setRightIcon(R.drawable.main_essence_btn_more_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "NewpostLeftIconOnClick", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.createAndBind((ViewGroup)view);
    }


}
