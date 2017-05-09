package com.parking.reserve;


import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class TimeTextView extends TextView {
	SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        // �ڿؼ�������ʱ�Ƴ���Ϣ
        handler.removeMessages(0);
    }

    long Time;
    private boolean run = true; // �Ƿ�������

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case 0:
                if (run) {
                    long mTime = Time;
                    if (mTime > 0) {
                        String day = "";
                            TimeTextView.this.setText("����ʱ    ����" + Time/1000+"s");
                            Time = Time - 1000;
                            handler.sendEmptyMessageDelayed(0, 1000);
                            
                    } else {
                     //   TimeTextView.this.setVisibility(View.GONE);
                    	TimeTextView.this.setText("�����κ�ԤԼ");
                   }
                
                }
                break;
            }
        }
    };


    public TimeTextView(Context context) {
        super(context);
    }

    public TimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void setTimes(long mT) {
        // ��ʾ�Ѿ�����
        Date date = new Date();
        long t2 = date.getTime();
        Time = mT - t2;
        date = null;

        if (Time > 0) {
            handler.removeMessages(0);
            handler.sendEmptyMessage(0);
        } else {
           // TimeTextView.this.setVisibility(View.GONE);
        	TimeTextView.this.setText("�����κ�ԤԼ");
        }
    }

    public void stop() {
        run = false;
    }
}
