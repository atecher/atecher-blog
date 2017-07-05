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
        <div class="col-sm-9 animated fadeInLeft">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>系统参数</h5>
                </div>
                <div class="ibox-content">
                    <div class="tabs-container">
                        <form class="form-horizontal" action="${base}/admin/profile" method="post" id="profileForm">
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">管理后台名称</label>
                                    <div class="col-sm-9"><input type="text" id="profile_web_manager_title" name="profile_web_manager_title" value="${profile.web_manager_title}" maxlength="50"
                                                                 class="form-control {required:true,specialchar:true,messages:{required:'管理后台名称不能为空!',specialchar:'管理后台名称存在非法字符'}}"/></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">网站名称</label>
                                    <div class="col-sm-9"><input type="text" id="profile_web_app_title" name="profile_web_app_title" value="${profile.web_app_title}" maxlength="50"
                                                                 class="form-control {required:true,specialchar:true,messages:{required:'网站名称不能为空!',specialchar:'网站名称存在非法字符'}}"/></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">网站域名</label>
                                    <div class="col-sm-9"><input type="text" id="profile_web_realm_name" name="profile_web_realm_name" value="${profile.web_realm_name}" maxlength="50"
                                                                 class="form-control {required:true,specialchar:true,messages:{required:'网站域名不能为空!',specialchar:'网站域名存在非法字符'}}"/></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">资源版本</label>
                                    <div class="col-sm-9"><input type="text" id="profile_static_version" name="profile_static_version" value="${profile.static_version}" maxlength="50"
                                                                 class="form-control {required:true,specialchar:true,messages:{required:'资源版本不能为空!',specialchar:'资源版本存在非法字符'}}"/></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">是否开放注册</label>
                                    <div class="col-sm-9">
                                        <input name="profile_is_enabled_reg" type="radio" value="1" <#if profile.is_enabled_reg=='1'>checked</#if> />
                                        <span class="lbl">是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                        <input name="profile_is_enabled_reg" type="radio" value="0" <#if profile.is_enabled_reg=='0'>checked</#if>/>
                                        <span class="lbl">否&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">网站关键词</label>
                                    <div class="col-sm-9"><input type="text" id="profile_keywords" name="profile_keywords" value="${profile.keywords}" maxlength="50" class="form-control {required:true,specialchar:true,messages:{required:'网站关键词不能为空!',specialchar:'网站关键词存在非法字符'}}"/></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">网站描述</label>
                                    <div class="col-sm-9"><textarea id="profile_description" name="profile_description" style="width: 90%;" rows="5" class="form-control {required:true,messages:{required:'网站描述不能为空!'}}">${profile.description}</textarea></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">网站注册EMAIL模版</label>
                                    <div class="col-sm-9"><textarea id="profile_email_reg_template" name="profile_email_reg_template" rows="5" style="width: 90%;" class="large m-wrap {required:true,messages:{required:'模版不能为空!'}}">${profile.email_reg_template}</textarea></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">网站密码重置EMAIL模版</label>
                                    <div class="col-sm-9"><textarea id="profile_email_resetpassword_template" name="profile_email_resetpassword_template" style="width: 90%;" rows="5" class="large m-wrap {required:true,messages:{required:'模版不能为空!'}}">${profile.email_resetpassword_template}</textarea></div>
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
                    <h5>操作</h5>
                </div>
                <div class="ibox-content">
                    <div class="file-manager">
                        <div class="form-group">
                            <button class="btn btn-info btn-block " id="returnSetting">返回</button>
                            <button class="btn btn-danger btn-block " id="saveProfile">保存</button>
                            <button class="btn btn-warning btn-block " id="resetProfile">重置</button>
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
<script type="text/javascript">
    $("#returnSetting").click(function () {
        window.location.href = "${base}/admin/setting";
    })
    $("#saveProfile").click(function () {
        $("#profileForm").submit();
    });
    $("#resetProfile").click(function () {
        $("#profileForm")[0].reset();
    });
</script>
</body>
</html>