<!DOCTYPE html>
<html lang="en-gb" dir="ltr" class="uk-notouch">
<head>
    <title>${article.title} - ATecher | 关注科技和程序员的那些事儿</title>
    <meta name="keywords" content=" ${article.keywords!'ATecher,互联网,程序员'}"/>
    <meta name="description" content="${article.summary!'ATecher | 关注科技和程序员的那些事儿'}"/>
    <#include "common/common_head.ftl"/>
    <link rel="stylesheet" type="text/css" href="${base}/asset/website/css/components/search.gradient.css">
    <link rel="stylesheet" type="text/css" href="${base}/asset/website/custom/custom.css">
    <link rel="stylesheet" type="text/css" href="${base}/asset/website/custom/share_style.css">
</head>
<body>
<#include "common/common_navigation.ftl"/>
<div class="at-content">
    <div class="uk-container uk-container-center uk-margin-top uk-margin-bottom">
        <div class="uk-grid" >
            <section class="uk-width-medium-1-1 uk-width-large-3-4">
                <div class="custom-panel-title"><ul class="uk-breadcrumb"><li><span>您的位置：</span><a href="${base}/">首页</a></li><li class="uk-active"><a href="${base}/category/${article.category_path}" title="查看${article.category_name}中的全部文章"><span>${article.category_name}</span></a></li></ul></div>
                <article class="uk-grid uk-article" >
                    <div class="uk-width-medium-1-1 ">
                        <h1><a>${article.title}</a></h1>
                        <p class="uk-article-meta"><span>作者：${article.author}</span> <span>发表于：${article.create_time?string("yyyy-MM-dd")}</span> <span>${article.total_clicks}次阅读</span></p>
                        <article class="article-content">
                            ${article.content}
                        </article>
                    </div>
                </article>
                <#if article.tags?? && (article.tags?size> 0)>
                <footer class="article-footer">
                    <div class="article-tags">继续浏览有关<#list article.tags as tag><a  href="${base}/tag/${tag.code}"  rel="tag">${tag.tag}</a></#list>的文章</div>
                </footer>
                </#if>
                <hr class="uk-grid-divider">
                <nav class="article-nav">
                <#if preNext?? && (preNext?size> 0)>
                    <#list preNext as pn>
                        <#if pn.pre><#assign pre=pn/></#if>
                        <#if pn.next><#assign next=pn/></#if>
                    </#list>
                    <span class="uk-width-medium-1-1 uk-width-large-1-2 pre">上一篇：<#if pre??><a href="${base}/article/${pre.article_id}" rel="prev">${pre.title}</a><#else >没有啦</#if></span>
                    <span class="uk-width-medium-1-1 uk-width-large-1-2 next">下一篇：<#if next??><a href="${base}/article/${next.article_id}" rel="next">${next.title}</a><#else >没有啦</#if></span>
                </#if>
                </nav>
                <div class="bdsharebuttonbox">
                    <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                    <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
                    <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
                    <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                    <a href="#" class="bds_more" data-cmd="more"></a>
                </div>
                <!--高速版-->
                <div id="SOHUCS"></div>
                <script charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/changyan.js" ></script>
                <script type="text/javascript">
                    window.changyan.api.config({
                        appid: 'cyrbtS4K4',
                        conf: 'prod_84542c496902ff016781c3cbad0b84bc'
                    });
                </script>
            </section>
            <aside class="uk-width-large-1-4">
            <#include "slide/slide_hots.ftl"/>
            <#include "slide/slide_tags.ftl"/>
            </aside>
        </div>

    </div>
</div>
<#include "common/common_foot.ftl"/>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["tsina","weixin","tqq","qzone"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<script type="application/javascript" src="${base}/asset/website/custom/custom.js"></script>
</body></html>