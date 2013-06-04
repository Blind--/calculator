package com.example.calculator;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText text;
	private Calculator calc;
	private Integer first, sec;
	private ArrayList<Integer> hist;
	private int curr;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText)findViewById(R.id.Row1_ShowInput);
        
        final Button[] num = new Button[10];
        final Button[] oper = new Button[6];
        final int[] ids_op = {R.id.buttonADD,R.id.buttonMINUS,R.id.buttonMULTIPLY,R.id.buttonDIVIDE,R.id.buttonClear,R.id.buttonEQUALS};
        final int[] ids_num = {R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,
        		R.id.button6,R.id.button7,R.id.button8,R.id.button9};
        

        //operators
        for (int j = 0; j < oper.length; j++) {
        	oper[j] = (Button)findViewById(ids_op[j]);
        	oper[j].setOnClickListener(new View.OnClickListener() {
        		public void onClick(View v) {
        			curr = Integer.parseInt(text.toString());
    				text.setText(((Button)v).getText());;
        		}
        	});
        }
        
        
//        switch(v.getId()) {
//    	case R.id.buttonClear:
//    		text.setText("");
//    		break;    		     
//    	case R.id.buttonADD:
//			op = '+';
//		case R.id.buttonMINUS:
//			op = '-';
//			break;
//		case R.id.buttonMULTIPLY:
//			op = '*';
//			break;
//		case R.id.buttonDIVIDE:
//			op = '/';
//			break;

        
        //numbers
        for (int i = 0; i < num.length; i++) {
        	num[i] = (Button)findViewById(ids_num[i]);
        	num[i].setOnClickListener(new View.OnClickListener() {
    			public void onClick(View v) {
    				text.append(((Button)v).getText());
    			}	
    		});
        }

    }
    public static boolean isInteger(String str) {
        try { 
            Integer.parseInt(str); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
    
    
//    public void updateDisplay() {
//    	text.setText(calc.toString());
//    }
    
    public class Calculator {
    	private int num1, num2;
    	private String res;
    	public Calculator(int a, int b) {
    		num1 = a;
    		num2 = b;
    		res = "";
    	}
    	public void add() {
            Integer sum = num1 + num2;
            res = sum.toString();
    	}
        public void div() {
            if (num2 == 0) {
                res = "error: cannot divide by 0";
            } else {
            	Double temp = (double)num1 / (double)num2;
                res = temp.toString();
            }
        }
        public void minus() {
            Integer diff = num1 - num2;
            res = diff.toString();
        }
        public int mult() {
            return num1 * num2;
        }
        @Override
        public String toString() {
        	return res;
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
