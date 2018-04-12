package ru.haknazarovfarkhod.startandroid;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.haknazarovfarkhod.startandroid.lesson2_LiveData.DataController;
import ru.haknazarovfarkhod.startandroid.lesson3_LiveData2.DataControllerInt;
import ru.haknazarovfarkhod.startandroid.lisson1_Lifecycle.MyServer;

public class MainActivity extends AppCompatActivity {
    MyServer myServer = new MyServer();
    private TextView mainTextView;
    private Button testButton;
    private Button buttonlsn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.mainTextView);
        testButton = findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataController.getInstance().setDataIntoLiveData("new text");
            }
        });
        buttonlsn3 = findViewById(R.id.buttonlsn3);

        buttonlsn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataControllerInt.getInstance().setData("45");
            }
        });
        getLifecycle().addObserver(myServer);

        LiveData<String> liveData = DataController.getInstance().getData();

        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String value) {
                mainTextView.setText(value);
            }
        });

        LiveData<Integer> liveDataInt = DataControllerInt.getInstance().getIntegerLiveData();
        liveDataInt.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                mainTextView.setText(integer.toString());
            }
        });
    }
}
