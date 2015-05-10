package com.alexsclim.tipcalc;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private static final String DEBUG = MainActivity.class.getName();
	public static final String TIP = "tag";
	public static final String GRAND_TOTAL = "total";
	
	private EditText et;
	
	private Button button10;
	private Button button12;
	private Button button15;
	private Button button20;
	private Button button30;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		et = (EditText) findViewById(R.id.editText1);
		
		button10 = (Button) findViewById(R.id.tip10);
		button12 = (Button) findViewById(R.id.tip12);
		button15 = (Button) findViewById(R.id.tip15);
		button20 = (Button) findViewById(R.id.tip20);
		button30 = (Button) findViewById(R.id.tip30);
		
		button10.setOnClickListener(this);
		button12.setOnClickListener(this);
		button15.setOnClickListener(this);
		button20.setOnClickListener(this);
		button30.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		
		double tipPercent = 0.0d;
		
		switch(v.getId()){

			case R.id.tip10 :{
				tipPercent = 0.10d;
				break;
			}
			case R.id.tip12	:{
				tipPercent = 0.12d;
				break;
			}
			case R.id.tip15	:{
				tipPercent = 0.15d;
				break;
			}
			case R.id.tip20	:{
				tipPercent = 0.200d;
				break;
			}
			case R.id.tip30	:{
				tipPercent = 0.30d;
				break;
			}
		}
		String text = et.getText().toString();
		if(text.equals("")){
			Toast.makeText(MainActivity.this, getResources().getString(R.string.error_et),Toast.LENGTH_LONG).show();
			return;
		}
		calculateTip(Double.parseDouble(et.getText().toString()),tipPercent);
	}
	
	private void calculateTip(double totalCost, double tipPercent){
		
		DecimalFormat formatter = new DecimalFormat("#0.00"); 
		double tipAmount = totalCost*tipPercent;
		double grandTotal = totalCost + tipAmount;
		tipAmount = (double)Math.round(tipAmount*100)/100;
		grandTotal = (double)Math.round(grandTotal*100)/100;
		
		
		
		Intent resultActivity = new Intent(MainActivity.this,Result.class);
		
		resultActivity.putExtra(TIP, formatter.format(tipAmount));
		resultActivity.putExtra(GRAND_TOTAL, formatter.format(grandTotal));
		
		startActivity(resultActivity);
	}


	
	


	
}
