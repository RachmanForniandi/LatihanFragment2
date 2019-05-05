package rachmanforniandi.com.latihanfragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListDataFragment.ItemSelected{

    TextView tvDescriptionItem;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescriptionItem = findViewById(R.id.tv_description_item);

        descriptions = getResources().getStringArray(R.array.descriptions);

        if (findViewById(R.id.layout_portrait)!= null){
            FragmentManager fm = this.getSupportFragmentManager();

            fm.beginTransaction()
                    .hide(fm.findFragmentById(R.id.detail_fragment))
                    .show(fm.findFragmentById(R.id.list_fragment))
                    .commit();
        }

        if (findViewById(R.id.layout_land)!= null){
            FragmentManager fm = this.getSupportFragmentManager();

            fm.beginTransaction()
                    .show(fm.findFragmentById(R.id.detail_fragment))
                    .show(fm.findFragmentById(R.id.list_fragment))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        tvDescriptionItem.setText(descriptions[index]);

        if (findViewById(R.id.layout_portrait)!= null){
            FragmentManager fm = this.getSupportFragmentManager();

            fm.beginTransaction()
                    .show(fm.findFragmentById(R.id.detail_fragment))
                    .hide(fm.findFragmentById(R.id.list_fragment))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
