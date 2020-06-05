var req_id;
var _user_id;
var _thing_id;

var _matchCount;

$(function() {
	//设置请求头token
	$.ajaxSetup({
			headers: {
			         "token":window.sessionStorage.getItem("token")
			}
		});
	$('#dg').datagrid({
		url: 'http://localhost:8000/selectAllRequestMatchInfo',
		rownumbers: true,
		singleSelect: true,
		pagination: true,
		fitColumns: true,
		method: 'get',
		loadFilter: function(data) {


			var value = {
				"total": data.data.length,
				"rows": data.data
			};

			return value;
		},
		columns: [
			[{
					field: 'account',
					title: '账号',
					width: 100,
					align: "center"
				},
				{
					field: 'name',
					title: '真实名字',
					width: 100,
					align: "center"
				},
				{
					field: 'thing_name',
					title: '商品名称',
					width: 100,
					align: "center"
				},
				{
					field: 'publish_date',
					title: '需求发布日期',
					width: 100,
					align: "center"
				},
				{
					field: 'matchCount',
					title: '匹配数目',
					width: 100,
					align: "center"
				}
			]
		],
		onClickRow: function(rowIndex, rowData) {
			req_id = rowData.request_id;
			_matchCount = rowData.matchCount;
			//console.log(_matchCount);
			$('#dl_need_detail').dialog({
				closable: true,
				closed: false,
				mmodal: false,
				draggable: true,
				chache: false,
			});

			show_need_info();
			/* console.log(req_id);
			console.log(rowData); */
		}

	});
});


function show_need_info() {
	//console.log(_matchCount);
	//const time = new Date().getTime()
	//+"?"+new Date().toTimeString()
	/* beforeSend: function(xmlHttp) {
			xmlHttp.setRequestHeader("If-Modified-Since", "0");
			xmlHttp.setRequestHeader("Cache-Control", "no-cache");
		}, */
	/* 解决form表单后面所有元素重复添加 */
	document.getElementById('show_info').innerHTML = "";
	$.ajax({
		url: "http://localhost:8000/selectDetailRequestMatchBy_id/" + req_id,
		type: 'get',
		cache: false,
		dataType: "json",
		success: function(data) {
			console.log(data);
			var _Columns = _matchCount;

			var form = document.getElementById('show_info');
			//var tb=document.getElementById('show');
			//$("#show_info").next().nextAll().remove();
			for (var i = 0; i < _Columns; i++) {
				/* var tr = document.createElement('tr')
				var th = document.createElement('th');
				th.innerHTML = '<input type="checkbox" value="1" onclick="ccb()" id="glhdcheckbox2" name="glhdcheckbox2">';
				tr.appendChild(th);
				tb.tBodies[0].appendChild(tr); */

				var bigdiv = document.createElement('div');
				bigdiv.style = "border-bottom:3px #CC2222 solid;";
				form.appendChild(bigdiv);
				
				var div = document.createElement('div');
				bigdiv.appendChild(div);
				div.style="margin-left:14px; ";
				var label = document.createElement('label');
				label.style="background: #FFE48D;font-size: 14px;border-radius: 5px;";
				label.innerHTML = "售卖者账号:";
				div.appendChild(label);
				var input = document.createElement('input');
				input.id = "seller_account" + i;
				input.style="margin-left:10px;border: none;font-size: 16px;font-family: 'book antiqua';";
				input.type = "text";
				input.readOnly = true;
				label.after(input);

				var div = document.createElement('div');
				bigdiv.appendChild(div);
				div.style="margin-left:14px;margin-top:10px; ";
				var label = document.createElement('label');
				label.style="background: #FFE48D;font-size: 14px;border-radius: 5px;";
				label.innerHTML = "售卖者姓名:";
				div.appendChild(label);
				var input = document.createElement('input');
				input.style="margin-left:10px;border: none;font-size: 16px;font-family: 'book antiqua';";
				input.id = "seller_name" + i;
				input.type = "text";
				input.readOnly = true;
				label.after(input);

				var div = document.createElement('div');
				bigdiv.appendChild(div);
				div.style="margin-top:10px; ";
				var label = document.createElement('label');
				label.style="background: #FFE48D;font-size: 14px;border-radius: 5px;";
				label.innerHTML = "商品新旧程度:";
				div.appendChild(label);
				var input = document.createElement('input');
				input.style="margin-left:10px;border: none;font-size: 16px;font-family: 'book antiqua';";
				input.id = "new_old" + i;
				input.type = "text";
				input.readOnly = true;
				label.after(input);

				var div = document.createElement('div');
				bigdiv.appendChild(div);
				div.style="margin-left:28px;margin-top:10px; ";
				var label = document.createElement('label');
				label.style="background: #FFE48D;font-size: 14px;border-radius: 5px;";
				label.innerHTML = "发布日期:";
				div.appendChild(label);
				var input = document.createElement('input');
				input.style="margin-left:10px;border: none;font-size: 16px;font-family: 'book antiqua';";
				input.id = "publish_date" + i;
				input.type = "text";
				input.readOnly = true;
				label.after(input);

				var div = document.createElement('div');
				bigdiv.appendChild(div);
				div.style="margin-left:28px; margin-top:10px;";
				var label = document.createElement('label');
				label.style="background: #FFE48D;font-size: 14px;border-radius: 5px;";
				label.innerHTML = "商品描述:";
				div.appendChild(label);
				var input = document.createElement('input');
				input.style="margin-left:10px;border: none;font-size: 16px;font-family: 'book antiqua';";
				input.id = "memo" + i;
				input.type = "text";
				input.readOnly = true;
				label.after(input);
				
				var div = document.createElement('div');
				bigdiv.appendChild(div);
				div.style="margin-top:10px;";
				var input_btn = document.createElement('input');
				input_btn.style="margin-left:80px;background: #E0ECFF;border-radius: 5px;border: none;font-size: 16px; ";
				input_btn.id = "btn";
				input_btn.type = "button";
				input_btn.value = "发送通知";
				input_btn.name = i;
				input_btn.onclick = function() {
					/* var _user_id=document.getElementById('_user');
					var _thing_id=document.getElementById('_user'); */
					_user_id = data.data[this.name].request_owner;
					_thing_id = data.data[this.name].thing_id;
					console.log(_user_id, _thing_id)
					$('#dl_need_show').dialog({
						closable: true,
						closed: false,
						mmodal: false,
						draggable: true,
						chache: false,
					});
				};
				//input_btn.addEventListener("click",send_inform()); 
				div.appendChild(input_btn);

				/* div.innerHTML='<input id="btn" name=i type="button" value="发送通知" onclick="send_inform()">'; */
				/* var btn=document.getElementById("btn");
				btn.name=i; */


				/* ajax加载数据,填充数据 */
				$("#seller_account" + i).val(data.data[i].seller_account);
				$("#seller_name" + i).val(data.data[i].seller_name);
				$("#new_old" + i).val(data.data[i].new_old);
				$("#publish_date" + i).val(data.data[i].publish_date);
				$("#memo" + i).val(data.data[i].memo);

			}



		},
		error: function() {
			alert('请求失败，请检查网络');
		}
	});
}

/* 发送通知 */
function send_user_inform() {
	var title = document.getElementById('tl').value;
	var message = document.getElementById('mg').value;
	$.ajax({
		url: 'http://localhost:8000/sendToUser',
		dataType: 'json',
		type: "post",
		cache: false,
		async: "true",
		data: {
			"_user": _user_id,
			"_thing": _thing_id,
			"title": title,
			"message": message
		},
		success: function(data) {
			if (data.success == 0) {
				alert("发送通知成功!");
				$('#dl_need_show').dialog({
					closed: true
				});
			} else {
				alert(data.message);
			}
			console.log(data);
			//alert(data.message);
		},
		error: function() {
			alert("请求失败")
		}
	});

}
