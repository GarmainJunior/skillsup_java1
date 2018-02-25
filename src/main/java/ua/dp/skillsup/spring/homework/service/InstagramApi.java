package ua.dp.skillsup.spring.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.dp.skillsup.spring.homework.Post;

import java.util.Arrays;
import java.util.List;
@Component
public class InstagramApi implements ServiceApi{
    @Value("${instagramAppName}")
    private String appName;
    @Value("${instagramAppSecret}")
    private String appSecret;

    @Override
    public List<Post> getPosts() {
        System.out.println("Reading posts from Instagram with following credentials: " + appName + "/" + appSecret);
        //some fancy implementation here
        return Arrays.asList(
                new Post("What a beautiful sunset! #sunset #evening #photo #potato #iphone #camera", "http://instagram.com/sunset.jpg"),
                new Post("Look at my dog!", "http://instagram.com/verygoodboy.jpg"),
                new Post("I'm such a hot chick! #selfie #kfc", "http://instagram.com/selfie.jpg")
        );
    }
}
