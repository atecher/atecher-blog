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
    <div class="row">
        <div class="col-sm-12 animated fadeInLeft">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>设置</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        <a class="close-link"><i class="fa fa-times"></i></a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="tabs-container">
                        <button id="profile" class="btn btn-primary dim btn-large-dim" type="button" style="width: 200px;font-size: 20px;"><i class="fa fa-cog"></i>参数设置</button>
                        <button id="indexBuild" class="btn btn-danger  dim btn-large-dim" type="button" style="width: 200px;font-size: 20px;"><i class="fa fa-search-plus"></i>生成索引</button>
                        </button>
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
<script type="text/javascript">
    $("#profile").click(function () {
        window.location.href = '${base}/admin/profile';
    });
    $("#indexBuild").click(function () {
        $.ajax({
            url: '${base}/admin/buildIndex',
            method: "get",
            dataType: 'json',
            traditional: true,
            success: function (result) {
                if (result.code == "success") {
                    parent.layer.alert('成功创建索引');
                }
            }
        });
    });
</script>
</body>
</html>