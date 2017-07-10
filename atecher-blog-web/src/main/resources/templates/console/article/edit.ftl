<#include "../../base/global.ftl"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>H+ 后台主题UI框架 - Bootstrap Table</title>
   <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap-table/1.9.0/bootstrap-table.min.css" rel="stylesheet">
    <link href="${base}/asset/console/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${base}/asset/console/css/style.min.css" rel="stylesheet"/>
    <link href="${base}/asset/console/css/plugins/treeview/bootstrap-treeview.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.css" rel="stylesheet">
    <style type="text/css">
    .bootstrap-tagsinput{border: 1px solid #e5e6e7;	padding: 6px 12px;box-shadow:none; 	border-radius:0;	width: 100%;}
    .bootstrap-tagsinput > input{background: #FFF;font-size: 14px;}
	.hot-tags{margin: 10px 0px;}
	.hot-tags .hot-tag{padding: 4px 9px 5px 9px;line-height: 20px;white-space: nowrap;font-size: 13px;color: #fff;text-decoration: none;cursor: pointer;background: rgb(217, 83, 79);}
	.hot-tags .hot-tag:nth-child(5n) {background-color: #4A4A4A;}
	.hot-tags .hot-tag:nth-child(5n+1) {background-color: #485f7c;}
	.hot-tags .hot-tag:nth-child(5n+2) {background-color: #5CB85C;}
	.hot-tags .hot-tag:nth-child(5n+3) {background-color: #D9534F;}
	.hot-tags .hot-tag:nth-child(5n+4) {background-color: #F0AD4E;}
    </style>
</head>

<body class="gray-bg" >
    <div class="wrapper wrapper-content animated fadeInRight">

        <div class="row">
            <div class="col-sm-9 animated fadeInLeft">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>文章管理</h5>
                <div class="ibox-tools">
                    <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    <a class="close-link"><i class="fa fa-times"></i></a>
                </div>
            </div>
            <div class="ibox-content">
              <div class="tabs-container">
                     <form class="form-horizontal" action="${base}/manage/article/save" method="post"  id="articleForm">
                           <input type="hidden" name="article_id" value="${article.article_id!}"/>
                           <input type="hidden" name="category_id" id="category_id" value="${article.category_id!}"/>
                           <input type="hidden" name="category_name"  id="category_name" value="${article.category_name!}"/>
                           <input type="hidden" name="status"  id="status" value="${article.status!}"/>
                            <div class="panel-body">
                                <div class="form-group">
	                                <label class="col-sm-2 control-label">标题</label>
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" name="title" value="${article.title!}"><span class="help-block m-b-none">文章标题，显示在网站列表中</span>
	                                </div>
	                            </div>
                            	<div class="hr-line-dashed"></div>
                            	<div class="form-group">
                                	<label class="col-sm-2 control-label">作者</label>
                                	<div class="col-sm-4">
                                        <#if article.author??>
                                            <input name="author" type="text" value="${article.author}"  class="form-control" placeholder="请输入作者..."/>
                                            <#else>
                                                <input name="author" type="text" value="${(website_current_user.name)!''}"  class="form-control" placeholder="请输入作者..."/>
                                        </#if>
                                	</div>
	                                <label class="col-sm-2 control-label">模板</label>
	                                <div class="col-sm-4">
	                                     <select class="form-control m-b" name="template">
	                                        <option>==默认==</option>
	                                        <option>website/default/article.jsp</option>
	                                    </select>
	                                </div>
                            	</div>
                            	<div class="hr-line-dashed"></div>
                               <div class="form-group">
	                                <label class="col-sm-2 control-label">标签</label>
	                                <div class="col-sm-10">
	                                    <input type="text" name="keywords" id="keywords" placeholder="提示信息"  class="form-control" value="${article.keywords!}" data-role="tagsinput">
										<div class="hot-tags">
										热门标签：
                                        <#if tags?? && (tags?size> 0)>
                                        <#list tags as tag>
                                            <span class="label label-info hot-tag" data-tag="${tag.tag}">${tag.tag}</span>
                                        </#list>
										</#if>
										</div>
	                                </div>
	                            </div>
	                            <div class="hr-line-dashed"></div>
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">封面图</label>
	                                <div class="col-sm-10">
	                                    <input type="text" name="cover_path" placeholder="如不填写，将自动读取正文中第一张图片" class="form-control" value="${article.cover_path!}">
	                                </div>
	                            </div>
	                            <div class="hr-line-dashed"></div>
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">摘要</label>
	                                <div class="col-sm-10">
	                                    <textarea name="summary" placeholder="如不填写，将自动读取正文生成摘要内容" class="form-control" style="min-height: 100px;">${article.summary!}</textarea>
	                                </div>
	                            </div>
	                             <div class="hr-line-dashed"></div>
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">正文</label>
	                                <div class="col-sm-10">
                                        <script type="text/plain" id="content" name="content" style="width:100%;height:400px">${article.content!}</script>
	                                </div>
	                            </div>
                            </div>
                    </form>
                </div>
            </div>
        </div>
        </div>
        <div class="col-sm-3 animated fadeInRight">
              <div class="ibox float-e-margins">
               	<div class="ibox-title">
                     <h5>发布</h5>
                    <div class="ibox-tools"> <button class="btn btn-primary btn-xs" id="returnList">返回文章列表</button></div>
                 </div>
                    <div class="ibox-content">
                        <div class="file-manager">
                        <div class="form-group">
	                            <label>文章属性：</label>
	                         	<span class="label label-info">
                                    <#if article.status??>
                                        <#if article.status==0>已删除
                                        <#elseif article.status==1>草稿
                                        <#elseif article.status==2>发布
                                        </#if>
                                    <#else>未保存
                                    </#if>
	                         	</span>
                         	</div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                            <button class="btn btn-primary btn-block "  id="saveDraft">保存草稿</button>
                            <button class="btn btn-danger btn-block "  id="savePublish">立即发布</button>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                   <div class="ibox float-e-margins">
                            <div class="ibox-title">
                            <h5>文章属性</h5>
                            </div>
                    <div class="ibox-content">
                        <div class="file-manager">
                            <div class="form-group">
	                            <label>选择分类：</label>
	                         	<div id="category_treeview" class="test" data-category-name="${article.category_name!}" data-category-id="${article.category_id!}" ></div>
                         	</div>
                            <div class="hr-line-dashed"></div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- End Panel Other -->
    </div>
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${base}/asset/console/js/content.min.js"></script>
	<script type="text/javascript" src="${base}/asset/console/js/plugins/iCheck/icheck.min.js"></script>
	<script type="text/javascript" src="${base}/asset/console/js/plugins/ueditor/ueditor.config.js?v=1.2" charset="utf-8"></script>
    <script type="text/javascript" src="${base}/asset/console/js/plugins/ueditor/ueditor.all.min.js?v=1.2" charset="utf-8"></script>
    <script type="text/javascript" src="${base}/asset/console/js/plugins/treeview/bootstrap-treeview.js"></script>
	<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap-tagsinput/0.7.1/bootstrap-tagsinput.js"></script>
    <script>
        $(document).ready(function(){
        	$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",});
        	var ueditor=UE.getEditor("content", {
		        toolbars:[[
				"drafts","source", "preview", "searchreplace", "undo", "redo", "removeformat","|", 
		                   "bold", "italic", "underline",  "formatmatch", "autotypeset", "blockquote", "pasteplain", "forecolor", "backcolor", "insertorderedlist", "insertunorderedlist", "selectall", "cleardoc", "|",
		                   "rowspacingtop", "rowspacingbottom", "lineheight", "indent",  "justifyleft", "justifycenter", "justifyright", "justifyjustify", "|", "paragraph",  "fontsize", 
		                   "link", "unlink", "simpleupload", "insertimage",  "imagenone", "imageleft", "imageright", "imagecenter", "|",
		                  "emotion", "scrawl", "insertvideo", "music", "attachment", "map", "insertframe", "insertcode",  "template", 
		                   "horizontal", "spechars", "snapscreen", "wordimage", "|",
		                   "inserttable",  "insertrow", "deleterow", "insertcol", "deletecol", "mergecells", "mergeright", "mergedown", "splittocells", "splittorows", "splittocols", "charts"
		                  
		       ]],//这里可以选择自己需要的工具按钮名称,此处仅选择如下五个
		        wordCount:false, //关闭字数统计
		        elementPathEnabled:false//关闭elementPath
    		});
        	
        	$(".hot-tag").click(function(){
        		$("#keywords").tagsinput("add", $(this).data("tag"));
        	});
        	
        	$.ajax({
				 url: "${base}/manage/article/categoryTree",
				 method:"post",
               dataType: "json",
               traditional:true,
               success: function (respData) {
               	var category_name_active=$("#category_name").val();
               	var category_id_active=$("#category_id").val();
               	var $tree=$("#category_treeview").treeview({
               		color:"#485f7c",
               		nodeIcon: "glyphicon glyphicon-book",
               		data:respData,
               		onNodeSelected: function(event, data) {
               			$("#category_name").val(data.text);
               			$("#category_id").val(data.code);
               		}
               		});
               	$("#category_treeview .list-group-item").each(function(){
               		var category_name=$(this).text();
               		if(category_name==category_name_active){
               			var nodeId=$(this).data("nodeid");
               			var node=$tree.treeview("getNode", nodeId);
               			if(node.code==category_id_active){
               				$tree.treeview("selectNode",  node);
               				$tree.treeview("expandNode",$tree.treeview("getParent",node));
               			}
               		}
               	});
               }
			 });
       	
       	$("#saveDraft").click(function(){
       		ueditor.sync();
       		$("#status").val("1");
            if($("#category_id").val()&&$("#category_id").val()!=""){
                $("#articleForm").submit();
            }else{
                parent.layer.alert("请选择分类~~");
            }
       	});
       	$("#savePublish").click(function(){
       		ueditor.sync();
       		$("#status").val("2");
            if($("#category_id").val()&&$("#category_id").val()!=""){
                $("#articleForm").submit();
            }else{
                parent.layer.alert("请选择分类~~");
            }
       	});
        	$("#returnList").on("click",function(){
        		window.location.href="${base}/manage/article";
        	});
        	});
    </script>
</body></html>