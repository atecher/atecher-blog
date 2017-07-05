package com.atecher.blog.config;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by mark on 2017/6/20.
 */
@Configuration
public class LuceneConfiguration {
    @Value("${spring.lucene.index-path}")
    private String indexPath;

    class LuceneDirectoryFactoryBean {
        public FSDirectory getFSDirectory() throws Exception {
            File indexDir = new File(indexPath);
            Path path = indexDir.toPath();
            try {
                return new SimpleFSDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Bean("luceneIndexDirectory")
    public FSDirectory getLuceneIndexDirectory() throws Exception {
        return new LuceneDirectoryFactoryBean().getFSDirectory();
    }

    @Bean("indexWriter")
    public IndexWriter getIndexWriter(@Qualifier("luceneIndexDirectory") FSDirectory luceneIndexDirectory){
        SmartChineseAnalyzer smartChineseAnalyzer=new SmartChineseAnalyzer(true);
        IndexWriterConfig indexWriterConfig=new IndexWriterConfig(smartChineseAnalyzer);
        IndexWriter indexWriter=null;
        try {
            indexWriter=new IndexWriter(luceneIndexDirectory,indexWriterConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indexWriter;
    }
}
