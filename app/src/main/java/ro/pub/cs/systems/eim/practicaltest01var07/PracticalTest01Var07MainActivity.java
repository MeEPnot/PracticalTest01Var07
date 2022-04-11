package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    Button setButton;

    ServiceBroadcastReceiver serviceBroadcastReceiver;
    IntentFilter intentFilter;

    private class SetClickListener implements View.OnClickListener {
        public void onClick(View view) {
            try {
                Integer.parseInt(editText1.getText().toString());
                Integer.parseInt(editText2.getText().toString());
                Integer.parseInt(editText3.getText().toString());
                Integer.parseInt(editText4.getText().toString());

                Intent intent = new Intent(getApplicationContext(), PracticalTest01var07SecondaryActivity.class);
                intent.putExtra("FirstValue", editText1.getText().toString());
                intent.putExtra("SecondValue", editText2.getText().toString());
                intent.putExtra("ThirdValue", editText3.getText().toString());
                intent.putExtra("ForthValue", editText4.getText().toString());
                startActivity(intent);
            } catch (NumberFormatException e) {
                return;
            }
        }
    }

    private SetClickListener setClickListener = new SetClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        setButton = findViewById(R.id.button);
        setButton.setOnClickListener(setClickListener);

        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07Service.class);
        getApplicationContext().startService(intent);

        serviceBroadcastReceiver = new ServiceBroadcastReceiver(editText1, editText2, editText3, editText4);
        intentFilter = new IntentFilter();
        intentFilter.addAction("CHANGE");
    }

    protected void onResume() {
        super.onResume();
        registerReceiver(serviceBroadcastReceiver, intentFilter);
    }

    protected void onPause() {
        unregisterReceiver(serviceBroadcastReceiver);
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07Service.class);
        stopService(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("firstField", editText1.getText().toString());
        savedInstanceState.putString("secondField", editText2.getText().toString());
        savedInstanceState.putString("thirdField", editText3.getText().toString());
        savedInstanceState.putString("forthField", editText4.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("firstField")) {
            editText1.setText(savedInstanceState.getString("firstField"));
        }
        if (savedInstanceState.containsKey("secondField")) {
            editText2.setText(savedInstanceState.getString("secondField"));
        }
        if (savedInstanceState.containsKey("thirdField")) {
            editText3.setText(savedInstanceState.getString("thirdField"));
        }
        if (savedInstanceState.containsKey("forthField")) {
            editText4.setText(savedInstanceState.getString("forthField"));
        }

    }

}