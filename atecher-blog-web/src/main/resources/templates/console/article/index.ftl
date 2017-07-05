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
    <link href="${base}/asset/console/css/style.min.css" rel="stylesheet"/>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>文章管理</h5>
        </div>
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
                    <div class="example-wrap">
                        <div class="example">
                            <div class="hidden-xs" id="dataTableEventsToolbar" role="group">
                                <button type="button" class="btn btn-info btn-circle" id="addArticle"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i></button>
                                <button type="button" class="btn btn-danger btn-circle" id="deleteBatch"><i class="glyphicon glyphicon-trash" aria-hidden="true"></i></button>
                            </div>
                            <table id="dataTableEvents"
                                   data-height="600" data-mobile-responsive="true"
                                   data-url="${base}/manage/article/data" data-cache="false" data-striped="true" data-method="post" data-data-type="json" data-content-type="application/x-www-form-urlencoded"
                                   data-pagination="true" data-page-number="1" data-page-size="20" data-page-list="[10, 20, 50, 100]" data-side-pagination="server" data-query-params="queryParams"
                                   data-toggle="table" data-show-toggle=“true”
                                   data-search="true" data-show-columns="true" data-show-refresh="true" data-icon-size="outline" data-toolbar="#dataTableEventsToolbar" data-sortable="true"
                            >
                                <thead>
                                <tr>
                                    <th data-field="check" data-checkbox="true"></th>
                                    <th data-field="article_id" data-align="center" data-valign="middle" data-sortable="true">ID</th>
                                    <th data-field="title" data-align="left" data-valign="middle" data-sortable="true">标题</th>
                                    <th data-field="category_name" data-align="center" data-valign="middle">分类</th>
                                    <th data-field="author" data-align="center" data-valign="middle">作者</th>
                                    <th data-field="update_time" data-align="center" data-valign="middle" data-sortable="true">修改时间</th>
                                    <th data-field="total_clicks" data-align="center" data-valign="middle" data-sortable="true">点击数</th>
                                    <th data-field="operate" data-align="center" data-valign="middle" data-formatter="operateFormatter" data-events="operateEvents">操作</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${base}/asset/console/js/content.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-table/1.9.0/bootstrap-table.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-table/1.9.0/extensions/mobile/bootstrap-table-mobile.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-table/1.9.0/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(window).resize(function () {
            $('#dataTableEvents').bootstrapTable('resetView');
        });

        $("#addArticle").on("click", function () {
            window.location.href = "${base}/manage/article/add";
        });

    });

    function operateFormatter(value, row, index) {
        return [
            '<button class="edit btn btn-info btn-circle btn-tb"  title="修改">',
            '<i class="glyphicon glyphicon-edit"></i>',
            '</button>  ',
            '<button class="remove btn btn-danger btn-circle btn-tb"  title="删除">',
            '<i class="glyphicon glyphicon-remove"></i>',
            '</button>'
        ].join('');
    }
    function queryParams(params) {  //配置参数
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            search: params.search,
            sort: params.sort,  //排序列名
            order: params.order//排位命令（desc，asc）
        };
        return temp;
    }
    window.operateEvents = {
        'click .edit': function (e, value, row, index) {
            window.location.href = '${base}/manage/article/edit/' + row.article_id;
        },
        'click .remove': function (e, value, row, index) {
            parent.layer.confirm('您确认要删除这条数据吗？', {
                btn: ['确认', '算了'],
                shade: false
            }, function () {
                parent.layer.closeAll();
                $.getJSON("${base}/manage/article/remove/" + row.article_id, function (data) {
                    if (data.code == "success") {
                        $('#dataTableEvents').bootstrapTable('refresh');
                    }
                });
            }, function () {
                parent.layer.closeAll();
            });

        }
    };
</script>
</body>
</html>