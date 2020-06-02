var appeal_complain_id;
var appeal_sell_seller_id;
var appeal_sell_buyer_id;
var sb_id;//买卖家信息id
var url="http://localhost:8000/selectAllComplainAndResist";
var _thing_id;

$(function(){
	$('#dg').datagrid({
		url: url,
		rownumbers: true,
		singleSelect: true,
		pagination: true,
		fitColumns: true,
		method: 'get',
		loadFilter: pagerFilter,
		columns: [
			[{
					field: 'sell_seller',
					title: '卖家',
					width: 100,
					align: 'center'
				},
				{
					field: 'sell_buyer',
					title: '买家',
					width: 100,
					align: 'center'
				},
				{
					field: 'sell_thingName',
					title: '商品',
					width: 100,
					align: 'center'
				},
				{
					field: 'sell_finishiDate',
					title: '交易日期',
					width: 100,
					align: 'center'
				},
				{
					field: 'complain_date',
					title: '投诉',
					width: 100,
					align: 'center'
				},
				{
					field: 'resist_date',
					title: '申诉',
					width: 100,
					align: 'center'
				}
			]
		],
		onClickRow: function(rowIndex, rowData) {
			appeal_complain_id=rowData.complain_id;
			_thing_id=rowData._thing;
			
			console.log("rowData--->");
			console.log(rowData);
			//判断是否为已调解
			/* if(rowData.hasOwnProperty("_thing")){
				$('#judge').attr('type','button');
				$('#ok_appeal').attr('type','button');
			}else{
				$('#judge').attr('type','hidden');
				$('#ok_appeal').attr('type','hidden');
			} */
			
			$('#dl_apeal_detail').dialog({
				closable: true,
				closed: false,
				mmodal: false,
				draggable: true,
				chache: false,
			});
			
			show_complain_info();
			
			console.log(rowData);
		}
	
	});
});

/* 单选框功能 */
$(function () {
   $("input[name='yn']").click(function (){
	  /* alert($(this).val()); */
	   if($(this).val()==0){
		   url="http://localhost:8000/selectComplainAndResistNoAccepted";
		   $('#dg').datagrid("options").url=url;
		   $('#dg').datagrid('reload');
		   $('#judge').attr('type','button');
		   $('#ok_appeal').attr('type','button');
	   }else if($(this).val()==1){
		   url="http://localhost:8000/selectComplainAndResistWithAccepted";
		   $('#dg').datagrid("options").url=url;
		   $('#dg').datagrid('reload');
		   $('#judge').attr('type','hidden');
		   $('#ok_appeal').attr('type','hidden'); 
	   }else if($(this).val()==2){
		   url="http://localhost:8000/selectAllComplainAndResist";
		   $('#dg').datagrid("options").url=url;
		   $('#dg').datagrid('reload');
		   $('#judge').attr('type','button');
		   $('#ok_appeal').attr('type','button'); 
	   }
	   

	 });
});

/* 投诉详细信息 */
function show_complain_info() {
	$.ajax({
		url: "http://localhost:8000/selectDetailComplainAndResistByComplain_id/"+appeal_complain_id,
		type: 'get',
		cache:false,
		dataType: "json",
		success: function(data) {
			
			if(data.hasOwnProperty("request_buyer_id")){
				appeal_sell_seller_id=data.data.request_seller_id;
				appeal_sell_buyer_id=data.data.request_buyer_id;
				
				
				$("#sell_seller_account").textbox('setValue',data.data.request_seller_account);
				$("#sell_seller_name").textbox('setValue',data.data.request_seller_name);
				$("#sell_buyer_account").textbox('setValue',data.data.request_buyer_account);
				$("#sell_buyer_name").textbox('setValue',data.data.request_buyer_name);
				$("#sell_memo").textbox('setValue',data.data.request_memo);
				$("#sell_trade_date").textbox('setValue',data.data.request_finishiedDate);
				$("#complain_date").textbox('setValue',data.data.complain_date);
				$("#complain_memo").textbox('setValue',data.data.complain_memo);
				$("#resist").textbox('setValue',data.data.resist);
			}else{
				//console.log(data);
				appeal_sell_seller_id=data.data.sell_seller_id;
				appeal_sell_buyer_id=data.data.sell_buyer_id;
				
				
				$("#sell_seller_account").textbox('setValue',data.data.sell_seller_account);
				$("#sell_seller_name").textbox('setValue',data.data.sell_seller_name);
				$("#sell_buyer_account").textbox('setValue',data.data.sell_buyer_account);
				$("#sell_buyer_name").textbox('setValue',data.data.sell_buyer_name);
				$("#sell_memo").textbox('setValue',data.data.sell_memo);
				$("#sell_trade_date").textbox('setValue',data.data.sell_finishiDate);
				$("#complain_date").textbox('setValue',data.data.complain_date);
				$("#complain_memo").textbox('setValue',data.data.complain_memo);
				$("#resist").textbox('setValue',data.data.resist);
			}
		},
		error: function() {
			alert('请求失败，请检查网络');
		}
	});
}
/* 设置为已调解 */
function isOK(){
	$.ajax({
			   url:"http://localhost:8000/updateStateToAccepted/"+appeal_complain_id,
			   type:'get',
			   cache:false,
			   dataType:"json",
			   success: function(data){
					if(data.success==0){
						alert("设置已调解成功");
					}else{
						alert(data.message);
					}				
					
			   },
			   error: function(){
				   alert('请求失败，请检查网络');
			   }
		   });
}
/* 查看买卖家信息 */
function show_s(){
	sb_id=appeal_sell_seller_id;
	show_info();
}
function show_b(){
	sb_id=appeal_sell_buyer_id;
	show_info();
}
function show_info(){
	$('#appeal_user_info').dialog({
		closable: true,
		closed: false,
		mmodal: false,
		draggable: true,
		chache: false,
	});
	$.ajax({
		url:"http://localhost:8000/selectUserDetailInfo/"+sb_id,
		type:'get',
		cache:false,
		dataType:"json",
		success: function(data){
			
			
			$("#account").textbox('setValue',data.data.account);
			$("#password").textbox('setValue',data.data.password);
			$("#name").textbox('setValue',data.data.name);
			$("#mobile").textbox('setValue',data.data.mobile);
			$("#weixin").textbox('setValue',data.data.weixin);
			$("#department").textbox('setValue',data.data.department);
			$("#_class").textbox('setValue',data.data._class);
			$("#photo").attr('src','http://localhost:8000/images/'+data.data.photo);
			if(data.data.state==1){
				$("#state").val("正常");
			}else{
				$("#state").val("禁用");
			}
			
			
		},
		error: function(){
			alert('请求失败，请检查网络');
		}
	});
}

/* 分页代码*/
function pagerFilter(data) {
	/* console.log("da");
	console.log(data); */
	
	

	//判断data的data字段是否存在,若存在data是源数据
	if (!data.hasOwnProperty("total")) {
		//console.log(1);
		/* 处理服务器返回的json数据 */
		var newData={
			total: data.data.length,
			rows: []
		}
		for(var i=0;i<data.data.length;i++){
			/* 是否为需求商品类型*/
			if(!data.data[i].hasOwnProperty("request_thingName")){
				//console.log(1.1);
				//console.log(data.rows[i]);
				//newData.rows.push(data.rows[i]);
				var oneData={
					"_thing": data.data[i]._thing,
					"resist_date": data.data[i].resist_date,
					"complain_id": data.data[i].complain_id,
					"sell_buyer": data.data[i].sell_buyer,
					"complain_date": data.data[i].complain_date,
					"sell_thingName": data.data[i].sell_thingName,
					"sell_finishiDate": data.data[i].sell_finishiDate,
					"sell_seller": data.data[i].sell_seller
				};
				if(data.data[i].resist_date!=null){
					oneData.resist_date="是";
				}else{
					oneData.resist_date="否";
				}
				if(data.data[i].complain_date!=null){
					oneData.complain_date="是";
				}else{
					oneData.complain_date="否";
				}
				newData.rows.push(oneData);
			}else{
				
				var oneData={
					"_thing": data.data[i]._thing,
					"resist_date": data.data[i].resist_date,
					"complain_id": data.data[i].complain_id,
					"sell_buyer": data.data[i].request_buyer,
					"complain_date": data.data[i].complain_date,
					"sell_thingName": data.data[i].request_thingName,
					"sell_finishiDate": data.data[i].request_finishiedDate,
					"sell_seller": data.data[i].request_seller
				};
				if(data.data[i].resist_date!=null){
					oneData.resist_date="是";
				}else{
					oneData.resist_date="否";
				}
				if(data.data[i].complain_date!=null){
					oneData.complain_date="是";
				}else{
					oneData.complain_date="否";
				}
				//console.log("oneData");
				//console.log(oneData);
				newData.rows.push(oneData);
			}
		}
		
		data=newData;
		
	}else(
		//console.log(2);
		data = {
			originalRows: data.originalRows,
			total: data.total,
			rows: data.rows
		}
	)
	
	//console.log(data);
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


/* 发送仲裁结果 */
function show_r(){
	$('#sead_judge').dialog({
		closable: true,
		closed: false,
		mmodal: false,
		draggable: true,
		chache: false,
	});
}
function send_judge(){
	
	$.ajax({
		   url:"http://localhost:8000/insertJudgeResult",
		   type:'post',
		   data:{
			   "_complain":appeal_complain_id,
			   "judge":$('#judgeResult').val(),
			   "thing_id":_thing_id
			   },
		   cache:false,
		   dataType:"json",
		   success: function(data){
				if(data.success==0){
					alert("发送仲裁通知成功!");
					$('#sead_judge').dialog({closed:true});
				}else{
					alert(data.message);
				}				
				
		   },
		   error: function(){
			   alert('请求失败，请检查网络');
		   }
	   });
}