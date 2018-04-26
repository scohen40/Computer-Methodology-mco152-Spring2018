package cohen.earthquake.net;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cohen.change.Change;
import cohen.change.VendingMachine;
import cohen.earthquake.Earthquake;
import cohen.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class EarthquakeRetrofitGUI extends JFrame{

	private JFormattedTextField word = new JFormattedTextField();
	private JButton month = new JButton("Biggest Earthquake This Month");
	private JButton week = new JButton("Biggest Earthquake This Week");
	private JButton today = new JButton("Biggest Earthquake Today");
	private JButton hour = new JButton("Biggest Earthquake in the Last Hour");
	private JLabel magLabel = new JLabel("Magnitude:");
	private JLabel placeLabel = new JLabel("Place:");
	private JLabel magLabel2 = new JLabel("Magnitude:");
	private JLabel placeLabel2 = new JLabel("Place:");
	private JLabel magLabel3 = new JLabel("Magnitude:");
	private JLabel placeLabel3 = new JLabel("Place:");
	private JLabel magLabel4 = new JLabel("Magnitude:");
	private JLabel placeLabel4 = new JLabel("Place:");
	private JFormattedTextField monthMagText = new JFormattedTextField();
	private JFormattedTextField monthPlaceText = new JFormattedTextField();
	private JFormattedTextField weekMagText = new JFormattedTextField();
	private JFormattedTextField weekPlaceText = new JFormattedTextField();
	private JFormattedTextField todayMagText = new JFormattedTextField();
	private JFormattedTextField todayPlaceText = new JFormattedTextField();
	private JFormattedTextField hourMagText = new JFormattedTextField();
	private JFormattedTextField hourPlaceText = new JFormattedTextField();

	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://earthquake.usgs.gov")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	USGSEarthquakeService service = retrofit.create(USGSEarthquakeService.class);
	
	public EarthquakeRetrofitGUI() throws IOException {
		setTitle("Greatest Earthquake Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,2));
		JPanel monthPan = new JPanel();
		monthPan.setLayout(new GridLayout(2,2));
		JPanel weekPan = new JPanel();
		weekPan.setLayout(new GridLayout(2,2));
		JPanel todayPan = new JPanel();
		todayPan.setLayout(new GridLayout(2,2));
		JPanel hourPan = new JPanel();
		hourPan.setLayout(new GridLayout(2,2));
		
		panel.add(month);
		panel.add(monthPan);
		panel.add(week);
		panel.add(weekPan);
		panel.add(today);
		panel.add(todayPan);
		panel.add(hour);
		panel.add(hourPan);
		
		monthPan.add(magLabel);
		monthPan.add(monthMagText);
		monthPan.add(placeLabel);
		monthPan.add(monthPlaceText);
		weekPan.add(magLabel2);
		weekPan.add(weekMagText);
		weekPan.add(placeLabel2);
		weekPan.add(weekPlaceText);
		todayPan.add(magLabel3);
		todayPan.add(todayMagText);
		todayPan.add(placeLabel3);
		todayPan.add(todayPlaceText);
		hourPan.add(magLabel4);
		hourPan.add(hourMagText);
		hourPan.add(placeLabel4);
		hourPan.add(hourPlaceText);
		
		month.addActionListener(this::changeMonth);
		week.addActionListener(this::changeWeek);
		today.addActionListener(this::changeToday);
		hour.addActionListener(this::changeHour);

		add(panel);
	}
	
	public void changeMonth(ActionEvent event) {
		Call<EarthquakeFeed> callMonth = service.getAllMonth();
		callMonth.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> callMonth, Response<EarthquakeFeed> responseMonth) {
				EarthquakeFeed feed = responseMonth.body();
	
				Optional<Earthquake> greatestMonth = feed.getFeatures()
						.stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));
				
				monthMagText.setText(String.valueOf(greatestMonth.get().getProperties().getMag()));
				monthPlaceText.setText(String.valueOf(greatestMonth.get().getProperties().getPlace()));
								
			}
			
			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace(); 
				
			}
			
		});
			
	}
	
	public void changeWeek(ActionEvent event) {
		Call<EarthquakeFeed> callWeek = service.getAllWeek();
		callWeek.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> callWeek, Response<EarthquakeFeed> responseWeek) {
				EarthquakeFeed feed = responseWeek.body();
				
				Optional<Earthquake> greatestWeek = feed.getFeatures()
						.stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));
				
				weekMagText.setText(String.valueOf(greatestWeek.get().getProperties().getMag()));
				weekPlaceText.setText(String.valueOf(greatestWeek.get().getProperties().getPlace()));
							
			}
			
			@Override
			public void onFailure(Call<EarthquakeFeed> callWeek, Throwable t) {
				t.printStackTrace(); 
				
			}
			
		});
	}
	
	public void changeToday(ActionEvent event) {
		Call<EarthquakeFeed> callDay = service.getAllDay();
		callDay.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> callToday, Response<EarthquakeFeed> responseToday) {
				EarthquakeFeed feed = responseToday.body();
				
				Optional<Earthquake> greatestToday = feed.getFeatures()
						.stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));
				
				todayMagText.setText(String.valueOf(greatestToday.get().getProperties().getMag()));
				todayPlaceText.setText(String.valueOf(greatestToday.get().getProperties().getPlace()));
					
			}
			
			@Override
			public void onFailure(Call<EarthquakeFeed> callToday, Throwable t) {
				t.printStackTrace(); 
				
			}
			
		});
	}
	
	public void changeHour(ActionEvent event) {
		Call<EarthquakeFeed> callHour = service.getAllHour();
		callHour.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> callHour, Response<EarthquakeFeed> responseHour) {
				EarthquakeFeed feed = responseHour.body();
				
				Optional<Earthquake> greatestHour = feed.getFeatures()
						.stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));
				
				hourMagText.setText(String.valueOf(greatestHour.get().getProperties().getMag()));
				hourPlaceText.setText(String.valueOf(greatestHour.get().getProperties().getPlace()));
				
			}
			
			@Override
			public void onFailure(Call<EarthquakeFeed> callHour, Throwable t) {
				t.printStackTrace(); 
				
			}
			
		});
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new EarthquakeRetrofitGUI().setVisible(true);	
	}
}
	



