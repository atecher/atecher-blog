<!DOCTYPE html>
<html lang="en-gb" dir="ltr" class="uk-notouch">
<head>
<title>搜索“${searchText}”相关的内容 - ATecher | 关注科技和程序员的那些事儿</title>
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
				<div class="custom-panel-title"><ul class="uk-breadcrumb"><li><span>您的位置：</span>
					<a href="${base}/">首页</a></li>
					<li class="uk-active"><span>
						<#if searchText??>
                            搜索“${searchText}”相关的内容
						<#else>
                            未输入要搜索的内容，向您推荐以下文章
						</#if>
					</span></li></ul></div>
				<#if searchText??>
					<#if searchList?? && (searchList?size> 0)>
						<#list searchList as article>
                        <article class="uk-grid uk-article at-search" >
                            <div class="uk-width-1-1">
                                <h2><a href="${base}/article/${article.article_id}">${article.title}</a></h2>
                                <p class="summary">${article.content}</p>
                                <p class="uk-article-meta"><span>分类于：<a class="at-category" href="${base}/category/${article.category_path}">${article.category_name}</a></span> <span>作者：${article.author}</span> <span>发表于：${article.create_time?string("yyyy-MM-dd")}</span> <span> ${article.total_clicks}次阅读</span></p>
                            </div>
                        </article>
                        <hr class="uk-grid-divider">
                    </#list>
					</#if>
				<#else>
					<#if hots?? && (hots?size> 0)>
						<#list hots as article>
                        <article class="uk-grid uk-article" >
                            <div class="uk-width-medium-1-4 uk-width-small-1-3 sidebar">
                                <a class="thumbnail" href="${base}/article/${article.article_id}"><img width="660" height="400" alt="${article.title}" src="${article.cover_path}"></a>
                            </div>
                            <div class="uk-width-medium-3-4 uk-width-small-2-3">
                                <h2><a href="${base}/article/${article.article_id}">${article.title}</a></h2>
                                <p class="summary">${article.summary}</p>
                                <p class="uk-article-meta"><span>分类于：<a class="at-category" href="${base}/category/${article.category_path}">${article.category_name}</a></span> <span>作者：${article.author}</span> <span>发表于：${article.create_time?string("yyyy-MM-dd")}</span> <span> ${article.total_clicks}次阅读</span></p>
                            </div>
                        </article>
                        <hr class="uk-grid-divider">
						</#list>
					</#if>
				</#if>

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
