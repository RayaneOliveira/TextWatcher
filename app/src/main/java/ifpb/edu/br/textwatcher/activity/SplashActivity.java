package ifpb.edu.br.textwatcher.activity;

/**
 * Created by Rayane on 27/02/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import ifpb.edu.br.textwatcher.R;

public class SplashActivity extends Activity implements Runnable {

    ImageView imageView;

    private static final long SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(this, SPLASH_TIME_OUT);

        ImageView image = (ImageView)findViewById(R.id.imageview);

        AlphaAnimation animation = new AlphaAnimation(0.2f, 1.0f);
        animation.setDuration(500);
        animation.setStartOffset(4000);
        animation.setFillAfter(true);
        image.startAnimation(animation);
    }

    @Override
    public void run() {
        Intent intent = new Intent(this, BuscarNomeActivity.class);
        startActivity(intent);
        finish();
    }
}
