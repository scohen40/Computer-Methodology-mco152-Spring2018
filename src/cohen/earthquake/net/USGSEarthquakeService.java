package cohen.earthquake.net;

import cohen.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.http.GET;

public interface USGSEarthquakeService {
	
	@GET("earthquakes/feed/v1.0/summary/all_month.geojson")
	Call<EarthquakeFeed> getAllMonth();
	
}
