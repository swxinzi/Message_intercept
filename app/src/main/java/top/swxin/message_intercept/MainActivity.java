package top.swxin.message_intercept;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    //boolean isChanged = false;
    //setContentView(R.layout.main);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1=(ImageView) findViewById(R.id.image1);
        ImageView imageView2=(ImageView) findViewById(R.id.image2);
        imageView1.setOnClickListener(listener);
        imageView2.setOnClickListener(listener);


        iv = (ImageView)findViewById(R.id.image1);
        /*iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == iv)
                {
                    if(isChanged){
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.home_solid));
                    }
                    else
                    {
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.home_empty));
                    }
                    isChanged=!isChanged;
                }
            }
        });*/

    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            Fragment f;
            f = null;
            switch (view.getId()){
                case R.id.image1:
                    f=new Message_Fragment();
                    iv.setImageDrawable(getResources().getDrawable(R.drawable.home_solid));
                    break;
                case R.id.image2:
                    f=new About_Fragment();
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fragment,f);
            ft.commit();
        }
    };
}