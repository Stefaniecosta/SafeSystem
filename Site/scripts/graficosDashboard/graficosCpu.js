
//----------------------- CPU GRAFICO 1 -----------------


am4core.ready(function () {

  // Themes begin
  am4core.useTheme(am4themes_dark);
  am4core.useTheme(am4themes_animated);
  // Themes end

  // Create chart instance
  var chart = am4core.create("chartCPU1", am4charts.XYChart);

  // Add data
  chart.data = [{
    "date": "2021-09-01",
    "value": 42
  }, {
    "date": "2021-09-02",
    "value": 35
  }, {
    "date": "2021-09-03",
    "value": 31
  }, {
    "date": "2021-09-04",
    "value": 47
  }, {
    "date": "2021-09-05",
    "value": 52
  }, {
    "date": "2021-09-06",
    "value": 46
  }, {
    "date": "2021-09-07",
    "value": 41
  }, {
    "date": "2021-09-08",
    "value": 43
  }, {
    "date": "2021-09-09",
    "value": 40
  }, {
    "date": "2021-09-10",
    "value": 39
  }, {
    "date": "2021-09-11",
    "value": 34
  }, {
    "date": "2021-09-12",
    "value": 29
  }, {
    "date": "2021-09-13",
    "value": 34
  }, {
    "date": "2021-09-14",
    "value": 37
  }, {
    "date": "2021-09-15",
    "value": 42
  }, {
    "date": "2021-09-16",
    "value": 49
  }, {
    "date": "2021-09-17",
    "value": 46
  }, {
    "date": "2021-09-18",
    "value": 47
  }, {
    "date": "2021-09-19",
    "value": 55
  }, {
    "date": "2021-09-20",
    "value": 59
  }, {
    "date": "2021-09-21",
    "value": 58
  }, {
    "date": "2021-09-22",
    "value": 57
  }, {
    "date": "2021-09-23",
    "value": 61
  }, {
    "date": "2021-09-24",
    "value": 59
  }, {
    "date": "2021-09-25",
    "value": 67
  }, {
    "date": "2021-09-26",
    "value": 65
  }, {
    "date": "2021-09-27",
    "value": 61
  }, {
    "date": "2021-09-28",
    "value": 66
  }, {
    "date": "2021-09-29",
    "value": 69
  }, {
    "date": "2021-09-30",
    "value": 71
  }, {
    "date": "2021-10-01",
    "value": 67
  }, {
    "date": "2021-10-02",
    "value": 63
  }, {
    "date": "2021-10-03",
    "value": 46
  }, {
    "date": "2021-10-04",
    "value": 32
  }, {
    "date": "2021-10-05",
    "value": 21
  }, {
    "date": "2021-10-06",
    "value": 18
  }, {
    "date": "2021-10-07",
    "value": 21
  }, {
    "date": "2021-10-08",
    "value": 28
  }, {
    "date": "2021-10-09",
    "value": 27
  }, {
    "date": "2021-10-10",
    "value": 36
  }, {
    "date": "2021-10-11",
    "value": 33
  }, {
    "date": "2021-10-12",
    "value": 31
  }, {
    "date": "2021-10-13",
    "value": 30
  }, {
    "date": "2021-10-14",
    "value": 34
  }, {
    "date": "2021-10-15",
    "value": 38
  }, {
    "date": "2021-10-16",
    "value": 37
  }, {
    "date": "2021-10-17",
    "value": 44
  }, {
    "date": "2021-10-18",
    "value": 49
  }, {
    "date": "2021-10-19",
    "value": 53
  }, {
    "date": "2021-10-20",
    "value": 57
  }, {
    "date": "2021-10-21",
    "value": 60
  }
  ];

  // Set input format for the dates
  chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

  // Create axes
  var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
  var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

  // Create series
  var series = chart.series.push(new am4charts.LineSeries());
  series.dataFields.valueY = "value";
  series.dataFields.dateX = "date";
  series.tooltipText = "Uso da cpu: {value}%"
  series.strokeWidth = 2;
  series.minBulletDistance = 15;

  // Drop-shaped tooltips
  series.tooltip.background.cornerRadius = 20;
  series.tooltip.background.strokeOpacity = 0;
  series.tooltip.pointerOrientation = "vertical";
  series.tooltip.label.minWidth = 40;
  series.tooltip.label.minHeight = 20;
  series.tooltip.label.textAlign = "middle";
  series.tooltip.label.textValign = "middle";

  // Make bullets grow on hover
  var bullet = series.bullets.push(new am4charts.CircleBullet());
  bullet.circle.strokeWidth = 2;
  bullet.circle.radius = 4;
  bullet.circle.fill = am4core.color("#fff");

  var bullethover = bullet.states.create("hover");
  bullethover.properties.scale = 1.3;

  // Make a panning cursor
  chart.cursor = new am4charts.XYCursor();
  chart.cursor.behavior = "panXY";
  chart.cursor.xAxis = dateAxis;
  chart.cursor.snapToSeries = series;

  // Create vertical scrollbar and place it before the value axis
  chart.scrollbarY = new am4core.Scrollbar();
  chart.scrollbarY.parent = chart.leftAxesContainer;
  chart.scrollbarY.toBack();

  // Create a horizontal scrollbar with previe and place it underneath the date axis
  chart.scrollbarX = new am4charts.XYChartScrollbar();
  chart.scrollbarX.series.push(series);
  chart.scrollbarX.parent = chart.bottomAxesContainer;

  dateAxis.start = 0.79;
  dateAxis.keepSelection = true;


}); // end am4core.ready()


//----------------------- CPU GRAFICO 2 -----------------



am4core.ready(function () {

  // Themes begin
  am4core.useTheme(am4themes_dark);
  am4core.useTheme(am4themes_animated);
  // Themes end

  // Create chart instance
  var chart = am4core.create("chartCPU2", am4charts.XYChart);

  // Add data
  chart.data = [{
    "date": "2021-09-01",
    "value": 42
  }, {
    "date": "2021-09-02",
    "value": 89
  }, {
    "date": "2021-09-03",
    "value": 67
  }, {
    "date": "2021-09-04",
    "value": 88
  }, {
    "date": "2021-09-05",
    "value": 52
  }, {
    "date": "2021-09-06",
    "value": 46
  }, {
    "date": "2021-09-07",
    "value": 89
  }, {
    "date": "2021-09-08",
    "value": 43
  }, {
    "date": "2021-09-09",
    "value": 48
  }, {
    "date": "2021-09-10",
    "value": 56
  }, {
    "date": "2021-09-11",
    "value": 78
  }, {
    "date": "2021-09-12",
    "value": 29
  }, {
    "date": "2021-09-13",
    "value": 34
  }, {
    "date": "2021-09-14",
    "value": 99
  }, {
    "date": "2021-09-15",
    "value": 78
  }, {
    "date": "2021-09-16",
    "value": 49
  }, {
    "date": "2021-09-17",
    "value": 78
  }, {
    "date": "2021-09-18",
    "value": 98
  }, {
    "date": "2021-09-19",
    "value": 68
  }, {
    "date": "2021-09-20",
    "value": 59
  }, {
    "date": "2021-09-21",
    "value": 58
  }, {
    "date": "2021-09-22",
    "value": 57
  }, {
    "date": "2021-09-23",
    "value": 61
  }, {
    "date": "2021-09-24",
    "value": 59
  }, {
    "date": "2021-09-25",
    "value": 67
  }, {
    "date": "2021-09-26",
    "value": 65
  }, {
    "date": "2021-09-27",
    "value": 61
  }, {
    "date": "2021-09-28",
    "value": 66
  }, {
    "date": "2021-09-29",
    "value": 69
  }, {
    "date": "2021-09-30",
    "value": 71
  }, {
    "date": "2021-10-01",
    "value": 67
  }, {
    "date": "2021-10-02",
    "value": 63
  }, {
    "date": "2021-10-03",
    "value": 46
  }, {
    "date": "2021-10-04",
    "value": 89
  }, {
    "date": "2021-10-05",
    "value": 88
  }, {
    "date": "2021-10-06",
    "value": 89
  }, {
    "date": "2021-10-07",
    "value": 90
  }, {
    "date": "2021-10-08",
    "value": 68
  }, {
    "date": "2021-10-09",
    "value": 27
  }, {
    "date": "2021-10-10",
    "value": 36
  }, {
    "date": "2021-10-11",
    "value": 33
  }, {
    "date": "2021-10-12",
    "value": 31
  }, {
    "date": "2021-10-13",
    "value": 30
  }, {
    "date": "2021-10-14",
    "value": 67
  }, {
    "date": "2021-10-15",
    "value": 75
  }, {
    "date": "2021-10-16",
    "value": 88
  }, {
    "date": "2021-10-17",
    "value": 89
  }, {
    "date": "2021-10-18",
    "value": 49
  }, {
    "date": "2021-10-19",
    "value": 53
  }, {
    "date": "2021-10-20",
    "value": 57
  }, {
    "date": "2021-10-21",
    "value": 60
  }
  ];

  // Set input format for the dates
  chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

  // Create axes
  var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
  var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

  // Create series
  var series = chart.series.push(new am4charts.LineSeries());
  series.dataFields.valueY = "value";
  series.dataFields.dateX = "date";
  series.tooltipText = "Uso da cpu: {value}%"
  series.strokeWidth = 2;
  series.minBulletDistance = 15;

  // Drop-shaped tooltips
  series.tooltip.background.cornerRadius = 20;
  series.tooltip.background.strokeOpacity = 0;
  series.tooltip.pointerOrientation = "vertical";
  series.tooltip.label.minWidth = 40;
  series.tooltip.label.minHeight = 20;
  series.tooltip.label.textAlign = "middle";
  series.tooltip.label.textValign = "middle";

  // Make bullets grow on hover
  var bullet = series.bullets.push(new am4charts.CircleBullet());
  bullet.circle.strokeWidth = 2;
  bullet.circle.radius = 4;
  bullet.circle.fill = am4core.color("#fff");

  var bullethover = bullet.states.create("hover");
  bullethover.properties.scale = 1.3;

  // Make a panning cursor
  chart.cursor = new am4charts.XYCursor();
  chart.cursor.behavior = "panXY";
  chart.cursor.xAxis = dateAxis;
  chart.cursor.snapToSeries = series;

  // Create vertical scrollbar and place it before the value axis
  chart.scrollbarY = new am4core.Scrollbar();
  chart.scrollbarY.parent = chart.leftAxesContainer;
  chart.scrollbarY.toBack();

  // Create a horizontal scrollbar with previe and place it underneath the date axis
  chart.scrollbarX = new am4charts.XYChartScrollbar();
  chart.scrollbarX.series.push(series);
  chart.scrollbarX.parent = chart.bottomAxesContainer;

  dateAxis.start = 0.79;
  dateAxis.keepSelection = true;


}); // end am4core.ready()


//----------------------- CPU GRAFICO 3 -----------------


am4core.ready(function () {

  // Themes begin
  am4core.useTheme(am4themes_dark);
  am4core.useTheme(am4themes_animated);
  // Themes end

  // Create chart instance
  var chart = am4core.create("chartCPU3", am4charts.XYChart);

  // Add data
  chart.data = [{
    "date": "2021-09-01",
    "value": 42
  }, {
    "date": "2021-09-02",
    "value": 35
  }, {
    "date": "2021-09-03",
    "value": 31
  }, {
    "date": "2021-09-04",
    "value": 37
  }, {
    "date": "2021-09-05",
    "value": 20
  }, {
    "date": "2021-09-06",
    "value": 46
  }, {
    "date": "2021-09-07",
    "value": 41
  }, {
    "date": "2021-09-08",
    "value": 43
  }, {
    "date": "2021-09-09",
    "value": 40
  }, {
    "date": "2021-09-10",
    "value": 39
  }, {
    "date": "2021-09-11",
    "value": 34
  }, {
    "date": "2021-09-12",
    "value": 29
  }, {
    "date": "2021-09-13",
    "value": 34
  }, {
    "date": "2021-09-14",
    "value": 37
  }, {
    "date": "2021-09-15",
    "value": 42
  }, {
    "date": "2021-09-16",
    "value": 49
  }, {
    "date": "2021-09-17",
    "value": 46
  }, {
    "date": "2021-09-18",
    "value": 47
  }, {
    "date": "2021-09-19",
    "value": 28
  }, {
    "date": "2021-09-20",
    "value": 23
  }, {
    "date": "2021-09-21",
    "value": 34
  }, {
    "date": "2021-09-22",
    "value": 57
  }, {
    "date": "2021-09-23",
    "value": 20
  }, {
    "date": "2021-09-24",
    "value": 45
  }, {
    "date": "2021-09-25",
    "value": 67
  }, {
    "date": "2021-09-26",
    "value": 65
  }, {
    "date": "2021-09-27",
    "value": 61
  }, {
    "date": "2021-09-28",
    "value": 66
  }, {
    "date": "2021-09-29",
    "value": 69
  }, {
    "date": "2021-09-30",
    "value": 71
  }, {
    "date": "2021-10-01",
    "value": 67
  }, {
    "date": "2021-10-02",
    "value": 63
  }, {
    "date": "2021-10-03",
    "value": 46
  }, {
    "date": "2021-10-04",
    "value": 32
  }, {
    "date": "2021-10-05",
    "value": 21
  }, {
    "date": "2021-10-06",
    "value": 18
  }, {
    "date": "2021-10-07",
    "value": 21
  }, {
    "date": "2021-10-08",
    "value": 28
  }, {
    "date": "2021-10-09",
    "value": 27
  }, {
    "date": "2021-10-10",
    "value": 36
  }, {
    "date": "2021-10-11",
    "value": 33
  }, {
    "date": "2021-10-12",
    "value": 31
  }, {
    "date": "2021-10-13",
    "value": 30
  }, {
    "date": "2021-10-14",
    "value": 34
  }, {
    "date": "2021-10-15",
    "value": 38
  }, {
    "date": "2021-10-16",
    "value": 37
  }, {
    "date": "2021-10-17",
    "value": 44
  }, {
    "date": "2021-10-18",
    "value": 49
  }, {
    "date": "2021-10-19",
    "value": 30
  }, {
    "date": "2021-10-20",
    "value": 15
  }, {
    "date": "2021-10-21",
    "value": 20
  }
  ];

  // Set input format for the dates
  chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

  // Create axes
  var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
  var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

  // Create series
  var series = chart.series.push(new am4charts.LineSeries());
  series.dataFields.valueY = "value";
  series.dataFields.dateX = "date";
  series.tooltipText = "Uso da cpu: {value}%"
  series.strokeWidth = 2;
  series.minBulletDistance = 15;

  // Drop-shaped tooltips
  series.tooltip.background.cornerRadius = 20;
  series.tooltip.background.strokeOpacity = 0;
  series.tooltip.pointerOrientation = "vertical";
  series.tooltip.label.minWidth = 40;
  series.tooltip.label.minHeight = 20;
  series.tooltip.label.textAlign = "middle";
  series.tooltip.label.textValign = "middle";

  // Make bullets grow on hover
  var bullet = series.bullets.push(new am4charts.CircleBullet());
  bullet.circle.strokeWidth = 2;
  bullet.circle.radius = 4;
  bullet.circle.fill = am4core.color("#fff");

  var bullethover = bullet.states.create("hover");
  bullethover.properties.scale = 1.3;

  // Make a panning cursor
  chart.cursor = new am4charts.XYCursor();
  chart.cursor.behavior = "panXY";
  chart.cursor.xAxis = dateAxis;
  chart.cursor.snapToSeries = series;

  // Create vertical scrollbar and place it before the value axis
  chart.scrollbarY = new am4core.Scrollbar();
  chart.scrollbarY.parent = chart.leftAxesContainer;
  chart.scrollbarY.toBack();

  // Create a horizontal scrollbar with previe and place it underneath the date axis
  chart.scrollbarX = new am4charts.XYChartScrollbar();
  chart.scrollbarX.series.push(series);
  chart.scrollbarX.parent = chart.bottomAxesContainer;

  dateAxis.start = 0.79;
  dateAxis.keepSelection = true;


}); // end am4core.ready()


//----------------------- CPU GRAFICO 4 -----------------


am4core.ready(function () {

  // Themes begin
  am4core.useTheme(am4themes_dark);
  am4core.useTheme(am4themes_animated);
  // Themes end

  // Create chart instance
  var chart = am4core.create("chartCPU4", am4charts.XYChart);

  // Add data
  chart.data = [{
    "date": "2021-09-01",
    "value": 42
  }, {
    "date": "2021-09-02",
    "value": 35
  }, {
    "date": "2021-09-03",
    "value": 31
  }, {
    "date": "2021-09-04",
    "value": 24
  }, {
    "date": "2021-09-05",
    "value": 23
  }, {
    "date": "2021-09-06",
    "value": 46
  }, {
    "date": "2021-09-07",
    "value": 26
  }, {
    "date": "2021-09-08",
    "value": 38
  }, {
    "date": "2021-09-09",
    "value": 40
  }, {
    "date": "2021-09-10",
    "value": 39
  }, {
    "date": "2021-09-11",
    "value": 34
  }, {
    "date": "2021-09-12",
    "value": 29
  }, {
    "date": "2021-09-13",
    "value": 34
  }, {
    "date": "2021-09-14",
    "value": 37
  }, {
    "date": "2021-09-15",
    "value": 42
  }, {
    "date": "2021-09-16",
    "value": 49
  }, {
    "date": "2021-09-17",
    "value": 46
  }, {
    "date": "2021-09-18",
    "value": 47
  }, {
    "date": "2021-09-19",
    "value": 55
  }, {
    "date": "2021-09-20",
    "value": 59
  }, {
    "date": "2021-09-21",
    "value": 58
  }, {
    "date": "2021-09-22",
    "value": 57
  }, {
    "date": "2021-09-23",
    "value": 61
  }, {
    "date": "2021-09-24",
    "value": 59
  }, {
    "date": "2021-09-25",
    "value": 67
  }, {
    "date": "2021-09-26",
    "value": 65
  }, {
    "date": "2021-09-27",
    "value": 61
  }, {
    "date": "2021-09-28",
    "value": 66
  }, {
    "date": "2021-09-29",
    "value": 69
  }, {
    "date": "2021-09-30",
    "value": 71
  }, {
    "date": "2021-10-01",
    "value": 67
  }, {
    "date": "2021-10-02",
    "value": 63
  }, {
    "date": "2021-10-03",
    "value": 46
  }, {
    "date": "2021-10-04",
    "value": 32
  }, {
    "date": "2021-10-05",
    "value": 21
  }, {
    "date": "2021-10-06",
    "value": 18
  }, {
    "date": "2021-10-07",
    "value": 21
  }, {
    "date": "2021-10-08",
    "value": 28
  }, {
    "date": "2021-10-09",
    "value": 27
  }, {
    "date": "2021-10-10",
    "value": 36
  }, {
    "date": "2021-10-11",
    "value": 33
  }, {
    "date": "2021-10-12",
    "value": 31
  }, {
    "date": "2021-10-13",
    "value": 30
  }, {
    "date": "2021-10-14",
    "value": 34
  }, {
    "date": "2021-10-15",
    "value": 38
  }, {
    "date": "2021-10-16",
    "value": 37
  }, {
    "date": "2021-10-17",
    "value": 23
  }, {
    "date": "2021-10-18",
    "value": 49
  }, {
    "date": "2021-10-19",
    "value": 53
  }, {
    "date": "2021-10-20",
    "value": 57
  }, {
    "date": "2021-10-21",
    "value": 30
  }
  ];

  // Set input format for the dates
  chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

  // Create axes
  var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
  var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

  // Create series
  var series = chart.series.push(new am4charts.LineSeries());
  series.dataFields.valueY = "value";
  series.dataFields.dateX = "date";
  series.tooltipText = "Uso da cpu: {value}%"
  series.strokeWidth = 2;
  series.minBulletDistance = 15;

  // Drop-shaped tooltips
  series.tooltip.background.cornerRadius = 20;
  series.tooltip.background.strokeOpacity = 0;
  series.tooltip.pointerOrientation = "vertical";
  series.tooltip.label.minWidth = 40;
  series.tooltip.label.minHeight = 20;
  series.tooltip.label.textAlign = "middle";
  series.tooltip.label.textValign = "middle";

  // Make bullets grow on hover
  var bullet = series.bullets.push(new am4charts.CircleBullet());
  bullet.circle.strokeWidth = 2;
  bullet.circle.radius = 4;
  bullet.circle.fill = am4core.color("#fff");

  var bullethover = bullet.states.create("hover");
  bullethover.properties.scale = 1.3;

  // Make a panning cursor
  chart.cursor = new am4charts.XYCursor();
  chart.cursor.behavior = "panXY";
  chart.cursor.xAxis = dateAxis;
  chart.cursor.snapToSeries = series;

  // Create vertical scrollbar and place it before the value axis
  chart.scrollbarY = new am4core.Scrollbar();
  chart.scrollbarY.parent = chart.leftAxesContainer;
  chart.scrollbarY.toBack();

  // Create a horizontal scrollbar with previe and place it underneath the date axis
  chart.scrollbarX = new am4charts.XYChartScrollbar();
  chart.scrollbarX.series.push(series);
  chart.scrollbarX.parent = chart.bottomAxesContainer;

  dateAxis.start = 0.79;
  dateAxis.keepSelection = true;


}); // end am4core.ready()


//----------------------- CPU GRAFICO 5 -----------------


am4core.ready(function () {

  // Themes begin
  am4core.useTheme(am4themes_dark);
  am4core.useTheme(am4themes_animated);
  // Themes end

  // Create chart instance
  var chart = am4core.create("chartCPU5", am4charts.XYChart);

  // Add data
  chart.data = [{
    "date": "2021-09-01",
    "value": 42
  }, {
    "date": "2021-09-02",
    "value": 35
  }, {
    "date": "2021-09-03",
    "value": 31
  }, {
    "date": "2021-09-04",
    "value": 47
  }, {
    "date": "2021-09-05",
    "value": 52
  }, {
    "date": "2021-09-06",
    "value": 46
  }, {
    "date": "2021-09-07",
    "value": 41
  }, {
    "date": "2021-09-08",
    "value": 43
  }, {
    "date": "2021-09-09",
    "value": 40
  }, {
    "date": "2021-09-10",
    "value": 39
  }, {
    "date": "2021-09-11",
    "value": 34
  }, {
    "date": "2021-09-12",
    "value": 29
  }, {
    "date": "2021-09-13",
    "value": 34
  }, {
    "date": "2021-09-14",
    "value": 37
  }, {
    "date": "2021-09-15",
    "value": 42
  }, {
    "date": "2021-09-16",
    "value": 49
  }, {
    "date": "2021-09-17",
    "value": 46
  }, {
    "date": "2021-09-18",
    "value": 47
  }, {
    "date": "2021-09-19",
    "value": 55
  }, {
    "date": "2021-09-20",
    "value": 59
  }, {
    "date": "2021-09-21",
    "value": 58
  }, {
    "date": "2021-09-22",
    "value": 57
  }, {
    "date": "2021-09-23",
    "value": 61
  }, {
    "date": "2021-09-24",
    "value": 59
  }, {
    "date": "2021-09-25",
    "value": 67
  }, {
    "date": "2021-09-26",
    "value": 65
  }, {
    "date": "2021-09-27",
    "value": 61
  }, {
    "date": "2021-09-28",
    "value": 66
  }, {
    "date": "2021-09-29",
    "value": 69
  }, {
    "date": "2021-09-30",
    "value": 71
  }, {
    "date": "2021-10-01",
    "value": 67
  }, {
    "date": "2021-10-02",
    "value": 63
  }, {
    "date": "2021-10-03",
    "value": 46
  }, {
    "date": "2021-10-04",
    "value": 32
  }, {
    "date": "2021-10-05",
    "value": 21
  }, {
    "date": "2021-10-06",
    "value": 18
  }, {
    "date": "2021-10-07",
    "value": 21
  }, {
    "date": "2021-10-08",
    "value": 28
  }, {
    "date": "2021-10-09",
    "value": 27
  }, {
    "date": "2021-10-10",
    "value": 36
  }, {
    "date": "2021-10-11",
    "value": 33
  }, {
    "date": "2021-10-12",
    "value": 31
  }, {
    "date": "2021-10-13",
    "value": 30
  }, {
    "date": "2021-10-14",
    "value": 34
  }, {
    "date": "2021-10-15",
    "value": 38
  }, {
    "date": "2021-10-16",
    "value": 37
  }, {
    "date": "2021-10-17",
    "value": 44
  }, {
    "date": "2021-10-18",
    "value": 49
  }, {
    "date": "2021-10-19",
    "value": 53
  }, {
    "date": "2021-10-20",
    "value": 57
  }, {
    "date": "2021-10-21",
    "value": 60
  }
  ];

  // Set input format for the dates
  chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

  // Create axes
  var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
  var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

  // Create series
  var series = chart.series.push(new am4charts.LineSeries());
  series.dataFields.valueY = "value";
  series.dataFields.dateX = "date";
  series.tooltipText = "Uso da cpu: {value}%"
  series.strokeWidth = 2;
  series.minBulletDistance = 15;

  // Drop-shaped tooltips
  series.tooltip.background.cornerRadius = 20;
  series.tooltip.background.strokeOpacity = 0;
  series.tooltip.pointerOrientation = "vertical";
  series.tooltip.label.minWidth = 40;
  series.tooltip.label.minHeight = 20;
  series.tooltip.label.textAlign = "middle";
  series.tooltip.label.textValign = "middle";

  // Make bullets grow on hover
  var bullet = series.bullets.push(new am4charts.CircleBullet());
  bullet.circle.strokeWidth = 2;
  bullet.circle.radius = 4;
  bullet.circle.fill = am4core.color("#fff");

  var bullethover = bullet.states.create("hover");
  bullethover.properties.scale = 1.3;

  // Make a panning cursor
  chart.cursor = new am4charts.XYCursor();
  chart.cursor.behavior = "panXY";
  chart.cursor.xAxis = dateAxis;
  chart.cursor.snapToSeries = series;

  // Create vertical scrollbar and place it before the value axis
  chart.scrollbarY = new am4core.Scrollbar();
  chart.scrollbarY.parent = chart.leftAxesContainer;
  chart.scrollbarY.toBack();

  // Create a horizontal scrollbar with previe and place it underneath the date axis
  chart.scrollbarX = new am4charts.XYChartScrollbar();
  chart.scrollbarX.series.push(series);
  chart.scrollbarX.parent = chart.bottomAxesContainer;

  dateAxis.start = 0.79;
  dateAxis.keepSelection = true;


}); // end am4core.ready()


//----------------------- CPU GRAFICO 6 -----------------


am4core.ready(function () {

  // Themes begin
  am4core.useTheme(am4themes_dark);
  am4core.useTheme(am4themes_animated);
  // Themes end

  // Create chart instance
  var chart = am4core.create("chartCPU6", am4charts.XYChart);

  // Add data
  chart.data = [{
    "date": "2021-09-01",
    "value": 42
  }, {
    "date": "2021-09-02",
    "value": 35
  }, {
    "date": "2021-09-03",
    "value": 31
  }, {
    "date": "2021-09-04",
    "value": 47
  }, {
    "date": "2021-09-05",
    "value": 52
  }, {
    "date": "2021-09-06",
    "value": 46
  }, {
    "date": "2021-09-07",
    "value": 41
  }, {
    "date": "2021-09-08",
    "value": 43
  }, {
    "date": "2021-09-09",
    "value": 40
  }, {
    "date": "2021-09-10",
    "value": 39
  }, {
    "date": "2021-09-11",
    "value": 34
  }, {
    "date": "2021-09-12",
    "value": 29
  }, {
    "date": "2021-09-13",
    "value": 34
  }, {
    "date": "2021-09-14",
    "value": 37
  }, {
    "date": "2021-09-15",
    "value": 35
  }, {
    "date": "2021-09-16",
    "value": 13
  }, {
    "date": "2021-09-17",
    "value": 23
  }, {
    "date": "2021-09-18",
    "value": 32
  }, {
    "date": "2021-09-19",
    "value": 21
  }, {
    "date": "2021-09-20",
    "value": 24
  }, {
    "date": "2021-09-21",
    "value": 23
  }, {
    "date": "2021-09-22",
    "value": 57
  }, {
    "date": "2021-09-23",
    "value": 61
  }, {
    "date": "2021-09-24",
    "value": 59
  }, {
    "date": "2021-09-25",
    "value": 67
  }, {
    "date": "2021-09-26",
    "value": 34
  }, {
    "date": "2021-09-27",
    "value": 23
  }, {
    "date": "2021-09-28",
    "value": 34
  }, {
    "date": "2021-09-29",
    "value": 23
  }, {
    "date": "2021-09-30",
    "value": 34
  }, {
    "date": "2021-10-01",
    "value": 34
  }, {
    "date": "2021-10-02",
    "value": 23
  }, {
    "date": "2021-10-03",
    "value": 23
  }, {
    "date": "2021-10-04",
    "value": 32
  }, {
    "date": "2021-10-05",
    "value": 21
  }, {
    "date": "2021-10-06",
    "value": 18
  }, {
    "date": "2021-10-07",
    "value": 21
  }, {
    "date": "2021-10-08",
    "value": 28
  }, {
    "date": "2021-10-09",
    "value": 27
  }, {
    "date": "2021-10-10",
    "value": 36
  }, {
    "date": "2021-10-11",
    "value": 33
  }, {
    "date": "2021-10-12",
    "value": 31
  }, {
    "date": "2021-10-13",
    "value": 30
  }, {
    "date": "2021-10-14",
    "value": 34
  }, {
    "date": "2021-10-15",
    "value": 38
  }, {
    "date": "2021-10-16",
    "value": 37
  }, {
    "date": "2021-10-17",
    "value": 44
  }, {
    "date": "2021-10-18",
    "value": 49
  }, {
    "date": "2021-10-19",
    "value": 45
  }, {
    "date": "2021-10-20",
    "value": 34
  }, {
    "date": "2021-10-21",
    "value": 34
  }
  ];

  // Set input format for the dates
  chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

  // Create axes
  var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
  var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

  // Create series
  var series = chart.series.push(new am4charts.LineSeries());
  series.dataFields.valueY = "value";
  series.dataFields.dateX = "date";
  series.tooltipText = "Uso da cpu: {value}%"
  series.strokeWidth = 2;
  series.minBulletDistance = 15;

  // Drop-shaped tooltips
  series.tooltip.background.cornerRadius = 20;
  series.tooltip.background.strokeOpacity = 0;
  series.tooltip.pointerOrientation = "vertical";
  series.tooltip.label.minWidth = 40;
  series.tooltip.label.minHeight = 20;
  series.tooltip.label.textAlign = "middle";
  series.tooltip.label.textValign = "middle";

  // Make bullets grow on hover
  var bullet = series.bullets.push(new am4charts.CircleBullet());
  bullet.circle.strokeWidth = 2;
  bullet.circle.radius = 4;
  bullet.circle.fill = am4core.color("#fff");

  var bullethover = bullet.states.create("hover");
  bullethover.properties.scale = 1.3;

  // Make a panning cursor
  chart.cursor = new am4charts.XYCursor();
  chart.cursor.behavior = "panXY";
  chart.cursor.xAxis = dateAxis;
  chart.cursor.snapToSeries = series;

  // Create vertical scrollbar and place it before the value axis
  chart.scrollbarY = new am4core.Scrollbar();
  chart.scrollbarY.parent = chart.leftAxesContainer;
  chart.scrollbarY.toBack();

  // Create a horizontal scrollbar with previe and place it underneath the date axis
  chart.scrollbarX = new am4charts.XYChartScrollbar();
  chart.scrollbarX.series.push(series);
  chart.scrollbarX.parent = chart.bottomAxesContainer;

  dateAxis.start = 0.79;
  dateAxis.keepSelection = true;


}); // end am4core.ready()
