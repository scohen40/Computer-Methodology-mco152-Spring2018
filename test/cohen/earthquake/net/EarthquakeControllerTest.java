package cohen.earthquake.net;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import cohen.earthquake.Earthquake;
import cohen.earthquake.EarthquakeFeedModel;
import retrofit2.Call;

class EarthquakeControllerTest {

	@Test
	public void testRefreshData() {
		//given
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		USGSEarthquakeService service = Mockito.mock(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		Mockito.when(service.getAllMonth()).thenReturn(Mockito.mock(Call.class));
		Mockito.when(view.getMonthPlaceText()).thenReturn((JFormattedTextField) Mockito.mock(JTextField.class));
		
		
		//when
		controller.requestMonth();
		
		//then
		assertFalse(view.getMonthPlaceText().getText().equals(""));
	}
	
	@Test
	public void testShowLargestEarthquake() {
		//given
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		USGSEarthquakeService service = Mockito.mock(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		JTextField mag  = Mockito.mock(JTextField.class);
		JTextField place  = Mockito.mock(JTextField.class);
		
		List<Earthquake> list = new ArrayList<Earthquake>();
		list.add(new Earthquake(2, "touro brooklyn", 1));
		list.add(new Earthquake(5, "touro manhattan", 2));
		list.add(new Earthquake(3, "touro queens", 3));
		EarthquakeFeedModel model = new EarthquakeFeedModel("", list);
		
		//when
		controller.showLargestEarthquake(mag, place, model);
		
		//then
		Mockito.verify(mag).setText("5.0");
		Mockito.verify(place).setText("touro manhattan");
		
	}

	
}
