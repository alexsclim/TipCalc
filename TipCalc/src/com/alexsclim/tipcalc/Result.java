package com.alexsclim.tipcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity {

	private TextView tipTextView;
	private TextView totalTextView;
	private Button back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.result);
		
		tipTextView = (TextView) findViewById(R.id.tip);
		totalTextView = (TextView) findViewById(R.id.totalcost);
		initializeTextViews();
		back = (Button) findViewById(R.id.confirm);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
	
	}
	
	private void initializeTextViews(){
		
		String tip = getIntent().getExtras().getString(MainActivity.TIP);
		String total = getIntent().getExtras().getString(MainActivity.GRAND_TOTAL);
		
		String currentTipText = tipTextView.getText().toString();
		currentTipText = currentTipText + "$" + tip;
		
		String currentTotalText = totalTextView.getText().toString();
		currentTotalText = currentTotalText + "$" + total;
		
		tipTextView.setText(currentTipText);
		totalTextView.setText(currentTotalText);
	}
}
