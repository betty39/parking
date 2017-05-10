package com.parking.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parking.R;
import com.parking.reserve.ReserveActivity;
import com.parking.reserve.TimeTextView;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ReserveActivityTest extends ActivityInstrumentationTestCase2<ReserveActivity> {
	private ReserveActivity reserve;
	private Button cancle;
	private TimeTextView text;
	private EditText hour;
	private EditText minute;
	private Button reButton;
	private TextView remainView;
	
	public ReserveActivityTest(){
		super(ReserveActivity.class);
		
	}
	protected void setUp() throws Exception{
		super.setUp();
		reserve=getActivity();
		cancle=(Button)reserve.findViewById(R.id.cancle);
		text = (TimeTextView)reserve.findViewById(R.id.text);
		hour = (EditText) reserve.findViewById(R.id.hour);
		minute = (EditText) reserve.findViewById(R.id.minute);
		reButton=(Button)reserve.findViewById(R.id.reserve);
		remainView=(TextView) reserve.findViewById(R.id.remain);
	}
	
	//�ò�������ʵ���ڲ�����������֮ǰ������ȷ����ȡ�������Ϊ�� 
	 public void test0() 
	 { 
		 assertNotNull(reserve); 
		 assertNotNull(cancle); 
		 assertNotNull(text); 
		 assertNotNull(hour); 
		 assertNotNull(minute); 
		 assertNotNull(reButton); 	  
	 } 
	 
	 /*ԤԼ���Ա��1
	  * �û���������������ԤԼʱ�䣬���ڵ�ǰʱ��
	  * Ԥ�ڽ����toast��ʾ�������ڵ�ǰʱ�䣬ԤԼʧ��
	  */
	 public void testReserve1(){
		 //����ʱ�䣺15:30
		 hour.requestFocus();
		 hour.performClick();
		 sendKeys(KeyEvent.KEYCODE_1,KeyEvent.KEYCODE_5);
		 minute.requestFocus();
		 minute.performClick();
		 sendKeys(KeyEvent.KEYCODE_3,KeyEvent.KEYCODE_0);
		 reButton.performClick();
		 String compare=(String) text.getText();
		 Assert.assertEquals("��������1ʧ�ܣ�","�����κ�ԤԼ", compare);
	 }
	 
	 /*ԤԼ���Ա��2
	  * �û�������������ȷ��ԤԼʱ�䣬�ҿճ�λ��Ϊ0
	  * Ԥ�ڽ����ԤԼ�ɹ������뵹��ʱ
	  */
	 public void testReserve2(){
		 //����ʱ�䣺15:30
		 hour.requestFocus();
		 hour.performClick();
		 sendKeys(KeyEvent.KEYCODE_1,KeyEvent.KEYCODE_6);
		 minute.requestFocus();
		 minute.performClick();
		 sendKeys(KeyEvent.KEYCODE_5,KeyEvent.KEYCODE_0);
		 reButton.performClick();
		 String compare=(String) text.getText();
		 Assert.assertEquals("��������1ʧ�ܣ�","����ʱ", compare.substring(0, 3));
	 }
	 
	 
}
