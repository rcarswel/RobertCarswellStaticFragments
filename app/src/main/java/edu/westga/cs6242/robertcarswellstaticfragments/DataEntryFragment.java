package edu.westga.cs6242.robertcarswellstaticfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DataEntryFragment extends Fragment {
    private EditText number1Text;
    private EditText number2Text;
    private DataEntryListener listener;

    public DataEntryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View theView = inflater.inflate(R.layout.fragment_data_entry, container, false);

        this.number1Text = (EditText) theView.findViewById(R.id.editView1);
        this.number2Text = (EditText) theView.findViewById(R.id.editView2);

        Button multiplyButton = (Button) theView.findViewById(R.id.button1);
        multiplyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                multiplyButtonClicked();
            }
        });

        return theView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataEntryListener) context;
    }

    private void multiplyButtonClicked() {
        double number1 = Double.parseDouble(this.number1Text.getText().toString());
        double number2 = Double.parseDouble(this.number2Text.getText().toString());

        this.listener.onDataEntry(number1, number2);
    }

    public interface DataEntryListener {
        void onDataEntry(Double number1, Double number2);
    }
}