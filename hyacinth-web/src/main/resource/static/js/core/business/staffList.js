/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

var staffs = function () {
    var dt_staffList;
    // var startTimeValue;
    // var endTimeValue;
    return {
        init: function () {
            staffs.runDataTables();
        },
        // getSearchCondition: function () {
            // var searchParam = {
                // 'search_LIKE_orderSN': $('#orderSN').val(),
                // 'search_EQ_boxCode': $('#selectedBoxName').val(),
                // 'search_LIKE_userName': $('#userName').val(),
                // 'search_LIKE_tradeNumber': $('#tradeNumber').val(),
                // 'search_EQ_orderStatus': $('#selectedOrderStatus').val(),
                // 'search_GTE_createTime': startTimeValue,
                // 'search_LTE_createTime': endTimeValue

            // };
            // return searchParam;
        // },
        runDataTables: function () {
            // var customParams = function (params) {
            //     var searchParam = staffs.getSearchCondition();
            //     $.extend(params, searchParam);
            //     params['draw'] = params.draw;
            //     var columns = params.columns;
            //     var staff = params.staff;
            //     if (staff != null && columns != null) {
            //         for (var i = 0; i < staff.length; i++) {
            //             var index = staff[i].column;
            //             var key = columns[index].data;
            //             staff[i].column = key;
            //         }
            //         params['staff'] = JSON.stringify(order);
            //     }
            //     return params;
            // };

            dt_staffList = $("#dt_staffList").DataTable({
                "sDom": 't<"bottom"flp><"clear">',
                "bFilter": false,
                "paging": false,
                "processing": true,
                "serverSide": true,
                "ajax": {
                    "url": '/staff/all',
                    "type": "get",
                    "dataSrc": function (data) {
                        return data;
                    },
                    "error": function (e) {
                        console.log(e.status + "  :status");
                        if (e.status == 401 || e.status == 500 || e.status == 404) {
                            //TODO
                        }
                    }
                },
                "columns": [
                    {"data": "id"},
                    {"data": "code"},
                    {"data": "name"},
                    {"data": "position"},
                    {"data":"department"},
                    {"data": "phone"},
                    {"data": "email"},
                    {"data":"emdate"}
                ]
            });
        }
    };

}();