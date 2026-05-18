import java.util.ArrayList;
import java.util.List;

interface Subscriber{
    void update(String videoTitle);
}

class User implements Subscriber{
    private String name;

    public User(String name) {
        this.name=name;
    }
    public void update(String videoTitle){
        System.out.println(name+" got notification, New VideoUploaded->"+videoTitle);
    }    
}

interface YouTubeChannel{
    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    void notifySubscriber();
}

class TechChannel implements YouTubeChannel{
    private List<Subscriber> subList=new ArrayList<>();
    private String latestVideo;

    public void subscribe(Subscriber subscriber){
        subList.add(subscriber);
    }
    public void unSubscribe(Subscriber subscriber){
        subList.remove(subscriber);
    }
    public void uploadVideo(String title){
        latestVideo=title;
        notifySubscriber();
    }

    public void notifySubscriber(){
        for(Subscriber subscriber:subList){
            subscriber.update(latestVideo);
        }
    }
}