package pl.mariuszdab.flowerpot.dailyNews;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT CHARACTER SET UTF8")
    private String news;

}
