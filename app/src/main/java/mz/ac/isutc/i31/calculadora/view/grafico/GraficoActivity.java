package mz.ac.isutc.i31.calculadora.view.grafico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;

import mz.ac.isutc.i31.calculadora.R;
import mz.ac.isutc.i31.calculadora.controller.Controller;
import mz.ac.isutc.i31.calculadora.databinding.ActivityGraficoBinding;

public class GraficoActivity extends AppCompatActivity {

    private ActivityGraficoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGraficoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //replaceFragment();

    binding.showGraph.setOnClickListener(
            v -> {
                Intent intent = new Intent(GraficoActivity.this, TabelaGraficoActivity.class);
                intent.putExtra("funcao", binding.displayEditText.getText().toString());
                startActivity(intent);
            }
        );
    }

    public void backspaceBTNPush(View view){
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
        binding.displayEditText.setText("");
    }
    public void parOpenBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void parCloseBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    //Trigonometria
    public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void triCosBTNPush(View view){
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){
        updateText("arctan");
    }

    public void logBTNPush(View view){
        updateText("log(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }

    public void eBTNPush(View view){
        updateText("e");
    }
    public void piBTNPush(View view){
        updateText(getResources().getString(R.string.piText));
    }

    public void absBTNPush(View view){
        updateText("abs");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void xBTNPush(View view){
        updateText("x");
    }
    public void x2TNPush(View view){
        updateText("^(2)");
    }

    private void  updateText(String strToAdd){
        Controller.changeText(strToAdd,binding.displayEditText);
    }
}