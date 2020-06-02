var us_year = 2019;
var bs_year = 2019;
var td_year = 2019;

/* 注册用户信息统计 */
$(function user_info() {

	/* 注册用户信息统计 */
	$.get("http://localhost:8000/selectUserCountsByMonth", {
		"year": us_year
	}, function(data) {
		// data 为服务器返回的数据
		//console.log(data);

		var user_series = {
			name: '注册用户数',
			data: []
		};


		user_series.data.push(data.register.one, data.register.two, data.register.three, data.register.four,
			data.register.five, data.register.six, data.register.seven, data.register.eight, data.register
			.nine, data.register.ten, data.register.eleven, data.register.twelve);


		//console.log(user_series);
		var chart = Highcharts.chart('ur_container', {
			chart: {
				type: 'area'
			},
			title: {
				text: '注册用户信息统计'
			},
			subtitle: {
				useHTML: true,
				text: '<input id="uinfo"  name="dept" style="width: 110px;height: 15px;">'
			},
			xAxis: {
				categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
			},
			yAxis: {
				min: 0,
				title: {
					text: '数量/人'
				}
			},
			tooltip: {
				pointFormat: '{series.name}<b>{point.y:,.0f}</b>人'
			},
			plotOptions: {
				/* area: {
					pointStart: 1940,
					marker: {
						enabled: false,
						symbol: 'circle',
						radius: 2,
						states: {
							hover: {
								enabled: true
							}
						}
					}
				} */
			},
			series: [user_series]
		});

		$('#uinfo').combobox({
			url: '../json/combobox_data.json',
			method: 'get',
			valueField: 'id',
			textField: 'text',
			onSelect: function(record) {
				us_year = record.value;
				user_info();
				
			}
		}).combobox('setValue', us_year + '年数据');



	});
});

/* 售卖/需求信息统计 */
$(function bs_info() {

	$.get("http://localhost:8000/selectThingsAndRequestCountByMonth", {
		"year": bs_year
	}, function(data) {
		// data 为服务器返回的数据

		var request_series = {
			name: '需求',
			data: []
		};

		var sell_series = {
			name: '售卖',
			data: []
		};

		//console.log(data);
		request_series.data.push(data.request.one, data.request.two, data.request.three, data.request.four,
			data.request.five, data.request.six, data.request.seven, data.request.eight, data.request.nine,
			data.request.ten, data.request.eleven, data.request.twelve);

		sell_series.data.push(data.sell.one, data.sell.two, data.sell.three, data.sell.four, data.sell.five,
			data.sell.six, data.sell.seven, data.sell.eight, data.sell.nine, data.sell.ten, data.sell.eleven,
			data.sell.twelve);

		/* 售卖/需求信息统计 */
		var chart = Highcharts.chart('sn_container', {
			chart: {
				type: 'line'
			},
			title: {
				text: '售卖/需求信息统计'
			},
			subtitle: {
				useHTML: true,
				text: '<input id="sinfo"  name="dept" style="width: 110px;height: 15px;">'
			},
			xAxis: {
				categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
			},
			yAxis: {
				title: {
					text: '数量/件'
				}
			},
			plotOptions: {
				line: {
					dataLabels: {
						// 开启数据标签
						enabled: true
					},
					// 关闭鼠标跟踪，对应的提示框、点击事件会失效
					enableMouseTracking: true
				}
			},
			series: [request_series, sell_series]
		});

		$('#sinfo').combobox({
			url: '../json/combobox_data.json',
			method: 'get',
			valueField: 'id',
			textField: 'text',
			onSelect: function(record) {
				bs_year = record.value;
				bs_info();
				//console.log(bs_year)
			}
		}).combobox('setValue', bs_year + '年数据');

	});
});

/* 交易信息统计 */
$(function td_info() {
	console.log("jiao:");
	$.get("http://localhost:8000/selectTradeSituationByMonth", {
		"year": td_year
	}, function(data) {
		// data 为服务器返回的数据

		console.log("jiao:");
		console.log(data);

		var requestNoDeal_series = {
			name: '需求未交易',
			data: []
		};
		var requestDeal_series = {
			name: '需求已交易',
			data: []
		};

		var sellNoDeal_series = {
			name: '售卖未交易',
			data: []
		};
		var sellDeal_series = {
			name: '售卖已交易',
			data: []
		};


		requestNoDeal_series.data.push(data.requestNoDeal.one, data.requestNoDeal.two, data.requestNoDeal.three,
			data.requestNoDeal.four, data.requestNoDeal.five, data.requestNoDeal.six, data.requestNoDeal.seven,
			data.requestNoDeal.eight, data.requestNoDeal.nine, data.requestNoDeal.ten, data.requestNoDeal.eleven,
			data.requestNoDeal.twelve);

		requestDeal_series.data.push(data.requestDeal.one, data.requestDeal.two, data.requestDeal.three, data
			.requestDeal.four, data.requestDeal.five, data.requestDeal.six, data.requestDeal.seven, data.requestDeal.eight,
			data.requestDeal.nine, data.requestDeal.ten, data.requestDeal.eleven, data.requestDeal
			.twelve);

		sellNoDeal_series.data.push(data.sellNodeal.one, data.sellNodeal.two, data.sellNodeal.three, data.sellNodeal.four,
			data.sellNodeal.five, data.sellNodeal.six, data.sellNodeal.seven, data.sellNodeal.eight,
			data.sellNodeal.nine, data.sellNodeal.ten, data.sellNodeal.eleven, data.sellNodeal.twelve);

		sellDeal_series.data.push(data.sellDeal.one, data.sellDeal.two, data.sellDeal.three, data.sellDeal
			.four, data.sellDeal.five, data.sellDeal.six, data.sellDeal.seven, data.sellDeal.eight, data.sellDeal.nine,
			data.sellDeal.ten, data.sellDeal.eleven, data.sellDeal.twelve);

		/* 交易信息统计 */
		var chart = Highcharts.chart('td_container', {
			chart: {
				type: 'column'
			},
			title: {
				text: '交易信息统计'
			},
			subtitle: {
				useHTML: true,
				text: '<input id="tinfo"  name="dept" style="width: 110px;height: 15px;">'
			},
			xAxis: {
				categories: [
					'一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'
				],
				crosshair: true
			},
			yAxis: {
				min: 0,
				title: {
					text: '数量/件'
				}
			},
			tooltip: {
				// head + 每个 point + footer 拼接成完整的 table
				headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
				pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
					'<td style="padding:0"><b>{point.y:.1f} 件</b></td></tr>',
				footerFormat: '</table>',
				shared: true,
				useHTML: true
			},
			plotOptions: {
				column: {
					borderWidth: 0
				}
			},
			series: [requestNoDeal_series, requestDeal_series, sellNoDeal_series, sellDeal_series]
		});


		$('#tinfo').combobox({
			url: '../json/combobox_data.json',
			method: 'get',
			valueField: 'id',
			textField: 'text',
			onSelect: function(record) {
				td_year = record.value;
				//user_series.data.length=0;
				td_info();
				console.log(td_year)
			}
		}).combobox('setValue', td_year + '年数据');

	});
});

/* 第四块 */

$(function() {
	Highcharts.chart('mo_container', {
		chart: {
			type: 'pyramid3d',
			options3d: {
				enabled: true,
				alpha: 10,
				depth: 50,
				viewDistance: 50
			}
		},
		title: {
			text: '用户等级'
		},
		plotOptions: {
			series: {
				dataLabels: {
					enabled: true,
					format: '<b>{point.name}</b> ({point.y:,.0f})人',
					color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black',
					allowOverlap: true,
					x: 10,
					y: -5
				},
				width: '60%',
				height: '80%',
				center: ['50%', '45%']
			}
		},
		series: [{
			name: '用户数量',
			data: [
				['0级', 20],
				['1级', 15],
				['2级', 14],
				['3级', 11],
				['4级', 10]
			]
		}]
	});

});
