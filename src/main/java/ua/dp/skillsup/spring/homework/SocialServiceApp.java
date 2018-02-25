package ua.dp.skillsup.spring.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.dp.skillsup.spring.homework.service.FacebookApi;
import ua.dp.skillsup.spring.homework.service.InstagramApi;
import ua.dp.skillsup.spring.homework.service.ServiceApi;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class SocialServiceApp {
    @Autowired
    List<PostProvider> providers;

    @Bean
    @Autowired
    public PostProvider facebookPostProvider(@Value("${keyWord}") String keyWord ,
                                             FacebookApi facebookApi , PostFilter postFilter)
    {
        PostProvider postProvider = PostProviderInit(keyWord, facebookApi, postFilter);
        return postProvider;
    }


    @Bean
    @Autowired
    public PostProvider instagramPostProvider(@Value("${keyWord}")String keyWord,
                                              InstagramApi instagramApi, PostFilter postFilter)
    {
        PostProvider postProvider = PostProviderInit(keyWord, instagramApi, postFilter);
        return postProvider;
    }




        public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SocialServiceApp.xml");
        SocialServiceApp socialServiceApp = (SocialServiceApp) context.getBean("socialServiceApp");
        socialServiceApp.run();


    }

     PostProvider PostProviderInit(String keyWord , ServiceApi serviceApi , PostFilter postFilter)
    {
        PostProvider postProvider = new PostProvider();
        postProvider.setServiceApi(serviceApi);
        postProvider.setPostFilter(postFilter);
        postProvider.setKeyWord(keyWord);
        return postProvider;
    }


    public void run(){
        List<Post> posts = new ArrayList<>();
        for (PostProvider provider : providers) {
            posts.addAll(provider.getPosts());
        }
        System.out.println("Filtered posts:");
        for (Post post : posts) {
            System.out.println(post);
        }
    }

}
