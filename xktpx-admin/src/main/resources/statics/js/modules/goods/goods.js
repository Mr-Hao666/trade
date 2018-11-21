$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'goods/goods/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '店铺id(保留)', name: 'shopId', index: 'shop_id', width: 80 }, 			
			{ label: 'tab', name: 'tabId', index: 'tab_id', width: 80 }, 			
			{ label: '商品名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '商品描述', name: 'desc', index: 'desc', width: 80 }, 			
			{ label: '商品详情(保留字段,图文)', name: 'detail', index: 'detail', width: 80 }, 			
			{ label: '商品货号(商品编号),唯一', name: 'artNo', index: 'art_no', width: 80 }, 			
			{ label: '商品关键字', name: 'keyword', index: 'keyword', width: 80 }, 			
			{ label: '商品展示图(主图)', name: 'picShow', index: 'pic_show', width: 80 }, 			
			{ label: '商品详情展示图1', name: 'picDetail1', index: 'pic_detail1', width: 80 }, 			
			{ label: '商品详情展示图2', name: 'picDetail2', index: 'pic_detail2', width: 80 }, 			
			{ label: '商品详情展示图3', name: 'picDetail3', index: 'pic_detail3', width: 80 }, 			
			{ label: '商品详情展示图4', name: 'picDetail4', index: 'pic_detail4', width: 80 }, 			
			{ label: '商品详情展示图5', name: 'picDetail5', index: 'pic_detail5', width: 80 }, 			
			{ label: '发售日期(暂时只到天,后期改)', name: 'releaseDate', index: 'release_date', width: 80 }, 			
			{ label: '所属品牌名称(便于搜索)', name: 'brand', index: 'brand', width: 80 }, 			
			{ label: '适用性别：0:不限，1:男，2:女', name: 'genderFor', index: 'gender_for', width: 80 }, 			
			{ label: '销量', name: 'salesVolume', index: 'sales_volume', width: 80 }, 			
			{ label: '最新成交价(单位:元人民币)', name: 'latestDealPrice', index: 'latest_deal_price', width: 80 }, 			
			{ label: '单位计量: 1:件 2...', name: 'unit', index: 'unit', width: 80 }, 			
			{ label: '重量', name: 'weight', index: 'weight', width: 80 }, 			
			{ label: '库存', name: 'inventory', index: 'inventory', width: 80 }, 			
			{ label: '是否上架销售 1:是 0:否', name: 'isOnSale', index: 'is_on_sale', width: 80 }, 			
			{ label: '单次购买上限数', name: 'limitTimes', index: 'limit_times', width: 80 }, 			
			{ label: '排序', name: 'sortNo', index: 'sort_no', width: 80 }, 			
			{ label: '标签：1:无标签；2:热卖；3:包邮；4:折扣', name: 'label', index: 'label', width: 80 }, 			
			{ label: '创建人id', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '创建时间', name: 'createdTime', index: 'created_time', width: 80 }, 			
			{ label: '更新人id', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '更新时间', name: 'updatedTime', index: 'updated_time', width: 80 }, 			
			{ label: '数据状态 0:正常 1:删除', name: 'delFlag', index: 'del_flag', width: 80 }, 			
			{ label: '审核人id', name: 'auditBy', index: 'audit_by', width: 80 }, 			
			{ label: '审核状态 1:待审核 2:审核通过 3:审核不通过', name: 'auditState', index: 'audit_state', width: 80 }, 			
			{ label: '审核备注', name: 'auditRemark', index: 'audit_remark', width: 80 }			
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
		goods: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.goods = {};
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
			var url = vm.goods.id == null ? "goods/goods/save" : "goods/goods/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.goods),
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
				    url: baseURL + "goods/goods/delete",
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
			$.get(baseURL + "goods/goods/info/"+id, function(r){
                vm.goods = r.goods;
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