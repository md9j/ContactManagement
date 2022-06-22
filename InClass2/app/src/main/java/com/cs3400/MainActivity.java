package com.cs3400;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mCancelOrder;
    private Button mPlaceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mPlaceOrder = (Button) findViewById(R.id.placeOrder);

       mPlaceOrder.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {

               Toast.makeText(MainActivity.this,
                       "Place Order!",

                       Toast.LENGTH_SHORT).show();

           }//end OnClick()

       });//end setOnClickListener()

       //mCancelOrder = (Button) findViewById(R.id.cancelOrder);

        addCancelButtonClickListener();

    }//end onCreate()

    public void onRadioButtonClick(View view){
        final RadioGroup mRadioGroup = (RadioGroup)findViewById(R.id.paymentRadioGroup);
        int mCheckRadioButtonId = mRadioGroup.getCheckedRadioButtonId();

        String toastString = "";

        switch(mCheckRadioButtonId){
            case R.id.debitCardRadioButton:;
                toastString = "Debit Card Payment";
                break;
            case R.id.creditCardRadioButton:;
                toastString = "Credit Card Payment";
                break;
            case R.id.paypalRadioButton:;
                toastString = "PayPal Payment";
                break;

        }//end switch

        Toast.makeText(MainActivity.this,
                toastString,
                Toast.LENGTH_LONG).show();
    }//end onRadioButtonClick

    class CancelClickListener implements  View.OnClickListener{

        @Override
        public void onClick(View v) {

            Toast.makeText(MainActivity.this,
                    "Order Canceled",
                    Toast.LENGTH_SHORT).show();

        }//end onClick()

    }//end CancelClickListener{}

    private void addCancelButtonClickListener(){

        mCancelOrder = (Button) findViewById(R.id.cancelOrder);
        mCancelOrder.setOnClickListener(new CancelClickListener());

    }//end addCancelButtonClickListener



}//end MainActivity{}