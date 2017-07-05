<#include "../base/global.ftl"/>
<!DOCTYPE html>
<html>
<head>
    <title>H+ 后台主题UI框架 - 主页示例</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css" rel="stylesheet">
    <link href="${base}/asset/console/css/style.min.css" rel="stylesheet"/>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-8">
            <div class="ibox float-e-margins">
                <div class="ibox-title"><h5>系统资源</h5></div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="widget style1 navy-bg">
                                <div class="row vertical-align">
                                    <div class="col-xs-6"><h4>可用处理器</h4></div>
                                    <div class="col-xs-6 text-right"><h4>${monitor.availableProcessors}</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-6"><h4>最大内存</h4></div>
                                    <div class="col-xs-6 text-right"><h4>${monitor.maxMemory}M</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-6"><h4>已用内存</h4></div>
                                    <div class="col-xs-6 text-right"><h4>${monitor.usedMemory}M</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-6"><h4>MaxPermGen</h4></div>
                                    <div class="col-xs-6 text-right"><h4>${monitor.maxPermGen}M</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-6"><h4>usedPermGen</h4></div>
                                    <div class="col-xs-6 text-right"><h4>${monitor.usedPermGen}M</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-6"><h4>usedNonHeapMemory</h4></div>
                                    <div class="col-xs-6 text-right"><h4>${monitor.usedNonHeapMemory}M</h4></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="widget style1 yellow-bg">
                                <div class="row vertical-align">
                                    <div class="col-xs-3"><h4>javaName</h4></div>
                                    <div class="col-xs-9 text-right"><h4>${monitor.javaName}</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-3"><h4>javaVersion</h4></div>
                                    <div class="col-xs-9 text-right"><h4>${monitor.javaVersion}</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-3"><h4>jvmName</h4></div>
                                    <div class="col-xs-9 text-right"><h4>${monitor.jvmName}</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-3"><h4>jvmVersion</h4></div>
                                    <div class="col-xs-9 text-right"><h4>${monitor.jvmVersion}</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-6"><h4>threadCount</h4></div>
                                    <div class="col-xs-6 text-right"><h4>${monitor.threadCount}</h4></div>
                                </div>
                                <div class="row vertical-align">
                                    <div class="col-xs-6"><h4>peakThreadCount</h4></div>
                                    <div class="col-xs-6 text-right"><h4>${monitor.peakThreadCount}</h4></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>联系信息</h5>
                </div>
                <div class="ibox-content">
                    <p><i class="fa fa-send-o"></i> 博客：<a href="http://www.zi-han.net/" target="_blank">http://www.zi-han.net</a></p>
                    <p><i class="fa fa-qq"></i> QQ：<a href="http://wpa.qq.com/msgrd?v=3&uin=516477188&site=qq&menu=yes" target="_blank">516477188</a>
                    </p>
                    <p><i class="fa fa-weixin"></i> 微信：<a href="javascript:;">zheng-zihan</a>
                    </p>
                    <p><i class="fa fa-credit-card"></i> 支付宝：<a href="javascript:;" class="支付宝信息">zheng-zihan@qq.com / *子涵</a>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>购买说明</h5>
                </div>
                <div class="ibox-content">
                    <p>购买后我可以获得什么？</p>
                    <ol>
                        <li>所有源码(未压缩、带注释版本)；</li>
                        <li>说明文档；</li>
                        <li>终身免费升级服务；</li>
                        <li>必要的技术支持；</li>
                        <li>付费二次开发服务；</li>
                        <li>授权许可；</li>
                        <li>……</li>
                    </ol>
                    <hr>
                    <p>如果需要购买H+主题，可直接付款到支付宝：<a href="http://www.zi-han.net/theme/hplus/javascript;">zheng-zihan@qq.com</a>，收款人：<a href="http://www.zi-han.net/theme/hplus/javascript;">*子涵</a>。也可以使用手机支付宝或者微信扫码支付：</p>
                    <div class="alert alert-warning">
                        付款完成后请及时联系作者，或在付款备注中留下邮箱或QQ，方便作者及时联系您。
                        <br>如果图片太小，可以点击图片放大。
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/metisMenu/2.1.0/metisMenu.min.js"></script>
<script type="text/javascript" src="${base}/asset/console/js/content.min.js"></script>
<script type="text/javascript" src="${base}/asset/console/js/welcome.min.js"></script>
</body>
</html>