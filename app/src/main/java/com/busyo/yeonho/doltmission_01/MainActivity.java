package com.busyo.yeonho.doltmission_01;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    ScrollView scrollView1;
    ScrollView scrollView2;
    ImageView imageView1;
    ImageView imageView2;
    int indexImage = 0; ///ㅣㅣㅣ///0 은 위에 그림을, 1은 아래에 그림을,
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView1 = (ScrollView) findViewById(R.id.scrollView1);
        scrollView2 = (ScrollView) findViewById(R.id.scrollView2);

        scrollView1.setHorizontalScrollBarEnabled(true);
        scrollView1.setVerticalScrollBarEnabled(true);
        scrollView2.setHorizontalScrollBarEnabled(false);
        scrollView2.setVerticalScrollBarEnabled(false);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.img01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView1.setImageDrawable(bitmap);
        imageView1.getLayoutParams().width=bitmapWidth;
        imageView1.getLayoutParams().height=bitmapHeight;
        imageView2.setImageDrawable(bitmap);
        imageView2.getLayoutParams().width=bitmapWidth;
        imageView2.getLayoutParams().height=bitmapHeight;

        //image_0();//처음에는 위쪽 그림을 보여준다

        Button btup = (Button)findViewById(R.id.btup);
        btup.setOnClickListener(new View.OnClickListener() { //위로 버튼을 누를때
            @Override
            public void onClick(View v) { //imageIndex 가 1 인 상태이면(아래에 그림이 있으면 1)
                Toast.makeText(getApplicationContext(), "위쪽 버튼누름", Toast.LENGTH_SHORT).show();
                if (indexImage == 1) {

                    //image_0();//imageview1 (위쪽 이미지뷰) 에 그림을 불러오는것을 수행하고

                    scrollView1.setHorizontalScrollBarEnabled(true);
                    scrollView1.setVerticalScrollBarEnabled(true);
                    scrollView2.setHorizontalScrollBarEnabled(false);
                    scrollView2.setVerticalScrollBarEnabled(false);

                    imageView1.setVisibility(View.VISIBLE); //위쪽이미지뷰는 보여주고
                    imageView2.setVisibility(View.GONE); //아래쪽이미지뷰는 안보여준다
                    indexImage=0;//위쪽그림을 보여줬으니깐 imageIndex는 0으로 변경(위쪽이 그림이 있다는 뜻이다)

                }
            }
        });
        Button btdn = (Button)findViewById(R.id.btdn);
        btdn.setOnClickListener(new View.OnClickListener() { //아래로 버튼을 누를때
            @Override
            public void onClick(View v) { //imageIndex 가 0 인 상태이면(아래에 그림이 있으면 0)
                Toast.makeText(getApplicationContext(), "아래쪽 버튼누름", Toast.LENGTH_SHORT).show();
                if (indexImage==0)
                {

                    //image_1();//imageview2 (아래쪽 이미지뷰) 에 그림을 불러오는것을 수행하고
                    scrollView1.setHorizontalScrollBarEnabled(false);
                    scrollView1.setVerticalScrollBarEnabled(false);
                    scrollView2.setHorizontalScrollBarEnabled(true);
                    scrollView2.setVerticalScrollBarEnabled(true);
                    imageView1.setVisibility(View.GONE); //위쪽이미지뷰는 안보여주고
                    imageView2.setVisibility(View.VISIBLE); //아래쪽이미지뷰는 보여준다
                    indexImage=1;//아래쪽그림을 보여줬으니깐 imageIndex는 1으로 변경(아래쪽이 그림이 있다는 뜻이다)
                }
            }
        });
    }
    /*
    public void image_0(){//처음에는 이미지를 버튼을 누를때 마다 불러오는것으로 했다가 1번 불러오고 보여주고 안보여주고로 변경하여 아래부분을 주석처리

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.img01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView1.setImageDrawable(bitmap);
        imageView1.getLayoutParams().width=bitmapWidth;
        imageView1.getLayoutParams().height=bitmapHeight;

    }
    */
    /*
    public void image_1(){

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.img01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView2.setImageDrawable(bitmap);
        imageView2.getLayoutParams().width=bitmapWidth;
        imageView2.getLayoutParams().height=bitmapHeight;

    }
`*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
