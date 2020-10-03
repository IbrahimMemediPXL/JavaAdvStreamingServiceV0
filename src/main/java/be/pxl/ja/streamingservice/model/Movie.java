package be.pxl.ja.streamingservice.model;
import java.time.LocalDate;

public class Movie extends oefeningen.Content implements oefeningen.Playable {
    private String director;
    private LocalDate releaseDate;
    private int duration;
    private oefeningen.Genre genre;
    public static final int LONG_PLAYING_TIME = 2 * 60 + 15;



    public Movie(String title, oefeningen.Rating rating){
        super(title, rating);
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return  releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }

    public int getDuration(){
        return duration;
    }

    @Override
    public void play() {
        System.out.println("Playing " + this);
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + this);
    }

    public void setDuration(int duration){
        this.duration = Math.abs(duration);
    }

    public oefeningen.Genre getGenre() {
        return genre;
    }

    public void setGenre(oefeningen.Genre genre) {
        this.genre = genre;
    }

    public boolean isLongPlayingTime(){
        return duration >= LONG_PLAYING_TIME;
    }

    public String getPlayingTime(){
        if (duration == 0){
            return "?";
        }

        if (duration >= 60) {
            if (duration / 60 > 0 && duration <= 120){
                return String.valueOf(duration / 60) + " h";
            }
            else{
                int hour = duration / 60;
                int minutes = duration % 60;
                return String.format("%d h %d min", hour, minutes);
            }
        }
        else{
            return String.valueOf(duration) + " min";
        }
    }


    @Override
    public String toString(){
        if (getReleaseDate() != null){
            return String.format("%s (%s)", super.getTitle(), getReleaseDate().getYear(), super.getMaturityRating().getMinimumAge());
        }
        else{
            return super.getTitle();
        }

    }

}
