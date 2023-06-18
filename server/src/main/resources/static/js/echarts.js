$(function () {

    ceshis();
    ceshis1();
    ceshis2();
    ceshis3();
    ceshis4();
    ceshis5();

    //中间的六个表
    function ceshis() {
        function updateAirAndSoilTemp(){
            //空气和土壤温度
            $.ajax({
                type: 'POST',
                url: '/airAndSoilTemp',
                success: function (data) {
                    var myChart = echarts.init(document.getElementById('chart1-1'));
                    var colors = ['rgb(46, 199, 201)', 'rgb(90, 177, 239)'];

                    var time=[],airTempValue=[],soilTempValue=[];
                    for(var i=0;i<data.length;i++){
                        time.push(data[i].time);
                        airTempValue.push(data[i].airTempValue);
                        soilTempValue.push(data[i].soilTempValue);
                    }

                    option = {
                        color: colors,

                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'cross'
                            },
                            formatter: function(params) {
                                var html = params[0].name + "<br>";
                                for (var i = 0; i < params.length; i++) {
                                    html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>';
                                    html += params[i].seriesName + ": " + params[i].value + "°C<br>";
                                }
                                return html;
                            }
                        },
                        grid: {
                            // right: '20%'
                        },
                        toolbox: {
                            feature: {
                                dataView: {
                                    show: true,
                                    readOnly: false
                                },
                                restore: {
                                    show: true
                                },
                                saveAsImage: {
                                    show: true
                                }
                            }
                        },
                        legend: {
                            textStyle: {
                                color: '#fff'
                            },
                            data: ['空气温度', '土壤温度']
                        },
                        xAxis: [{
                            type: 'category',
                            axisTick: {
                                alignWithLabel: true
                            },
                            axisLabel: {
                                formatter: '{value} ',
                                textStyle: {
                                    color: "#ffffff" //X轴文字颜色
                                }
                            },
                            data:time
                            // data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                        }],
                        yAxis: [{
                            type: 'value',
                            name: '空气温度',
                            min: 10,
                            max: 40,
                            position: 'left',
                            axisLine: {
                                lineStyle: {
                                    color: colors[0]
                                }
                            },
                            axisLabel: {
                                formatter: '{value}°C'
                            }
                        },
                            {
                                type: 'value',
                                name: '土壤温度',
                                min: 10,
                                max: 40,
                                position: 'right',
                                axisLine: {
                                    lineStyle: {
                                        color: colors[1]
                                    }
                                },
                                axisLabel: {
                                    formatter: '{value}°C'
                                }
                            }],
                        series: [
                            {
                                name: '空气温度',
                                type: 'line',
                                yAxisIndex: 0,
                                data:airTempValue
                                // data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
                            },
                            {
                                name: '土壤温度',
                                type: 'line',
                                yAxisIndex: 1,
                                data:soilTempValue
                                // data: [70, 75, 80, 78, 82, 85, 88, 90, 85, 80, 75, 72],
                            }
                        ]
                    };


                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                },
                error:function (xhr,status,error) {
                    console.error(error);
                }
            });
        }

        var internal=5000;
        setInterval(updateAirAndSoilTemp,internal);


        //光照强度
        function updateLightIntensity(){
            $.ajax({
                type: 'POST',
                url: '/lightIntensity',
                success: function (data) {
                    var myChart = echarts.init(document.getElementById('chart1-2'));
                    var colors = ['rgb(46, 199, 201)', 'rgb(90, 177, 239)'];

                    var time=[],lightIntensity=[];
                    for(var i=0;i<data.length;i++){
                        time.push(data[i].time);
                        lightIntensity.push(data[i].lightIntensity);
                    }

                    option = {
                        color: colors,

                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'cross'
                            },
                            formatter: function(params) {
                                var html = params[0].name + "<br>";
                                for (var i = 0; i < params.length; i++) {
                                    html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>';
                                    html += params[i].seriesName + ": " + params[i].value + "°C<br>";
                                }
                                return html;
                            }
                        },
                        grid: {
                            left: '15%'
                        },
                        toolbox: {
                            feature: {
                                dataView: {
                                    show: true,
                                    readOnly: false
                                },
                                restore: {
                                    show: true
                                },
                                saveAsImage: {
                                    show: true
                                }
                            }
                        },
                        legend: {
                            textStyle: {
                                color: '#fff'
                            },
                            data: ['光照强度']
                        },
                        xAxis: [{
                            type: 'category',
                            axisTick: {
                                alignWithLabel: true
                            },
                            axisLabel: {
                                formatter: '{value} ',
                                textStyle: {
                                    color: "#ffffff" //X轴文字颜色
                                }
                            },
                            data:time
                            // data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                        }],
                        yAxis: [{
                            type: 'value',
                            name: '光照强度',
                            min: 30,
                            max: 90,
                            position: 'left',
                            axisLine: {
                                lineStyle: {
                                    color: colors[0]
                                }
                            },
                            axisLabel: {
                                formatter: '{value}'
                            }
                        }],
                        series: [
                            {
                                name: '光照强度',
                                type: 'line',
                                yAxisIndex: 0,
                                data:lightIntensity
                                // data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
                            }
                        ]
                    };


                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                },
                error:function (xhr,status,error) {
                    console.error(error);
                }
            });
        }
        setInterval(updateLightIntensity,internal);


        //土壤PH值
        function updateSoilPH(){
            $.ajax({
                type: 'POST',
                url: '/soilPH',
                success: function (data) {
                    var myChart = echarts.init(document.getElementById('chart1-3'));
                    var colors = ['rgb(46, 199, 201)', 'rgb(90, 177, 239)'];

                    var time=[],soilPH=[];
                    for(var i=0;i<data.length;i++){
                        time.push(data[i].time);
                        soilPH.push(data[i].soilPH);
                    }

                    option = {
                        color: colors,

                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'cross'
                            },
                            formatter: function(params) {
                                var html = params[0].name + "<br>";
                                for (var i = 0; i < params.length; i++) {
                                    html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>';
                                    html += params[i].seriesName + ": " + params[i].value + "°C<br>";
                                }
                                return html;
                            }
                        },
                        grid: {
                            right: '20%'
                        },
                        toolbox: {
                            feature: {
                                dataView: {
                                    show: true,
                                    readOnly: false
                                },
                                restore: {
                                    show: true
                                },
                                saveAsImage: {
                                    show: true
                                }
                            }
                        },
                        legend: {
                            textStyle: {
                                color: '#fff'
                            },
                            data: ['土壤PH值']
                        },
                        xAxis: [{
                            type: 'category',
                            axisTick: {
                                alignWithLabel: true
                            },
                            axisLabel: {
                                formatter: '{value} ',
                                textStyle: {
                                    color: "#ffffff" //X轴文字颜色
                                }
                            },
                            data:time
                            // data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                        }],
                        yAxis: [{
                            type: 'value',
                            name: '土壤PH值',
                            min: 4.0,
                            max: 7.0,
                            position: 'left',
                            axisLine: {
                                lineStyle: {
                                    color: colors[0]
                                }
                            },
                            axisLabel: {
                                formatter: '{value}'
                            }
                        }],
                        series: [
                            {
                                name: '土壤PH值',
                                type: 'line',
                                yAxisIndex: 0,
                                data:soilPH
                                // data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
                            }
                        ]
                    };


                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                },
                error:function (xhr,status,error) {
                    console.error(error);
                }
            });
        }
        setInterval(updateSoilPH,internal);


        //空气和土壤湿度
        function updateAirAndSoilHumidity(){
            $.ajax({
                type: 'POST',
                url: '/airAndSoilHumidity',
                success: function (data) {
                    var myChart = echarts.init(document.getElementById('chart1-4'));
                    var colors = ['rgb(46, 199, 201)', 'rgb(90, 177, 239)'];

                    var time=[],airHumidityValue=[],soilHumidityValue=[];
                    for(var i=0;i<data.length;i++){
                        time.push(data[i].time);
                        airHumidityValue.push(data[i].airHumidityValue);
                        soilHumidityValue.push(data[i].soilHumidityValue);
                    }

                    option = {
                        color: colors,

                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'cross'
                            },
                            formatter: function(params) {
                                var html = params[0].name + "<br>";
                                for (var i = 0; i < params.length; i++) {
                                    html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>';
                                    html += params[i].seriesName + ": " + params[i].value + "°C<br>";
                                }
                                return html;
                            }
                        },
                        grid: {
                            // right: '20%'
                            // left: '15%'
                        },
                        toolbox: {
                            feature: {
                                dataView: {
                                    show: true,
                                    readOnly: false
                                },
                                restore: {
                                    show: true
                                },
                                saveAsImage: {
                                    show: true
                                }
                            }
                        },
                        legend: {
                            textStyle: {
                                color: '#fff'
                            },
                            data: ['空气湿度', '土壤湿度']
                        },
                        xAxis: [{
                            type: 'category',
                            axisTick: {
                                alignWithLabel: true
                            },
                            axisLabel: {
                                formatter: '{value} ',
                                textStyle: {
                                    color: "#ffffff" //X轴文字颜色
                                }
                            },
                            data:time
                            // data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                        }],
                        yAxis: [{
                            type: 'value',
                            name: '空气湿度',
                            min: 40,
                            max: 90,
                            position: 'left',
                            axisLine: {
                                lineStyle: {
                                    color: colors[0]
                                }
                            },
                            axisLabel: {
                                formatter: '{value}%'
                            }
                        },
                            {
                                type: 'value',
                                name: '土壤湿度',
                                min: 40,
                                max: 90,
                                position: 'right',
                                axisLine: {
                                    lineStyle: {
                                        color: colors[1]
                                    }
                                },
                                axisLabel: {
                                    formatter: '{value}%'
                                }
                            }],
                        series: [
                            {
                                name: '空气湿度',
                                type: 'line',
                                yAxisIndex: 0,
                                data:airHumidityValue
                                // data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
                            },
                            {
                                name: '土壤湿度',
                                type: 'line',
                                yAxisIndex: 1,
                                data:soilHumidityValue
                                // data: [70, 75, 80, 78, 82, 85, 88, 90, 85, 80, 75, 72],
                            }
                        ]
                    };


                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                },
                error:function (xhr,status,error) {
                    console.error(error);
                }
            });
        }
        setInterval(updateAirAndSoilHumidity,internal);

        //二氧化碳浓度
        function updateAirCo2(){
            $.ajax({
                type: 'POST',
                url: '/airCo2',
                success: function (data) {
                    var myChart = echarts.init(document.getElementById('chart1-5'));
                    var colors = ['rgb(46, 199, 201)', 'rgb(90, 177, 239)'];

                    var time=[],airCo2=[];
                    for(var i=0;i<data.length;i++){
                        time.push(data[i].time);
                        airCo2.push(data[i].airCo2);
                    }

                    option = {
                        color: colors,

                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'cross'
                            },
                            formatter: function(params) {
                                var html = params[0].name + "<br>";
                                for (var i = 0; i < params.length; i++) {
                                    html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>';
                                    html += params[i].seriesName + ": " + params[i].value + "°C<br>";
                                }
                                return html;
                            }
                        },
                        grid: {
                            left: '15%'
                        },
                        toolbox: {
                            feature: {
                                dataView: {
                                    show: true,
                                    readOnly: false
                                },
                                restore: {
                                    show: true
                                },
                                saveAsImage: {
                                    show: true
                                }
                            }
                        },
                        legend: {
                            textStyle: {
                                color: '#fff'
                            },
                            data: ['二氧化碳浓度']
                        },
                        xAxis: [{
                            type: 'category',
                            axisTick: {
                                alignWithLabel: true
                            },
                            axisLabel: {
                                formatter: '{value} ',
                                textStyle: {
                                    color: "#ffffff" //X轴文字颜色
                                }
                            },
                            data:time
                            // data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                        }],
                        yAxis: [{
                            type: 'value',
                            name: '二氧化碳浓度',
                            min: 500,
                            max: 1000,
                            position: 'left',
                            axisLine: {
                                lineStyle: {
                                    color: colors[0]
                                }
                            },
                            axisLabel: {
                                formatter: '{value}'
                            }
                        }],
                        series: [
                            {
                                name: '二氧化碳浓度',
                                type: 'line',
                                yAxisIndex: 0,
                                data:airCo2
                                // data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
                            }
                        ]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                },
                error:function (xhr,status,error) {
                    console.error(error);
                }
            });
        }
        setInterval(updateAirCo2,internal);


        //土壤FC值
        function updateSoilFC(){
            $.ajax({
                type: 'POST',
                url: '/soilFC',
                success: function (data) {
                    var myChart = echarts.init(document.getElementById('chart1-6'));
                    var colors = ['rgb(46, 199, 201)', 'rgb(90, 177, 239)'];

                    var time=[],soilFC=[];
                    for(var i=0;i<data.length;i++){
                        time.push(data[i].time);
                        soilFC.push(data[i].soilFC);
                    }

                    option = {
                        color: colors,

                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'cross'
                            },
                            formatter: function(params) {
                                var html = params[0].name + "<br>";
                                for (var i = 0; i < params.length; i++) {
                                    html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>';
                                    html += params[i].seriesName + ": " + params[i].value + "°C<br>";
                                }
                                return html;
                            }
                        },
                        grid: {
                            // right: '20%'
                            left: '10%',
                            right: '10%',
                        },
                        toolbox: {
                            feature: {
                                dataView: {
                                    show: true,
                                    readOnly: false
                                },
                                restore: {
                                    show: true
                                },
                                saveAsImage: {
                                    show: true
                                }
                            }
                        },
                        legend: {
                            textStyle: {
                                color: '#fff'
                            },
                            data: ['土壤FC值']
                        },
                        xAxis: [{
                            type: 'category',
                            axisTick: {
                                alignWithLabel: true
                            },
                            axisLabel: {
                                formatter: '{value} ',
                                textStyle: {
                                    color: "#ffffff" //X轴文字颜色
                                }
                            },
                            data:time
                            // data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                        }],
                        yAxis: [{
                            type: 'value',
                            name: '土壤FC值',
                            min: 40,
                            max: 80,
                            position: 'left',
                            axisLine: {
                                lineStyle: {
                                    color: colors[0]
                                }
                            },
                            axisLabel: {
                                formatter: '{value}'
                            }
                        }],
                        series: [
                            {
                                name: '土壤FC值',
                                type: 'line',
                                yAxisIndex: 0,
                                data:soilFC
                                // data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
                            }
                        ]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                },
                error:function (xhr,status,error) {
                    console.error(error);
                }
            });
        }
        setInterval(updateSoilFC,internal);

    }

    //左下，作物产量占比图
    function ceshis1() {
        $.ajax({
            type:'POST',
            url:'/plantYield',
            success:function (data) {
                var myChart = echarts.init(document.getElementById('chart3'));

                var ydata=[];
                var xdata=[];
                for(var i=0;i<data.length;i++){
                    ydata.push({
                        name:data[i].name,
                        value:data[i].value
                    });
                    xdata.push(data[i].name);
                }

                var color = ["#8d7fec", "#5085f2", "#e75fc3", "#f87be2", "#f2719a", "#fca4bb", "#f59a8f", "#fdb301", "#57e7ec", "#cf9ef1"]

                var option = {
                    /*backgroundColor: "rgba(255,255,255,1)",*/
                    color: color,
                    legend: {
                        orient: "vartical",
                        x: "left",
                        top: "center",
                        left: "73%",
                        bottom: "0%",
                        data: xdata,
                        itemWidth: 12,
                        itemHeight: 12,
                        textStyle: {
                            color: '#fff',
                            fontSize:18
                        },
                        /*itemGap: 16,*/
                        /*formatter:function(name){
                          var oa = option.series[0].data;
                          var num = oa[0].value + oa[1].value + oa[2].value + oa[3].value+oa[4].value + oa[5].value + oa[6].value + oa[7].value+oa[8].value + oa[9].value ;
                          for(var i = 0; i < option.series[0].data.length; i++){
                              if(name==oa[i].name){
                                  return ' '+name + '    |    ' + oa[i].value + '    |    ' + (oa[i].value/num * 100).toFixed(2) + '%';
                              }
                          }
                        }*/

                        formatter: function(name) {
                            return '' + name
                        }
                    },
                    series: [{
                        type: 'pie',
                        clockwise: false, //饼图的扇区是否是顺时针排布
                        minAngle: 2, //最小的扇区角度（0 ~ 360）
                        radius: ["30%", "80%"],
                        center: ["40%", "50%"],
                        avoidLabelOverlap: false,
                        itemStyle: { //图形样式
                            normal: {
                                borderColor: '#ffffff',
                                borderWidth: 1,
                            },
                        },
                        label: {
                            normal: {
                                show: false,
                                position: 'center',
                                formatter: '{text|{b}}\n{c} ({d}%)',
                                rich: {
                                    text: {
                                        color: "#fff",
                                        fontSize: 18,
                                        align: 'center',
                                        verticalAlign: 'middle',
                                        padding: 8
                                    },
                                    value: {
                                        color: "#8693F3",
                                        fontSize: 24,
                                        align: 'center',
                                        verticalAlign: 'middle',
                                    },
                                }
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: 24,
                                }
                            }
                        },
                        data: ydata
                    }]
                };
                myChart.setOption(option);

                setTimeout(function() {
                    myChart.on('mouseover', function(params) {
                        if (params.name == ydata[0].name) {
                            myChart.dispatchAction({
                                type: 'highlight',
                                seriesIndex: 0,
                                dataIndex: 0
                            });
                        } else {
                            myChart.dispatchAction({
                                type: 'downplay',
                                seriesIndex: 0,
                                dataIndex: 0
                            });
                        }
                    });

                    myChart.on('mouseout', function(params) {
                        myChart.dispatchAction({
                            type: 'highlight',
                            seriesIndex: 0,
                            dataIndex: 0
                        });
                    });
                    myChart.dispatchAction({
                        type: 'highlight',
                        seriesIndex: 0,
                        dataIndex: 0
                    });
                }, 1000);

                // 使用刚指定的配置项和数据显示图表。
                /*myChart.setOption(option);*/
                window.addEventListener("resize",function(){
                    myChart.resize();
                });
            },
            error:function (xhr,status,error) {
                console.error(error);
            }
        });
    }


    //右中 雷达图，作物土壤各营养物质含量
    function ceshis2() {
        $.ajax({
            type: 'POST',
            url: '/plantSoil',
            success: function (data) {
                var myChart = echarts.init(document.getElementById('chart2'));

                var indicator=[];
                var danValue=[],linValue=[],jiaValue=[];
                for(var i=0;i<data.length;i++){
                    indicator.push({
                        text:data[i].name,
                        max:1.8
                    });
                    danValue.push(data[i].danValue);
                    linValue.push(data[i].linValue);
                    jiaValue.push(data[i].jiaValue);
                }
                option = {
                    color: ['#67F9D8', '#FFE434', '#56A3F1', '#FF917C'],
                    title: {
                        // text: 'Customized Radar Chart'
                    },
                    legend: {
                        top: '30px',
                        textStyle: {
                            color: '#fff',
                            fontSize:20
                        }
                    },

                    radar: [
                        {
                            indicator:
                            indicator
                            ,
                            center: ['50%', '50%'],
                            radius: 160,
                            axisName: {
                                color: '#fff',
                                textStyle:{
                                    fontSize: 20
                                },
                                backgroundColor: '#95a3c8',
                                borderRadius: 6,
                                padding: [3, 5]
                            }
                        }
                    ],
                    series: [
                        {
                            type: 'radar',
                            radarIndex: 0,
                            data: [
                                {
                                    value: danValue,
                                    name: '氮',
                                    color:'#95a3c8',
                                    symbol: 'rect',
                                    symbolSize: 12,
                                    lineStyle: {
                                        type: 'dashed',
                                        width:3
                                    },
                                    label: {
                                        show: true,
                                        formatter: function (params) {
                                            return params.value;
                                        },
                                        textStyle:{
                                            fontSize:20
                                        }
                                    }
                                },
                                {
                                    value: linValue,
                                    name: '磷',
                                    lineStyle: {
                                        width:3
                                    },
                                    areaStyle: {
                                        color: new echarts.graphic.RadialGradient(0.1, 0.6, 1, [
                                            {
                                                color: 'rgba(255, 145, 124, 0.1)',
                                                offset: 0
                                            },
                                            {
                                                color: 'rgba(255, 145, 124, 0.9)',
                                                offset: 1
                                            }
                                        ])
                                    }
                                },
                                {
                                    value: jiaValue,
                                    name: '钾',
                                    lineStyle: {
                                        width:3
                                    },
                                    areaStyle: {
                                        color: new echarts.graphic.RadialGradient(0.1, 0.6, 1, [
                                            {
                                                color: 'rgba(255, 145, 124, 0.1)',
                                                offset: 0
                                            },
                                            {
                                                color: 'rgba(255, 145, 124, 0.9)',
                                                offset: 1
                                            }
                                        ])
                                    }
                                }
                            ]
                        }
                    ]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
                window.addEventListener("resize",function(){
                    myChart.resize();
                });
            },
            error:function (xhr,status,error) {
                console.error(error);
            }
        });
    }


    //中下 实时参数
    function ceshis3() {
        function updateParameters(){
            $.ajax({
                type: 'POST',
                url: '/parameters',
                success: function (data) {
                    // console.log(data);
                    // 在成功接收到响应后，处理返回的数据
                    var parameterValuesContainer = document.getElementById("parameter-values");
                    parameterValuesContainer.innerHTML = "";
                    for (var i = 0; i < data.length; i++) {
                        var parameterValue = document.createElement("div");
                        parameterValue.className = "parameter-value";
                        parameterValue.textContent = data[i];
                        parameterValuesContainer.appendChild(parameterValue);
                    }
                },
                error:function (xhr,status,error) {
                    console.error(error);
                }

            })
        }
        var internal=5000;
        setInterval(updateParameters,internal);

        // var myChart = echarts.init(document.getElementById('chart4'));
        //
        // var colors = ['rgb(46, 199, 201)', 'rgb(90, 177, 239)', 'rgb(255, 185, 128)'];
        //
        // option = {
        //     color: colors,
        //
        //     tooltip: {
        //         trigger: 'axis',
        //         axisPointer: {
        //             type: 'cross'
        //         },
        //         formatter: function(params) {
        //             // 系列
        //             var html = params[0].name + "<br>";
        //
        //             for (var i = 0; i < params.length; i++) {
        //
        //                 // 获取每个系列对应的颜色值
        //                 html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>';
        //
        //                 // 通过判断指定系列增加 % 符号
        //                 if (option.series[params[i].seriesIndex].type == "line") {
        //                     html += params[i].seriesName + ": " + params[i].value + "%<br>";
        //                 } else {
        //                     html += params[i].seriesName + ": " + params[i].value + "<br>";
        //                 }
        //             }
        //             return html;
        //         }
        //     },
        //     grid: {
        //         right: '20%'
        //     },
        //     toolbox: {
        //         feature: {
        //             dataView: {
        //                 show: true,
        //                 readOnly: false
        //             },
        //             restore: {
        //                 show: true
        //             },
        //             saveAsImage: {
        //                 show: true
        //             }
        //         }
        //     },
        //     legend: {
        //         textStyle: {
        //             color: '#fff'
        //         },
        //         data: ['蒸发量', '降水量', '平均温度']
        //     },
        //     // 缩放组件
        //     /*dataZoom: {
        //         type: 'slider'
        //     },*/
        //     xAxis: [{
        //         type: 'category',
        //         axisTick: {
        //             alignWithLabel: true
        //         },
        //         axisLabel: {
        //             formatter: '{value} ',
        //             textStyle: {
        //                 color: "#ffffff" //X轴文字颜色
        //             }
        //         },
        //         data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
        //     }],
        //     yAxis: [{
        //         type: 'value',
        //         name: '蒸发量',
        //         min: 0,
        //         max: 250,
        //         position: 'right',
        //         axisLine: {
        //             lineStyle: {
        //                 color: colors[0]
        //             }
        //         },
        //         axisLabel: {
        //             formatter: '{value} ml'
        //         }
        //     },
        //         {
        //             type: 'value',
        //             name: '降水量',
        //             min: 0,
        //             max: 250,
        //             position: 'right',
        //             offset: 80,
        //             axisLine: {
        //                 lineStyle: {
        //                     color: colors[1]
        //                 }
        //             },
        //             axisLabel: {
        //                 formatter: '{value} ml'
        //             }
        //         },
        //         {
        //             type: 'value',
        //             name: '温度',
        //             min: 0,
        //             max: 25,
        //             position: 'left',
        //             axisLine: {
        //                 lineStyle: {
        //                     color: colors[2]
        //                 }
        //             },
        //             axisLabel: {
        //                 formatter: '{value} °C'
        //             }
        //         }
        //     ],
        //     series: [{
        //         name: '蒸发量',
        //         type: 'bar',
        //         data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
        //         itemStyle: {
        //             normal: {
        //                 barBorderRadius: 2
        //             }
        //         }
        //     },
        //         {
        //             barGap: '-50%', // 增加偏移量使重叠显示
        //             name: '降水量',
        //             type: 'bar',
        //             yAxisIndex: 1,
        //             data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
        //             itemStyle: {
        //                 normal: {
        //                     barBorderRadius: 2
        //                 }
        //             }
        //         },
        //         {
        //             name: '平均温度',
        //             type: 'line',
        //             yAxisIndex: 2,
        //             data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
        //         }
        //     ]
        // };
        // // 使用刚指定的配置项和数据显示图表。
        // myChart.setOption(option);
        // window.addEventListener("resize",function(){
        //     myChart.resize();
        // });
    }

    //右下，警报信息
    function ceshis4() {
        function updateWarnMessages(){
            $.ajax({
                type: 'POST',
                url: '/warnMessages',
                success: function (data) {
                    // 在成功接收到响应后，处理返回的数据
                    var messages= document.getElementById("warn-messages");
                    messages.innerHTML = "";
                    for (var i = 0; i < data.length; i++) {
                        var parameterValue = document.createElement("div");
                        parameterValue.className = "message";
                        parameterValue.textContent = data[i];
                        messages.appendChild(parameterValue);
                    }
                },
                error:function (xhr,status,error) {
                    console.error(error);
                }
            })
        }
        var internal=5000;
        setInterval(updateWarnMessages,internal);
    }

    function ceshis5() {
        $.ajax({
            type: 'POST',
            url: '/speciesAreaYield',
            success: function (data) {
                var myChart = echarts.init(document.getElementById('species-areaYield'));

                var nameData = [];
                var areaData = [];
                var yieldData = [];
                for (var i = 0; i < data.length; i++) {
                    nameData.push(data[i].name);
                    areaData.push(data[i].area);
                    yieldData.push(data[i].yield);
                }
                option = {
                    /*backgroundColor: '#05163B',*/
                    tooltip: {
                        trigger: 'axis'
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {
                                show: true
                            },
                            dataView: {
                                show: true,
                                readOnly: false
                            },
                            magicType: {
                                show: true,
                                type: ['line', 'bar']
                            },
                            restore: {
                                show: true
                            },
                            saveAsImage: {
                                show: true
                            }
                        }
                    },
                    grid: {
                        top: 'middle',
                        left: '3%',
                        right: '4%',
                        bottom: '12%',
                        top: '19%',
                        containLabel: true
                    },
                    legend: {
                        data: ['面积', '产量'],
                        textStyle: {
                            color: "#fff"
                        }

                    },
                    xAxis: [{
                        type: 'category',
                        // data: ['挖土方(m³)', '挖石方(m³)', '填方(m³)', '涵洞通道(道)', '桩基(根)', '承台(个)', '墩柱（含肋板）(根)', '台帽盖梁(个)', '梁板预制(片)', '梁板安装(片)', '桥面铺装(㎡)', '防撞护栏(m)',
                        //     '明洞(米)', '主动掘进(米)', '初期支护(米)', '二次衬砌(米)', '水稳底基层(米)', '水稳基层(第一层)(米)', '水稳基层(第二层)(米)', '上基层(米)', '沥青下面层(米)', '沥青上面层(米)',
                        // ],
                        data: nameData,
                        axisLabel: {
                            show: true,
                            textStyle: {
                                color: "#ebf8ac" //X轴文字颜色
                            }
                        },
                        axisLine: {
                            lineStyle: {
                                color: '#01FCE3'
                            }
                        },
                    }],
                    yAxis: [{
                        type: 'value',
                        name: '面积',
                        axisLabel: {
                            formatter: '{value} 亩',
                            textStyle: {
                                color: "#2EC7C9" //X轴文字颜色
                            }
                        },
                        axisLine: {
                            lineStyle: {
                                color: '#01FCE3'
                            }
                        },
                    },
                        {
                            type: 'value',
                            name: '产量',
                            axisLabel: {
                                formatter: '{value} 公斤',
                                textStyle: {
                                    color: "#2EC7C9" //X轴文字颜色
                                }
                            }, axisLine: {
                                lineStyle: {
                                    color: '#01FCE3'
                                }
                            },
                        }
                    ],
                    series: [
                        {
                            name: '面积',
                            type: 'bar',
                            itemStyle: {
                                normal: {
                                    barBorderRadius: 5,
                                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                        offset: 0,
                                        color: "#00FFE3"
                                    },
                                        {
                                            offset: 1,
                                            color: "#4693EC"
                                        }
                                    ])
                                }
                            },
                            /*data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]*/
                            // data: [26.4, 28.7, 70.7, 75.6, 82.2, 48.7, 58.8, 16.0, 32.3, 30.3, 21.3, 66.3, 41.3, 15.3, 30.3, 22.3, 12.3, 82.3, 72.3, 62.3, 52.3, 42.3, 36.6],
                            data: areaData,
                        },
                        {
                            name: '产量',
                            type: 'bar',
                            itemStyle: {
                                normal: {
                                    barBorderRadius: 5,
                                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                        offset: 0,
                                        color: "#C1B2EA"
                                    },
                                        {
                                            offset: 1,
                                            color: "#8362C6"
                                        }
                                    ])
                                }
                            },
                            // data: [26.4, 28.7, 70.7, 75.6, 82.2, 48.7, 58.8, 16.0, 32.3, 30.3, 21.3, 66.3, 41.3, 15.3, 30.3, 22.3, 12.3, 82.3, 72.3, 62.3, 52.3, 42.3, 36.6],
                            data: yieldData,
                            yAxisIndex: 1,
                        },
                        //         {
                        //             name: '累计',
                        //             type: 'line',
                        //             yAxisIndex: 1,
                        //             data: [26.4, 28.7, 70.7, 75.6, 82.2, 48.7, 58.8, 16.0, 32.3, 30.3, 21.3, 66.3, 41.3, 15.3, 30.3, 22.3, 12.3, 82.3, 72.3, 62.3, 52.3, 42.3, 36.6],
                        //             // data: yieldData,
                        //             lineStyle: {
                        //                 normal: {
                        //                     width: 5,
                        //                     color: {
                        //                         type: 'linear',
                        //
                        //                         colorStops: [{
                        //                             offset: 0,
                        //                             color: '#AAF487' // 0% 处的颜色
                        //                         },
                        //                             {
                        //                                 offset: 0.4,
                        //                                 color: '#47D8BE' // 100% 处的颜色
                        //                             }, {
                        //                                 offset: 1,
                        //                                 color: '#47D8BE' // 100% 处的颜色
                        //                             }
                        //                         ],
                        //                         globalCoord: false // 缺省为 false
                        //                     },
                        //                     shadowColor: 'rgba(71,216,190, 0.5)',
                        //                     shadowBlur: 10,
                        //                     shadowOffsetY: 7
                        //                 }
                        //             },
                        //             itemStyle: {
                        //                 normal: {
                        //                     color: '#AAF487',
                        //                     borderWidth: 10,
                        //                     /*shadowColor: 'rgba(72,216,191, 0.3)',
                        //                      shadowBlur: 100,*/
                        //                     borderColor: "#AAF487"
                        //                 }
                        //             },
                        //             smooth: true,
                        //         },
                        //         {
                        //             name: '累计2',
                        //             type: 'line',
                        //             yAxisIndex: 1,
                        //             data: [26.4, 28.7, 70.7, 75.6, 82.2, 48.7, 58.8, 16.0, 32.3, 30.3, 21.3, 66.3, 41.3, 15.3, 30.3, 22.3, 12.3, 82.3, 72.3, 62.3, 52.3, 42.3, 36.6],
                        //             lineStyle: {
                        //                 normal: {
                        //                     width: 5,
                        //                     color: {
                        //                         type: 'linear',
                        //
                        //                         colorStops: [{
                        //                             offset: 0,
                        //                             color: '#F8B854' // 0% 处的颜色
                        //                         },
                        //                             {
                        //                                 offset: 0.4,
                        //                                 color: '#DE801C' // 100% 处的颜色
                        //                             }, {
                        //                                 offset: 1,
                        //                                 color: '#DE801C' // 100% 处的颜色
                        //                             }
                        //                         ],
                        //                         globalCoord: false // 缺省为 false
                        //                     },
                        //                     shadowColor: 'rgba(71,216,190, 0.5)',
                        //                     shadowBlur: 10,
                        //                     shadowOffsetY: 7
                        //                 }
                        //             },
                        //             itemStyle: {
                        //                 normal: {
                        //                     color: '#F7AD3E',
                        //                     borderWidth: 10,
                        //                     /*shadowColor: 'rgba(72,216,191, 0.3)',
                        //                      shadowBlur: 100,*/
                        //                     borderColor: "#F7AD3E"
                        //                 }
                        //             },
                        //             smooth: true,
                        //         }
                    ]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
                window.addEventListener("resize", function () {
                    myChart.resize();
                });
            }
        })
    }

});