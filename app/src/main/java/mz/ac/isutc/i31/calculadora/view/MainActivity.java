package mz.ac.isutc.i31.calculadora.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mz.ac.isutc.i31.calculadora.view.calculadora.CalculadoraActivity;
import mz.ac.isutc.i31.calculadora.databinding.ActivityMainBinding;
import mz.ac.isutc.i31.calculadora.view.grafico.GraficoActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.cardCalculadora.setOnClickListener(
                v -> {
                    Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                    startActivity(intent);
                }
        );

        binding.cardGrafico.setOnClickListener(
                v -> {
                    Intent intent = new Intent(MainActivity.this, GraficoActivity.class);
                    startActivity(intent);
                }
        );

    }
}