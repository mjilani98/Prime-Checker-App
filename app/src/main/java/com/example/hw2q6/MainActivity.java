package com.example.hw2q6;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private IsPrime isPrime ;
    private AppInterface appinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //creating a button handler object
        ButtonHandler buttonHandler = new ButtonHandler();

        //creating is prime object
        isPrime = new IsPrime();

        //creating an app interface object
        appinterface = new AppInterface(this ,buttonHandler);

        //setting the screen
        setContentView(appinterface);


    }

    private class ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v)
        {
            //getting the number from the screen
            int number = appinterface.getNumber();

            //sending the number to the model ,to decide weather the number is prime or not
            isPrime.setNumber(number);

            //string variable that will be determined based on if the number is prime or not
            String message = "";

            if(isPrime.getIsPrime())
                message = "Prime number";
            else
                message = "Not prime number";

            //sending the message back to the screen
            appinterface.setMessage(message);


        }
    }
}