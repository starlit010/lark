$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'supplieruserext/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '', name: 'supplierCode', index: 'supplier_code', width: 80 }, 			
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'dialogName', index: 'dialog_name', width: 80 }, 			
			{ label: '', name: 'onlineStatus', index: 'online_status', width: 80 }, 			
			{ label: '', name: 'firstCat', index: 'first_cat', width: 80 }, 			
			{ label: '', name: 'secondCat', index: 'second_cat', width: 80 }, 			
			{ label: '', name: 'threeCat', index: 'three_cat', width: 80 }, 			
			{ label: '', name: 'brandId', index: 'brand_id', width: 80 }, 			
			{ label: '', name: 'provinceCode', index: 'province_code', width: 80 }, 			
			{ label: '', name: 'cityCode', index: 'city_code', width: 80 }, 			
			{ label: '', name: 'areaCode', index: 'area_code', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '', name: 'updateTime', index: 'update_time', width: 80 }, 			
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
		supplierUserExt: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.supplierUserExt = {};
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
			var url = vm.supplierUserExt.id == null ? "supplieruserext/save" : "supplieruserext/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.supplierUserExt),
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
				    url: baseURL + "supplieruserext/delete",
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
			$.get(baseURL + "supplieruserext/info/"+id, function(r){
                vm.supplierUserExt = r.supplierUserExt;
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