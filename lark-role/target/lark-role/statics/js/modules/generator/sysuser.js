$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sysuser/list',
        datatype: "json",
        colModel: [			
			{ label: 'userId', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '', name: 'username', index: 'username', width: 80 }, 			
			{ label: '', name: 'password', index: 'password', width: 80 }, 			
			{ label: '', name: 'salt', index: 'salt', width: 80 }, 			
			{ label: '', name: 'email', index: 'email', width: 80 }, 			
			{ label: '', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '', name: 'status', index: 'status', width: 80 }, 			
			{ label: '', name: 'deptId', index: 'dept_id', width: 80 }, 			
			{ label: '', name: 'channelId', index: 'channel_id', width: 80 }, 			
			{ label: '', name: 'serviceLimit', index: 'service_limit', width: 80 }, 			
			{ label: '', name: 'defaultState', index: 'default_state', width: 80 }, 			
			{ label: '', name: 'nickname', index: 'nickname', width: 80 }, 			
			{ label: '', name: 'usericon', index: 'usericon', width: 80 }, 			
			{ label: '', name: 'employeeid', index: 'employeeId', width: 80 }, 			
			{ label: '1:自营 2:商家 3;供应商', name: 'usertype', index: 'usertype', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '', name: 'delFlag', index: 'del_flag', width: 80 }, 			
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
		sysUser: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysUser = {};
		},
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userId)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysUser.userId == null ? "sysuser/save" : "sysuser/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.sysUser),
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
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sysuser/delete",
				    contentType: "application/json",
				    data: JSON.stringify(userIds),
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
		getInfo: function(userId){
			$.get(baseURL + "sysuser/info/"+userId, function(r){
                vm.sysUser = r.sysUser;
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