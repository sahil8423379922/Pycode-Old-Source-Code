package com.priyanka.pycode;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class TimerDialog {

    private Context mContext;
    private Dialog TimerDialog;
    private  int getscore;
    String value;
    private InterstitialAd mInterstitialAd;
    private TextView textviewTimeUP;
    public TimerDialog(Context mContext) {
        this.mContext = mContext;
    }
    public void timerDialog() {


        TimerDialog = new Dialog(mContext);
        TimerDialog.setContentView(com.priyanka.pycode.R.layout.timer_dialog);
        mInterstitialAd = new InterstitialAd(TimerDialog.getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3774908939242242/2077460977");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        final Button btTimer = (Button) TimerDialog.findViewById(com.priyanka.pycode.R.id.bt_timer);
        btTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();

                    mInterstitialAd.setAdListener(new AdListener() {

                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            TimerDialog.dismiss();
                            Intent intent = new Intent(mContext, startcourse.class);
                            mContext.startActivity(intent);
                        }
                    });

                }
                else
                {
                    TimerDialog.dismiss();
                    Intent intent = new Intent(mContext, startcourse.class);
                    mContext.startActivity(intent);
                }






            }
        });

        TimerDialog.show();
        TimerDialog.setCancelable(false);
        TimerDialog.setCanceledOnTouchOutside(false);

        TimerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}
