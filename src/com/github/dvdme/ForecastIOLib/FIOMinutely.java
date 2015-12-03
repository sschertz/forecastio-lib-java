package com.github.dvdme.ForecastIOLib;

public class FIOMinutely {

	FIODataBlock minutely;

	public FIOMinutely(ForecastIO fio){

		init(fio);

	}

	private void init(ForecastIO fio){

		if(fio.hasMinutely()){
			this.minutely = new FIODataBlock(fio.getMinutely());
			this.minutely.setTimezone(fio.getTimezone());
		}
		else {
			this.minutely = null;
		}
	}

	/**
	 * Returns the data point for the given minute in the minutely report
	 * @param minute the minute to get
	 * @return return the data point with the report
	 */
	public FIODataPoint getMinute(int minute){

		return this.minutely == null ? null : this.minutely.datapoint(minute);  
	}

	/**
	 * Returns the minutes in the minutely report
	 * @return integer with the number of minute. Returns -1 if there is not data in the report.
	 */
	public int minutes(){
		return this.minutely == null ? -1 : this.minutely.datablockSize();
	}
	
	/**
	 * Returns the top-level summary for the data block. This summary
	 * is not tied to a specific minute, but instead provides 
	 * a human-readable overview of the next hour.
	 * 
	 * @return the top-level minutely summary
	 */
	public String getSummary(){
		return this.minutely.summary() == null ? null : this.minutely.summary();
		
	}
	
	/**
	 * Returns the top-level icon for the data block. This is not
	 * tied to a specific minute, but for the entire hour.
	 * 
	 * @return the name of the icon for the minutely forecast
	 */
	public String getIcon(){
		return this.minutely.icon() == null ? null : this.minutely.icon();
	}


}
