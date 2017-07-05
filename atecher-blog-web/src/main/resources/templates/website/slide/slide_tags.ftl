<div class="uk-panel at-panel-tag uk-margin-bottom">
    <h3 class="uk-panel-title">热门标签</h3>
    <ul class="uk-list">
    <#if tags?? && (tags?size> 0)>
        <#list tags as tag>
            <li><a  href="${base}/tag/${tag.code}">${tag.tag}(${tag.counts})</a></li>
        </#list>
    </#if>
    </ul>
</div>