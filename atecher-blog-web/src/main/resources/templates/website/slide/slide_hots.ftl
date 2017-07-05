<div class="uk-panel at-panel-hot uk-width-medium-none">
    <h3 class="uk-panel-title">热文</h3>
    <ol class="uk-list">
    <#if hots?? && (hots?size> 0)>
        <#list hots as hot>
            <li><span class="num">${hot_index+1}</span><p class="title"><a title="${hot.title}"  href="${base}/article/${hot.article_id}">${hot.title}</a></p></li>
        </#list>
    </#if>
    </ol>
</div>