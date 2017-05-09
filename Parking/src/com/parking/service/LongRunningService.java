package com.parking.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class LongRunningService extends Service {

	Long time;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO �Զ����ɵķ������
		return null;
	}
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i("info", "Service--onCreate()");
		super.onCreate();
		
	}
	@Override
	 public int onStartCommand(Intent intent, int flags, int startId) { 
	  
	  AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE); 
	  //���߿����޸Ĵ˴���Minutes�Ӷ��ı����Ѽ��ʱ�� 
	  //�˴�������ÿ��90��������һ�� 
	  //����90���ӵĺ����� 
	  int Minutes = 90*60*1000; 
	  //SystemClock.elapsedRealtime()��ʾ1970��1��1��0��������������ʱ�� 
	  long triggerAtTime = SystemClock.elapsedRealtime() + Minutes; 
	  //�˴����ÿ���AlarmReceiver���Service 
	  Intent i = new Intent(this, AlarmReceiver.class); 
	  PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0); 
	  //ELAPSED_REALTIME_WAKEUP��ʾ�ö�ʱ����ĳ���ʱ���ϵͳ�������𣬲��һỽ��CPU�� 
	  manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi); 
	  return super.onStartCommand(intent, flags, startId); 
	 } 
	  
	 @Override
	 public void onDestroy() { 
	  super.onDestroy(); 
	  //��Service������ر�AlarmManager 
	  AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE); 
	  Intent i = new Intent(this, AlarmReceiver.class); 
	  PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0); 
	  manager.cancel(pi); 
	  
	 } 
}
