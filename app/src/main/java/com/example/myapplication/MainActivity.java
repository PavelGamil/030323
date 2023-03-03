package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // создание полей для вывода на экран нужных значений
    private TextView textCount; // окно вывода значения счётчика
    private Button button; // кнопка счётчика
    private int count = 0; // переменная счётчика

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // присваивание переменным активити элементов представления activity_main
        textCount = findViewById(R.id.textCount);
        button = findViewById(R.id.button);

        // выполнение действий при нажатии кнопки
        button.setOnClickListener(listener);
    }

    // объект обработки нажатия кнопки (слушатель)
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            count++; // инкрементирование счётчика
            textCount.setText(Integer.toString(count));
        }
    };

    @Override
    protected void onStart() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, "Старт активности", Toast.LENGTH_SHORT); // инициализация
        toast.show(); // демонстрация тоста на экране
        super.onStart();
    }

    @Override
    protected void onResume() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, R.string.resume_activity, Toast.LENGTH_SHORT); // инициализация
        toast.setGravity(Gravity.CENTER, 0, 0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
        // помещение тоста в контейнер
        super.onResume();
    }

    @Override
    protected void onPause() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, R.string.pause_activity, Toast.LENGTH_SHORT); // инициализация
        toast.setGravity(Gravity.TOP, 0, 0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
        toast.show(); // демонстрация тоста на экране
        super.onPause();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key", count);
        Toast toast = Toast.makeText(this, "запись данных в контейнере Bundle", Toast.LENGTH_SHORT); //инициализация
        toast.show(); //демонстрация на экран
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("key");
        Toast toast = Toast.makeText(this, "считывание контейнера из контейнера Bundle", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onStop() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, "Стоп активности", Toast.LENGTH_SHORT); // инициализация
        toast.setGravity(Gravity.LEFT, 0, 0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
        toast.show(); // демонстрация тоста на экране
        super.onStop();


    }

    @Override
    protected void onDestroy() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, "Уничтожение активности", Toast.LENGTH_SHORT); // инициализация
        toast.setGravity(Gravity.BOTTOM, 0, 0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
        toast.show(); // демонстрация тоста на экране
        super.onDestroy();
    }

}
