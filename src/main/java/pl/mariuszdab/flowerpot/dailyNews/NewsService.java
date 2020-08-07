package pl.mariuszdab.flowerpot.dailyNews;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class NewsService {

    private final NewsRepository newsRepository;
    private String news;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public String getNews() {
        return news;
    }

    @Scheduled(cron = "0 * * * * *")
    public String generateNews() {
        List<News> listOfNews = newsRepository.findAll();
        Collections.shuffle(listOfNews, new Random());
        news = listOfNews.get(0).getNews();
        log.info("Nowy news !!!!");
        return news;
    }
}
