package edu.Calendar;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import services.Parser;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.HomeScreen.HomeScreen;

public class MenuCalendar extends SherlockListActivity {

	HashMap<String,String> terms=new HashMap<String, String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        try {
			terms = new Parser().execute("http://loras.edu/Academics/Academic-Calendar.aspx").get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

        setListAdapter(new ArrayAdapter<String>(MenuCalendar.this,
                android.R.layout.simple_list_item_1, terms.keySet().toArray(new String[terms.values().size()])));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        openPdf(position);

    }

	private void openPdf(int position) {
		String urls[] = terms.values().toArray(new String[terms.values().size()]);
        String url = urls[position];
        Intent i = new Intent(Intent.ACTION_VIEW);
        System.out.println(url);
        System.out.println(Uri.parse(url));
        i.setDataAndType(Uri.parse("http://docs.google.com/viewer?url=" + url), "text/html");
        startActivity(i);
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                Intent intent = new Intent(this, HomeScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

