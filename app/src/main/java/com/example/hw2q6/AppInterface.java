package com.example.hw2q6;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AppInterface extends RelativeLayout
{
    private EditText inputNumber;
    private TextView answerView;
    private Button btnSubmit;


    //constructor
    public AppInterface(Context context , View.OnClickListener buttonHandler)
    {
        super(context);

        final int DP = (int)(getResources().getDisplayMetrics().density);

        //Text view (enter a number)
        TextView labelMessage = new TextView(context);
        labelMessage.setId(TextView.generateViewId());
        labelMessage.setTextColor(Color.parseColor("#000000"));
        labelMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        labelMessage.setText("Enter a number");
        //setting the layouts
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0,0);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = 50*DP;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        labelMessage.setLayoutParams(params); //setting the layouts to the text view
        addView(labelMessage); //adding the text to the screen

        //Edit text (input number)
        inputNumber = new EditText(context);
        inputNumber.setId(EditText.generateViewId());
        inputNumber.setTextColor(Color.parseColor("#000000"));
        inputNumber.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        inputNumber.setHint("Num");
        inputNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        //setting the layouts
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = 30*DP;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.BELOW,labelMessage.getId());
        inputNumber.setLayoutParams(params); //setting the layouts to edit box
        addView(inputNumber); //adding the edit box to the screen

        //Text view (answer)
        answerView = new TextView(context);
        answerView.setId(TextView.generateViewId());
        answerView.setTextColor(Color.parseColor("#000000"));
        answerView.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        answerView.setHint("Answer");
        //setting the layouts
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = 30*DP;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.BELOW,inputNumber.getId());
        answerView.setLayoutParams(params); //setting the the layouts to the text view
        addView(answerView) ;//adding the text view to the screen

        //Button (submit button)
        btnSubmit = new Button(context);
        btnSubmit.setId(Button.generateViewId());
        btnSubmit.setBackgroundColor(Color.parseColor("#B0E0E6"));
        btnSubmit.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        btnSubmit.setText("Submit");
        btnSubmit.setAllCaps(false);
        //setting the layout
        params = new LayoutParams(0,0);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = 30*DP;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.BELOW,answerView.getId());
        btnSubmit.setOnClickListener(buttonHandler); // adding a button handler to the button
        btnSubmit.setLayoutParams(params); //setting the layout to the button
        addView(btnSubmit); //adding the button to the screen

    }

    //method to get the number from the edit box
    public int getNumber()
    {
        String strNumber = inputNumber.getText().toString();

        int number=0;
        try {
            number = Integer.parseInt(strNumber);
        }
        catch (NumberFormatException e){

        }

        return number;
    }

    //method the print the message to the screen
    public void setMessage(String message)
    {
        answerView.setText(message);
    }

}
