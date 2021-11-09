package com.example.drawer_layout_with_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class Currency_Converter extends Fragment {
    TextView tv_result;
    String[] CurrencyFrom={"INR","POUND","EURO","USD"};
    String[] CurrencyTo={"INR","POUND","EURO","USD"};
    String k,z;
    EditText num;
    int error =0;
    double amt=0;
   Button btn_submit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_currency__converter, container, false);
   tv_result=view.findViewById(R.id.tv_result);

   num=view.findViewById(R.id.et_num);
   btn_submit=view.findViewById(R.id.btn_submit);

        Spinner spin =view.findViewById(R.id.spin_from);
        Spinner spin2=view.findViewById(R.id.spin_convertto);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.spinner_options, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spin.setAdapter(adapter);
        spin2.setAdapter(adapter);

        spin2.setOnItemSelectedListener(new Currencyto());

        spin.setOnItemSelectedListener(new Currencyfrom());
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin2.setOnItemSelectedListener(new Currencyto());
                spin.setOnItemSelectedListener(new Currencyfrom());
                try {
                    float number= Float.parseFloat(num.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    error=1;
                }
                if(error==0)
                { float number= Float.parseFloat(num.getText().toString());
                    if(k=="INR")
                    {
                        if(z=="USD")
                        {
                            amt=number*0.013;
                            tv_result.setText(Double.toString(amt));
                        }
                        else if(z=="POUND")
                        {
                            amt=number*0.0099;
                            tv_result.setText(Double.toString(amt));
                        }
                        else if(z=="EURO")
                        {
                            amt=number*0.012;
                            tv_result.setText(Double.toString(amt));
                        }
                        else
                        {
                            tv_result.setText(Float.toString(number));
                        }
                    }
                    else if(k=="USD")
                    {
                        if (z == "INR") {
                            amt = number * 74.47;
                            tv_result.setText(Double.toString(amt));
                        }
                        else if(z=="POUND")
                        {
                            amt=number*0.73;
                            tv_result.setText(Double.toString(amt));
                        }
                        else if(z=="EURO")
                        {
                            amt=number*0.86;
                            tv_result.setText(Double.toString(amt));
                        }
                        else
                        {
                            tv_result.setText(Float.toString(number));
                        }
                    }
                    else if(k=="POUND")
                    {
                        if (z == "INR") {
                            amt = number * 101.45;
                            tv_result.setText(Double.toString(amt));
                        }
                        else if(z=="USD")
                        {
                            amt=number*1.36;
                            tv_result.setText(Double.toString(amt));
                        }
                        else if(z=="EURO")
                        {
                            amt=number*1.18;
                            tv_result.setText(Double.toString(amt));
                        }
                        else
                        {
                            tv_result.setText(Float.toString(number));
                        }
                    }
                    else if(k=="EURO")
                    {
                        if (z == "INR") {
                            amt = number * 86.25;
                            tv_result.setText(Double.toString(amt));
                        }
                        else if(z=="POUND")
                        {
                            amt=number*0.85;
                            tv_result.setText(Double.toString(amt));
                        }
                        else if(z=="USD")
                        {
                            amt=number*1.16;
                            tv_result.setText(Double.toString(amt));
                        }
                        else
                        {
                            tv_result.setText(Float.toString(number));
                        }
                    }

                }

            }
        });

        return view;
    }

    private class Currencyfrom implements AdapterView.OnItemSelectedListener
    {
        @Override
        public void onItemSelected(AdapterView arg0, View arg1, int position, long id)
        {if(CurrencyTo[position]=="USD")
        {
            k="USD";
        }
        else if (CurrencyTo[position]=="INR")
        {
            k="INR";

        }
        else if (CurrencyTo[position]=="POUND")
        {
            k="POUND";
        }
        else {
            k="EURO";
        }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class Currencyto implements AdapterView.OnItemSelectedListener
    {
        @Override
        public void onItemSelected(AdapterView arg0, View arg1, int position, long id)
        {
            if(CurrencyFrom[position]=="USD")
            {
                z="USD";
            }
            else if (CurrencyFrom[position]=="INR")
            {
                z="INR";

            }
            else if (CurrencyFrom[position]=="POUND")
            {
                z="POUND";
            }
            else {
                z="EURO";
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}