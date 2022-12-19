package com.example.wall_y;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    ImageView logosus;
    TextView nume;
    TextView networth;
    TextView suma;
    TextView addIncome;
    TextView addExpense;
    SharedPreferences sp;
    float balanta = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logosus = (ImageView) findViewById(R.id.imageView5);
        nume = (TextView) findViewById(R.id.textView);
        networth = (TextView) findViewById(R.id.textView2);
        suma = (TextView) findViewById(R.id.textView4);
        addIncome = (TextView) findViewById(R.id.textView5);
        addExpense = (TextView) findViewById(R.id.textView6);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        suma.setText(String.valueOf(balanta));
        setTextViewColor(suma, getResources().getColor(R.color.violet), getResources().getColor(R.color.crem));
        addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        MainActivity.this, R.style.BottomSheetDialogTheme);
                    View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                            R.layout.layout_bottom_sheet,
                            (LinearLayout) findViewById(R.id.bottomSheetContainer)
                    );
                    bottomSheetView.findViewById(R.id.addbutton).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Shared Prefs
                            EditText camp = (EditText) bottomSheetView.findViewById(R.id.editTextNumberDecimal);
                            float valoare = Float.valueOf(camp.getText().toString());
                            balanta+=valoare;
                            suma.setText(balanta + " RON");
                        }
                    });
                    bottomSheetView.findViewById(R.id.textView12).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bottomSheetDialog.dismiss();
                        }
                    });
                    bottomSheetDialog.setContentView(bottomSheetView);
                    bottomSheetDialog.show();
            }
        });

        addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        MainActivity.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                        R.layout.layout_bottom_sheet1,
                        (LinearLayout) findViewById(R.id.bottomSheetContainer)
                );
                bottomSheetView.findViewById(R.id.addbutton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Shared Prefs
                        EditText camp = (EditText) bottomSheetView.findViewById(R.id.editTextNumberDecimal);
                        float valoare = Float.valueOf(camp.getText().toString());
                        balanta-=valoare;
                        suma.setText(balanta + " RON");
                    }
                });
                bottomSheetView.findViewById(R.id.textView12).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
        sp = getSharedPreferences("Balanta", Context.MODE_PRIVATE);
    }
        private void setTextViewColor (TextView suma, int...color) {
            TextPaint paint = suma.getPaint();
            float width = paint.measureText(suma.getText().toString());
            Shader shader = new LinearGradient(0, 0, width, suma.getTextSize(), color, null, Shader.TileMode.CLAMP);
            suma.getPaint().setShader(shader);
            suma.setTextColor(color[0]);
        }
}