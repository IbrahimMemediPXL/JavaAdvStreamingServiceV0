package be.pxl.ja.streamingservice.model;

import oefeningen.Genre;
import oefeningen.Rating;

public class Documentary extends Movie{
    private String topic;

    public Documentary(String title, Rating rating) {
        super(title, rating);
        super.setGenre(Genre.DOCUMENTARY);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void play(){
        StringBuilder result = new StringBuilder();
        result.append("Plating documentary ").append(this);
        if (topic != null){
            result.append(" on ").append(topic);
        }
        System.out.println(result.toString());
    }

    @Override
    public void pause(){
        System.out.println("Pausing documentary " + this);
    }
}
