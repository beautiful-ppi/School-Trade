//获取token
var token=window.sessionStorage.getItem("token");

$(function () {
	
	
	
	//console.log(document.cookie)
	var manData;
	var name=getCookie();
	document.getElementById("who").innerHTML=name;
	// if(name==null){
	// 	window.location.href="login.html";
	// }
	
	if(name=="admin"){
		console.log(getCookie());
		manData=[{
				text: '注册用户管理',
				iconCls : 'icon-man',
				value: '1'
			}, {
				text: '投诉及申诉管理',
				iconCls : 'icon-tip',
				value: '2'
			}, {
				text: '管理用户管理',
				iconCls: 'icon-man',
				value: '3'
			}];
	}else{
		manData=[{
				text: '注册用户管理',
				iconCls : 'icon-man',
				value: '1'
			}, {
				text: '投诉及申诉管理',
				iconCls : 'icon-tip',
				value: '2'
			}];
	}
	
	$('#LeftMenu').sidemenu({
		data: [{
			text: '管理模块',
			iconCls: 'icon-sum',
			state: 'open',
			children: manData
		}, {
			text: '其他模块',
			iconCls: 'icon-more',
			children: [{
				text: '不诚信用户检测',
				iconCls: 'icon-man',
				value: '4'
			}, {
				text: '售卖及需求匹配',
				iconCls: 'icon-tip',
				value: '5'
			}, {
				text: '信息统计',
				iconCls: 'icon-large-chart',
				value: '6'
			}]
		}],
		
		onSelect: onSideMenuSelect,
		border: false
	});
});

function onSideMenuSelect(item) {
        console.log(item.value);
		var item_url;
		
		
		if (item.value==1) {
			item_url="user.html"
		}
		if (item.value==2) {
			item_url="appeal.html"
		}
		if (item.value==3) {
			item_url="manage.html"
		}
		if (item.value==4) {
			item_url="check.html"
		}
		if (item.value==5) {
			item_url="need.html"
		}
		if (item.value==6) {
			item_url="info.html"
		}
		

		
        if (!$('#tabs').tabs('exists', item.text)) {
            $('#tabs').tabs('add', {
				fit: true,
                title: item.text,
                content: '<iframe scrolling="auto" frameborder="0"  src="'+item_url+'" style="width:100%;height:99%;"></iframe>',
                closable: true,
                icon: item.iconCls,
                id: item.id
            });
        } else {
            $('#tabs').tabs('select', item.text);
        }
        addTabMenu();
    }
	
 function addTabMenu() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function () {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	});
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function (e) {
		$('#tab_menu').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#tab_menu').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}

/* 注销 */
function loginOut(){
	$.ajax({
		url: "http://localhost:8000/ManagerLogout",
		headers:{token:window.sessionStorage.token},
		success:function(data){
			if(data.success==0){
				alert(data.message);
				document.cookie = "name="+getCookie()+"; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
			}
			alert(data.message);
		}
		
	});
	/* if (getCookie()!=null) {
		//document.cookie = "name="+getCookie()+"; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
		
		window.location.href="login.html"
	} else{
		window.location.href="login.html"
	} */
	//alert(document.cookie)
}
/* 获取cookie的值 */
function getCookie(){
	var arr=document.cookie.split(";");
	for(var i=0;i<arr.length;i++){
		var arr1=arr[i].split("=");
		if (arr1[0]=="name") {
			return arr1[1];
			break;
		}else{
			return null;
			break;
		}
	}
}
