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
	
	/**
	 * Returns the FIODataBlock for this daily forecast. This is useful if
	 * your code needs to do common operations on the Daily, Hourly,
	 * or Minutely data blocks, so you need a more generic version.
	 * (For example, you want to find out when it will rain next,
	 * so you need to loop through minutely, hourly, and daily
	 * and stop when you find the first result with rain. You
	 * can use the same loop to check all three forecasts
	 * using FIODataBlock).
	 * 
	 * Use caution when accessing data in an FIODataBlock, as the 
	 * available properties vary depending on the type of forecast
	 * used to generate the block.
	 * @return
	 */
	public FIODataBlock getDataBlock(){
		return this.daily == null ? null : this.daily;
	}

}
