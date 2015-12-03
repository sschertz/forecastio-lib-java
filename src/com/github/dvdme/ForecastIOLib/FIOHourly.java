package com.github.dvdme.ForecastIOLib;

public class FIOHourly {

	FIODataBlock hourly;

	public FIOHourly(ForecastIO fio){

		init(fio);

	}

	private void init(ForecastIO fio){

		if(fio.hasHourly()){
			this.hourly = new FIODataBlock(fio.getHourly());
			this.hourly.setTimezone(fio.getTimezone());
		}
		else {
			this.hourly = null;
		}
	}

	/**
	 * Returns the data point for the given day in the hourly report
	 * @param hour the hour to get
	 * @return return the data point with the report
	 */
	public FIODataPoint getHour(int hour){

		return this.hourly == null ? null : this.hourly.datapoint(hour);  
	}

	/**
	 * Returns the hours in the hourly report
	 * @return integer with the number of hours. Returns -1 if there is not data in the report.
	 */
	public int hours(){
		return this.hourly == null ? -1 : this.hourly.datablockSize();
	}
	
	/**
	 * Returns the top-level summary for the data block. This 
	 * is not tied to a specific hour, but provides
	 * a human-readable overview of the next 48-hours.
	 * 
	 * @return the top-level daily summary
	 */
	public String getSummary(){
		return this.hourly.summary() == null ? null : this.hourly.summary();
		
	}
	
	/**
	 * Returns the top-level icon for the data block. This is not
	 * tied to a specific hour, but for the entire 48-hour period.
	 * 
	 * @return the name of the icon for the hourly forecast
	 */
	public String getIcon(){
		return this.hourly.icon() == null ? null : this.hourly.icon();
	}

}
