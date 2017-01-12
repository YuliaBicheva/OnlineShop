/**
 * This plugin is responsive about button and link actions
 */
(function( $ ){
	
	var Actions = {
		init: function(options,el){
			var base = this;
			
            base.options = $.extend({}, $.fn.activity.options, options);
			base.$elem = $(el);

            base.userOptions = options;
            
            base.onLoad();
            base.onClick();
            base.saveGoods();
		},
		onLoad : function(){
			var base = this;
			$(document).ready(function(){			
				var url = base.options.defaultPath + '/list';
				base.getJSON(url);
			})
		},
		onClick : function(){
			var base = this;
			
			$(".pagination a").on("click",function(e){
				e.preventDefault();
				var start = $(this).attr("data-start");
//				start *=3;
				var step = 3;
				
				var url = base.options.defaultPath + '/list?start=' + start +"&step=" + step ;
				base.getJSON(url);

			})
		},
		getJSON : function(url){
			var base = this;
			$.ajax({
				url: url,
				type : 'GET',
				datatype : 'json',
				beforeSend : function(){
					$('#goodsList tr:not(:first-child)').remove();
					$("#goodsList tfoot").show();
				},
				complete : function(){
					$("#goodsList tfoot").hide();
				},
				success : function(response){
					base.renderList(response)
				}
				
			});
		},
		renderList : function(data){
			$.each(data, function(index, goods) {
				$('#goodsList').append('<tr>' 
						+ '<td>'+ goods.serialNo +'</td>' 
						+'<td>'+ goods.name + '</td>'
						+ '<td>' + goods.description + '</td>' 
						+ '<td>' + goods.quantity + '</td>'
						+ '<td>' + goods.availability + '</td>'
						+ '<td>' +  goods.price.integralPart + '.' + goods.price.fractionalPart + '</td>'
						+ '</tr>');
			});
		},
		saveGoods : function(){
			var base = this;
			$("#saveGoodsForm .btn-submit").on("click",function(e){
				e.preventDefault();

				var $url = "/application/catalog/validate?";
				
				var $inputs = $('#saveGoodsForm :input:not(input[type="submit"])');

			    $inputs.each(function() {
			    	var $input = $(this);
			    	var $name = $input.attr("name");
			    	var $value = $input.val();
			    	$url += $name + '=' + $value + '&';
			    });
				
				$.ajax({
					url: $url,
					type : 'GET',
					success : function(response){
						$("#saveGoodsForm").submit();
					},
					error : function(xhr){
						var json = JSON.parse(xhr.responseText);
						$("#saveGoodsForm .error").remove();
						for(var i = 0; i < json.length; i++){
							var ex = json[i];
							base.setErrorMessage(ex.index, ex.message);
						}
					}
				});
			});
		},
		setErrorMessage: function(inputIndex, errorMessage){
			var base = this;
			
			var inputs = $('#saveGoodsForm :input:not(input[type="submit"])');
			
			var input = $(inputs[inputIndex]);
			
			input.after("<p class='error'>" + errorMessage + "</p>");
		}
	};
	
	$.fn.activity = function(options) {
		return this.each(function(){
			var activ = Object.create(Actions);
			activ.init(options,this)
		})
	};
	
	$.fn.activity.options = {
		defaultPath : '/application/catalog',
		message : 'Default message'
	}
})( jQuery );