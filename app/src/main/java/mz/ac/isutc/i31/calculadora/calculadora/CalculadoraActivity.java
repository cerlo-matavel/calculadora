package mz.ac.isutc.i31.calculadora.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import mz.ac.isutc.i31.calculadora.databinding.ActivityCalculadoraBinding;

public class CalculadoraActivity extends AppCompatActivity {

    private ActivityCalculadoraBinding binding;
    private static boolean landscape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculadoraBinding.inflate(getLayoutInflater());
        landscape = false;
        setContentView(binding.getRoot());

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
}