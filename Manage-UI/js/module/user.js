var _id;
var un;
var search_id;

function search_user(val) {
	//search_id = document.getElementById('search_u').value;
	var url="http://localhost:8000/selectUserByPage?queryCondition="+val;
	$('#dg').datagrid('options').url=url;
	$('#dg').datagrid('reload');
}

function reset_password() {
	$.ajax({
		url: "http://localhost:8000/resetPassword/" + _id,
		type: 'get',
		cache: false,
		dataType: "json",
		success: function(data) {
			if (data.success == 0) {
				alert("重置密码成功!");
				 $('#dg').datagrid('reload');
				show_user_info();
			} else {
				alert(data.message);
			}

		},
		error: function() {
			alert('请求失败，请检查网络');
		}
	});

}

function un_user() {
	if (un == 1) {
		unable();
	} else {
		able();
	}
}

/* 禁用用户 */
function unable() {
	$.ajax({
		url: "http://localhost:8000/forbiddenUser/" + _id,
		type: 'get',
		cache: false,
		dataType: "json",
		success: function(data) {
			if (data.success == 0) {
				show_user_info();
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

/* 启用用户 */
function able() {
	$.ajax({
		url: "http://localhost:8000/startUser/" + _id,
		type: 'get',
		cache: false,
		dataType: "json",
		success: function(data) {
			if (data.success == 0) {
				show_user_info();
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

/* 请求注册用户详细信息 */
function show_user_info() {
	$.ajax({
		url: "http://localhost:8000/selectUserDetailInfo/" + _id,
		type: 'get',
		cache: false,
		dataType: "json",
		success: function(data) {
			un = data.data.state;
			//$('#password').textbox('setValue',data.data.password);
			
			$("#account").textbox('setValue',data.data.account);
			$("#password").textbox('setValue',data.data.password);
			$("#name").textbox('setValue',data.data.name);
			$("#mobile").textbox('setValue',data.data.mobile);
			$("#weixin").textbox('setValue',data.data.weixin);
			$("#department").textbox('setValue',data.data.department);
			$("#_class").textbox('setValue',data.data._class);
			$("#photo").attr('src', 'http://localhost:8000/images/' + data.data.photo);
			if (data.data.state == 1) {
				$("#state").val("正常");
				$("#un").val("禁用用户");

			} else {
				$("#state").val("禁用");
				$("#un").val("启用用户");
			}


		},
		error: function() {
			alert('请求失败，请检查网络');
		}
	});
}

$(function() {
	//设置请求头token
	$.ajaxSetup({
			headers: {
			         "token":window.sessionStorage.getItem("token")
			}
		});
	$('#dg').datagrid({
		url: ' http://localhost:8000/selectUserByPage',
		method: 'get',
		loadFilter: pagerFilter,
		onClickRow: function(rowIndex, rowData) {
			_id = rowData._id;

			$('#user_info').dialog({
				closable: true,
				closed: false,
				mmodal: false,
				draggable: true,
				chache: false,
			});
			show_user_info();

			console.log(_id);
			console.log(rowIndex);
			console.log(rowData);
		}

	});
});

/* 分页代码*/
function pagerFilter(data) {
	console.log(data);

	//判断data的data字段是否存在,若存在data是源数据
	if (data.hasOwnProperty("data")) {
		/* data = {
			total: data.data.length,
			rows: data.data
		} */
		var newData={
			total: data.data.length,
			rows: []
		};
		for(var i=0;i<data.data.length;i++){
			var oneData={
				"_id": data.data[i]._id,
				"account": data.data[i].account,
				"password": data.data[i].password,
				"name": data.data[i].name,
				"mobile": data.data[i].mobile,
				"weixin": data.data[i].weixin,
				"department": data.data[i].department,
				"_class": data.data[i]._class,
				"photo": data.data[i].photo,
				"register_date": data.data[i].register_date,
				"state": data.data[i].state==1 ? "正常":"禁用",
				"grade": data.data[i].grade
			};
			/* if(data.data[i].state==1){
				oneData.state="正常";
			}else{
				oneData.state="禁止";
			} */
			//console.log(oneData);
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

/* 发送系统通知 */
function show_sys(){
	$('#system_noti').dialog({closed:false});
}

function send_sys_noti(){
	$.ajax({
		   url:"http://localhost:8000/insertSystemMessage",
		   type:'post',
		   data:{
			   "_user":_id,
			   "title":$('#sn_title').val(),
			   "message":$('#sn_message').val()
			   },
		   cache:false,
		   dataType:"json",
		   success: function(data){
				if(data.success==0){
					alert("发送系统消息成功!");
					$('#system_noti').dialog({closed:true});
				}else{
					alert(data.message);
				}				
				
		   },
		   error: function(){
			   alert('请求失败，请检查网络');
		   }
	   });
}