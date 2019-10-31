package com.example.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.widget.Toast;

import static android.content.Context.TELEPHONY_SERVICE;

public class CallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

       StateListener phoneStateListener = new StateListener();
        TelephonyManager telephonyManager =(TelephonyManager)context.getSystemService(TELEPHONY_SERVICE);
        telephonyManager.listen(phoneStateListener,PhoneStateListener.LISTEN_CALL_STATE);

      /*  if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            System.out.println("inc--------------------------");
            showToast(context, "Incoming call...");
        }else if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
            System.out.println("c start--------------------------");
            //showToast(context,"Call started...");
        }
        else if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE)){
            System.out.println("c end--------------------------");
            showToast(context,"Call ended...");
        }

*/
    }
    class StateListener extends PhoneStateListener {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    System.out.println("ans-------------------");
                //    LockScreenActivity.this.finish();
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    System.out.println("c end--------------------------");
                    break;
            }
        }
    };
    void showToast(Context context,String message){
        Toast toast=Toast.makeText(context,message,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
