package net.ourdailytech.rest.mapper;

import javax.annotation.processing.Generated;
import net.ourdailytech.rest.models.Category;
import net.ourdailytech.rest.models.News;
import net.ourdailytech.rest.models.dto.CategoryDto;
import net.ourdailytech.rest.models.dto.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-07T17:33:49-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class NewsMapperImpl implements NewsMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public News toEntity(NewsDto newsDto) {
        if ( newsDto == null ) {
            return null;
        }

        News.NewsBuilder news = News.builder();

        news.id( newsDto.getId() );
        news.title( newsDto.getTitle() );
        news.url( newsDto.getUrl() );
        news.category( categoryMapper.toEntity( newsDto.getCategory() ) );

        return news.build();
    }

    @Override
    public NewsDto toDto(News news) {
        if ( news == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String url = null;
        CategoryDto category = null;

        id = news.getId();
        title = news.getTitle();
        url = news.getUrl();
        category = categoryMapper.toDto( news.getCategory() );

        NewsDto newsDto = new NewsDto( id, title, url, category );

        return newsDto;
    }

    @Override
    public News partialUpdate(NewsDto newsDto, News news) {
        if ( newsDto == null ) {
            return news;
        }

        if ( newsDto.getId() != null ) {
            news.setId( newsDto.getId() );
        }
        if ( newsDto.getTitle() != null ) {
            news.setTitle( newsDto.getTitle() );
        }
        if ( newsDto.getUrl() != null ) {
            news.setUrl( newsDto.getUrl() );
        }
        if ( newsDto.getCategory() != null ) {
            if ( news.getCategory() == null ) {
                news.setCategory( Category.builder().build() );
            }
            categoryMapper.partialUpdate( newsDto.getCategory(), news.getCategory() );
        }

        return news;
    }
}
