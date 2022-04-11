package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01var07SecondaryActivity extends AppCompatActivity {

    Context context;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    Button buttonPlus;
    Button buttonMul;


    private class PlusClickListener implements View.OnClickListener {
        public void onClick(View view) {
            int first = Integer.parseInt(textView1.getText().toString());
            int second = Integer.parseInt(textView2.getText().toString());
            int third = Integer.parseInt(textView3.getText().toString());
            int forth = Integer.parseInt(textView4.getText().toString());

            int result = first + second + third + forth;
            CharSequence resultString = Integer.toString(result);

            Toast.makeText(context, resultString, Toast.LENGTH_LONG).show();
        }
    }

    private PlusClickListener plusClickListener = new PlusClickListener();

    private class MulClickListener implements View.OnClickListener {
        public void onClick(View view) {
            int first = Integer.parseInt(textView1.getText().toString());
            int second = Integer.parseInt(textView2.getText().toString());
            int third = Integer.parseInt(textView3.getText().toString());
            int forth = Integer.parseInt(textView4.getText().toString());

            int result = first * second * third * forth;
            CharSequence resultString = Integer.toString(result);

            Toast.makeText(context, resultString, Toast.LENGTH_LONG).show();
        }
    }

    private MulClickListener mulClickListener = new MulClickListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01var07_secondary);

        context = this;

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMul = findViewById(R.id.buttonMul);

        Intent intent = getIntent();
        if (intent != null) {
            textView1.setText(intent.getStringExtra("FirstValue"));
            textView2.setText(intent.getStringExtra("SecondValue"));
            textView3.setText(intent.getStringExtra("ThirdValue"));
            textView4.setText(intent.getStringExtra("ForthValue"));
        }

        buttonPlus.setOnClickListener(plusClickListener);
        buttonMul.setOnClickListener(mulClickListener);
    }
}