package com.viger.gf_bdj.pro.newpost.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.base.view.BaseFragment;
import com.viger.gf_bdj.pro.newpost.view.navigation.NewpostNavigationBuilder;

/**
 * Created by Administrator on 2017/8/1.
 */

public class NewpostFragment extends BaseFragment {

    @Override
    protected int getContentView() {
        return R.layout.fragment_newpost;
    }

    @Override
    protected void initContentView(View viewContent) {
        initToolBar(viewContent);
    }

    private void initToolBar(View view) {
        NewpostNavigationBuilder builder = new NewpostNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setRightIcon(R.drawable.main_essence_btn_more_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "NewpostLeftIconOnClick", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.createAndBind((ViewGroup)view);
        builder.setImageViewStyle(R.id.iv_left, R.drawable.main_newpost_audit_btn_selector,
                builder.getLeftIconOnClickListener());
    }
}
