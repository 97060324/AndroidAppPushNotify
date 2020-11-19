package nl.lensmedia.verkeersborden;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements Runnable{
    Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mThread = new Thread(this);

        mThread.start();

        // Hide the status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // If the status bar is not hidden, hide that too.
        ActionBar actionBar = getActionBar();
        if(actionBar != null) actionBar.hide();
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