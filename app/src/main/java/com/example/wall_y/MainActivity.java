package com.example.wall_y;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";
    ImageView logosus;
    TextView nume;
    TextView networth;
    TextView suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logosus = (ImageView) findViewById(R.id.imageView5);
        nume = (TextView) findViewById(R.id.textView);
        networth = (TextView) findViewById(R.id.textView2);
        suma = (TextView) findViewById(R.id.textView4);
        float balanta = 0;
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        suma.setText(String.valueOf(balanta));
        setTextViewColor(suma, getResources().getColor(R.color.violet), getResources().getColor(R.color.crem));
    }
        private void setTextViewColor (TextView suma, int...color){
            TextPaint paint = suma.getPaint();
            float width = paint.measureText(suma.getText().toString());
            Shader shader = new LinearGradient(0, 0, width, suma.getTextSize(), color, null, Shader.TileMode.CLAMP);
            suma.getPaint().setShader(shader);
            suma.setTextColor(color[0]);
        }

        public void saveData(){
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(TEXT, suma.getText().toString());
            //editor.putBoolean(SWITCH1, )
        }
}