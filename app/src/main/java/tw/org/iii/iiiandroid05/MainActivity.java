package tw.org.iii.iiiandroid05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter adapter;
    private LinkedList<HashMap<String,String>> data;
    private String[] from = {"title", "mesg"};
    private int[] to = {R.id.item_title, R.id.item_mesg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        initListView();
    }

    private void initListView(){
        data = new LinkedList<>();

        for (int i=0; i<20; i++){
            HashMap<String,String> dd = new HashMap<>();
            int rand = (int)(Math.random()*49+1);
            dd.put(from[0], "Title " + rand);
            dd.put(from[1], "Content: " + rand);
            data.add(dd);
        }
        adapter = new SimpleAdapter(
                        this, data,
                        R.layout.item_test1,
                        from, to);

        listView.setAdapter(adapter);

    }
}
