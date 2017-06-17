package com.zx.dialoglib;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by zx on 2017/6/12 10:09
 * 项目名称：BottomDialog
 * 类描述：
 * 备注
 */
public class BottomDialog<T extends Entity> extends Dialog implements View.OnClickListener {

    ListView mLv;

    Button mBtnCancel;


    private List<T> mDatas;
    private SelectPositionCallBack mCallBack;
    private Context mContext;
    BottomAdapter<T> adapter;

    public BottomDialog(Context context, List<T> datas, SelectPositionCallBack callBack) {
        this(context, R.style.dialog);
        this.mContext = context;
        this.mCallBack = callBack;
        this.mDatas = datas;
    }

    public BottomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.bottom_dialog, null);
        mLv = (ListView) view.findViewById(R.id.lv);
        mBtnCancel = (Button) view.findViewById(R.id.btn_cancel);
        adapter = new BottomAdapter<>(mContext, mDatas);
        mLv.setAdapter(adapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallBack.selectPosition(position);
                dismiss();
            }
        });

        setContentView(view);
        getWindow().setGravity(Gravity.BOTTOM);
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = d.getWidth();
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setAttributes(p);

        setTitle(null);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_cancel)
            dismiss();
    }
}
