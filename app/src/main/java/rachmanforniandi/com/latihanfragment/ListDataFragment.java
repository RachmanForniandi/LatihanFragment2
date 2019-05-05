package rachmanforniandi.com.latihanfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListDataFragment extends ListFragment {

    ItemSelected activity;

    public interface ItemSelected{
        void onItemSelected(int index);
    }
    public ListDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected)context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> data = new ArrayList<>();
        data.add("1. This is 1st item");
        data.add("2. This is 2nd item");
        data.add("3. This is 3rd item");
        data.add("4. This is 4th item");
        data.add("5. This is 5th item");

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,data));
        activity.onItemSelected(0);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);

        activity.onItemSelected(position);
    }

}
