var vm = new Vue({
	el:'#rrapp',
	data:{
		statistics:{}
	},
	methods: {
		query: function() {
			$.get(baseURL + "o2o/order/statistics",{},function(r){
				vm.statistics = r.statistics
				
				$("#main").css("width", $(".content-header").width() - 50);
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: ''
                    },
                    tooltip: {},
                    legend: {
                        data:['销量']
                    },
                    xAxis: {
                        data: r.statistics.orderCountList.map(function(v){return v.createTime})
                    },
                    yAxis: {
                        minInterval: 1,
                    },
                    series: [{
                        name: '订单数量',
                        type:'line',
                        data: r.statistics.orderCountList.map(function(v){return v.count})
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);

			});
		}
	},
	
	created: function(){
		this.query();
	}
});
