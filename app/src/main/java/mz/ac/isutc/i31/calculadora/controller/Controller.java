package mz.ac.isutc.i31.calculadora.controller;

import android.widget.EditText;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

public class Controller {

    public static void changeText(String strToAdd, EditText component){
        String oldStr = component.getText().toString();

        int cursorPos = component.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        component.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        component.setSelection(cursorPos + strToAdd.length());
    }

    public static double calculate(String expressao){

        Expression exp = new Expression(expressao);
        mXparser.setDegreesMode();

        return exp.calculate();
    }

}
