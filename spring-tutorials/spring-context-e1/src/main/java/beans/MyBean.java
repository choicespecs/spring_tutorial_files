package beans;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class MyBean {
    // whatever you want
    private String text;

    // Performs after creation
    @PostConstruct
    private void init() {
        this.text = "HELLO";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
