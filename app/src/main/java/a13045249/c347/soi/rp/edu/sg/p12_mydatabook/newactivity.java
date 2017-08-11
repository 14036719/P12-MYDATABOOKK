package a13045249.c347.soi.rp.edu.sg.p12_mydatabook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class newactivity extends AppCompatActivity {
    ActionBar ab;
    TextView tv, tvCreated;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newactivity);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        tv = (TextView) findViewById(R.id.textView);
        tvCreated = (TextView) findViewById(R.id.textViewCreated);
        iv = (ImageView) findViewById(R.id.imageView);

        tvCreated.setText("Created By : Ah Chong, Peter, Mary");
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.with(this).load(imageUrl).into(iv);
        tv.setText("C347 Android Programming II Republic Polytechnic");
    }
}
