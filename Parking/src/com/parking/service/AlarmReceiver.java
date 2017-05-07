package com.parking.service;

import com.parking.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(
				context);
		builder.setSmallIcon(R.drawable.time);
		// ���֪ͨ���Զ����
		builder.setTicker("ԤԼʱ�䵽");
		builder.setAutoCancel(true);
		builder.setContentTitle("ԤԼʱ�䵽");
		builder.setContentText("ԤԼ���Զ�ȡ��");
		 //��һ�����������ķ���
	    Notification notify = builder.build();
		   //����ϵͳĬ������
		//ʹ��Ĭ�ϵ��������񶯡�����
		notify.defaults = Notification.DEFAULT_ALL;
		
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(context.NOTIFICATION_SERVICE);
		notificationManager.notify(0, builder.build());
	}

}
