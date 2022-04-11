package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

public class ServiceBroadcastReceiver extends BroadcastReceiver {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    public ServiceBroadcastReceiver(EditText editText1, EditText editText2, EditText editText3, EditText editText4) {
        this.editText1 = editText1;
        this.editText2 = editText2;
        this.editText3 = editText3;
        this.editText4 = editText4;
    }

    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("CHANGE")) {
            editText1.setText(intent.getStringExtra("firstValue"));
            editText2.setText(intent.getStringExtra("secondValue"));
            editText3.setText(intent.getStringExtra("thirdValue"));
            editText4.setText(intent.getStringExtra("forthValue"));
        }
    }
}
