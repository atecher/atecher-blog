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
    <link href="${base}/asset/console/css/style.min.css" rel="stylesheet"/>
    <link href="${base}/asset/console/css/plugins/treeview/bootstrap-treeview.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-9 animated fadeInLeft">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>文章管理</h5>
                </div>
                <div class="ibox-content">
                    <div class="tabs-container">
                        <form class="form-horizontal" action="${base}/manage/category/save" method="post" enctype="multipart/form-data" id="categoryForm">
                            <input name="category_id" type="hidden" value="${category.category_id}"/>
                            <input name="category_level" type="hidden" value="${category.category_level}"/>
                            <input name="parent_name" id="parent_name" type="hidden" value="${(parent.category_name)!''}"/>
                            <input name="parent_id" id="parent_id" type="hidden" value="${category.parent_id}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">名 称</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" name="category_name" value="${category.category_name}" onblur="fwpath.value=CC2PYF(category_name.value)"><span class="help-block m-b-none">分类名称，显示在网站列表中</span>
                                    </div>
                                    <label class="col-sm-2 control-label">排 序</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" name="priority" value="${category.priority}" maxlength="10"/><span class="help-block m-b-none">排序，将影响分类的显示顺序</span>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">访问路径</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="category_path" id="fwpath" value="${category.category_path}"/><span class="help-block m-b-none">将作为本分类在网站中的访问地址</span>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">关键字</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="keywords" placeholder="可以填写关键信息，有助于优化互联网搜索" class="form-control" value="${category.keywords}">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">分类描述</label>
                                    <div class="col-sm-10">
                                        <textarea name="description" placeholder="如不填写，将自动读取正文生成摘要内容" class="form-control" style="min-height: 100px;" id="idDescription">${category.description}</textarea>
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
                    <div class="ibox-tools">
                        <button class="btn btn-primary btn-xs" id="returnList">返回分类列表</button>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="file-manager">
                        <div class="form-group">
                            <button class="btn btn-primary btn-block" id="resetCategory">重置分类</button>
                            <button class="btn btn-danger btn-block" id="saveCategory">立即保存</button>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>分类属性</h5>
                </div>
                <div class="ibox-content">
                    <div class="file-manager">
                        <div class="form-group">
                            <label>选择分类：</label>
                            <div id="category_treeview" class="test" data-category-name="${(parent.category_name)!''}" data-category-id="${category.parent_id}"></div>
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
<script type="text/javascript" src="${base}/asset/console/js/plugins/treeview/bootstrap-treeview.js"></script>
<script>
    $(document).ready(function () {
        $.ajax({
            url: "${base}/manage/article/categoryTree",
            method: "post",
            dataType: "json",
            traditional: true,
            success: function (respData) {
                var category_name_active = $("#parent_name").val();
                var category_id_active = $("#parent_id").val();
                var $tree = $("#category_treeview").treeview({
                    color: "#428bca",
                    nodeIcon: "glyphicon glyphicon-book",
                    data: respData,
                    onNodeSelected: function (event, data) {
                        $("#parent_name").val(data.text);
                        $("#parent_id").val(data.code);
                    }
                });
                $("#category_treeview .list-group-item").each(function () {
                    var category_name = $(this).text();
                    if (category_name == category_name_active) {
                        var nodeId = $(this).data("nodeid");
                        var node = $tree.treeview("getNode", nodeId);
                        if (node.code == category_id_active) {
                            $tree.treeview("selectNode", node);
                            $tree.treeview("expandNode", $tree.treeview("getParent", node));
                        }
                    }
                });
            }
        });

        $("#resetCategory").click(function () {
            $("#categoryForm")[0].reset();
        });
        $("#saveCategory").click(function () {
            $("#categoryForm").submit();
        });
        $("#returnList").on("click", function () {
            window.location.href = "${base}/manage/category";
        });
    });
</script>
</body>
</html>