package nl.besuikerd.imageloader.example;

import java.util.Arrays;
import java.util.List;

import nl.besuikerd.imageloader.R;
import nl.besuikerd.viewholder.DefaultViewHolderFactory;
import nl.besuikerd.viewholder.ViewHolderListAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewHolderListAdapter<TestReference> adapter = new ViewHolderListAdapter<TestReference>(this, new DefaultViewHolderFactory<TestReference>(TestViewHolder.class));
        List<TestReference> list = Arrays.asList(
        	new TestReference(2),
        	new TestReference(5745),
        	new TestReference(14529),
        	new TestReference(4585),
        	new TestReference(7384),
        	new TestReference(7370),
        	new TestReference(5809),
        	new TestReference(1263),
        	new TestReference(11228),
        	new TestReference(9244),
        	new TestReference(7378),
        	new TestReference(5803),
        	new TestReference(14531),
        	new TestReference(4587),
        	new TestReference(1664),
        	new TestReference(11256),
        	new TestReference(5716),
        	new TestReference(14479),
        	new TestReference(3204),
        	new TestReference(24365),
        	new TestReference(5805),
        	new TestReference(15259),
        	new TestReference(11222),
        	new TestReference(8524),
        	new TestReference(1911),
        	new TestReference(19323),
        	new TestReference(1377),
        	new TestReference(11230),
        	new TestReference(1149)
        );
        adapter.setList(list);
        ((ListView) findViewById(R.id.listView1)).setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
