package edu.westga.cs6242.robertcarswellstaticfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DataDisplayFragment extends Fragment {
    private TextView textView;
    private DataDisplayListener listener;
    private Double number1;
    private Double number2;
    private Double product;

    public DataDisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);

        Button additionButton = (Button) theView.findViewById(R.id.button1);
        additionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                additionButtonClicked();
            }
        });

        this.textView = (TextView) theView.findViewById(R.id.textView1);

        return theView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataDisplayListener) context;
    }

    private void additionButtonClicked() {
        this.listener.onDataDisplay(this.number1, this.number2);
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }

    public void multiply() {
        this.product = this.number1 * this.number2;
    }

    public void displayProduct() {
        this.textView.setText(String.format("%.2f", this.product));
    }

    public interface DataDisplayListener {
        void onDataDisplay(Double number1, Double number2);
    }
}