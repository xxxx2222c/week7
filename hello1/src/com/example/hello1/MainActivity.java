package com.example.hello1;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        EditText edit1;
        Button okbtn;
        ImageView[] images;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            edit1=(EditText)rootView.findViewById(R.id.editText1);
            okbtn=(Button)rootView.findViewById(R.id.button1);
            images=new ImageView[3];
            images[0]=(ImageView)rootView.findViewById(R.id.imageView1);
            images[1]=(ImageView)rootView.findViewById(R.id.ImageView01);
            images[2]=(ImageView)rootView.findViewById(R.id.ImageView02);
    		images[0].setVisibility(View.INVISIBLE);
    		images[1].setVisibility(View.INVISIBLE);
    		images[2].setVisibility(View.INVISIBLE);
            okbtn.setOnClickListener (new OnClickListener() {
            	public void onClick(View v)
            	{
            		int a=(int)(Math.random()*3);
            		okbtn.setVisibility(View.INVISIBLE);
            		edit1.setVisibility(View.INVISIBLE);
            		images[a].setVisibility(View.VISIBLE);
            		Toast.makeText(getActivity(), "Hello, "+ edit1.getText() + "!", Toast.LENGTH_SHORT).show();
            	}
            });
            return rootView;
        }
        
    }

}
