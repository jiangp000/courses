


// 注册地图数据
echarts.registerMap('China', data);
var myChart = echarts.init(document.getElementById('main'));
var option = {
    title: {
        text: '中国地图',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{b}<br/>{c} (p / km2)'
    },
    visualMap: {
        min: 0,
        max: 2500,
        left: 'left',
        top: 'bottom',
        text: ['高','低'],
        calculable: true,
        inRange: {
            color: ['#e0ffff', '#006edd']
        }
    },
    series: [
        {
            name: '中国',
            type: 'map',
            mapType: 'China',  // 使用中国地图
            roam: false,
            label: {
                show: true,
                color: '#fff'
            },
            data: []  // 这里是你的数据，格式如[{name: '北京', value: Math.round(Math.random()*1000)}]
        }
    ]
};
myChart.setOption(option);


