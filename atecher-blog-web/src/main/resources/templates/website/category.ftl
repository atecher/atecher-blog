
<!DOCTYPE html>
<html lang="en-gb" dir="ltr" class="uk-notouch">
<head>
    <title>${category.category_name} - ATecher | 关注科技和程序员的那些事儿</title>
    <meta name="keywords" content=" ${keywords!'ATecher,互联网,程序员'}"/>
    <meta name="description" content="${description!'ATecher | 关注科技和程序员的那些事儿'}"/>
    <#include "common/common_head.ftl"/>
    <link rel="stylesheet" type="text/css" href="${base}/asset/website/css/components/search.gradient.css">
    <link rel="stylesheet" type="text/css" href="${base}/asset/website/css/components/sticky.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/asset/website/custom/custom.css">
</head>
<body>
<#include "common/common_navigation.ftl"/>
<div class="at-content">
    <div class="uk-container uk-container-center uk-margin-top uk-margin-bottom">
        <div class="uk-grid" >
            <section class="uk-width-medium-1-1 uk-width-large-3-4">
                <div class="custom-panel-title">
                <ul class="uk-breadcrumb">
                    <li><span>您的位置：</span><a href="${base}/">首页</a></li>
                <#if categoryNav?? && (categoryNav?size> 0)><#list categoryNav as nav><li class="uk-active"><a href="${base}/category/${nav.category_path}">${nav.category_name}</a></li></#list></#if>
                </ul></div>
            <#if articleList?? && (articleList?size> 0)>
                <#list articleList as article>
                    <article class="uk-grid uk-article bounceInLeft animated" >
                        <div class="uk-width-medium-1-4 uk-width-small-1-3 sidebar">
                            <a class="thumbnail" href="${base}/article/${article.article_id}"><img width="660" height="400" alt="${article.title}" src="${article.cover_path}" onerror="this.src='${base}/asset/website/images/default_cover.png'" ></a>
                        </div>
                        <div class="uk-width-medium-3-4 uk-width-small-2-3">
                            <h2><a href="${base}/article/${article.article_id}">${article.title}</a></h2>
                            <p class="summary">${article.summary}</p>
                            <p class="uk-article-meta"><span>分类于：<a class="at-category" href="${base}/category/${article.category_path}">${article.category_name}</a></span><span>作者：${article.author}</span> <span>发表于：${article.create_time?string("yyyy-MM-dd")}</span> <span> ${article.total_clicks}次阅读</span></p>
                        </div>
                    </article>
                    <hr class="uk-grid-divider">
                </#list>
            </#if>
                <ul class="uk-pagination uk-margin-bottom" data-uk-pagination="{items:${totalRows}, itemsOnPage:${displayRows}, currentPage:${page-1}}" data-base-url="${base}/category/${menuId}"></ul>
            </section>
            <aside class="uk-width-large-1-4">
            <#include "slide/slide_hots.ftl"/>
            <#include "slide/slide_tags.ftl"/>
            </aside>
        </div>
    </div>
</div>
<#include "common/common_foot.ftl"/>
<script type="application/javascript" src="${base}/asset/website/js/components/sticky.min.js"></script>
<script type="application/javascript" src="${base}/asset/website/js/components/pagination.js"></script>
<script type="application/javascript" src="${base}/asset/website/custom/custom.js"></script>
</body>
</html>