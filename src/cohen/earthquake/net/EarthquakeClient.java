package cohen.earthquake.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import cohen.earthquake.EarthquakeFeed;

/**
 * This is code to download the GeoJSON file directly from the web, not from a local file. 
 * @author sc
 */
public class EarthquakeClient {
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		
		EarthquakeFeed feed = gson.fromJson(reader, EarthquakeFeed.class);
		
		System.out.println(
				feed.getFeatures()
				.stream()
				.filter(e -> e.getProperties().getMag() >= 5)
				.count());
		
	}
	
}
