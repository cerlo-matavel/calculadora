package mz.ac.isutc.i31.calculadora.grafico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import mz.ac.isutc.i31.calculadora.MainActivity;
import mz.ac.isutc.i31.calculadora.databinding.ActivityGraficoBinding;

public class GraficoActivity extends AppCompatActivity {

    private static ActivityGraficoBinding binding;
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
                startActivity(intent);
            }
    );
    }

    /*private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(binding.);
        //fragmentTransaction.commit();
    }*/
}