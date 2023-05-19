package sg.edu.nus.iss.practice2day12.model;

import org.springframework.stereotype.Component;

@Component
public class Image {
    
    private String number;
    private String path;
    
    public Image() {
    }
    
    public Image(String number, String path) {
        this.number = number;
        this.path = path;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    @Override
    public String toString() {
        return "Image [number=" + number + ", path=" + path + "]";
    }

    
    

}
