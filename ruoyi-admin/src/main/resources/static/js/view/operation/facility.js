
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




