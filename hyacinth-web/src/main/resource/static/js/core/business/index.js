/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

var index = function () {

    var components = {};
    return {
        initIndex: function () {
            // components = {
            //     div_product_well: $(".product-well"),
            //     div_mask_block: $(".mask-block"),
            //     div_thumbnail: $(".thumbnail"),
            //     img_show_img: $(".show-img"),
            //     img_mask_img: $(".mask-img"),
            //     h5_select_count: $("#select-count"),
            // };
            // this.initProductEvent();
            // this.initButtonSubmitEvent();
            // this.initUploadEvent();
        },

        // initProductEvent: function () {
        //     components.div_product_well.find(components.div_thumbnail).each(function () {
        //         $(this).on('click', function () {
        //             if (components.h5_select_count.html() == "0") {
        //                 $(this).children("div").addClass("mask-block-show");
        //                 $(this).children("img.mask-img").css("opacity", "1");
        //                 components.h5_select_count.html("1");
        //                 components.btn_submit.removeAttr("disabled");
        //
        //             } else {
        //                 if ($(this).children("div").hasClass("mask-block-show")) {
        //                     $(this).children("div").removeClass("mask-block-show");
        //                     $(this).children("img.mask-img").css("opacity", "0");
        //                     components.h5_select_count.html("0");
        //                     components.btn_submit.attr("disabled", "");
        //                 }
        //             }
        //         });
        //     });
        //
        //     components.div_product_well.find(components.div_thumbnail).each(function () {
        //         $(this).on('mouseover', function () {
        //             if (components.h5_select_count.html() != "0" && !$(this).children("div").hasClass("mask-block-show")) {
        //                 $(this).css("cursor", "not-allowed");
        //             } else {
        //                 $(this).css("cursor", "pointer");
        //             }
        //         });
        //
        //         $(this).on('mouseout', function () {
        //             $(this).css("cursor", "default");
        //         });
        //     });
        //
        // },
        //
        // initButtonSubmitEvent: function () {
        //     components.btn_submit.on('click', function () {
        //         console.log("同步成功！");
        //     });
        // },
        //
        // initUploadEvent: function () {
        //
        // }
    };

}();
function show(){
    var loginname ='${Loginname}';
    alert(loginname);
}
