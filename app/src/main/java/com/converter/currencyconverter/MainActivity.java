package com.converter.currencyconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button convertButton = (Button)findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ConvertAmount();
            }
        });
    }

    public void ConvertAmount() {
        final EditText inputAmount = (EditText) findViewById(R.id.inputAmount);
        String inputAmountValidator = inputAmount.getText().toString().trim();
        EditText outputAmount = (EditText) findViewById(R.id.outputAmount);

        //Radio group 1
        RadioGroup currencyRadioGroup = (RadioGroup) findViewById(R.id.currencyRadioGroup);
        int radioButtonID_1 = currencyRadioGroup.getCheckedRadioButtonId();
        View radioButton_1 = currencyRadioGroup.findViewById(radioButtonID_1);
        int id_1 = currencyRadioGroup.indexOfChild(radioButton_1);

        //Radio group 2
        RadioGroup convertToRadioGroup = (RadioGroup) findViewById(R.id.convertToRadioGroup);
        int radioButtonID_2 = convertToRadioGroup.getCheckedRadioButtonId();
        View radioButton_2 = convertToRadioGroup.findViewById(radioButtonID_2);
        int id_2 = convertToRadioGroup.indexOfChild(radioButton_2);

        if (inputAmountValidator.isEmpty() || inputAmountValidator.length() == 0 || inputAmountValidator.equals("") || inputAmountValidator == null) {
            Toast.makeText(MainActivity.this, "Input amount empty!",
                    Toast.LENGTH_SHORT).show();
        } else if (id_1 == -1 && id_2 == -1) {
            Toast.makeText(MainActivity.this, "Please check currency!",
                    Toast.LENGTH_SHORT).show();
        } else if (id_1 == -1) {
            Toast.makeText(MainActivity.this, "Please check base currency!",
                    Toast.LENGTH_SHORT).show();
        } else if (id_2 == -1) {
            Toast.makeText(MainActivity.this, "Please check target currency!",
                    Toast.LENGTH_SHORT).show();
        } else {
            ConvertHelper(id_1, id_2, inputAmountValidator, outputAmount);
        }
    }

    private void ConvertHelper(int id_1, int id_2, String inputAmount, EditText outputAmount) {
        Double inputVal = Double.parseDouble(inputAmount);
        double output;
        if (id_1 == 0 && id_2 == 0) {
            output = inputVal / (1.34);
            double rounded = (double) Math.round(output * 10000) / 10000;
            outputAmount.setText(String.valueOf(rounded));
        }

        if (id_1 == 1 && id_2 == 0) {
            output = inputVal / (1.32);
            double rounded = (double) Math.round(output * 10000) / 10000;
            outputAmount.setText(String.valueOf(rounded));
        }

        if (id_1 == 2 && id_2 == 0) {
            output = inputVal / (68.14);
            double rounded = (double) Math.round(output * 10000) / 10000;
            outputAmount.setText(String.valueOf(rounded));
        }

        if (id_1 == 0 && id_2 == 1) {
            output = inputVal / (1.34);
            output = output * (0.83);
            double rounded = (double) Math.round(output * 10000) / 10000;
            outputAmount.setText(String.valueOf(rounded));

        }

        if (id_1 == 1 && id_2 == 1) {
            output = inputVal / (1.32);
            output = output * (0.83);
            double rounded = (double) Math.round(output * 10000) / 10000;
            outputAmount.setText(String.valueOf(rounded));

        }

        if (id_1 == 2 && id_2 == 1) {
            output = inputVal / (68.14);
            output = output * (0.83);
            double rounded = (double) Math.round(output * 10000) / 10000;
            outputAmount.setText(String.valueOf(rounded));

        }
    }


    public void ClearAll(View v) {
        final EditText inputAmount = (EditText) findViewById(R.id.inputAmount);
        EditText outputAmount = (EditText) findViewById(R.id.outputAmount);
        RadioGroup currencyRadioGroup = (RadioGroup) findViewById(R.id.currencyRadioGroup);
        RadioGroup convertToRadioGroup = (RadioGroup) findViewById(R.id.convertToRadioGroup);

        inputAmount.getText().clear();
        outputAmount.getText().clear();
        currencyRadioGroup.clearCheck();
        convertToRadioGroup.clearCheck();
    }
}
