package com.baculsoft.sample.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;

    @BindView(R.id.et_main_name)
    EditText etMainName;

    @BindString(R.string.app_name)
    String appName;

    @BindString(R.string.app_desc)
    String appDesc;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
    }

    @OnClick(R.id.btn_main_click)
    public void onBtnMainClick() {
        final String message = etMainName.getText().toString();

        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    private void initToolbar() {
        // Initial toolbar
        toolbarMain.setTitle(appName);
        toolbarMain.setSubtitle(appDesc);
        setSupportActionBar(toolbarMain);
    }
}