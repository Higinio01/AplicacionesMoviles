package com.example.tarea01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.tarea01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.proyecto.MESSAGE";
    ActivityMainBinding binding;
    private Spinner spinnerGenero;

    private EditText editTextTexto;
    private String programar = "";
    String lenguajes ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_main);

        spinnerGenero = findViewById(R.id.spnGenero);

        String[] opciones = {"Masculino", "Femenino"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenero.setAdapter(adapter);

        //TextView view = (View) findViewById(R.id);

        EditText etPlannedDate = (EditText) findViewById(R.id.etPlannedDate);// binding.etPlannedDate;
        etPlannedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.etPlannedDate) {
                    showDatePickerDialog();
                }
            }

            private void showDatePickerDialog() {
                DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        // +1 because January is zero
                        final String selectedDate = day + " / " + (month + 1) + " / " + year;
                        etPlannedDate.setText(selectedDate);
                    }
                });

                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        EditText Nombre = (EditText) findViewById(R.id.txtNombre);
        EditText Apellido = (EditText) findViewById(R.id.txtApellido);
        //String Genero = spinnerGenero.getSelectedItem().toString();
        EditText Fecha = (EditText) findViewById(R.id.etPlannedDate);
        CheckBox checkBoxCmasmas = findViewById(R.id.cbxCmasmas);
        CheckBox checkBoxCsharp = findViewById(R.id.cbxC);
        CheckBox checkBoxPython = findViewById(R.id.cbxPython);
        CheckBox checkBoxJava = findViewById(R.id.cbxJava);
        CheckBox checkBoxJS = findViewById(R.id.cbxJS);
        CheckBox checkBoxGo = findViewById(R.id.cbxGo);
        RadioButton btnNo = (RadioButton) findViewById(R.id.rbtnNo);
        RadioButton btnSi = (RadioButton) findViewById(R.id.rbtnSi);
        Button btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nombre.setText("");
                Apellido.setText("");
                etPlannedDate.setText("");
                btnSi.setChecked(true);
                btnNo.setChecked(false);
                checkBoxGo.setChecked(false);
                checkBoxCmasmas.setChecked(false);
                checkBoxCsharp.setChecked(false);
                checkBoxPython.setChecked(false);
                checkBoxJS.setChecked(false);
                checkBoxJava.setChecked(false);


            }
        });
        btnSi.setChecked(true);
        btnNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxGo.setEnabled(false);
                    checkBoxCmasmas.setEnabled(false);
                    checkBoxCsharp.setEnabled(false);
                    checkBoxPython.setEnabled(false);
                    checkBoxJS.setEnabled(false);
                    checkBoxJava.setEnabled(false);
                    checkBoxGo.setChecked(false);
                    checkBoxCmasmas.setChecked(false);
                    checkBoxCsharp.setChecked(false);
                    checkBoxPython.setChecked(false);
                    checkBoxJS.setChecked(false);
                    checkBoxJava.setChecked(false);


                } else {
                    checkBoxGo.setEnabled(true);
                    checkBoxCmasmas.setEnabled(true);
                    checkBoxCsharp.setEnabled(true);
                    checkBoxPython.setEnabled(true);
                    checkBoxJS.setEnabled(true);
                    checkBoxJava.setEnabled(true);
                }
            }
        });
        checkBoxGo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lenguajes= lenguajes + "\n-Go land";
                }
            }
        });
        checkBoxJS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lenguajes= lenguajes + "\n-JS";
                }
            }
        });

        checkBoxCmasmas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lenguajes= lenguajes + "\n-C/C++";
                }
            }
        });

        checkBoxCsharp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lenguajes= lenguajes + "\n-C#";
                }
            }
        });

        checkBoxPython.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lenguajes= lenguajes + "\n-Python";
                }
            }
        });

        checkBoxJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lenguajes= lenguajes + "\n-Java";
                }
            }

        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText Nombre = (EditText) findViewById(R.id.txtNombre);
        EditText Apellido = (EditText) findViewById(R.id.txtApellido);
        String Genero = spinnerGenero.getSelectedItem().toString();
        EditText Fecha = (EditText) findViewById(R.id.etPlannedDate);
        RadioButton btnSi = (RadioButton) findViewById(R.id.rbtnSi);
        RadioButton btnNo = (RadioButton) findViewById(R.id.rbtnNo);
        CheckBox checkBoxGo = findViewById(R.id.cbxGo);



        CheckBox checkBoxCmasmas = findViewById(R.id.cbxCmasmas);
        CheckBox checkBoxCsharp = findViewById(R.id.cbxC);
        CheckBox checkBoxPython = findViewById(R.id.cbxPython);
        CheckBox checkBoxJava = findViewById(R.id.cbxJava);
        CheckBox checkBoxJS = findViewById(R.id.cbxJS);
        Button btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nombre.setText("");
                Apellido.setText("");
                Fecha.setText("");
                btnSi.setChecked(true);
                btnNo.setChecked(false);
                checkBoxGo.setChecked(false);
                checkBoxCmasmas.setChecked(false);
                checkBoxCsharp.setChecked(false);
                checkBoxPython.setChecked(false);
                checkBoxJS.setChecked(false);
                checkBoxJava.setChecked(false);


            }
        });

        if (btnSi.isChecked()) {
            programar= "Me gusta programar. Mis lenguajes favoritos son:";
        } else if (btnNo.isChecked()) {
            programar= "No me gusta programar";


        }


        String message = "Hola!, Mi nombre es "+Nombre.getText().toString()+" "+Apellido.getText().toString()+".\n\nSoy "+Genero.toString()+", y naci en fecha "+Fecha.getText().toString()+".\n\n"+programar+".";
        message = message+" "+lenguajes;
        intent.putExtra(EXTRA_MESSAGE,message);

        startActivity(intent);
        lenguajes= "";


    }



    

}


