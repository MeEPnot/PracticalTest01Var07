package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Random;

public class ProcessingThread extends Thread{

    private Context context;
    public ProcessingThread(Context context) {
        this.context = context;
    }

    public void run() {
        while(true) {
            sendMessage();
            sleep();
        }
    }

    private void sleep() {
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        Random random = new Random();

        Intent intent = new Intent();
        intent.setAction("CHANGE");
        intent.putExtra("firstValue", Integer.toString(random.nextInt() % 10));
        intent.putExtra("secondValue", Integer.toString(random.nextInt() % 10));
        intent.putExtra("thirdValue", Integer.toString(random.nextInt() % 10));
        intent.putExtra("forthValue", Integer.toString(random.nextInt() % 10));
        context.sendBroadcast(intent);
    }
}
