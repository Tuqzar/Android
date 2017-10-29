package com.example.oleg.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    boolean clear = false;
    boolean clickNumber = false;
    boolean clickOperator = false;
    float left = 0.0f;
    float right = 0.0f;
    char operator = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

    }
    public void clearTextView(){
        print("");
        clear = false;
    }
    public void print(String temp){
//        float a = Float.parseFloat(temp);
//        if((int) a == a)
//            textView.setText((int)a);
//        else
            textView.setText(temp);
    }

    public void zero(View view) {
        if(clear) clearTextView();
        if (textView.getText().toString().isEmpty())
            print("0.");
        else print(this.textView.getText() + "0");

        clickOperator = false;
    }
    public void one(View view) {
        if(clear) clearTextView();
        print(textView.getText() + "1");

        clickOperator = false;
    }
    public void two(View view) {
        if(clear) clearTextView();
        Button two = (Button) findViewById(R.id.two);
        print(textView.getText() + "2");

        clickOperator = false;
    }
    public void three(View view) {
        if(clear) clearTextView();
        print(textView.getText() + "3");

        clickOperator = false;
    }
    public void four(View view) {
        if(clear) clearTextView();
        print(textView.getText() + "4");

        clickOperator = false;
    }
    public void five(View view) {
        if(clear) clearTextView();
        print(textView.getText() + "5");

        clickOperator = false;
    }
    public void six(View view) {
        if(clear) clearTextView();
        print(textView.getText() + "6");

        clickOperator = false;
    }
    public void seven(View view) {
        if(clear) clearTextView();
        print(textView.getText() + "7");

        clickOperator = false;
    }
    public void eight(View view) {
        if(clear) clearTextView();
        print(textView.getText() + "8");

        clickOperator = false;
    }
    public void nine(View view) {
        if(clear) clearTextView();
        print(textView.getText() + "9");

        clickOperator = false;
    }
    public void point(View view) {
        if(textView.getText().toString().indexOf(".") == -1) {
            if (textView.getText().toString().isEmpty() || textView.getText().toString() == "0")
                print("0");
            print(textView.getText() + ".");
        }
    }

    public void AC(View view) {
        print("");
        left = 0; right = 0;
        clear = false;
        clickOperator = true;
    }

    public void plust(View view) {
        if(clickOperator) {operator = '+'; return;}
        if(left == 0) {
            left = Float.parseFloat(textView.getText() + "");
            clear = true;
            clickOperator = true;
        }
        else equal(view);
        operator = '+';
    }
    public void minus(View view) {
        if(clickOperator) {operator = '-'; return;}
        if(left == 0) {
            left = Float.parseFloat(textView.getText() + "");
            clear = true;
            clickOperator = true;
        }
        else equal(view);
        operator = '-';
    }
    public void multiply(View view) {
        if(clickOperator) {operator = '*'; return;}
        if(left == 0) {
            left = Float.parseFloat(textView.getText() + "");
            clear = true;
            clickOperator = true;
        }
        else equal(view);
        operator = '*';;
    }
    public void division(View view) {
        if(clickOperator) {operator = '/'; return;}
        if(left == 0) {
            left = Float.parseFloat(textView.getText() + "");
            clear = true;
            clickOperator = true;
        }
        else equal(view);
        operator = '/';
    }
    public void persent(View view) {
        AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
        build.setTitle("Очень важное сообщение").
                setMessage("Кнопка временно не работает").
                setCancelable(false).
                setNegativeButton("Закройся",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = build.create();
        alert.show();
    }
    public void plustOrMinus(View view) {
        if(textView.getText().toString().isEmpty()) return;
        float temp = Float.parseFloat(textView.getText()+"");
        if((int)temp == temp)
            textView.setText((int)temp*(-1)+"");
        else
            textView.setText(temp*(-1)+"");
    }


    public void equal(View view) {
        if(clickOperator) return;
        switch (operator){
            case '+':
                left += Float.parseFloat(textView.getText()+"");
                print(left+""); break;
            case '-':
                left -= Float.parseFloat(textView.getText()+"");
                print(left+""); break;
            case '*':
                left *= Float.parseFloat(textView.getText()+"");
                print(left+""); break;
            case '/':
                left /= Float.parseFloat(textView.getText()+"");
                print(left+""); break;
            case '%':
                left = left + left * Float.parseFloat(textView.getText()+"") / 100;
                print((left * Float.parseFloat(textView.getText()+"") / 100)+""); break;
        }
        clear = true;
        clickOperator = true;
    }
}
