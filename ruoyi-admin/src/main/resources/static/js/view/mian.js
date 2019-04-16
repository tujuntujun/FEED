// 等待页面DOM加载完后自动加载
function main_onload() {

    // 前台图表
    init_echarts_recent20()
}

function init_echarts_recent20() {
    $.ajax({
        type: "GET",
        url: "/api/piginfo/rc20",
        datatype: "JSON",
        success: function (data) {
            var pre_data = data.data;
            var tem = new Array();
            var rh = new Array();
            var ag = new Array();
            var lg = new Array();
            var logtime = new Array();

            for(i in pre_data){
                tem.push(pre_data[i].tem_v);
                rh.push(pre_data[i].rh_v);
                ag.push(pre_data[i].ag_v);
                lg.push(pre_data[i].light_v);
                logtime.push(pre_data[i].rec_time);
            }

            var valueOfTem = echarts.init(document.getElementById('valueOfTem'));
            var valueOfRh = echarts.init(document.getElementById('valueOfRh'));
            var valueOfLight = echarts.init(document.getElementById('valueOfLight'));
            var valueOfAg = echarts.init(document.getElementById('valueOfAg'));

            valueOfTem_option = {
                tooltip: {
                },
                grid: {
                    top: '2%',
                    left: '1%',
                    right: '1%',
                    bottom: '2%',
                    containLabel: true,
                },
                xAxis: [{
                    type: 'category',
                    boundaryGap: false,
                    axisLine: { //坐标轴轴线相关设置。数学上的x轴
                        show: true,
                        lineStyle: {
                            color: '#233e64'
                        },
                    },
                    axisLabel: { //坐标轴刻度标签的相关设置
                        textStyle: {
                            color: '#6a9cd5',
                            margin:15,
                        },
                    },
                    axisTick: { show: false,},
                    data: logtime,
                }],
                yAxis: [{
                    type: 'value',
                    splitNumber: 7,
                    splitLine: {
                        show: true,
                        lineStyle: {
                            color: '#233e64'
                        }
                    },
                    axisLine: {show: false,},
                    axisLabel: {
                        margin:20,
                        textStyle: {
                            color: '#6a9cd5',

                        },
                    },
                    axisTick: { show: false,},
                }],
                series: [{
                    name: '异常流量',
                    type: 'line',
                    smooth: true, //是否平滑曲线显示
// 			symbol:'circle',  // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize:0,

                    lineStyle: {
                        normal: {
                            color: "#3deaff"   // 线条颜色
                        }
                    },
                    areaStyle: { //区域填充样式
                        normal: {
                            //线性渐变，前4个参数分别是x0,y0,x2,y2(范围0~1);相当于图形包围盒中的百分比。如果最后一个参数是‘true’，则该四个值是绝对像素位置。
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                { offset: 0,  color: 'rgba(61,234,255, 0.9)'},
                                { offset: 0.7,  color: 'rgba(61,234,255, 0)'}
                            ], false),

                            shadowColor: 'rgba(53,142,215, 0.9)', //阴影颜色
                            shadowBlur: 20 //shadowBlur设图形阴影的模糊大小。配合shadowColor,shadowOffsetX/Y, 设置图形的阴影效果。
                        }
                    },
                    data: tem
                }]

            };
            valueOfTem.setOption(valueOfTem_option);

            valueOfRh_option = {
                tooltip: {
                },
                grid: {
                    top: '2%',
                    left: '1%',
                    right: '1%',
                    bottom: '2%',
                    containLabel: true,
                },
                xAxis: [{
                    type: 'category',
                    boundaryGap: false,
                    axisLine: { //坐标轴轴线相关设置。数学上的x轴
                        show: true,
                        lineStyle: {
                            color: '#233e64'
                        },
                    },
                    axisLabel: { //坐标轴刻度标签的相关设置
                        textStyle: {
                            color: '#6a9cd5',
                            margin:15,
                        },
                    },
                    axisTick: { show: false,},
                    data: logtime,
                }],
                yAxis: [{
                    type: 'value',
                    splitNumber: 7,
                    splitLine: {
                        show: true,
                        lineStyle: {
                            color: '#233e64'
                        }
                    },
                    axisLine: {show: false,},
                    axisLabel: {
                        margin:20,
                        textStyle: {
                            color: '#6a9cd5',

                        },
                    },
                    axisTick: { show: false,},
                }],
                series: [{
                    name: '异常流量',
                    type: 'line',
                    smooth: true, //是否平滑曲线显示
// 			symbol:'circle',  // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize:0,

                    lineStyle: {
                        normal: {
                            color: "#3deaff"   // 线条颜色
                        }
                    },
                    areaStyle: { //区域填充样式
                        normal: {
                            //线性渐变，前4个参数分别是x0,y0,x2,y2(范围0~1);相当于图形包围盒中的百分比。如果最后一个参数是‘true’，则该四个值是绝对像素位置。
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                { offset: 0,  color: 'rgba(61,234,255, 0.9)'},
                                { offset: 0.7,  color: 'rgba(61,234,255, 0)'}
                            ], false),

                            shadowColor: 'rgba(53,142,215, 0.9)', //阴影颜色
                            shadowBlur: 20 //shadowBlur设图形阴影的模糊大小。配合shadowColor,shadowOffsetX/Y, 设置图形的阴影效果。
                        }
                    },
                    data: rh
                }]

            };
            valueOfRh.setOption(valueOfRh_option);

            valueOfLight_option = {
                tooltip: {
                },
                grid: {
                    top: '2%',
                    left: '1%',
                    right: '1%',
                    bottom: '2%',
                    containLabel: true,
                },
                xAxis: [{
                    type: 'category',
                    boundaryGap: false,
                    axisLine: { //坐标轴轴线相关设置。数学上的x轴
                        show: true,
                        lineStyle: {
                            color: '#233e64'
                        },
                    },
                    axisLabel: { //坐标轴刻度标签的相关设置
                        textStyle: {
                            color: '#6a9cd5',
                            margin:15,
                        },
                    },
                    axisTick: { show: false,},
                    data: logtime,
                }],
                yAxis: [{
                    type: 'value',
                    splitNumber: 7,
                    splitLine: {
                        show: true,
                        lineStyle: {
                            color: '#233e64'
                        }
                    },
                    axisLine: {show: false,},
                    axisLabel: {
                        margin:20,
                        textStyle: {
                            color: '#6a9cd5',

                        },
                    },
                    axisTick: { show: false,},
                }],
                series: [{
                    name: '异常流量',
                    type: 'line',
                    smooth: true, //是否平滑曲线显示
// 			symbol:'circle',  // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize:0,

                    lineStyle: {
                        normal: {
                            color: "#3deaff"   // 线条颜色
                        }
                    },
                    areaStyle: { //区域填充样式
                        normal: {
                            //线性渐变，前4个参数分别是x0,y0,x2,y2(范围0~1);相当于图形包围盒中的百分比。如果最后一个参数是‘true’，则该四个值是绝对像素位置。
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                { offset: 0,  color: 'rgba(61,234,255, 0.9)'},
                                { offset: 0.7,  color: 'rgba(61,234,255, 0)'}
                            ], false),

                            shadowColor: 'rgba(53,142,215, 0.9)', //阴影颜色
                            shadowBlur: 20 //shadowBlur设图形阴影的模糊大小。配合shadowColor,shadowOffsetX/Y, 设置图形的阴影效果。
                        }
                    },
                    data: lg
                }]

            };
            valueOfLight.setOption(valueOfLight_option);

            valueOfAg_option = {
                tooltip: {
                },
                grid: {
                    top: '2%',
                    left: '1%',
                    right: '1%',
                    bottom: '2%',
                    containLabel: true,
                },
                xAxis: [{
                    type: 'category',
                    boundaryGap: false,
                    axisLine: { //坐标轴轴线相关设置。数学上的x轴
                        show: true,
                        lineStyle: {
                            color: '#233e64'
                        },
                    },
                    axisLabel: { //坐标轴刻度标签的相关设置
                        textStyle: {
                            color: '#6a9cd5',
                            margin:15,
                        },
                    },
                    axisTick: { show: false,},
                    data: logtime,
                }],
                yAxis: [{
                    type: 'value',
                    splitNumber: 7,
                    splitLine: {
                        show: true,
                        lineStyle: {
                            color: '#233e64'
                        }
                    },
                    axisLine: {show: false,},
                    axisLabel: {
                        margin:20,
                        textStyle: {
                            color: '#6a9cd5',

                        },
                    },
                    axisTick: { show: false,},
                }],
                series: [{
                    name: '异常流量',
                    type: 'line',
                    smooth: true, //是否平滑曲线显示
// 			symbol:'circle',  // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize:0,

                    lineStyle: {
                        normal: {
                            color: "#3deaff"   // 线条颜色
                        }
                    },
                    areaStyle: { //区域填充样式
                        normal: {
                            //线性渐变，前4个参数分别是x0,y0,x2,y2(范围0~1);相当于图形包围盒中的百分比。如果最后一个参数是‘true’，则该四个值是绝对像素位置。
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                { offset: 0,  color: 'rgba(61,234,255, 0.9)'},
                                { offset: 0.7,  color: 'rgba(61,234,255, 0)'}
                            ], false),

                            shadowColor: 'rgba(53,142,215, 0.9)', //阴影颜色
                            shadowBlur: 20 //shadowBlur设图形阴影的模糊大小。配合shadowColor,shadowOffsetX/Y, 设置图形的阴影效果。
                        }
                    },
                    data: ag
                }]

            };
            valueOfAg.setOption(valueOfAg_option);
        }
    })
}
