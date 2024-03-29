/**
 * 
 */

//菜单组件
Vue.component('menu-item',{
    props:["item", "index"],
    template:[
        '<li :class="item.class">',
        '<a v-if="item.type === 0" href="javascript:;">',
        '<i v-if="item.icon != null" :class="item.icon"></i>',
        '<span>{{item.name}}</span>',
        '<i class="fa fa-angle-left pull-right"></i>',
        '</a>',
        '<ul v-if="item.type === 0" class="treeview-menu">',
        '<menu-item :item="item" :index="index" v-for="(item, index) in item.list"></menu-item>',
        '</ul>',
        '<a v-if="item.type === 1" :href="item.url" :target="item.target">' +
        '<i v-if="item.icon != null" :class="item.icon"></i>' +
        '<i v-else class="fa fa-circle-o"></i> {{item.name}}' +
        '</a>',
        '</li>'
    ].join(''),
    created: function(){
    	if(this.item.url && location.href.indexOf(this.item.url) != -1){
    		this.item.class = "active";
    	}
    },
    mounted: function(){
    	if(this.item.url && location.href.indexOf(this.item.url) != -1){
    		$("aside .active").parents("li").attr("class", "active");
    	}
    }
});

Vue.component("main-header", {
    props: [""],
    data: function() {
        return {
        	user:{},
    		main:"main.html",
            form:{
                password:'',
                newPassword:''
    		}
        }
    },
    template: 
      '<div>'+
	  '<header class="main-header">'+
	    '<a href="javascript:;" class="logo">'+
	      '<!-- mini logo for sidebar mini 50x50 pixels -->'+
	      '<span class="logo-mini"><b>二手</b></span>'+
	      '<!-- logo for regular state and mobile devices -->'+
	      '<span class="logo-lg"><b>二手市场</b></span>'+
	    '</a>'+
	    '<!-- Header Navbar: style can be found in header.less -->'+
	    '<nav class="navbar navbar-static-top" role="navigation">'+
	      '<!-- Sidebar toggle button-->'+
	      '<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">'+
	        '<span class="sr-only">Toggle navigation</span>'+
	      '</a>'+
	      '<div class="navbar-custom-menu">'+
	        '<ul class="nav navbar-nav">'+
			  '<li><a href="javascript:;" @click="updatePassword"><i class="fa fa-lock"></i> &nbsp;修改密码</a></li>'+
	          '<li><a href="javascript:;" @click="logout"><i class="fa fa-sign-out"></i> &nbsp;退出系统</a></li>'+
			'</ul>'+
	      '</div>'+
	    '</nav>'+
	  '</header>'+
	  '<div id="passwordLayer" style="display: none;">'+
		'<form class="form-horizontal">'+
		'<div class="form-group">'+
			'<div class="form-group">'+
			   	'<div class="col-sm-2 control-label">账号</div>'+
			    '<span class="label label-success" style="vertical-align: bottom;">{{user.username}}</span>'+
			'</div>'+
			'<div class="form-group">'+
			   	'<div class="col-sm-2 control-label">原密码</div>'+
			   	'<div class="col-sm-10">'+
			      '<input type="password" class="form-control" v-model="form.password" placeholder="原密码"/>'+
			    '</div>'+
			'</div>'+
			'<div class="form-group">'+
			   	'<div class="col-sm-2 control-label">新密码</div>'+
			   	'<div class="col-sm-10">'+
			      '<input type="text" class="form-control" v-model="form.newPassword" placeholder="新密码"/>'+
			    '</div>'+
			'</div>'+
		'</div>'+
		'</form>'+
	  '</div>'+
	'</div>'
    ,
    methods: {
		getUser: function(){
			var $this = this;
			$.getJSON(baseURL + "sys/user/info", function(r){
				$this.user = r.user;
			});
		},
		updatePassword: function(){
			var $this = this;
			layer.open({
				type: 1,
				skin: 'layui-layer-molv',
				title: "修改密码",
				area: ['550px', '270px'],
				shadeClose: false,
				content: jQuery("#passwordLayer"),
				btn: ['修改','取消'],
				btn1: function (index) {
					$.ajax({
						type: "POST",
					    url: baseURL + "sys/user/password?password="+$this.form.password+"&newPassword="+$this.form.newPassword,
					    dataType: "json",
                        contentType: "application/json",
					    success: function(r){
							if(r.code == 0){
								layer.close(index);
								layer.alert('修改成功', function(){
									location.reload();
								});
							}else{
								layer.alert(r.msg);
							}
						}
					});
	            }
			});
		},
        logout: function () {
        	//删除本地token
            localStorage.removeItem("token");
            localStorage.removeItem("menuList");
            localStorage.removeItem("permissions");
            //跳转到登录页面
            location.href = baseURL + 'login.html';
        }
    },
    created: function() {
		this.getUser();
    }
});

Vue.component("main-sidebar", {
    props: [""],
    data: function() {
        return {
    		menuList:{},
    		main:"main.html",
    		activeMenuId:-1
        }
    },
    template:
	  '<aside class="main-sidebar">'+
	    '<!-- sidebar: style can be found in sidebar.less -->'+
	    '<section class="sidebar">'+
	      '<!-- /.search form -->'+
	      '<!-- sidebar menu: : style can be found in sidebar.less -->'+
	      '<ul class="sidebar-menu">'+
	        '<li class="header">导航菜单</li>'+
	        '<!-- vue生成的菜单 -->'+
			'<menu-item :item="item" :index="index" v-for="(item, index) in menuList"></menu-item>'+
	      '</ul>'+
	    '</section>'+
	    '<!-- /.sidebar -->'+
	  '</aside>'
    ,
    methods: {
    	getMenuList: function () {
    		var $this = this;
			$.getJSON(baseURL + "sys/menu/user", function(r){
				$this.menuList = r.menuList;
                window.permissions = r.permissions;
                localStorage.setItem("menuList", JSON.stringify(r.menuList));
                localStorage.setItem("permissions", permissions);
			});
		}
    },
    created: function() {
    	var params = getRequest();
    	if(params){
    		this.activeMenuId = params.menuId;
    	}
    	
    	if(localStorage.getItem("menuList") && localStorage.getItem("menuList") != 'undefined'){
    		this.menuList = JSON.parse(localStorage.getItem("menuList"));
    		window.permissions = localStorage.getItem("permissions");
    	}else{
    		this.getMenuList();
    	}
    },
    mounted: function(){
    }
});


Vue.component("content-header", {
    props: ['title'],
    template:
      '<section class="content-header">'+
	    '<h1>{{title}}</h1>'+
	    '<ol class="breadcrumb" id="nav_title">'+
	      '<li class="active"><i class="fa fa-home"></i> &nbsp; 首页</li>'+
	      '<li class="active">{{title}}</li>'+
	    '</ol>'+
	  '</section>'
});

Vue.component("main-footer", {
	props: [""],
	data: function() {
	},
	template:
	  '<footer class="main-footer">'+
	    '<div class="pull-right hidden-xs">'+
	      'Version 1.0'+
	    '</div>'+
	    'Copyright &copy; 2018 <a href="http://www.taobishe.cn" target="_blank">taobishe.cn</a> All Rights Reserved'+
	  '</footer>'
});
