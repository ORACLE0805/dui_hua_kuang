package com.example.dui_hua_kuang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void layDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // 创建一个view，并且将布局加入view中
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.dialog_edt, null, false);
        // 将view添加到builder中
        builder.setView(view);
        // 创建dialog
        final Dialog dialog = builder.create();
        // 初始化控件，注意这里是通过view.findViewById
        final EditText edt = (EditText) view.findViewById(R.id.edt);
        final EditText password = (EditText) view.findViewById(R.id.password);
        Button confirm = (Button) view.findViewById(R.id.confirm);
        Button cancel = (Button) view.findViewById(R.id.cancel);
        // 设置button的点击事件及获取editview中的文本内容
        confirm.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String str = edt.getText() == null ? "" : edt.getText()
                        .toString();
                String str1 =password.getText() == null ? "" : password.getText().toString();
                if(str.equals("abc") && str1.equals("123"))
                {
                    Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                }


            }
        });
        // 取消按钮
        cancel.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                layDialog();


        }
    }
}
