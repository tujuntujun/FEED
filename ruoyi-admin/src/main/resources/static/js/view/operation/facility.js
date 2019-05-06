
function facility_onload() {
    init_facility();
    all_time();
    day_time();
    start_time();
    end_time();
    Tall_time();
    Tday_time();
    Tstart_time();
    Tend_time();
/*    setInterval('init_echarts_tem',1000);
    setInterval('facility_onload()',1000);*/

}

function  init_facility() {

    $.ajax({
        type: "GET",
        url: "/api/piginfo/rc10",
        datatype: "JSON",
        success: function (data) {
            var pre_tempAhumi = data.data;
            var tem = new Array();
            var humi = new Array();
            var logtime = new Array();

            for (i in pre_tempAhumi) {
                tem.push(pre_tempAhumi[i].temp_v);
                humi.push(pre_tempAhumi[i].humi_v);
                logtime.push(pre_tempAhumi[i].rec_time.substring(11));
            }

            // 初始化echarts
            var temAhumi = echarts.init(document.getElementById('temAhumi'));


            temAhumi_option = {
                title: {
                    text: '温湿度数据'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data:['温度','数据']
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
                    max:50
                },
                series: [
                    {
                        name:'温度值',
                        type:'line',

                        label:{
                            normal:{
                                show:true
                            }
                        },
                        data:tem
                    },
                    {
                        name:'湿度值',
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
                                    color:"#F4A460"//折线颜色
                                }
                            }
                        },
                        areaStyle: {normal: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#FFD39B'},
                                        {offset: 0.5, color: '#FFE7BA'},
                                        {offset: 1, color: '#FFF8DC'}
                                    ]
                                )
                            }},
                        data:humi
                    },
                ]
            };


            temAhumi.setOption(temAhumi_option);
        }
    })
}

function all_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/allTime",
        datatype: "JSON",
        success: function (data) {
            var time = data.data;
            document.getElementById('Time').innerText = time;
        }
    })
}

function day_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/dayTime",
        datatype: "JSON",
        success: function (data) {
            var daytime = data.data;
            document.getElementById('dayTime').innerText = daytime;
        }
    })
}

function start_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/startTime",
        datatype: "JSON",
        success: function (data) {
            var starttime = data.data;
            document.getElementById('startTime').innerText = starttime;
        }
    })
}

function end_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/endTime",
        datatype: "JSON",
        success: function (data) {
            var endtime = data.data;
            document.getElementById('endTime').innerText = endtime;
        }
    })
}

function Tall_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/TallTime",
        datatype: "JSON",
        success: function (data) {
            var time = data.data;
            document.getElementById('TTime').innerText = time;
        }
    })
}

function Tday_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/TdayTime",
        datatype: "JSON",
        success: function (data) {
            var daytime = data.data;
            document.getElementById('TdayTime').innerText = daytime;
        }
    })
}

function Tstart_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/TstartTime",
        datatype: "JSON",
        success: function (data) {
            var starttime = data.data;
            document.getElementById('TstartTime').innerText = starttime;
        }
    })
}

function Tend_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/TendTime",
        datatype: "JSON",
        success: function (data) {
            var endtime = data.data;
            document.getElementById('TendTime').innerText = endtime;
        }
    })
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




