package mz.ac.isutc.i31.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mz.ac.isutc.i31.calculadora.calculadora.CalculadoraActivity;
import mz.ac.isutc.i31.calculadora.databinding.ActivityMainBinding;
import mz.ac.isutc.i31.calculadora.grafico.GraficoActivity;

public class MainActivity extends AppCompatActivity {

    private static ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.cardCalculadora.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                        startActivity(intent);
                    }
                }
        );

        binding.cardGrafico.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, GraficoActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}