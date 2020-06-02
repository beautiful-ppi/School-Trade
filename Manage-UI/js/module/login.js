function login(){
	var account=document.getElementById('at').value;
	var password=document.getElementById('pw').value;
	
	$.ajax({          
			 url:'http://localhost:8000/selectAdminastratorByAccountAndPass', 
			 dataType:'json',  
			 type:"post", 
			 data:{"account":account,"password":password},
			 success:function(data){
				 if (data.success == 0) {
					 document.cookie="name="+account;
					 sessionStorage.setItem("token",data.mtoken);
					window.location.href="index.html";
				 } else{
					alert(data.message);
				 }
				 //console.log(data);
				 //alert(data.message);
			 },      
			 error:function(){
				window.location.href="error.html";
			 }
	});
	
	//jquery全局配置
	// $.ajaxSetup({
	//     dataType: "json",
	//     cache: false,
	//     headers: {
	//         "token": mtoken
	//     },
	//     // xhrFields: {
	//     //     withCredentials: true
	//     // },
	//     complete: function(xhr) {
	//         //token过期，则跳转到登录页面
	//         if(xhr.responseJSON.code == 401){
	//             parent.location.href = base.url.appname + 'login.html';
	//         }
	//     }
	// });

	
} 