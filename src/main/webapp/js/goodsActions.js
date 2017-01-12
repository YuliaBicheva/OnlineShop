$(document).ready(function() {    var goodsTableId = "#goodsList";    var goodsFormId = "#saveGoodsForm";    var goodsFormBtnSelector = ".btn-submit";    var paginationSelector = ".pagination";    var paginationStep = 3;    var firstPageSelector = paginationSelector + ' li:first-child a';    getPagination();    goToPage(firstPageSelector);    $(goodsFormId + ' ' + goodsFormBtnSelector).on('click', function(e) {        e.preventDefault();        saveGoods();        return false;    });    function getAll(start, step) {        var url = '/application/catalog/list?start=' + start + '&step=' + step;        $.ajax({            url: url,            type: 'GET',            beforeSend: function() {                $(goodsTableId + ' tr:not(:first-child)').remove();                $(goodsTableId + ' tfoot').show();            },            complete: function() {                $(goodsTableId + ' tfoot').hide();            },            success: function(response) {                renderList(response);                $(paginationSelector).show();            },            error: function(xhr) {            	$(paginationSelector).hide();                var json = JSON.parse(xhr.responseText);                $(goodsTableId).append('<tr>');                $(goodsTableId).append('<td>' + json.message + '</td>')                $(goodsTableId).append('</tr>')            }        });    };    function renderList(data) {        $.each(data, function(index, goods) {            $(goodsTableId).append('<tr>' + '<td>' + goods.serialNo + '</td>' + '<td>' + goods.name + '</td>' + '<td>' + goods.description + '</td>' + '<td>' + goods.quantity + '</td>' + '<td>' + goods.availability + '</td>' + '<td>' + goods.price.integralPart + '.' + goods.price.fractionalPart + '</td>' + '<td><a href="/application/catalog/deleteGoods/' + goods.id + '"> Delete </a>   <a href="/application/catalog/editGoods/' + goods.id + '"> Edit </a></td>' + '</tr>');        });    };        function getPagination(){    	var url = "/application/catalog/size";    	$.ajax({            url: url,            type: 'GET',            success: function(response) {                renderPagination(response);                	                $(paginationSelector + ' a').on('click', function(e) {                    e.preventDefault();                    goToPage(this);                    return false;                });            }        });    };        function renderPagination(size){    	for(var i = 0, count = 1; i < size; i+=paginationStep, count++){    		$(paginationSelector + " ul").append('<li><a href="" data-start="' + i + '" >'+ count +'</a></li>');    	}    }    function saveGoods() {        var url = '/application/catalog/validate?';        var inputs = $(goodsFormId + ' :input');        $.each(inputs, function(index, input) {            url += $(input).attr('name') + '=' + $(input).val() + '&';        });        $.ajax({            url: url,            type: 'GET',            success: function(response) {                $(goodsFormId).submit();            },            error: function(xhr) {                var json = JSON.parse(xhr.responseText);                $(goodsFormId + ' .error').remove();                for (var i = 0; i < json.length; i++) {                    var ex = json[i];                    setMessage(inputs[ex.index], ex.message, ex.messageType);                }            }        });    };    function setMessage(selector, message, messageType) {        $(selector).after('<p class="' + messageType + '">' + message + '</p>');    };    function goToPage(elem) {    	console.log("Go to page " + elem);        var start = $(elem).attr("data-start");        getAll(start, paginationStep);        $(paginationSelector + " a.active").removeClass('active');        $(elem).addClass(".active");    };});