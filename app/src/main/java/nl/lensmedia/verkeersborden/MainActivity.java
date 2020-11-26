package nl.lensmedia.verkeersborden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity implements Runnable{
    Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        mThread = new Thread(this);

        mThread.start();

    }

    // SplashScreen
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));

            finish();
        }
    }
}