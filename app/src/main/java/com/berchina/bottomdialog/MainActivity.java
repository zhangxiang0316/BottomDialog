package com.berchina.bottomdialog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.zx.dialoglib.BottomDialog;
import com.zx.dialoglib.SelectPositionCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.btn)
    Button mBtn;

    List<MyEntity> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MyEntity entity = new MyEntity();
            entity.name = "第" + (i + 1) + "条";
            entity.isOK = Math.random() * 2 > 1;
            entity.title = "抬头";
            list.add(entity);
        }
    }

    @OnClick({R.id.btn})
    public void onClick() {
        BottomDialog<MyEntity> dialog = new BottomDialog<>(this, list, new SelectPositionCallBack() {
            @Override
            public void selectPosition(int position) {
                Toast.makeText(MainActivity.this, list.get(position).name, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}
