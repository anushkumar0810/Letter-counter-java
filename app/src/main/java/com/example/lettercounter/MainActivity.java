package com.example.lettercounter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    EditText editText;

    @SuppressLint({"MissingInflatedId", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(v -> {
            String input = editText.getText().toString().toLowerCase();
            int[] letterCounts = new int[26]; // Assuming only lowercase letters
            int totalLetters = 0;

            // Count the occurrences of each letter
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    letterCounts[c - 'a']++;
                    totalLetters++;
                }
            }

            // Prepare the result string
            StringBuilder result = new StringBuilder();
            for (char c = 'a'; c <= 'z'; c++) {
                if (letterCounts[c - 'a'] > 0) {
                    result.append(c).append(": ").append(letterCounts[c - 'a']).append("\n");
                }
            }

            textView.setText(String.format("Total letters: %d\n\n%s", totalLetters, result.toString()));

        });

    }
}