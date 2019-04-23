package com.atguigu.elastic;

import com.atguigu.elastic.bean.Artile;
import com.atguigu.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atguigu.elastic.bean.Book;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;


    /**
     * spring data 测试失败
     * Exception:
     * NoNodeAvailableException[None of the configured nodes are available: [{#transport#-1}{sCId6f4LTNWB4p34uKw7Yg}{47.102.202.67}{47.102.202.67:9300}]
     * ]
     */
    @Test
    public void test2() {
        Book book = new Book();
        book.setAuthor("雪碧");
        book.setBookName("百事可乐");
        book.setId(1);
        bookRepository.index(book);
    }


    @Test
    public void contextLoads() {
        Artile artile = new Artile();
        artile.setAuthor("林冲");
        artile.setContent("水浒传");
        artile.setTitle("风雪山神庙");
        artile.setId(1);
        Index build = new Index.Builder(artile).index("atguigu").type("news").build();
        try {
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        String query = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"水浒传\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search build = new Search.Builder(query).addIndex("atguigu").addType("news").build();
        try {
            SearchResult result = jestClient.execute(build);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
