package mz.ac.isutc.i31.calculadora.view.grafico;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Arrays;

import mz.ac.isutc.i31.calculadora.controller.Controller;
import mz.ac.isutc.i31.calculadora.databinding.ActivityTabelaGraficoBinding;

public class TabelaGraficoActivity extends AppCompatActivity {

    private XYPlot plot;

    //LineGraphSeries<DataPoint> series;
    private ActivityTabelaGraficoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabelaGraficoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        plot = binding.grafico;

        String data = getIntent().getStringExtra("funcao");

        Number[] xValues = {-6,-5,-4,-3,-2,-1,0,1,2,3,4,5};
        //Number yValues[] = {32,16,9,4,1,0,1,4,9,16,32};
        Number[] yValues = new Number[xValues.length];
        for (int i = 0; i < xValues.length; i++){
            yValues[i] = Controller.calculate(
                    data.replace("x"
                            , xValues[i]
                                    .toString()));
        }

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

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabelaGraficoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        String data = getIntent().getStringExtra("funcao");

        double y, x;
        x = -50.0;

        series = new LineGraphSeries<DataPoint>();

        for (int i = 0; i < 500; i++){
            x = x + 0.1;
            y = Controller.calculate(
                    data.replace("x", String.valueOf(x))
            );
            //y = Math.sin(x);

            series.appendData(new DataPoint(x,y), true, 500);
        }

        binding.grafico.addSeries(series);

    }*/

}