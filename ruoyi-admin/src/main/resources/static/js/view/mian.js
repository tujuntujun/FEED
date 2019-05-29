// 等待页面DOM加载完后自动加载
function main_onload() {

    // 前台图表
    init_echarts_recent20();

    init_selectCount();

/*    setInterval('init_echarts_recent20()',1000);

    setInterval('init_selectCount',1000);*/
}

function init_echarts_recent20() {
    $.ajax({
        type: "GET",
        url: "/api/piginfo/rc10",
        datatype: "JSON",
        success: function (data) {
            var pre_data = data.data;
            var tem = new Array();
            var rh = new Array();
            var ag = new Array();
            var lg = new Array();
            var logtime = new Array();

            for(i in pre_data){
                tem.push(pre_data[i].temp_v);
                rh.push(pre_data[i].humi_v);
                ag.push(pre_data[i].air_v);
                lg.push(pre_data[i].light_v);
                logtime.push(pre_data[i].rec_time.substring(11));
            }

            var valueOfTem = echarts.init(document.getElementById('valueOfTem'));
            var valueOfRh = echarts.init(document.getElementById('valueOfRh'));
            var valueOfLight = echarts.init(document.getElementById('valueOfLight'));
            var valueOfAg = echarts.init(document.getElementById('valueOfAg'));

            valueOfTem_option = {
                tooltip: {},
                grid:{
                    top: '5%',
                    left: '1%',
                    right: '1%',
                    bottom: '2%',
                    containLabel: true,
                },
                xAxis: {
                    type: 'category',
                    data:logtime,       //横坐标
                    axisTick:{
                        show:false,
                    },
                    axisLabel:{
                        interval: 0,
                        rotate:0,
                        textStyle: {
                            color:'#FF8C69',
                            margin:15,
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            type: 'solid',
                            color:'#FF8C69',
                            width:'1  ',                                                //坐标线的宽度

                        }
                    },
                },

                yAxis: {
                    splitLine: {
                        show: true,
                        lineStyle:{
                            color: '#40A1EA',                                         //网格横线颜色
                            width: 1,
                            type: 'solid'
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#FF8C69',
                        }
                    },
                    axisLine: {
                        show:false,
                    },
                },
                series: [{
                    name: '温度值',
                    type: 'bar',
                    barWidth:35,
                    data:tem,        //数据
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#06B5D7'},                   //柱图渐变色
                                    {offset: 0.5, color: '#44C0C1'},                 //柱图渐变色
                                    {offset: 1, color: '#71C8B1'},                   //柱图渐变色
                                ]
                            )
                        },
                        emphasis: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#71C8B1'},                  //柱图高亮渐变色
                                    {offset: 0.7, color: '#44C0C1'},                //柱图高亮渐变色
                                    {offset: 1, color: '#06B5D7'}                   //柱图高亮渐变色
                                ]
                            )
                        }
                    },
                }]

            };
            valueOfTem.setOption(valueOfTem_option);

            valueOfRh_option = {
                tooltip: {},
                grid:{
                    top: '5%',
                    left: '1%',
                    right: '1%',
                    bottom: '2%',
                    containLabel: true,
                },
                xAxis: {
                    type: 'category',
                    data:logtime,       //横坐标
                    axisTick:{
                        show:false,
                    },
                    axisLabel:{
                        interval: 0,
                        rotate:0,
                        textStyle: {
                            color:'#FF8C69',
                            margin:15,
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            type: 'solid',
                            color:'#FF8C69',
                            width:'1  ',                                                //坐标线的宽度

                        }
                    },
                },

                yAxis: {
                    splitLine: {
                        show: true,
                        lineStyle:{
                            color: '#40A1EA',                                         //网格横线颜色
                            width: 1,
                            type: 'solid'
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#FF8C69',
                        }
                    },
                    axisLine: {
                        show:false,
                    },
                },
                series: [{
                    name: '湿度值',
                    type: 'bar',
                    barWidth:30,
                    data:rh,        //数据
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#06B5D7'},                   //柱图渐变色
                                    {offset: 0.5, color: '#44C0C1'},                 //柱图渐变色
                                    {offset: 1, color: '#71C8B1'},                   //柱图渐变色
                                ]
                            )
                        },
                        emphasis: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#71C8B1'},                  //柱图高亮渐变色
                                    {offset: 0.7, color: '#44C0C1'},                //柱图高亮渐变色
                                    {offset: 1, color: '#06B5D7'}                   //柱图高亮渐变色
                                ]
                            )
                        }
                    },
                }]
            };
            valueOfRh.setOption(valueOfRh_option);

            valueOfLight_option = {
                tooltip: {},
                grid:{
                    top: '5%',
                    left: '1%',
                    right: '1%',
                    bottom: '2%',
                    containLabel: true,
                },
                xAxis: {
                    type: 'category',
                    data:logtime,       //横坐标
                    axisTick:{
                        show:false,
                    },
                    axisLabel:{
                        interval: 0,
                        rotate:0,
                        textStyle: {
                            color:'#FF8C69',
                            margin:15,
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            type: 'solid',
                            color:'#FF8C69',
                            width:'1  ',                                                //坐标线的宽度

                        }
                    },
                },

                yAxis: {
                    splitLine: {
                        show: true,
                        lineStyle:{
                            color: '#40A1EA',                                         //网格横线颜色
                            width: 1,
                            type: 'solid'
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#FF8C69',
                        }
                    },
                    axisLine: {
                        show:false,
                    },
                },
                series: [{
                    name: '光照值',
                    type: 'bar',
                    barWidth:30,
                    data:lg,        //数据
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#06B5D7'},                   //柱图渐变色
                                    {offset: 0.5, color: '#44C0C1'},                 //柱图渐变色
                                    {offset: 1, color: '#71C8B1'},                   //柱图渐变色
                                ]
                            )
                        },
                        emphasis: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#71C8B1'},                  //柱图高亮渐变色
                                    {offset: 0.7, color: '#44C0C1'},                //柱图高亮渐变色
                                    {offset: 1, color: '#06B5D7'}                   //柱图高亮渐变色
                                ]
                            )
                        }
                    },
                }]
            };
            valueOfLight.setOption(valueOfLight_option);

            valueOfAg_option = {
                tooltip: {},
                grid:{
                    top: '5%',
                    left: '1%',
                    right: '1%',
                    bottom: '2%',
                    containLabel: true,
                },
                xAxis: {
                    type: 'category',
                    data:logtime,       //横坐标
                    axisTick:{
                        show:false,
                    },
                    axisLabel:{
                        interval: 0,
                        rotate:0,
                        textStyle: {
                            color:'#FF8C69',
                            margin:15,
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            type: 'solid',
                            color:'#FF8C69',
                            width:'1  ',                                                //坐标线的宽度

                        }
                    },
                },

                yAxis: {
                    splitLine: {
                        show: true,
                        lineStyle:{
                            color: '#40A1EA',                                         //网格横线颜色
                            width: 1,
                            type: 'solid'
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#FF8C69',
                        }
                    },
                    axisLine: {
                        show:false,
                    },
                },
                series: [{
                    name: '氨气值',
                    type: 'bar',
                    barWidth:30,
                    data:ag,        //数据
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#06B5D7'},                   //柱图渐变色
                                    {offset: 0.5, color: '#44C0C1'},                 //柱图渐变色
                                    {offset: 1, color: '#71C8B1'},                   //柱图渐变色
                                ]
                            )
                        },
                        emphasis: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#71C8B1'},                  //柱图高亮渐变色
                                    {offset: 0.7, color: '#44C0C1'},                //柱图高亮渐变色
                                    {offset: 1, color: '#06B5D7'}                   //柱图高亮渐变色
                                ]
                            )
                        }
                    },
                }]
            };
            valueOfAg.setOption(valueOfAg_option);
        }
    })
}


function init_selectCount() {
/*    $.ajax({
        type: "GET",
        url: "/api/piginfo/selectCount",
        datatype: "JSON",
        success: function (data) {
            var countAll = data.data
            document.getElementById('CountAll').innerText = countAll;
        }
    })*/

    $.ajax({
        type: "GET",
        url: "/api/piginfo/prentem",
        datatype: "JSON",
        success: function (data) {
            var prentem = data.data
            document.getElementById('PrenTem').innerText = prentem;
        }
    })

    $.ajax({
        type: "GET",
        url: "/api/piginfo/prenrh",
        datatype: "JSON",
        success: function (data) {
            var prenrh = data.data
            document.getElementById('PrenRh').innerText = prenrh;
        }
    })

    $.ajax({
        type: "GET",
        url: "/api/piginfo/prenlight",
        datatype: "JSON",
        success: function (data) {
            var prenlight = data.data
            document.getElementById('PrenLight').innerText = prenlight;
        }
    })

    $.ajax({
        type: "GET",
        url: "/api/piginfo/prenag",
        datatype: "JSON",
        success: function (data) {
            var prenag = data.data
            document.getElementById('PrenAg').innerText = prenag;
        }
    })
}

