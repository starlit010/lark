$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'msgremark/list',
        datatype: "json",
        colModel: [			
			{ label: 'msgId', name: 'msgId', index: 'msg_id', width: 50, key: true },
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'visitorId', index: 'visitor_id', width: 80 }, 			
			{ label: '', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
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
		msgRemark: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.msgRemark = {};
		},
		update: function (event) {
			var msgId = getSelectedRow();
			if(msgId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(msgId)
		},
		saveOrUpdate: function (event) {
			var url = vm.msgRemark.msgId == null ? "msgremark/save" : "msgremark/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.msgRemark),
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
			var msgIds = getSelectedRows();
			if(msgIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "msgremark/delete",
				    contentType: "application/json",
				    data: JSON.stringify(msgIds),
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
		getInfo: function(msgId){
			$.get(baseURL + "msgremark/info/"+msgId, function(r){
                vm.msgRemark = r.msgRemark;
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