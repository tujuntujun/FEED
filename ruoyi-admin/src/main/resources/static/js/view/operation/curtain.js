
function curtain_onload() {
    init_curtain();
    Call_time();
    Cday_time();
    Cstart_time();
    Cend_time();
    /*    setInterval('init_echarts_tem',1000);
        setInterval('facility_onload()',1000);*/

}

function  init_curtain(){
    $.ajax({
        type: "GET",
        url: "/api/piginfo/light",
        datatype: "JSON",
        success: function (data) {
            var light = data.data;
            var guang = new Array();
            var logtime = new Array();

            for (i in light) {
                guang.push(light[i].light_v);
                logtime.push(light[i].rec_time.substring(11));
            }

            var Light = echarts.init(document.getElementById('Light'));

            Light_option = {
                title: {
                    text: '光照值'
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
                        name:'光照值',
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
                                    color:"#FF3E96"//折线颜色
                                }
                            }
                        },
                        areaStyle: {normal: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#FF69B4'},
                                        {offset: 0.5, color: '#FFBBFF'},
                                        {offset: 1, color: '#FFE1FF'}
                                    ]
                                )
                            }},
                        data:guang
                    },
                ]
            };

            Light.setOption(Light_option);
        }
    })
}

function Call_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/CallTime",
        datatype: "JSON",
        success: function (data) {
            var time = data.data;
            document.getElementById('Time').innerText = time;
        }
    })
}

function Cday_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/CdayTime",
        datatype: "JSON",
        success: function (data) {
            var daytime = data.data;
            document.getElementById('dayTime').innerText = daytime;
        }
    })
}

function Cstart_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/CstartTime",
        datatype: "JSON",
        success: function (data) {
            var starttime = data.data;
            document.getElementById('startTime').innerText = starttime;
        }
    })
}

function Cend_time() {
    $.ajax({
        type: "GET",
        url: "/api/motor/CendTime",
        datatype: "JSON",
        success: function (data) {
            var endtime = data.data;
            document.getElementById('endTime').innerText = endtime;
        }
    })
}

function button() {
    $.ajax({
        type: "GET",
        url: "/api/motor/button"

        /*        success: function (data) {
                    var endtime = data.data;
                    document.getElementById('endTime').innerText = endtime;
                }*/
    })
}



