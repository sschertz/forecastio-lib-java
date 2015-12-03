package com.github.dvdme.ForecastIOLib;

public class FIODaily {

	FIODataBlock daily;

	public FIODaily(ForecastIO fio){

		this.daily = null;
		init(fio);

	}

	private void init(ForecastIO fio){

		if(fio.hasDaily()){
			this.daily = new FIODataBlock(fio.getDaily());
			this.daily.setTimezone(fio.getTimezone());
		}
		else {
			this.daily = null;
		}
	}

	/**
	 * Returns the data point for the given day in the daily report
	 * @param day the day to get
	 * @return return the data point with the report
	 */
	public FIODataPoint getDay(int day){

		return this.daily == null ? null : this.daily.datapoint(day);  
	}

	/**
	 * Returns the days in the daily report
	 * @return integer with the number of days. Returns -1 if there is not data in the report.
	 */
	public int days(){
		return this.daily == null ? -1 : this.daily.datablockSize();
	}
	
	/**
	 * Returns the top-level summary for the data block. This summary
	 * is not tied to any particular day. This usually provides
	 * a human-readable overview of the next several days.
	 * 
	 * @return the top-level daily summary
	 */
	public String getSummary(){
		return this.daily.summary() == null ? null : this.daily.summary();
		
	}
	
	/**
	 * Returns the top-level icon for the data block. This is not
	 * tied to a specific day, but for the entire 7-day forecast.
	 * 
	 * @return the name of the icon for the daily forecast
	 */
	public String getIcon(){
		return this.daily.icon() == null ? null : this.daily.icon();
	}

}
