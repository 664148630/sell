<script>
    //如果报路径不对，这个文件还需要在微信公众号-微信支付里面配置好地址
    //这是自动获取的方式，在 pom 引用 spring-boot-starter-freemarker 自动获取
    function onBridgeReady() {
        WeixinJSBridge.invoke('getBrandWCPayRequest', {
                "appId": "${payResponse.appId}",     //公众号ID，由商户传入
                "timeStamp": "${payResponse.timeStamp}",     //时间戳，自1970年以来的秒数
                "nonceStr": "${payResponse.nonceStr}",      //随机串
                "package": "${payResponse.package}",
                "signType": "MD5",     //微信签名方式：
                "paySign": "${payResponse.paySign}" //微信签名
            },
            function(res) {
                // if (res.err_msg == "get_brand_wcpay_request:ok") {
                //     // 使用以上方式判断前端返回,微信团队郑重提示：
                //     //res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠，商户需进一步调用后端查单确认支付结果。
                // }

                //这里直接返回
                location.href = "${returnUrl}";
            });
    }
    if (typeof WeixinJSBridge == "undefined") {
        if (document.addEventListener) {
            document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
        } else if (document.attachEvent) {
            document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
        }
    } else {
        onBridgeReady();
    }
</script>