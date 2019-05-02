
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



