
    


class Time{

    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;


    Time(int hours){

        this.hours = hours;

    };

    Time(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }

    Time(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours(){
        return this.hours;
    }

    public void setHours(int hours){
        this.hours =  hours;
    }

    public int getMinutes(){
        return this.minutes;
    }

    public void setMinutes(int minutes){
        this.minutes =  minutes;
    }

    public int getSeconds(){
        return this.seconds;
    }

    public void setSeconds(int seconds){
        this.seconds =  seconds;
    }


    public Time timeDifference(Time other){
        
        // Convert times to seconds since midnight'
        int thisTotalSeconds = this.toSeconds();
        int otherTotalSeconds  = other.toSeconds();


        // Grt absolute difference in seconds
        int differenceInSeconds = Math.abs(thisTotalSeconds - otherTotalSeconds);

        //Convert the difference back to hours,, minutes and seconds
        int hours = differenceInSeconds/3600;
        int remainingSeconds = differenceInSeconds %3600;
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds %60;

        // Return time object representing time difference
        return new Time(hours, minutes, seconds);

         
    }

    // Convert hours, minutes to seconds
    private int toSeconds(){
        return (this.hours*3600) + (this.minutes*60) + this.seconds;
    }


    // Method to advance time by one second
    public Time addASecond(){
        this.seconds++;

        // Handle second overflow
        if(this.seconds == 60){
            this.seconds = 0;
            this.minutes++;
        }

        // Handle minute overflow
        if(this.minutes == 60){
            this.minutes =0;
            this.hours++;
        }

        return this; // return current instance to support the chain

    }


// Method to display time
public String toString(){
    return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }

}


class TimeCreator{

    public Time createTime(int hours){
        return new Time(hours);
    }

    public Time createTime(int hours, int minutes){
        return new Time(hours, minutes);
    }

    public Time createTime(int hours, int minutes, int seconds){
        return new Time(hours, minutes, seconds);
    }


}


public class App4 {


public static void main(String[] args){

    TimeCreator create = new TimeCreator();

    Time time1 = create.createTime(5);
    System.out.println("Time 1: " + time1 + " was created successfully");
    Time time2 = create.createTime(12, 45, 26);
    System.out.println("Time 2: " + time2 + " was created successfully");
    System.out.println("The time difference is: " + time1.timeDifference(time2).addASecond()  + " (a second was added)");



}
}
