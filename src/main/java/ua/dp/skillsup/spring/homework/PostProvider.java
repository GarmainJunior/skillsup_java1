package ua.dp.skillsup.spring.homework;

import org.springframework.beans.factory.annotation.Value;
import ua.dp.skillsup.spring.homework.service.ServiceApi;

import java.util.List;

public class PostProvider {
    private ServiceApi serviceApi;
    private PostFilter postFilter;
    @Value("${keyWord}")
    private String keyWord;

    public List<Post> getPosts(){
        return postFilter.filterByKeyword(serviceApi.getPosts(), keyWord);
    }

    public ServiceApi getServiceApi() {
        return serviceApi;
    }

    public void setServiceApi(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    public PostFilter getPostFilter() {
        return postFilter;
    }

    public void setPostFilter(PostFilter postFilter) {
        this.postFilter = postFilter;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
