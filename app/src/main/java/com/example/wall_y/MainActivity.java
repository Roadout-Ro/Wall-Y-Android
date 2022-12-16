package com.example.wall_y;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView logosus = (ImageView) findViewById(R.id.imageView5);
        TextView nume = (TextView) findViewById(R.id.textView);
        TextView networth = (TextView) findViewById(R.id.textView2);
        TextView suma = (TextView) findViewById(R.id.textView4);
        float balanta = 0;
        setTextViewColor (suma, getResources().getColor(R.color.violet), getResources().getColor(R.color.crem));
        suma.setText(String.valueOf(balanta));
    }
        private void setTextViewColor (TextView suma, int...color){
            TextPaint paint = suma.getPaint();
            float width = paint.measureText(suma.getText().toString());
            Shader shader = new LinearGradient(0, 0, width, suma.getTextSize(), color, null, Shader.TileMode.CLAMP);
            suma.getPaint().setShader(shader);
            suma.setTextColor(color[0]);
        }
}