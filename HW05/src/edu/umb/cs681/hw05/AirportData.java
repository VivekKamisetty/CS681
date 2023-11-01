package edu.umb.cs681.hw05;

class AirportData {
    private int year;
    private int month;
    private int loganPassengers;
    private int loganIntlFlights;
    private float hotelOccupancyRate;
    private float hotelAvgDailyRate;
    private int totalJobs;
    private float unemploymentRate;
    private float laborForceParticipationRate;

    public AirportData(int year, int month, int loganPassengers, int loganIntlFlights, float hotelOccupancyRate,
                       float hotelAvgDailyRate, int totalJobs, float unemploymentRate, float laborForceParticipationRate) {
        this.year = year;
        this.month = month;
        this.loganPassengers = loganPassengers;
        this.loganIntlFlights = loganIntlFlights;
        this.hotelOccupancyRate = hotelOccupancyRate;
        this.hotelAvgDailyRate = hotelAvgDailyRate;
        this.totalJobs = totalJobs;
        this.unemploymentRate = unemploymentRate;
        this.laborForceParticipationRate = laborForceParticipationRate;
    }

    public int getYear() {
        return year;
    }

    public int getLoganPassengers() {
        return loganPassengers;
    }

    public float getHotelOccupancyRate() {
        return hotelOccupancyRate;
    }

    public int getTotalJobs() {
        return totalJobs;
    }

    public float getUnemploymentRate() {
        return unemploymentRate;
    }
}
