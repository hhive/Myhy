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
                "sDom": 't<"bottom"flp><"clear">',
                "bFilter": false,
                "paging": false,
                "processing": true,
                "serverSide": true,
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
                ]
            });
        }
    };

}();