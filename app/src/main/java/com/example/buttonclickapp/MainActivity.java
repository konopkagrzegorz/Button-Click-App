package com.example.buttonclickapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private TextView textView;
    private int counter = 0;
    private final String TEXTVIEW_CONTENT = "textViewContent";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        editText.setText("");
        textView.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod());
        View.OnClickListener counterOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(editText.getText().toString().equals(""))) {
                    counter++;
                    String result = editText.getText().toString() + " was pressed " + counter + " time";
                    if (counter > 1) {
                        result += "s";
                    }
                    result += ".\n";
                    textView.append(result);
                    editText.setText("");
                }
            }
        };
        button.setOnClickListener(counterOnClickListener);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(TEXTVIEW_CONTENT, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString(TEXTVIEW_CONTENT));
    }
}