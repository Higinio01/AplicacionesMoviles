package com.example.tarea4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NewTareaActivity extends AppCompatActivity {

        public static final String EXTRA_REPLY = "com.example.android.tarealistsql.REPLY";

        private EditText mEditTareaView;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_tarea);
            mEditTareaView = findViewById(R.id.edit_tarea);

            final Button button = findViewById(R.id.button_save);
            button.setOnClickListener(view -> {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTareaView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditTareaView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            });
        }
}