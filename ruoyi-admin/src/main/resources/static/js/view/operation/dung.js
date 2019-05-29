
function dung_onload() {
    init_dung();
    Dall_time();
    Dday_time();
    Dstart_time();
    Dend_time();
    /*    setInterval('init_echarts_tem',1000);
        setInterval('facility_onload()',1000);*/

}

function  init_dung(){
    $.ajax({
        type: "GET",
        url: "/api/piginfo/amm",
        datatype: "JSON",
        success: function (data) {
            var amm = data.data;
            var air = new Array();
            var logtime = new Array();

            for (i in amm) {
                air.push(amm[i].air_v);
                logtime.push(amm[i].rec_time.substring(11));
            }

            var Amm = echarts.init(document.getElementById('Amm'));

            Amm_option = {
                title: {
                    text: '氨气值'
                },
                tooltip: {
                    trigger: 'axis'
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data:logtime
                },
                yAxis: {
                    type: 'value',
                    min:0,
                },
                series: [
                    {
                        name:'氨气值',
                        type:'line',
                        label:{
                            normal:{
                                show:true
                            }
                        },
                        itemStyle : {
                            normal : {
                                lineStyle:{
                                    width:3,//折线宽度
                                    color:"#FF7F00"//折线颜色
                                }
                            }
                        },
                        areaStyle: {normal: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#FFA500'},
                                        {offset: 0.5, color: '#FFD700'},
                                        {offset: 1, color: '#FFEC8B'}
                                    ]
                                )
                            }},


                        data:air
                    },
                ]
            };

            Amm.setOption(Amm_option);
        }
    })
}

function Dall_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/DallTime",
        datatype: "JSON",
        success: function (data) {
            var time = data.data;
            document.getElementById('Time').innerText = time;
        }
    })
}

function Dday_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/DdayTime",
        datatype: "JSON",
        success: function (data) {
            var daytime = data.data;
            document.getElementById('dayTime').innerText = daytime;
        }
    })
}

function Dstart_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/DstartTime",
        datatype: "JSON",
        success: function (data) {
            var starttime = data.data;
            document.getElementById('startTime').innerText = starttime;
        }
    })
}

function Dend_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/DendTime",
        datatype: "JSON",
        success: function (data) {
            var endtime = data.data;
            document.getElementById('endTime').innerText = endtime;
        }
    })
}

function startsent(command){
    if (ws != null) {
        // 控制台打印
        console.log('开始发送Wb指令');
        // 推送信息
        ws.send(command);
    } else {
        $.modal.confirm("WebSocket 连接建立失败，请重新连接");
    }
}

function connectWS(command) {

    // 当前地址
    var path = window.location.pathname;

    // 当前主机
    var hostaddress = window.location.host + path.substring(0,path.substr(1).indexOf('/')+1);

    // 后台wb控制器url
    var target = "/wb/test";

    // 将http协议换成ws
    if (window.location.protocol == 'http:') {
        target = 'ws://' + hostaddress + target;
    } else {
        target = 'wss://' + hostaddress + target;
    }
    console.log('WebSocketServer地址：'+target);

    //创建一个针对控制器的 webSocket 对象
    if ('WebSocket' in window) {
        ws = new WebSocket(target);
    } else if ('MozWebSocket' in window) {
        ws = new MozWebSocket(target);
    } else {
        $.modal.confirm("您的浏览器不支持 WebSocket！");
        return;
    }

    // 如果没有ws对象 直播状态为2 设置对应按钮
    if(ws==null){
        console.log("WebSocket创建失败...")
    }

    // 开启WS
    ws.onopen = function () {
        //向后台发送指令
        startsent(command);
        console.log('发送控制命令');
    };

    // WS的返回信息
    ws.onmessage = function (event) {
        console.log('WS接收到的信息:' + event.data);
    };

    // WS关闭
    ws.onclose = function (event) {
        console.log('WS已关闭:' + event.data );
    };

}



