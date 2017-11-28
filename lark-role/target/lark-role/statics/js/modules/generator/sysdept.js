$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sysdept/list',
        datatype: "json",
        colModel: [			
			{ label: 'deptId', name: 'deptId', index: 'dept_id', width: 50, key: true },
			{ label: '', name: 'channelId', index: 'channel_id', width: 80 }, 			
			{ label: '', name: 'parentId', index: 'parent_id', width: 80 }, 			
			{ label: '', name: 'name', index: 'name', width: 80 }, 			
			{ label: '', name: 'orderNum', index: 'order_num', width: 80 }, 			
			{ label: '', name: 'delFlag', index: 'del_flag', width: 80 }, 			
			{ label: '', name: 'level', index: 'level', width: 80 }, 			
			{ label: '', name: 'path', index: 'path', width: 80 }, 			
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
		sysDept: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysDept = {};
		},
		update: function (event) {
			var deptId = getSelectedRow();
			if(deptId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(deptId)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysDept.deptId == null ? "sysdept/save" : "sysdept/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.sysDept),
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
			var deptIds = getSelectedRows();
			if(deptIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sysdept/delete",
				    contentType: "application/json",
				    data: JSON.stringify(deptIds),
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
		getInfo: function(deptId){
			$.get(baseURL + "sysdept/info/"+deptId, function(r){
                vm.sysDept = r.sysDept;
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