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
	
	//该测试用例实现在测试其他用例之前，测试确保获取的组件不为空 
	 public void test0() 
	 { 
		 assertNotNull(reserve); 
		 assertNotNull(cancle); 
		 assertNotNull(text); 
		 assertNotNull(hour); 
		 assertNotNull(minute); 
		 assertNotNull(reButton); 	  
	 } 
	 
	 /*预约测试编号1
	  * 用户操作：输入错误的预约时间，早于当前时间
	  * 预期结果：toast提示不能早于当前时间，预约失败
	  */
	 public void testReserve1(){
		 //输入时间：15:30
		 hour.requestFocus();
		 hour.performClick();
		 sendKeys(KeyEvent.KEYCODE_1,KeyEvent.KEYCODE_5);
		 minute.requestFocus();
		 minute.performClick();
		 sendKeys(KeyEvent.KEYCODE_3,KeyEvent.KEYCODE_0);
		 reButton.performClick();
		 String compare=(String) text.getText();
		 Assert.assertEquals("测试用例1失败：","暂无任何预约", compare);
	 }
	 
	 /*预约测试编号2
	  * 用户操作：输入正确的预约时间，且空车位不为0
	  * 预期结果：预约成功，进入倒计时
	  */
	 public void testReserve2(){
		 //输入时间：15:30
		 hour.requestFocus();
		 hour.performClick();
		 sendKeys(KeyEvent.KEYCODE_1,KeyEvent.KEYCODE_6);
		 minute.requestFocus();
		 minute.performClick();
		 sendKeys(KeyEvent.KEYCODE_5,KeyEvent.KEYCODE_0);
		 reButton.performClick();
		 String compare=(String) text.getText();
		 Assert.assertEquals("测试用例1失败：","倒计时", compare.substring(0, 3));
	 }
	 
	 
}
