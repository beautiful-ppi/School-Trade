var bs_year=2019;
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