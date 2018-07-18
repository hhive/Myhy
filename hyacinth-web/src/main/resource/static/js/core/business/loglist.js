/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

var staffs = function () {
    var dt_staffList;
    return {
        init: function () {
            staffs.runDataTables();
        },

        runDataTables: function () {


            dt_staffList = $("#dt_logList").DataTable({
               // "sDom": 't<"bottom"flp><"clear">',
               // "bFilter": false,
               // "paging": false,
               // "processing": true,
              //  "serverSide": true,
                "ajax": {
                    "url": '/log/all',
                    "type": "GET",
                    // "data":{"message":"DM12345"},
                    "dataSrc": function (data) {
                        return data;
                    },
                    "error": function (e) {
                        console.log(e.status + "  :status");
                        if (e.status == 401 || e.status == 500 || e.status == 404) {
                        }
                    }
                },
                "columns": [
                    {"data": "id"},
                    {"data": "opera_time"},
                    {"data": "opera_name"},
                    {"data": "description"},
                ],
                "oLanguage" : { // 国际化配置
                    "sProcessing" : "正在获取数据，请稍后...",
                    "sLengthMenu" : "显示 _MENU_ 条",
                    "sZeroRecords" : "没有找到数据",
                    "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                    "sInfoEmpty" : "记录数为0",
                    "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
                    "sInfoPostFix" : "",
                    "sSearch" : "查询",
                    "sUrl" : "",
                    "oPaginate" : {
                        "sFirst" : "第一页",
                        "sPrevious" : "上一页",
                        "sNext" : "下一页",
                        "sLast" : "最后一页"
                    }

                },
                getAjaxPagingOptions : function(settings) {
                    var options = {
                        ajax : {
                            url : settings.ajaxUrl,
                            type : "post"
                        },
                        serverSide : true,
                        destroy : true,
                        processing : true,
                        ordering : true,
                        searching : false,
                        paging : true,
                        pagingType : "full_numbers",
                        lengthMenu : [5, 10, 15, 20 ],
                        pageLength :5,
                        order : settings.order,// [index,'asc|desc']
                        // language : DataTablePaging.language.zh_cn,
                        columns : settings.colums,
                        columnDefs : settings.columsdefs,
                    };
                    return options;
                },
            });
        }
    };

}();