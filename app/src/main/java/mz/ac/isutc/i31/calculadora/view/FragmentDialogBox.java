package mz.ac.isutc.i31.calculadora.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import mz.ac.isutc.i31.calculadora.R;

public class FragmentDialogBox extends DialogFragment {

    private AlertDialogListener listener;
    String[] lista;

    public interface AlertDialogListener {
        void onOptionSelected(int position);
    }

    public FragmentDialogBox(String[] lista) {
        this.lista = lista;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (AlertDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context + " deve implementar a interface AlertDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.operacoes_anteriores);

        builder.setItems(lista, (dialog, which) ->
                    listener.onOptionSelected(which)
                );
        return builder.create();
    }


}