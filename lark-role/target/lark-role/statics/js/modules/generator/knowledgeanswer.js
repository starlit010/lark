$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'knowledgeanswer/list',
        datatype: "json",
        colModel: [			
			{ label: 'askId', name: 'askId', index: 'ask_id', width: 50, key: true },
			{ label: '', name: 'kmId', index: 'km_id', width: 80 }, 			
			{ label: '', name: 'ask', index: 'ask', width: 80 }, 			
			{ label: '', name: 'channelId', index: 'channel_id', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '', name: 'updateTime', index: 'update_time', width: 80 }, 			
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
		knowledgeAnswer: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.knowledgeAnswer = {};
		},
		update: function (event) {
			var askId = getSelectedRow();
			if(askId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(askId)
		},
		saveOrUpdate: function (event) {
			var url = vm.knowledgeAnswer.askId == null ? "knowledgeanswer/save" : "knowledgeanswer/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.knowledgeAnswer),
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
			var askIds = getSelectedRows();
			if(askIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "knowledgeanswer/delete",
				    contentType: "application/json",
				    data: JSON.stringify(askIds),
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
		getInfo: function(askId){
			$.get(baseURL + "knowledgeanswer/info/"+askId, function(r){
                vm.knowledgeAnswer = r.knowledgeAnswer;
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