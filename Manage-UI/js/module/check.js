var seller_id; //售卖商品售卖者id
var acomplain_id; //complain表的主键id字段
var un_sell_seller_id; //禁用卖家用户id
var url;

/* 不诚信页面 */
$(function() {
	//设置请求头token
	$.ajaxSetup({
			headers: {
			         "token":window.sessionStorage.getItem("token")
			}
		});
	$('#dg').datagrid({
		url: 'http://localhost:8000/selectUnhonestUser?pageNo=1&pageSize=20',
		// onBeforeLoad: function(request){
		// 	request.setRequestHeader("token",window.sessionStorage.token);
		// 	console.log("window.sessionStorage.token");
		// },
		//headers:{token:window.sessionStorage.token},
		rownumbers: true,
		singleSelect: true,
		pagination: true,
		fitColumns: true,
		method: 'get',
		loadFilter: pagerFilter,
		columns: [
			[{
					field: 'sell_seller_account',
					title: '账号',
					width: 100,
					align: 'center'
				},
				{
					field: 'sell_seller_name',
					title: '真实名字',
					width: 100,
					align: 'center'
				},
				{
					field: 'sell_seller_mobile',
					title: '联系电话',
					width: 100,
					align: 'center'
				},
				{
					field: 'sell_seller_department',
					title: '所属院系',
					width: 100,
					align: 'center'
				},
				{
					field: 'sell_seller_class',
					title: '班级',
					width: 100,
					align: 'center'
				},
				{
					field: 'sell_seller_state',
					title: '状态',
					width: 100,
					align: 'center'
				}
			]
		],
		onClickRow: function(rowIndex, rowData) {
			seller_id = rowData.sell_seller_id;

			$('#dd_Dialog').dialog({
				closable: true,
				closed: false,
				mmodal: false,
				draggable: true,
				chache: false,
			});
			isSelect();

			//console.log(rowData);
		}

	});
});


/* 到期不接受交易 */
function isSelect() {
	$('#dg_deal').datagrid({
		url: 'http://localhost:8000/selectDetailUnhonestUser/' + seller_id,
		rownumbers: true,
		singleSelect: true,
		pagination: true,
		fitColumns: true,
		method: 'get',
		loadFilter: function(data) {
			if (data.hasOwnProperty('data')) {
				var newData = {
					total:data.data.length,
					rows:[]
				}
				for(var i=0;i<data.data.length;i++){
					var oneData={
						"sell_buyer_name": data.data[i].sell_buyer_name,
						"complain_id": data.data[i].complain_id,
						"sell_seller_name": data.data[i].sell_seller_name,
						"isAccepted": 1,
						"sell_trade_date": data.data[i].sell_trade_date,
						"sell_thing_name": data.data[i].sell_thing_name
					}
					if(data.data[i].isAccepted==1){
						oneData.isAccepted="接受调解";
					}else{
						oneData.isAccepted="不接受调解";
					}
					newData.rows.push(oneData);
				}
				data=newData;
			} else {
				data = {
					originalRows: data.originalRows,
					total: data.total,
					rows: data.rows
				}
			}
			return data;
		},
		columns: [
			[{
					field: 'sell_seller_name',
					title: '卖家',
					width: 40,
					align: 'center'
				},
				{
					field: 'sell_buyer_name',
					title: '买家',
					width: 40,
					align: 'center'
				},
				{
					field: 'sell_thing_name',
					title: '商品名称',
					align: 'center'

				},
				{
					field: 'sell_trade_date',
					title: '交易日期',

				},
				{
					field: 'isAccepted',
					title: '不诚信类型',
					align: 'center'

				}
			]
		],
		onClickRow: function(rowIndex, rowData) {
			acomplain_id = rowData.complain_id;

			$('#dl_detail').dialog({
				closable: true,
				closed: false,
				mmodal: false,
				draggable: true,
				chache: false,
			});

			show_unhonest_info()
			console.log('acomplain_id');
			console.log(acomplain_id);
		}

	});
}



/* 不诚信交易详细信息 */
function show_unhonest_info() {
	$.ajax({
		url: "http://localhost:8000/selectUnhonestTradeDetail/" + acomplain_id,
		type: 'get',
		cache: false,
		dataType: "json",
		success: function(data) {
			console.log("xiangxi:");
			console.log(data);
			un_sell_seller_id = data.data.sell_seller_id

			$("#sell_seller_account").textbox('setValue',data.data.sell_seller_account);
			$("#sell_seller_name").textbox('setValue',data.data.sell_seller_name);
			$("#sell_buyer_account").textbox('setValue',data.data.sell_buyer_account);
			$("#sell_buyer_name").textbox('setValue',data.data.sell_buyer_name);
			$("#sell_memo").textbox('setValue',data.data.sell_memo);
			$("#sell_trade_date").textbox('setValue',data.data.sell_trade_date);
			$("#complain_date").textbox('setValue',data.data.complain_date);
			$("#complain_memo").textbox('setValue',data.data.complain_memo);
			$("#resist").textbox('setValue',data.data.resist);

		},
		error: function() {
			alert('请求失败，请检查网络');
		}
	});
}

/* 禁用卖家用户 */
function unable_seller() {
	$.ajax({
		url: "http://localhost:8000/forbiddenUser/" + un_sell_seller_id,
		type: 'get',
		cache: false,
		dataType: "json",
		success: function(data) {
			if (data.success == 0) {
				alert("禁用卖家用户成功");
				$('#dg').datagrid('reload');
			} else {
				alert(data.message);
			}

		},
		error: function() {
			alert('请求失败，请检查网络');
		}
	});
}

/* 搜索用户 */
function search_cuser(val) {
	//13817817
	//var search_uid=$('#search_u').val();
	url = "http://localhost:8000/selectUnhonestUser?queryCondition=" + val;
	$('#dg').datagrid('options').url = url;
	$('#dg').datagrid('reload');

}

/* 分页代码*/
function pagerFilter(data) {
	console.log(data);

	//判断data的data字段是否存在,若存在data是源数据
	if (data.hasOwnProperty("data")) {
		var newData = {
			total: data.data.length,
			rows: []
		}
		for (var i = 0; i < data.data.length; i++) {
			var oneData = {
				"sell_seller_account": data.data[i].sell_seller_account,
				"sell_seller_name": data.data[i].sell_seller_name,
				"sell_seller_id": data.data[i].sell_seller_id,
				"sell_seller_department": data.data[i].sell_seller_department,
				"sell_seller_mobile": data.data[i].sell_seller_mobile,
				"sell_seller_class": data.data[i].sell_seller_class,
				"sell_seller_state": 1
			}
			if (data.data[i].sell_seller_state == 1) {
				oneData.sell_seller_state = "正常";
			} else {
				oneData.sell_seller_state = "禁用";
			}
			newData.rows.push(oneData);
		}
		data = newData;
	} else {
		data = {
			originalRows: data.originalRows,
			total: data.total,
			rows: data.rows
		}
	}

	console.log(data);
	var dg = $(this);
	var opts = dg.datagrid('options');
	var pager = dg.datagrid('getPager');
	pager.pagination({
		onSelectPage: function(pageNum, pageSize) {
			opts.pageNumber = pageNum;
			opts.pageSize = pageSize;
			pager.pagination('refresh', {
				pageNumber: pageNum,
				pageSize: pageSize
			});
			dg.datagrid('loadData', data);
		}
	});
	if (!data.originalRows) {
		data.originalRows = (data.rows);
	}
	var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = (data.originalRows.slice(start, end));
	return data;
}
