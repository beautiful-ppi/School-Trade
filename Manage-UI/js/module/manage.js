var muser_id;

/* 分页代码*/
function pagerFilter(data) {
	//console.log(data);

	//判断data的data字段是否存在,若存在data是源数据
	if (data.hasOwnProperty("data")) {
		var newData = {
			total: data.data.length,
			rows: []
		}
		for (var i = 0; i < data.data.length; i++) {
			var oneData = {
				"_id": data.data[i]._id,
				"account": data.data[i].account,
				"password": data.data[i].password,
				"name": data.data[i].name,
				"mobile": data.data[i].mobile,
				"weixin": data.data[i].weixin,
				"photo": data.data[i].photo,
				"create_date": data.data[i].create_date,
				"level": 2,
				"state": 1
			}
			if (data.data[i].level == 1) {
				oneData.level = "超级管理员";
			} else {
				oneData.level = "普通管理员";
			}
			if (data.data[i].state == 1) {
				oneData.state = "正常";
			} else {
				oneData.state = "禁用";
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

	//console.log(data);
	var dg = $(this);
	var opts = dg.datagrid('options');
	var pager = dg.datagrid('getPager');
	pager.pagination({

		buttons: [{
			iconCls: 'icon-add',
			handler: function() {
				$('#dl_manage_add').dialog({
					closable: true,
					closed: false,
					mmodal: false,
					draggable: true,
					chache: false,
				});
			}
		}],
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

$(function() {
	$('#dg').datagrid({
		url: 'http://localhost:8000/selectAdminByPage',
		rownumbers: true,
		// headers:{token:window.sessionStorage.token},
		singleSelect: true,
		pagination: true,
		fitColumns: true,
		method: 'get',
		loadFilter: pagerFilter,
		columns: [
			[{
					field: 'account',
					title: '账号',
					width: 100,
					align: "center"
				},
				{
					field: 'name',
					title: '姓名',
					width: 100,
					align: "center"
				},
				{
					field: 'weixin',
					title: '微信',
					width: 100,
					align: "center"
				},
				{
					field: 'mobile',
					title: '联系电话',
					width: 100,
					align: "center"
				},
				{
					field: 'create_date',
					title: '注册时间',
					width: 100,
					align: "center"
				},
				{
					field: 'level',
					title: '权限级别',
					width: 100,
					align: "center"
				},
				{
					field: 'state',
					title: '状态',
					width: 100,
					align: "center"
				}
			]
		],
		onClickRow: function(rowIndex, rowData) {
			muser_id = rowData._id;
			$('#dl_manage_detail').dialog({
				closable: true,
				closed: false,
				mmodal: false,
				draggable: true,
				chache: false,
			});
			show_user_info();
			console.log("user" + muser_id);
		}

	});

	/* var pager = $('#dg').datagrid().datagrid('getPager');
	pager.pagination({
		pageSize:3,
		pageList: [3,5,10,15],
		buttons: [{
			iconCls: 'icon-add',
			handler: function() {
				$('#dl_manage_add').dialog({
					closable: true,
					closed: false,
					mmodal: false,
					draggable: true,
					chache: false,
				});
			}
		}]
	}); */
});

/* 显示详细信息 */
function show_user_info() {
	$.ajax({
		url: "http://localhost:8000/selectDetailManageById/" + muser_id,
		type: 'get',
		data: {},
		cache: false,
		dataType: "json",
		success: function(data) {
			console.log(data);
			$("#dt_account").val(data.data.account);
			$("#dt_password").val(data.data.password);
			$("#dt_name").val(data.data.name);
			$("#dt_mobile").val(data.data.mobile);
			$("#dt_weixin").val(data.data.weixin);

			$("#img").attr('src', 'http://localhost:8000/images/' + data.data.photo);
			if (data.data.level == 1) {
				$("#dt_level").val("超级管理员");
			} else {
				$("#dt_level").val("普通管理员");
			}


		},
		error: function() {
			alert('请求失败，请检查网络');
		}
	});
}
/* 新建管理 */

function new_manage() {
	//$("#account").value;
	//alert($("#account").val());
	var formData = new FormData();
	formData.append('account', $("#account").val());
	formData.append('password', $("#password").val());
	formData.append('name', $("#name").val());
	formData.append('mobile', $("#mobile").val());
	formData.append('weixin', $("#weixin").val());
	formData.append('photo', $('#photo')[0].files[0]);
	/* var newData={
		"account":$("#account").val(),
		"password":$("#password").val(),
		"name":$("#name").val(),
		"mobile":$("#mobile").val(),
		"weixin":$("#weixin").val(),
		"photo":$("#photo")[0].files[0]
		} */
	//console.log(newData);
	var act = $("#account").val();
	var psd = $("#password").val();
	if (act === null || act === "" || psd === null || psd === "") {
		alert("请输入账号或者密码")
	} else {
		$.ajax({

			url: 'http://localhost:8000/insertAdminastrator',
			data: formData,
			type: 'post',
			cache: false,
			processData: false,
			contentType: false,
			dataType: 'json',
			success: function(data) {
				console.log(data)
				if (data.success == 0) {
					alert("新建管理员成功");
					$('#dl_manage_add').dialog({
						closed: true
					});
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

}

/* 修改 */
function d_modify() {
	var formData = new FormData();
	formData.append('password', $("#dt_password").val());
	formData.append('name', $("#dt_name").val());
	formData.append('mobile', $("#dt_mobile").val());
	formData.append('weixin', $("#dt_weixin").val());
	formData.append('photo', $('#dt_photo')[0].files[0]);
	formData.append('_id', muser_id);

	$.ajax({
		url: 'http://localhost:8000/updateManager',
		data: formData,
		type: 'post',
		cache: false,
		processData: false,
		contentType: false,
		dataType: 'json',
		success: function(data) {
			console.log(data)
			if (data.success == 0) {
				alert("修改用户管理员成功!");
				$('#dl_manage_detail').dialog({
					closed: true
				});
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
/* 删除 */
function d_delete() {

	$.ajax({
		url: 'http://localhost:8000/deleteManagerById/' + muser_id,
		type: 'get',
		cache: false,
		processData: false,
		contentType: false,
		dataType: 'json',
		success: function(data) {
			console.log(data)
			if (data.success == 0) {
				alert("删除管理员成功!");
				$('#dl_manage_detail').dialog({
					closed: true
				});
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
/* 上传图片预览功能 */
$(function() {
	//在input file内容改变的时候触发事件
	$('#photo').change(function() {
		//获取input file的files文件数组;
		//$('#filed')获取的是jQuery对象，.get(0)转为原生对象;
		//这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
		var file = $('#photo').get(0).files[0];
		//创建用来读取此文件的对象
		var reader = new FileReader();
		//使用该对象读取file文件
		reader.readAsDataURL(file);
		//读取文件成功后执行的方法函数
		reader.onload = function(e) {
			//读取成功后返回的一个参数e，整个的一个进度事件
			console.log(e);
			//选择所要显示图片的img，要赋值给img的src就是e中target下result里面
			//的base64编码格式的地址
			$('#imgshow').get(0).src = e.target.result;
		}
	})

	/* 鼠标移入弹出提示信息 */

	$('#photo').tooltip({
		position: 'right',
		content: '<span style="color:#fff">点击选择上传文件</span>',
		onShow: function() {
			$(this).tooltip('tip').css({
				backgroundColor: '#666',
				borderColor: '#666',
			});
		}
	});

	$('#dt_photo').change(function() {
		//获取input file的files文件数组;
		//$('#filed')获取的是jQuery对象，.get(0)转为原生对象;
		//这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
		var file = $('#dt_photo').get(0).files[0];
		//创建用来读取此文件的对象
		var reader = new FileReader();
		//使用该对象读取file文件
		reader.readAsDataURL(file);
		//读取文件成功后执行的方法函数
		reader.onload = function(e) {
			//读取成功后返回的一个参数e，整个的一个进度事件
			console.log(e);
			//选择所要显示图片的img，要赋值给img的src就是e中target下result里面
			//的base64编码格式的地址
			$('#img').get(0).src = e.target.result;
		}
	})

	/* 鼠标移入弹出提示信息 */
	/* $('#dt_photo').mouseover(function(){
		//alert("获取焦点");
		console.log("鼠标移入");
	}); */
	$('#dt_photo').tooltip({
		position: 'right',
		content: '<span style="color:#fff">点击选择上传文件</span>',
		onShow: function() {
			$(this).tooltip('tip').css({
				backgroundColor: '#666',
				borderColor: '#666',
			});
		}
	});
});

/* 点击清空功能*/
/* function btn_clear() {
	$("input").click(function() {
		var ip_id=$(this).attr("id")
		$('#'+ip_id).val("");
		//console.log(val)
	})
}
 */