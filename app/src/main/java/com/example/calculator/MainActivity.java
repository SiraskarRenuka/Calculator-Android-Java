package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnpercent, btnplus, btnminus, btnmultiply, btndivision,
            btnbracket, btnequal, btnclear, btndot, btnbackspace;
    TextView tvipnut, tvoutput;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setTitle("Calculate Here");
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnpercent = findViewById(R.id.btn_percent);
        btnplus = findViewById(R.id.btn_plus);
        btnminus = findViewById(R.id.btn_minus);
        btndivision = findViewById(R.id.btn_division);
        btnmultiply = findViewById(R.id.btn_multiply);

        btnbracket = findViewById(R.id.btn_bracket);
        btnclear = findViewById(R.id.btn_clear);
        btndot = findViewById(R.id.btn_dot);
        btnequal = findViewById(R.id.btn_equal);
        btnbackspace = findViewById(R.id.btn_backspace);

        tvipnut = findViewById(R.id.tv_input);
        tvoutput = findViewById(R.id.tv_output);

        btnbackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String backspace = null;
                if (tvipnut.getText().length() > 0) {
                    StringBuilder st = new StringBuilder(tvipnut.getText());
                    st.deleteCharAt(tvipnut.getText().length() - 1);
                    backspace = st.toString();
                    tvipnut.setText(backspace);
                }
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvipnut.setText(" ");
                tvoutput.setText(" ");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "0");

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "1");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "2");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "4");

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "5");

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "9");

            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "+");

            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "-");

            }
        });
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "*");

            }
        });
        btndivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "/");

            }
        });

        btnpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + "%");

            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                tvipnut.setText(process + ".");

            }
        });
        btnbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBracket) {
                    process = tvipnut.getText().toString();
                    tvipnut.setText(process + ")");
                    checkBracket = false;
                } else {
                    process = tvipnut.getText().toString();
                    tvipnut.setText(process + "(");
                    checkBracket = true;
                }
            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvipnut.getText().toString();
                process = process.replace("×", "*");
                process = process.replace("%", "/100");
                process = process.replace("÷", "/");
                Context rhino= Context.enter();
                rhino.setOptimizationLevel(-1);
                String result ="";
                try{
                    Scriptable scriptable=rhino.initStandardObjects();
                    result = rhino.evaluateString(scriptable,process,"javascript",1,null)
                            .toString();
                }catch (Exception e)
                {
                    result="0";
                }
                tvoutput.setText(result);
            }
        });
    }
}









































