package mz.ac.isutc.i31.calculadora.grafico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.List;

import mz.ac.isutc.i31.calculadora.databinding.ActivityTabelaGraficoBinding;

public class TabelaGraficoActivity extends AppCompatActivity {

    private XYPlot plot;

    private static ActivityTabelaGraficoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabelaGraficoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        plot = binding.grafico;

        Number xValues[] = {4,-3,-2,-1,0,1,2,3,4};
        Number yValues[] = {16,9,4,1,0,1,4,9,16};

        XYSeries ySeries= new SimpleXYSeries(
                Arrays.asList(yValues)
                ,SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"y");

        LineAndPointFormatter yFormat= new LineAndPointFormatter(Color.RED,Color.GREEN, null,null);

        plot.addSeries(ySeries, yFormat);

        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                int i = Math.round(    ((Number)obj).floatValue() );
                return toAppendTo.append(xValues[i]);
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });
    }
}