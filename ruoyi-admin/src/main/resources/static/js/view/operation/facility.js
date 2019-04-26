
function facility_onload() {
    init_facility();
    all_time();
    day_time();
    start_time();
    end_time();
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



