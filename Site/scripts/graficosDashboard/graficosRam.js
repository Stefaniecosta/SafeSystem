
function chamarGraf1() {
    
   
    chartRAM1.style.display = 'block';
    chartRAM2.style.display = 'none';
    chartRAM3.style.display = 'none';
    chartRAM4.style.display = 'none';
    chartRAM5.style.display = 'none';
    chartRAM6.style.display = 'none';


    chartdivDisco1.style.display = 'block';
    chartdivDisco2.style.display = 'none';
    chartdivDisco3.style.display = 'none';
    chartdivDisco4.style.display = 'none';
    chartdivDisco5.style.display = 'none';
    chartdivDisco6.style.display = 'none';


    }


    function chamarGraf2() {
        
        chartRAM1.style.display = 'none';
        chartRAM2.style.display = 'block';
        chartRAM3.style.display = 'none';
        chartRAM4.style.display = 'none';
        chartRAM5.style.display = 'none';
        chartRAM6.style.display = 'none';


             
    chartdivDisco1.style.display = 'none';
    chartdivDisco2.style.display = 'block';
    chartdivDisco3.style.display = 'none';
    chartdivDisco4.style.display = 'none';
    chartdivDisco5.style.display = 'none';
    chartdivDisco6.style.display = 'none';



    }

    function chamarGraf3() {

        chartRAM1.style.display = 'none';
        chartRAM2.style.display = 'none';
        chartRAM3.style.display = 'block';
        chartRAM4.style.display = 'none';
        chartRAM5.style.display = 'none';
        chartRAM6.style.display = 'none';


             
    chartdivDisco1.style.display = 'none';
    chartdivDisco2.style.display = 'none';
    chartdivDisco3.style.display = 'block';
    chartdivDisco4.style.display = 'none';
    chartdivDisco5.style.display = 'none';
    chartdivDisco6.style.display = 'none';


    }


    function chamarGraf4() {

        chartRAM1.style.display = 'none';
        chartRAM2.style.display = 'none';
        chartRAM3.style.display = 'none';
        chartRAM4.style.display = 'block';
        chartRAM5.style.display = 'none';
        chartRAM6.style.display = 'none';

              
    chartdivDisco1.style.display = 'none';
    chartdivDisco2.style.display = 'none';
    chartdivDisco3.style.display = 'none';
    chartdivDisco4.style.display = 'block';
    chartdivDisco5.style.display = 'none';
    chartdivDisco6.style.display = 'none';



    }

    function chamarGraf5() {

        chartRAM1.style.display = 'none';
        chartRAM2.style.display = 'none';
        chartRAM3.style.display = 'none';
        chartRAM4.style.display = 'none';
        chartRAM5.style.display = 'block';
        chartRAM6.style.display = 'none';

             
    chartdivDisco1.style.display = 'none';
    chartdivDisco2.style.display = 'none';
    chartdivDisco3.style.display = 'none';
    chartdivDisco4.style.display = 'none';
    chartdivDisco5.style.display = 'block';
    chartdivDisco6.style.display = 'none';


    }

    function chamarGraf6() {

        chartRAM1.style.display = 'none';
        chartRAM2.style.display = 'none';
        chartRAM3.style.display = 'none';
        chartRAM4.style.display = 'none';
        chartRAM5.style.display = 'none';
        chartRAM6.style.display = 'block';


             
    chartdivDisco1.style.display = 'none';
    chartdivDisco2.style.display = 'none';
    chartdivDisco3.style.display = 'none';
    chartdivDisco4.style.display = 'none';
    chartdivDisco5.style.display = 'none';
    chartdivDisco6.style.display = 'block';



    }





//----------------- grafico ram 1 --------------//


    am4core.ready(function() {

        // Themes begin
        am4core.useTheme(am4themes_dark);
        am4core.useTheme(am4themes_animated);
        // Themes end

        // Create chart instance
        var chart = am4core.create("chartRAM1", am4charts.PieChart);

        // Set data
        var selected;
        var types = [{
            type: "Quantidade livre",
            percent: 70,
            color: chart.colors.getIndex(0),
            // subs: [{
            //     type: "Oil",
            //     percent: 15
            // }, {
            //     type: "Coal",
            //     percent: 35
            // }, {
            //     type: "Nuclear",
            //     percent: 20
            // }]
        }, {
            type: "Utilizado",
            percent: 30,
            color: chart.colors.getIndex(1),
            // subs: [{
            //     type: "Hydro",
            //     percent: 15
            // }, {
            //     type: "Wind",
            //     percent: 10
            // }, {
            //     type: "Other",
            //     percent: 5
            // }]
        }];

        // Add data
        chart.data = generateChartData();

        // Add and configure Series
        var pieSeries = chart.series.push(new am4charts.PieSeries());
        pieSeries.dataFields.value = "percent";
        pieSeries.dataFields.category = "type";
        pieSeries.slices.template.propertyFields.fill = "color";
        pieSeries.slices.template.propertyFields.isActive = "pulled";
        pieSeries.slices.template.strokeWidth = 0;

        function generateChartData() {
            var chartData = [];
            for (var i = 0; i < types.length; i++) {
                if (i == selected) {
                    for (var x = 0; x < types[i].subs.length; x++) {
                        chartData.push({
                            type: types[i].subs[x].type,
                            percent: types[i].subs[x].percent,
                            color: types[i].color,
                            pulled: true
                        });
                    }
                } else {
                    chartData.push({
                        type: types[i].type,
                        percent: types[i].percent,
                        color: types[i].color,
                        id: i
                    });
                }
            }
            return chartData;
        }

        pieSeries.slices.template.events.on("hit", function(event) {
            if (event.target.dataItem.dataContext.id != undefined) {
                selected = event.target.dataItem.dataContext.id;
            } else {
                selected = undefined;
            }
            chart.data = generateChartData();
        });

    }); // end am4core.ready()




//----------------- grafico ram 2 --------------//


    am4core.ready(function() {

        // Themes begin
        am4core.useTheme(am4themes_dark);
        am4core.useTheme(am4themes_animated);
        // Themes end

        // Create chart instance
        var chart = am4core.create("chartRAM2", am4charts.PieChart);

        // Set data
        var selected;
        var types = [{
            type: "Utilizado",
            percent: 90,
            color: chart.colors.getIndex(0),
            // subs: [{
            //     type: "Oil",
            //     percent: 15
            // }, {
            //     type: "Coal",
            //     percent: 35
            // }, {
            //     type: "Nuclear",
            //     percent: 20
            // }]
        }, {
            type: "Quantidade livre",
            percent: 10,
            color: chart.colors.getIndex(1),
            // subs: [{
            //     type: "Hydro",
            //     percent: 15
            // }, {
            //     type: "Wind",
            //     percent: 10
            // }, {
            //     type: "Other",
            //     percent: 5
            // }]
        }];

        // Add data
        chart.data = generateChartData();

        // Add and configure Series
        var pieSeries = chart.series.push(new am4charts.PieSeries());
        pieSeries.dataFields.value = "percent";
        pieSeries.dataFields.category = "type";
        pieSeries.slices.template.propertyFields.fill = "color";
        pieSeries.slices.template.propertyFields.isActive = "pulled";
        pieSeries.slices.template.strokeWidth = 0;

        function generateChartData() {
            var chartData = [];
            for (var i = 0; i < types.length; i++) {
                if (i == selected) {
                    for (var x = 0; x < types[i].subs.length; x++) {
                        chartData.push({
                            type: types[i].subs[x].type,
                            percent: types[i].subs[x].percent,
                            color: types[i].color,
                            pulled: true
                        });
                    }
                } else {
                    chartData.push({
                        type: types[i].type,
                        percent: types[i].percent,
                        color: types[i].color,
                        id: i
                    });
                }
            }
            return chartData;
        }

        pieSeries.slices.template.events.on("hit", function(event) {
            if (event.target.dataItem.dataContext.id != undefined) {
                selected = event.target.dataItem.dataContext.id;
            } else {
                selected = undefined;
            }
            chart.data = generateChartData();
        });

    }); // end am4core.ready()



//----------------- grafico ram 3 --------------//


am4core.ready(function() {

    // Themes begin
    am4core.useTheme(am4themes_dark);
    am4core.useTheme(am4themes_animated);
    // Themes end

    // Create chart instance
    var chart = am4core.create("chartRAM3", am4charts.PieChart);

    // Set data
    var selected;
    var types = [{
        type: "Utilizado",
        percent: 20,
        color: chart.colors.getIndex(0),
        // subs: [{
        //     type: "Oil",
        //     percent: 15
        // }, {
        //     type: "Coal",
        //     percent: 35
        // }, {
        //     type: "Nuclear",
        //     percent: 20
        // }]
    }, {
        type: "Quantidade livre",
        percent: 80,
        color: chart.colors.getIndex(1),
        // subs: [{
        //     type: "Hydro",
        //     percent: 15
        // }, {
        //     type: "Wind",
        //     percent: 10
        // }, {
        //     type: "Other",
        //     percent: 5
        // }]
    }];

    // Add data
    chart.data = generateChartData();

    // Add and configure Series
    var pieSeries = chart.series.push(new am4charts.PieSeries());
    pieSeries.dataFields.value = "percent";
    pieSeries.dataFields.category = "type";
    pieSeries.slices.template.propertyFields.fill = "color";
    pieSeries.slices.template.propertyFields.isActive = "pulled";
    pieSeries.slices.template.strokeWidth = 0;

    function generateChartData() {
        var chartData = [];
        for (var i = 0; i < types.length; i++) {
            if (i == selected) {
                for (var x = 0; x < types[i].subs.length; x++) {
                    chartData.push({
                        type: types[i].subs[x].type,
                        percent: types[i].subs[x].percent,
                        color: types[i].color,
                        pulled: true
                    });
                }
            } else {
                chartData.push({
                    type: types[i].type,
                    percent: types[i].percent,
                    color: types[i].color,
                    id: i
                });
            }
        }
        return chartData;
    }

    pieSeries.slices.template.events.on("hit", function(event) {
        if (event.target.dataItem.dataContext.id != undefined) {
            selected = event.target.dataItem.dataContext.id;
        } else {
            selected = undefined;
        }
        chart.data = generateChartData();
    });

}); // end am4core.ready()


//----------------- grafico ram 4 --------------//


am4core.ready(function() {

    // Themes begin
    am4core.useTheme(am4themes_dark);
    am4core.useTheme(am4themes_animated);
    // Themes end

    // Create chart instance
    var chart = am4core.create("chartRAM4", am4charts.PieChart);

    // Set data
    var selected;
    var types = [{
        type: "Utilizado",
        percent: 30,
        color: chart.colors.getIndex(0),
        // subs: [{
        //     type: "Oil",
        //     percent: 15
        // }, {
        //     type: "Coal",
        //     percent: 35
        // }, {
        //     type: "Nuclear",
        //     percent: 20
        // }]
    }, {
        type: "Quantidade livre",
        percent: 70,
        color: chart.colors.getIndex(1),
        // subs: [{
        //     type: "Hydro",
        //     percent: 15
        // }, {
        //     type: "Wind",
        //     percent: 10
        // }, {
        //     type: "Other",
        //     percent: 5
        // }]
    }];

    // Add data
    chart.data = generateChartData();

    // Add and configure Series
    var pieSeries = chart.series.push(new am4charts.PieSeries());
    pieSeries.dataFields.value = "percent";
    pieSeries.dataFields.category = "type";
    pieSeries.slices.template.propertyFields.fill = "color";
    pieSeries.slices.template.propertyFields.isActive = "pulled";
    pieSeries.slices.template.strokeWidth = 0;

    function generateChartData() {
        var chartData = [];
        for (var i = 0; i < types.length; i++) {
            if (i == selected) {
                for (var x = 0; x < types[i].subs.length; x++) {
                    chartData.push({
                        type: types[i].subs[x].type,
                        percent: types[i].subs[x].percent,
                        color: types[i].color,
                        pulled: true
                    });
                }
            } else {
                chartData.push({
                    type: types[i].type,
                    percent: types[i].percent,
                    color: types[i].color,
                    id: i
                });
            }
        }
        return chartData;
    }

    pieSeries.slices.template.events.on("hit", function(event) {
        if (event.target.dataItem.dataContext.id != undefined) {
            selected = event.target.dataItem.dataContext.id;
        } else {
            selected = undefined;
        }
        chart.data = generateChartData();
    });

}); // end am4core.ready()


//----------------- grafico ram 5 --------------//


am4core.ready(function() {

    // Themes begin
    am4core.useTheme(am4themes_dark);
    am4core.useTheme(am4themes_animated);
    // Themes end

    // Create chart instance
    var chart = am4core.create("chartRAM5", am4charts.PieChart);

    // Set data
    var selected;
    var types = [{
        type: "Utilizado",
        percent: 60,
        color: chart.colors.getIndex(0),
        // subs: [{
        //     type: "Oil",
        //     percent: 15
        // }, {
        //     type: "Coal",
        //     percent: 35
        // }, {
        //     type: "Nuclear",
        //     percent: 20
        // }]
    }, {
        type: "Quantidade livre",
        percent: 40,
        color: chart.colors.getIndex(1),
        // subs: [{
        //     type: "Hydro",
        //     percent: 15
        // }, {
        //     type: "Wind",
        //     percent: 10
        // }, {
        //     type: "Other",
        //     percent: 5
        // }]
    }];

    // Add data
    chart.data = generateChartData();

    // Add and configure Series
    var pieSeries = chart.series.push(new am4charts.PieSeries());
    pieSeries.dataFields.value = "percent";
    pieSeries.dataFields.category = "type";
    pieSeries.slices.template.propertyFields.fill = "color";
    pieSeries.slices.template.propertyFields.isActive = "pulled";
    pieSeries.slices.template.strokeWidth = 0;

    function generateChartData() {
        var chartData = [];
        for (var i = 0; i < types.length; i++) {
            if (i == selected) {
                for (var x = 0; x < types[i].subs.length; x++) {
                    chartData.push({
                        type: types[i].subs[x].type,
                        percent: types[i].subs[x].percent,
                        color: types[i].color,
                        pulled: true
                    });
                }
            } else {
                chartData.push({
                    type: types[i].type,
                    percent: types[i].percent,
                    color: types[i].color,
                    id: i
                });
            }
        }
        return chartData;
    }

    pieSeries.slices.template.events.on("hit", function(event) {
        if (event.target.dataItem.dataContext.id != undefined) {
            selected = event.target.dataItem.dataContext.id;
        } else {
            selected = undefined;
        }
        chart.data = generateChartData();
    });

}); // end am4core.ready()




//----------------- grafico ram 6 --------------//


am4core.ready(function() {

    // Themes begin
    am4core.useTheme(am4themes_dark);
    am4core.useTheme(am4themes_animated);
    // Themes end

    // Create chart instance
    var chart = am4core.create("chartRAM6", am4charts.PieChart);

    // Set data
    var selected;
    var types = [{
        type: "Utilizado",
        percent: 50,
        color: chart.colors.getIndex(0),
        // subs: [{
        //     type: "Oil",
        //     percent: 15
        // }, {
        //     type: "Coal",
        //     percent: 35
        // }, {
        //     type: "Nuclear",
        //     percent: 20
        // }]
    }, {
        type: "Green Energy",
        percent: 50,
        color: chart.colors.getIndex(1),
        // subs: [{
        //     type: "Hydro",
        //     percent: 15
        // }, {
        //     type: "Wind",
        //     percent: 10
        // }, {
        //     type: "Other",
        //     percent: 5
        // }]
    }];

    // Add data
    chart.data = generateChartData();

    // Add and configure Series
    var pieSeries = chart.series.push(new am4charts.PieSeries());
    pieSeries.dataFields.value = "percent";
    pieSeries.dataFields.category = "type";
    pieSeries.slices.template.propertyFields.fill = "color";
    pieSeries.slices.template.propertyFields.isActive = "pulled";
    pieSeries.slices.template.strokeWidth = 0;

    function generateChartData() {
        var chartData = [];
        for (var i = 0; i < types.length; i++) {
            if (i == selected) {
                for (var x = 0; x < types[i].subs.length; x++) {
                    chartData.push({
                        type: types[i].subs[x].type,
                        percent: types[i].subs[x].percent,
                        color: types[i].color,
                        pulled: true
                    });
                }
            } else {
                chartData.push({
                    type: types[i].type,
                    percent: types[i].percent,
                    color: types[i].color,
                    id: i
                });
            }
        }
        return chartData;
    }

    pieSeries.slices.template.events.on("hit", function(event) {
        if (event.target.dataItem.dataContext.id != undefined) {
            selected = event.target.dataItem.dataContext.id;
        } else {
            selected = undefined;
        }
        chart.data = generateChartData();
    });

}); // end am4core.ready()