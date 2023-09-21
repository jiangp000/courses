function fnW(str) {
    var num;
    str >= 10 ? num = str : num = "0" + str;
    return num;
}

//中国地图开始
var china_map =echarts.init(document.getElementById("china_map"),'infographic');



var dataList=[
    {name:"南海诸岛",value:0},
    {name: '北京', value: 2200},
    {name: '天津', value: 1500},
    {name: '上海', value: 2190},
    {name: '重庆', value: 980},
    {name: '河北', value: 1200},
    {name: '河南', value: 1000},
    {name: '云南', value: 200},
    {name: '辽宁', value: 580},
    {name: '黑龙江', value:290},
    {name: '湖南', value: 790},
    {name: '安徽', value: 690},
    {name: '山东', value: 1800},
    {name: '新疆', value: 200},
    {name: '江苏', value: 2900},
    {name: '浙江', value: 1700},
    {name: '江西', value: 780},
    {name: '湖北', value: 1200},
    {name: '广西', value: 310},
    {name: '甘肃', value: 310},
    {name: '山西', value: 740},
    {name: '内蒙古', value: 200},
    {name: '陕西', value: 510},
    {name: '吉林', value: 420},
    {name: '福建', value: 1100},
    {name: '贵州', value: 690},
    {name: '广东', value: 2000},
    {name: '青海', value: 150},
    {name: '西藏', value: 190},
    {name: '四川', value: 1200},
    {name: '宁夏', value: 100},
    {name: '海南', value: 450},
    {name: '台湾', value: 790},
    {name: '香港', value: 890},
    {name: '澳门', value: 40}
]




var option = {
    tooltip: {
        formatter:function(params,ticket, callback){
            return params.seriesName+'<br />'+params.name+'：'+params.value
        },
        color: ['#FFFF00', '#FF0000']//取值范围的颜色

    },
    visualMap: {
        show:true,
        min: 20,
        max: 2000,
        left: 'left',
        font:17,
        top: 'bottom',
        text: ['3000万','0'],//取值范围的文字
        inRange: {
            color: ['#FFFF00', '#FF0000']//取值范围的颜色
        },
        textStyle: {
            color: '#FF0000', //设置字体颜色
            fontSize: 17 //设置字体大小
        },
        show:true//图注
    },
    geo: {
        map: 'china',
        roam: false,//不开启缩放和平移
        zoom:1.23,//视角缩放比例
        label: {
            normal: {
                show: true,
                fontSize:'10',
                color: 'rgba(FF,,0,0.7)'
            }
        },
        itemStyle: {
            normal:{
                borderColor: 'rgba(00, 0, 0, 0.2)'
            },
            emphasis:{
                areaColor: '#F3B329',//鼠标选择区域颜色
                shadowOffsetX: 0,
                shadowOffsetY: 0,
                shadowBlur: 20,
                borderWidth: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    },
    series : [
        {
            name: '总票房',
            type: 'map',
            geoIndex: 0,
            data:dataList
        }
    ]
};


// 代码 map


// function randomData() {
// 		return Math.round(Math.random()*500);
// 	}
//
// 	var mydata = [
// 		{name: '北京',value: randomData() },{name: '天津',value: randomData() },
// 		{name: '上海',value: randomData() },{name: '重庆',value: randomData() },
// 		{name: '河北',value: randomData() },{name: '河南',value: randomData() },
// 		{name: '云南',value: randomData() },{name: '辽宁',value: randomData() },
// 		{name: '黑龙江',value: randomData() },{name: '湖南',value: randomData()},
// 		{name: '安徽',value: randomData() },{name: '山东',value: randomData() },
// 		{name: '新疆',value: randomData() },{name: '江苏',value: randomData() },
// 		{name: '浙江',value: randomData() },{name: '江西',value: randomData() },
// 		{name: '湖北',value: randomData() },{name: '广西',value: randomData() },
// 		{name: '甘肃',value: randomData() },{name: '山西',value: randomData() },
// 		{name: '内蒙古',value: randomData() },{name: '陕西',value: randomData()},
// 		{name: '吉林',value: randomData() },{name: '福建',value: randomData() },
// 		{name: '贵州',value: randomData() },{name: '广东',value: randomData() },
// 		{name: '青海',value: randomData() },{name: '西藏',value: randomData() },
// 		{name: '四川',value: randomData() },{name: '宁夏',value: randomData() },
// 		{name: '海南',value: randomData() },{name: '台湾',value: randomData() },
// 		{name: '香港',value: randomData() },{name: '澳门',value: randomData() }
// 	];
//
// 	var option = {
// 		//backgroundColor: '#FFFFFF',
//
// 		title: {
// 			text: '犯罪人口来源分析',
// 			textStyle:{color:'#fff'},
// 			//subtext: '纯属虚构',
// 			x:'center'
// 		},
// 		tooltip : {
// 			trigger: 'item'
// 		},
// 		visualMap: {
// 			show : false,
// 			x: 'left',
// 			y: 'bottom',
// 			//layoutCenter:['30%','30%'],
// 			splitList: [
// 				{start: 500, end:600},{start: 400, end: 500},
// 				{start: 300, end: 400},{start: 200, end: 300},
// 				{start: 100, end: 200},{start: 0, end: 100},
// 			],
// 			color: ['#ff0', '#ffff00', '#0E94EB','#6FBCF0', '#F0F06F', '#00CC00']
// 		},
// 		series: [{
// 			name: '犯罪人口来源分析',
// 			type: 'map',
// 			mapType: 'china',
// 			roam: true,
// 			label: {
// 				normal: {
// 					show: false
// 				},
// 				emphasis: {
// 					show: false
// 				}
// 			},
// 			data:mydata
// 		}]
// 	};

china_map.on('click', function (params) {
    alert(params.name+':'+params.seriesName+':'+params.value);
});
china_map.setOption(option);
//中国地图结束







//获取当前时间
var timer = setInterval(function () {
    var date = new Date();
    var year = date.getFullYear(); //当前年份
    var month = date.getMonth(); //当前月份
    var data = date.getDate(); //天
    var hours = date.getHours(); //小时
    var minute = date.getMinutes(); //分
    var second = date.getSeconds(); //秒
    var day = date.getDay(); //获取当前星期几 
    var ampm = hours < 12 ? 'am' : 'pm';
    $('#time').html(fnW(hours) + ":" + fnW(minute) + ":" + fnW(second));
    $('#date').html('<span>' + year + '/' + (month + 1) + '/' + data + '</span><span>' + ampm + '</span><span>周' + day + '</span>')

}, 1000)


//违法犯罪人员分析占比，带边框效果的饼图
//var pie_fanzui =echarts.init(document.getElementById("pie_fanzui"),'macarons'); 
var pie_fanzui =echarts.init(document.getElementById("pie_fanzui"),'infographic');

// 添加代码

var option = {
    // backgroundColor: '#03111D',
    tooltip: {
        trigger: 'axis',
    },
    grid: {
        left: '2%',
        right: '4%',
        bottom: '14%',
        top:'16%',
        containLabel: true
    },
    legend: {
        data: ['综合票房', '分账票房', '上座率'],
        left: '7%',
        top:'5%',
        textStyle: {
            color: "#666666"
        },
        itemWidth: 15,
        itemHeight: 10,
        itemGap: 25
    },
    xAxis: {
        type: 'category',
        data: ['9.1日','9.2日','9.3日','9.4日','9.5日','9.6日','今日',],
        axisLabel: {
            color: '#A0A4AA'
        },
        axisLine: {
            show: true,
            lineStyle: {
                color: 'rgba(65, 97, 128, 0.5)',
            },
        },
        axisTick: {
            alignWithLabel: true
        }
    },
    yAxis: [{
        type: 'value',
        splitLine: {
            show: true,
            lineStyle: {
                color: 'rgba(163, 163, 163, 0.5)',
                type: 'dashed'
            }
        },
        axisLabel: {
            color: '#A0A4AA'
        },
        axisLine: {
            show: true,
            lineStyle: {
                color: 'rgba(65, 97, 128, 0.5)',
            },
        },
    },
        {
            type: "value",
            name: "",
            nameTextStyle: {
                color: "#666666"
            },
            position: "right",
            axisLine: {
                lineStyle: {
                    color: '#cdd5e2'
                }
            },
            splitLine: {
                show: false,
            },
            axisLabel: {
                show: false,
                formatter: "{value} %", //右侧Y轴文字显示
                textStyle: {
                    color: "#666666"
                }
            }
        }
    ],
    series: [
        {
            name: '综合票房',
            type: 'bar',
            barWidth: '12px',
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#DE9600'
                    }, {
                        offset: 1,
                        color: 'rgba(255, 183, 24,0)'
                    }]),
                }
            },
            data: [330120400, 450120400, 379021220, 530120400, 343890123, 592345672, 523461728]
        },
        {
        name: '分账票房',
        type: 'bar',
        barWidth: '12px',
        itemStyle: {
            normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                    offset: 0,
                    color: '#12BDDF'
                }, {
                    offset: 1,
                    color: 'rgba(24, 253, 255, 0)'
                }]),
            },
        },
        data: [300120400, 400120400, 309021220, 490120400, 263890123, 572345672, 423461728]
    },

        {
            name: "上座率",
            type: "line",
            yAxisIndex: 1, //使用的 y 轴的 index，在单个图表实例中存在多个 y轴的时候有用
            smooth: true, //平滑曲线显示

            symbol: "circle", //标记的图形为实心圆
            symbolSize: 0, //标记的大小
            itemStyle: {
                normal: {
                    color: '#0AF37A',
                    borderColor: '#0AF37A',  //圆点透明 边框
                    borderWidth: 0,
                    lineStyle: {
                        color: "#0AF37A"
                    },
                    areaStyle: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#46C118'
                        },{
                            offset: 1,
                            color: 'rgba(12, 162, 13, 0)'
                        }])
                    },
                },
            },
            data: [50, 80, 60, 39.6, 82.9, 88.8, 63]
        }
    ]
};


// 添加代码

// option = {
//     title : {
//         x:'center'
//     },
//     tooltip : {
//         trigger: 'item',
//         formatter: "{a} <br/>{b} : {c} ({d}%)"
//     },
//
//     // 1,300,456,789
//     // 412356789
//     // 247859653
//     // 124578963
//     // 495214752
//     // 20,446,631
//     legend: {
//         orient: 'vertical',
//         left: 'left',
//         data: ['孤注一掷','封神第一部','学爸','奥本海默','其他'],
//         textStyle: {color: '#fff'}
//     },
//
// 	label: {
// 	     normal: {
// 	          textStyle: {
// 	                color: 'red'  // 改变标示文字的颜色
// 	          }
// 	     }
// 	},
//     series : [
//         {
//             name: '票房占比',
//             type: 'pie',
//             radius : '55%',
//             center: ['55%', '55%'],
//             data:[
//                 {value:495214752, name:'孤注一掷'},
//                 {value:412356789, name:'封神第一部'},
//                 {value:247859653, name:'学爸'},
//                 {value:124578963, name:'奥本海默'},
//                 {value:20446631, name:'其他'},
//             ],
//
//             itemStyle: {
//                 emphasis: {
//                     shadowBlur: 10,
//                     shadowOffsetX: 0,
//
//                     shadowColor: 'rgba(0, 0, 0, 0.5)'
//                 }
//             }
//
//         }
//     ]
// };
pie_fanzui.setOption(option);
//----------------------违法犯罪人员分析占比end---------------



// 图2

//违法犯罪人员分析占比，带边框效果的饼图
//var pie_fanzui =echarts.init(document.getElementById("pie_fanzui"),'macarons');
var pic3 =echarts.init(document.getElementById("piaofang2"),'infographic');

// 添加代码
option = {
    // backgroundColor: "#2c343c",
    // title: {
    //     text: "产品库存",
    //     left: "center",
    //     top: 20,
    //     textStyle: {
    //         color: "#ccc",
    //     },
    // },

    tooltip: {
        trigger: "item",
        formatter: "{b} : {c} ({d}%)",
    },

    visualMap: {
        show: false,
        min: 500,
        max: 600,
        inRange: {
            //colorLightness: [0, 1]
        },
    },
    series: [
        {
            name: "访问来源",
            type: "pie",
            radius: "50%",
            center: ["50%", "50%"],
            color: ["rgb(50,100,255)", "rgb(250,55,126)", "rgb(255,72,79)", "rgb(255,115,33)",'rgb(55,212,92)','rgb(156,32,209)'], //'#FBFE27','rgb(11,228,96)','#FE5050'
            data: [
                {
                    value: 160123892,
                    name: "孤注一掷",
                },
                {
                    value: 120823019,
                    name: "封神第一部",
                },
                {
                    value: 78236761,
                    name: "长安三万里",
                },
                {
                    value: 51234782,
                    name: "八角笼中",
                },
                {
                    value: 41238920,
                    name: "奥本海默",
                },
                {
                    value: 39123749,
                    name: "其他",
                },
            ],

            label: {
                normal: {
                    formatter: ["{c|{c}}", "{b|{b}}"].join("\n"),
                    rich: {
                        c: {
                            color: "rgb(241,246,104)",
                            fontSize: 16,
                            fontWeight: "bold",
                            lineHeight: 5,
                        },
                        b: {
                            color: "rgb(98,137,169)",
                            fontSize: 15,
                            height: 40,
                        },
                    },
                },
            },
            labelLine: {
                normal: {
                    lineStyle: {
                        color: "rgb(98,137,169)",
                    },
                    smooth: 0.2,
                    length: 30,
                    length2: 20,
                },
            },
            itemStyle: {
                normal: {
                    shadowColor: "rgba(0, 0, 0, 0.8)",
                    shadowBlur: 50,
                },
            },
        },
    ],
};



// 添加代码
pic3.setOption(option);

// 图2

//违法犯罪人员年龄分析占比，带边框效果的饼图
//var pie_age =echarts.init(document.getElementById("pie_age"),'macarons'); 
var pic4 =echarts.init(document.getElementById("pie_age"),'infographic');
//var pie_age =echarts.init(document.getElementById("pie_age"),'shine');

// 代码4
option = {
    // backgroundColor: '#093036',
    title: {
        show:false,
        text: '南丁格尔玫瑰图',
        left: 'center',
        top: 20,
        textStyle: {
            color: '#ccc'
        }
    },

    tooltip: {
        trigger: 'item',
        formatter: "{b} : {c} ({d}%)"
    },

    visualMap: {
        show: false,
        min: 500,
        max: 600,
        inRange: {
            //colorLightness: [0, 1]
        }
    },
    series: [{
        name: '农房信息',
        type: 'pie',
        radius: '60%',
        center: ['50%', '43%'],
        color: ['rgb(131,249,103)', '#FBFE27', '#FE5050', '#1DB7E5',"#F3972F"], //'#FBFE27','rgb(11,228,96)','#FE5050'
        data: [{
            value: 38255,
            name: '孤注一掷'
        },
            {
                value: 41029,
                name: '封神第一部'
            },
            {
                value: 27839,
                name: '长安三万里'
            },
            {
                value: 19827,
                name: '八角笼中'
            },
            {
                value: 13568,
                name: '奥本海默'
            }
        ].sort(function(a, b) {
            return a.value - b.value
        }),
        roseType: 'radius',

        label: {
            normal: {
                formatter: ['{c|{c}场}', '{b|{b}}'].join('\n'),
                rich: {
                    c: {
                        color: '#8DEF8B',
                        fontSize: 20,
                        fontWeight:'bold',
                        lineHeight: 5
                    },
                    b: {
                        color: 'rgb(98,137,169)',
                        fontSize: 15,
                        height: 40
                    },
                },
            }
        },
        labelLine: {
            normal: {
                lineStyle: {
                    color: 'rgb(98,137,169)',
                },
                smooth: 0.2,
                length: 10,
                length2: 20,

            }
        },
        itemStyle: {
            normal: {
                shadowColor: 'rgba(0, 0, 0, 0.8)',
                shadowBlur: 50,
            }
        }
    }]
};



// 代码4
// option = {
//     tooltip: {
//         trigger: 'item',
//         formatter: "{a} <br/>{b}: {c} ({d}%)"
//     },
//     legend: {
//         orient: 'vertical',
//         x: 'left',
//         data:['孤注一掷','封神第一部','长安三万里','八角笼中','奥本海默','其他'],
//         textStyle: {color: '#fff'}
//     },
//     series: [
//         {
//             name:'排片占比',
//             type:'pie',
//             radius: ['30%', '55%'],
//             avoidLabelOverlap: false,
//             label: {
//                 normal: {
//                     show: false,
//                     position: 'center'
//                 },
//                 emphasis: {
//                     show: true,
//                     textStyle: {
//                         fontSize: '10',
//                         fontWeight: 'bold'
//                     }
//                 }
//             },
//             labelLine: {
//                 normal: {
//                     show: false
//                 }
//             },
//             data:[
//                 {value:76525, name:'孤注一掷'},
//                 {value:89414, name:'封神第一部'},
//                 {value:38088, name:'长安三万里'},
//                 {value:22440, name:'八角笼中'},
//                 {value:19210, name:'奥本海默'},
//                 {value:21980, name:'其他'}
//             ]
//         }
//     ]
// };
pic4.setOption(option);
//----------------------违法犯罪人员年龄分析占比end---------------



//===================人口出入时间段统计=======================
//var line_time =echarts.init(document.getElementById("line_time"),'shine'); 
var line_time =echarts.init(document.getElementById("line_time"),'macarons');

// 代码最后

var xData = [
    '0点',
    '1点',
    '2点',
    '3点',
    '4点',
    '5点',
    '6点',
    '7点',
    '8点',
    '9点',
    '10点',
    '11点',
    '12点',
    '13点',
    '14点',
];
option = {
    // backgroundColor: '#000',
    grid: {
        left: '5%',
        right: '10%',
        top: '20%',
        bottom: '15%',
        containLabel: true,
    },
    tooltip: {
        show: true,
        trigger: 'axis',
    },
    xAxis: [
        {
            type: 'category',
            axisLine: {
                show: false,
                lineStyle: {
                    color: '#85C1D9',
                },
            },
            axisTick: {
                show: false,
            },
            axisLabel: {
                color: '#8BC4F2',
                margin: 6,
            },
            splitLine: {
                show: false,
            },
            boundaryGap: ['5%', '5%'],
            data: xData,
        },
    ],
    yAxis: [
        {
            name:'累计票房(千万)',
            type: 'value',
            axisLabel: {
                color: '#8BC4F2',
                margin: 6,
            },
            splitLine: {
                lineStyle: {
                    color: '#355C84',
                    type: 'dashed',
                },
            },
        },
    ],
    series: [
        {
            name: '累计票房',
            type: 'line',
            stack: '总量',
            symbolSize: 6,
            itemStyle: {
                color: '#55EFF1',
                borderColor: '#55EFF1',
                borderWidth: 2,
            },
            data: [0, 5.9, 11.2, 12.5, 13.8, 14.2,15.8,19.0,22.0, 30.1, 35.9, 42.9, 46.0, 49.2, 56.1],
        },
    ],
};


// 代码最后
//var line_time =echarts.init(document.getElementById("line_time"),'infographic'); 
// var option = {
//         // 给echarts图设置背景色
//         //backgroundColor: '#FBFBFB',  // -----------> // 给echarts图设置背景色
//         color: ['#7FFF00'],
//         tooltip: {
//             trigger: 'axis'
//         },
//
// 		grid:{
//                     x:40,
//                     y:30,
//                     x2:5,
//                     y2:20
//
//                 },
//         calculable: true,
//
//
//         xAxis: [{
//              type: 'category',
//         data: ['6:00-9:00', '10:00-12:00', '13:00-15:00', '16:00-20:00', '21:00-24:00'],
//      axisLabel: {
// 			color: "#7FFF00" //刻度线标签颜色
// 			}
//         }],
//         yAxis: [{
//
//             type: 'value',
//             axisLabel: {
// 			color: "#7FFF00" //刻度线标签颜色
// 			}
//         }],
//         series: [{
//             name: '人次',
//             type: 'line',
//             data: [800, 300, 500, 800, 300, 600],
//
//         }]
//     };


line_time.setOption(option);


//=========违法犯罪人员地区分布开始=======================
//var qufenbu_data =echarts.init(document.getElementById("qufenbu_data"),'shine'); 
//var qufenbu_data =echarts.init(document.getElementById("qufenbu_data"),'macarons'); 
var qufenbu_data =echarts.init(document.getElementById("qufenbu_data"),'infographic');

// 代码 5

option = {
    // backgroundColor: '#000',
    tooltip: {
        showContent: true,
        trigger: 'axis',
        backgroundColor: 'rgba(8,36,68,.7)',
        color: '#fff',
        textStyle: {
            color: '#fff'
        },
    },
    textStyle: {
        "color": "#c0c3cd",
        "fontSize": 14
    },
    grid: {
        top: '23%',
        left: '14%',
        bottom: '25%',
        right: '10%'
    },
    xAxis: {
        nameTextStyle: {
            "color": "#c0c3cd",
            "padding": [0, 0, -10, 0],
            "fontSize": 14
        },
        axisLabel: {
            interval: 0,
            // rotate: '15',
            // formatter: function (value) {
            //   if (value.length > 3) {
            //     return `${value.slice(0, 2)}...`;
            //   }
            //   return value;
            // },
            textStyle: {
                color: '#639FD2' //坐标轴字颜色
            },
            margin: 15
        },
        axisTick: {
            show: false //隐藏X轴刻度
        },
        splitLine: {     //网格线
            "show": false
        },
        data: ["上海", "北京", "深圳", "杭州", "广州", "重庆", "成都", "长沙"],
        type: "category"
    },
    yAxis: {
        name: '总票房（千万）',
        axisLine: {
            show: false, //隐藏X轴轴线
            lineStyle: {
                color: '#11417a'
            }
        },
        axisTick: {
            show: false //隐藏X轴刻度
        },
        axisLabel: {
            textStyle: {
                color: '#fff'
            }
        },
        splitLine: {     //网格线
            "show": false
        }
    },
    series: [
        {
            name: '总票房',
            data: [2.2, 2.1, 1.75, 1.68, 1.1, 0.9, 0.8, 0.8],
            "type": "bar",
            "showBackground": true,
            // backgroundStyle: {
            //     color: "#0c3252"
            // },
            "barMaxWidth": "auto",
            // "barWidth": 7,
            "barWidth": 17,
            "itemStyle": {
                barBorderRadius: [7, 7, 0, 0], // 圆角（左上、右上、右下、左下）
                normal: {
                    //每个柱子的颜色即为colorList数组里的每一项，如果柱子数目多于colorList的长度，则柱子颜色循环使用该数组
                    color: function (params) {
                        var colorList = ['#027db4', '#03b915', '#ffe400', '#bd4fff', '#8be68e', '#dce19d','#62edf8', '#0676A7'];
                        return colorList[params.dataIndex];
                    }
                },
                "color": {
                    "x": 0,
                    "y": 0,
                    "x2": 0,
                    "y2": 1,
                    "type": "linear",
                    "global": false,
                    "colorStops": [{
                        "offset": 0,
                        "color": "#0b9eff"
                    }, {
                        "offset": 1,
                        "color": "#63caff"
                    }]
                }
            },
            "label": {
                "show": true,
                "position": "top",
                "distance": 10,
                "color": "#fff",
                "fontSize": 13
            }
        },
    ],
};


// 代码 5


// option = {
//     color: ['#FADB71'],
//     tooltip : {
//         trigger: 'axis',
//         axisPointer : {            // 坐标轴指示器，坐标轴触发有效
//             type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
//         }
//     },
//     grid: {
//         x:30,
//         y:10,
//         x2:15,
//         y2:20
//     },
//     xAxis : [
//         {
//             type : 'category',
//             data : ['河北', '天津', '北京', '新疆', '内蒙', '宁夏', '海南'],
//             axisTick: {
//                 alignWithLabel: true
//             },
//             axisLabel: {
// 			color: "#FADB71" //刻度线标签颜色
// 			}
//         }
//     ],
//     yAxis : [
//         {
//             type : 'value',
//             axisLabel: {
// 			color: "#FADB71" //刻度线标签颜色
// 			}
//         }
//     ],
//     series : [
//         {
//             name:'地区分布',
//             type:'bar',
//             barWidth: '60%',
//             data:[10, 52, 200, 334, 390, 330, 220]
//         }
//     ]
// };

qufenbu_data.setOption(option);
//=========违法犯罪人员地区分布结束=======================


//时间选择器
var startV = '';
var endV = '';
laydate.skin('danlan');
var startTime = {
    elem: '#startTime',
    format: 'YYYY-MM-DD',
    min: '1997-01-01', //设定最小日期为当前日期
    max: laydate.now(), //最大日期
    istime: true,
    istoday: true,
    fixed: false,
    choose: function (datas) {
        startV = datas;
        endTime.min = datas; //开始日选好后，重置结束日的最小日期
    }
};
var endTime = {
    elem: '#endTime',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: laydate.now(),
    istime: true,
    istoday: true,
    fixed: false,
    choose: function (datas) {
        //        startTime.max = datas; //结束日选好后，重置开始日的最大日期
        endV = datas;
    }
};

laydate(startTime);
laydate(endTime);

//时间选择器
var startVs = '';
var endVs = '';
laydate.skin('danlan');
var startTimes = {
    elem: '#startTimes',
    format: 'YYYY-MM-DD',
    min: '1997-01-01', //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: true,
    fixed: false,
    choose: function (datas) {
        startVs = datas;
        endTimes.min = datas; //开始日选好后，重置结束日的最小日期
        setQgData($('#barTypes').parent().parent(), 1);
    }
};
var endTimes = {
    elem: '#endTimes',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: laydate.now(),
    istime: true,
    istoday: true,
    fixed: false,
    choose: function (datas) {
        //        startTime.max = datas; //结束日选好后，重置开始日的最大日期
        endVs = datas;
        setQgData($('#barTypes').parent().parent(), 1);
    }
};

laydate(startTimes);
laydate(endTimes);




//更改日期插件的样式
function dateCss() {
    var arr = $('#laydate_box').attr('style').split(';');
    var cssStr =
        'position:absolute;right:0;';
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].indexOf('top') != -1) {
            cssStr += arr[i];
        }
    }

    $('#laydate_box').attr('style', cssStr);
}


var workDate;
var time = {
    elem: '#times',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: laydate.now() + 30,
    istime: true,
    istoday: true,
    fixed: false,
    choose: function (datas) {
        //        startTime.max = datas; //结束日选好后，重置开始日的最大日期
        workDate = datas;
    }
};

laydate(time);



