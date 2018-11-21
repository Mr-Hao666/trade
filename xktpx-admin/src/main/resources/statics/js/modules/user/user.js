$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/user/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '昵称', name: 'nickname', index: 'nickname', width: 80 }, 			
			{ label: '身份证号码', name: 'idCardNo', index: 'id_card_no', width: 80 }, 			
			{ label: '电话号码', name: 'phone', index: 'phone', width: 80 }, 			
			{ label: '登录密码', name: 'loginPwd', index: 'login_pwd', width: 80 }, 			
			{ label: '头像id', name: 'avatarId', index: 'avatar_id', width: 80 }, 			
			{ label: '性别 0:未知 1:男 2:女', name: 'gender', index: 'gender', width: 80 }, 			
			{ label: 'open_id(保留字段)', name: 'openId', index: 'open_id', width: 80 }, 			
			{ label: 'token(保留字段)', name: 'token', index: 'token', width: 80 }, 			
			{ label: '是否实名认证 0:未认证 1:认证成功 2:认证失败', name: 'realNameAuthorized', index: 'real_name_authorized', width: 80 }, 			
			{ label: '最近登录时间', name: 'latestLoginTime', index: 'latest_login_time', width: 80 }, 			
			{ label: '最近登录ip', name: 'latestLoginIp', index: 'latest_login_ip', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '状态 1:正常 2:禁用 3:删除', name: 'curState', index: 'cur_state', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		user: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.user = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.user.id == null ? "user/user/save" : "user/user/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.user),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/user/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "user/user/info/"+id, function(r){
                vm.user = r.user;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});