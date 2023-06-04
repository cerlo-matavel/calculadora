package mz.ac.isutc.i31.calculadora.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import mz.ac.isutc.i31.calculadora.R;
import mz.ac.isutc.i31.calculadora.databinding.ActivityCalculadoraBinding;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView previousCalculation;

    private EditText display;
    private ActivityCalculadoraBinding binding;
    private static boolean landscape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculadoraBinding.inflate(getLayoutInflater());
        landscape = false;
        setContentView(binding.getRoot());

        binding.displayEditText.setShowSoftInputOnFocus(false);

        binding.rotateBT.setOnClickListener(
                v -> {
                    if(!landscape){
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                        landscape = true;
                    }
                    else{
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                        landscape = false;
                    }
                }
        );

    }
    private void  updateText(String strToAdd){
        String oldStr = binding.displayEditText.getText().toString();

        int cursorPos = binding.displayEditText.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        binding.displayEditText.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        binding.displayEditText.setSelection(cursorPos + strToAdd.length());
       // binding.displayEditText.setText(strToAdd);
    }
    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }
    public void multiplyBTNPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divideText));
    }
    public void subtractBTNPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }
    public void addBTNPush(View view){
        updateText(getResources().getString(R.string.addText));
    }
    public void clearBTNPush(View view){
        //updateText(getResources().getString(R.string.clearText));
       binding.displayEditText.setText("");
    }
    public void parOpenBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void parCloseBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void equalBTNPush(View view){
        //updateText(getResources().getString(R.string.equalsText));
    }
    public void backspaceBTNPush(View view){
        //updateText(getResources().getString(R.string.backspace));
        int cursorPos = binding.displayEditText.getSelectionStart();
        int textLen = binding.displayEditText.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) binding.displayEditText.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            binding.displayEditText.setText(selection);
            binding.displayEditText.setSelection(cursorPos-1);
        }
    }
    public void decimalBTNPush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }

}