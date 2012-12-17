package services;

import java.io.IOException;

import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

import android.os.AsyncTask;

public class Parser extends AsyncTask<String, Void, HashMap<String, String>> {
	HashMap<String, String> content=new HashMap<String, String>();

	@Override
	protected HashMap<String, String> doInBackground(String... url) {
		Document webCalendar = null;
		try {
			webCalendar = Jsoup.connect(url[0]).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Elements webContents = webCalendar.select("a[href~=(Calendar\\d+)]");
    	for(int index = 0; index < webContents.size(); index++){
    		content.put(webContents.get(index).ownText(), webContents.get(index).attr("abs:href"));
    	}		
    	return content;
	}
	
	 
}
