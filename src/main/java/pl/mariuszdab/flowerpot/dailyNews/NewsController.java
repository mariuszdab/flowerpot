package pl.mariuszdab.flowerpot.dailyNews;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/daily")
    public String dailyNews(Model model){
        model.addAttribute("news", newsService.getNews());
        return "dailyNews/dailyNews";
    }
}
