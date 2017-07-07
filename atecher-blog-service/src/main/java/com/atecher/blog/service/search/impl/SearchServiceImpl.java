package com.atecher.blog.service.search.impl;


import com.atecher.blog.mapper.content.ArticleMapper;
import com.atecher.blog.model.Article;
import com.atecher.blog.service.search.ISearchService;
import com.atecher.blog.common.model.Page;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Created by hanhongwei on 2016/6/14.
 */
@Service("searchService")
public class SearchServiceImpl implements ISearchService {

    @Autowired(required = false)
    IndexWriter indexWriter;
    @Autowired(required = false)
    Analyzer analyzer;
    @Autowired(required = false)
    ArticleMapper articleMapper;
    String[] searchFields=new String[]{"title","content"};


    @PostConstruct
    public void buildIndexAll() throws IOException {
        indexWriter.deleteAll();
        Map<String,Object> queryParam=new HashMap<>();
        int startRow=0;
        queryParam.put("limit", 100);
        queryParam.put("start", startRow);
        List<Article> articles=articleMapper.selectArticleForPage(queryParam);
        while(articles.size()>0){
            for(Article article:articles){
                Document doc = article2Document(article);
                indexWriter.addDocument(doc);
            }
            startRow+=100;
            queryParam.put("start", startRow);
            articles=articleMapper.selectArticleForPage(queryParam);
        }
        indexWriter.commit();
    }

    private Document article2Document(Article article) {
        Document doc;
        doc = new Document();
        doc.add(new LongField("article_id", article.getArticle_id(), Field.Store.YES));
        doc.add(new StringField("title", article.getTitle(), Field.Store.YES));
        doc.add(new StringField("category_path", article.getCategory_path(), Field.Store.YES));
        doc.add(new StringField("category_name", article.getCategory_name(), Field.Store.YES));
        doc.add(new LongField("create_time", article.getCreate_time().getTime(), Field.Store.YES));
        doc.add(new StringField("author", article.getAuthor(), Field.Store.YES));
        doc.add(new IntField("total_clicks", article.getTotal_clicks(), Field.Store.YES));
        doc.add(new StringField("cover_path", article.getCover_path(), Field.Store.YES));
        String content = Jsoup.parse(article.getContent().replaceAll("&nbsp;", "").replaceAll("&NBSP;", "")).text().trim();
        doc.add(new TextField("content", content, Field.Store.YES));
        return doc;
    }

    @Override
    public Page<Article> search(int page, int limit, String text) {
        DirectoryReader ireader;
        List<Article> list=new ArrayList<>();
        int totals=0;
        try {
            ireader = DirectoryReader.open(indexWriter.getDirectory());
            IndexSearcher searcher = new IndexSearcher(ireader);
            Map<String , Float> boosts = new HashMap<String, Float>();
            boosts.put("title", 1.0f);
            boosts.put("content", 1.0f);
            QueryParser parser=new MultiFieldQueryParser(searchFields , analyzer,boosts);
            Query query=parser.parse(text);
            TopDocs td=searcher.search(query,Integer.MAX_VALUE);
            SimpleHTMLFormatter fors = new SimpleHTMLFormatter("<span style=\"color:red;\">", "</span>");// 定制高亮标签
            QueryScorer score = new QueryScorer(query);
			Highlighter highlighter = new Highlighter(fors,score);// 高亮分析器
			totals=td.totalHits;
			int start=(page-1)*limit;
			int end=(page*limit)>totals?totals:(page*limit);
			for(int i=start;i<end;i++){
				Document d = searcher.doc(td.scoreDocs[i].doc);
				Fragmenter fragment = new SimpleSpanFragmenter(score,100);
				highlighter.setTextFragmenter(fragment);
                Article item = document2Article(highlighter, d);
				list.add(item);
			}
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (InvalidTokenOffsetsException exe) {
            exe.printStackTrace();
        }
    return new Page<>(totals,list);
    }

    private Article document2Article(Highlighter highlighter, Document d) throws IOException, InvalidTokenOffsetsException {
        Article item=new Article();
        item.setArticle_id(d.getField("article_id").numericValue().longValue());
        item.setTitle(getHighlighter(highlighter,"title",d.get("title")));
        item.setContent(getHighlighter(highlighter,"content",d.get("content")));
        item.setCategory_name(d.get("category_name"));
        item.setCategory_path(d.get("category_path"));
        item.setCreate_time(new Date(d.getField("create_time").numericValue().longValue()));
        item.setAuthor(d.get("author"));
        item.setTotal_clicks(d.getField("total_clicks").numericValue().intValue());
        item.setCover_path(d.get("cover_path"));
        return item;
    }

    private String getHighlighter(Highlighter highlighter,String fieldName,String value) throws IOException, InvalidTokenOffsetsException {
        TokenStream tokenStream = analyzer.tokenStream(fieldName, new StringReader(value)); //TokenStream用来分析文字流，按一定的规则罗列token,在lucene有字节流是即将要索引的文本，或者查询的关键字。
        String res=highlighter.getBestFragment(tokenStream,value);
        if(res!=null&&!"".equals(res)){
            return res;
        }else{
            return value;
        }
    }


}
