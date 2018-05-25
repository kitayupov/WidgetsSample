package com.kbnt.qam.statuswidgetsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.kbnt.qam.roundbuttons.PhotoButton;
import com.kbnt.qam.roundbuttons.RecordButton;
import com.kbnt.qam.roundbuttons.RoundButton;
import com.kbnt.qam.statuswigdet.BatteryStatusRow;
import com.kbnt.qam.statuswigdet.MemoryStatusRow;
import com.kbnt.qam.statuswigdet.StatusRow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final StatusRow statusRow = findViewById(R.id.statusRow);
        final BatteryStatusRow batteryRow = findViewById(R.id.batteryRow);
        final MemoryStatusRow memoryRow = findViewById(R.id.memoryRow);

        statusRow.setValue(100);
        batteryRow.setValue(100);
        memoryRow.setValue(100);

        final RoundButton roundButton = findViewById(R.id.roundButton);
        roundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Round button", Toast.LENGTH_SHORT).show();
            }
        });

        final PhotoButton photoButton = findViewById(R.id.photoButton);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Photo clicked", Toast.LENGTH_SHORT).show();
            }
        });

        final RecordButton recordButton = findViewById(R.id.recordButton);
        recordButton.setOnRecButtonTouchListener(new RecordButton.OnRecButtonTouchListener() {
            @Override
            public void onRecordStart() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                recordButton.setRecord(true);
            }

            @Override
            public void onRecordStop() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                recordButton.setRecord(false);
            }

            @Override
            public void onMessage() {
                Log.e("TAG", "onMessage: ");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
