package rachmanforniandi.com.latihanfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListDataFragment.ItemSelected{

    TextView tvDescriptionItem;
    ArrayList<String>descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescriptionItem = findViewById(R.id.tv_description_item);

        descriptions = new ArrayList<>();
        descriptions.add("Description of 1st item");
        descriptions.add("Description of 2nd item");
        descriptions.add("Description of 3rd item");
        descriptions.add("Description of 4th item");
        descriptions.add("Description of 5th item");
    }

    @Override
    public void onItemSelected(int index) {
        tvDescriptionItem.setText(descriptions.get(index));
    }
}
