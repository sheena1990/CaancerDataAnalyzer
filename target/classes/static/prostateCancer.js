$(document).ready(function(){
	//var score = eval('('+'${piradsScoreCategories}'+')');
/*	var score = eval("${piradsScoreCategories}");
	console.log(score);*/
/*	displayChart("PIRADS score", score, '#pirads_chart');
	displayChart("PIRADS score", [[${piradsScoreCategories}]], '#pirads_chart');*/
});

function displayData(value, minVal, maxVal, divId, width, color, col){
	var chart = c3.generate({
		bindto: $(divId)[0],
	    data: {
	        columns: [
	            ['data', value],
	        ],
	        type: 'gauge',
	        onclick: function (d, i) { console.log("onclick", d, i); },
	        onmouseover: function (d, i) { console.log("onmouseover", d, i); },
	        onmouseout: function (d, i) { console.log("onmouseout", d, i); }
	    },
	    gauge: {
	    min: minVal, // 0 is default, //can handle negative min e.g. vacuum / voltage / current flow / rate of change
	    max: maxVal, // 100 is default
//	    units: ' %',
	    width: 20*width, // for adjusting arc thickness
	    label:{
	    	format: function(value, ratio){
	    		return col + ': ' + value;
	    	},
	    }
	    },
	    color: {
	        pattern: [color], // the three color levels for the percentage values.
	        threshold: {
	            unit: 'value', // percentage is default
	            max: maxVal, // 100 is default
	            //values: [1,2,3,4,5,6,7,8,9,10]
	        }
	    },
	    size: {
	        height: 100*width
	    }
	});
}



function displayChart(title, input, divId){
	var chart = c3.generate({
		bindto: $(divId)[0],
		data : {
			columns : [ [ 'most probably benign (3-4)', input[0] ],
					[ 'probably benign (5-6)', input[1] ],
					[ 'intermediate (7-9)', input[1] ],
					[ 'probably malignant (10-12)',input[1] ] ,
					[ 'most probably malignant (10-12)', input[1] ] ],
			type : 'donut',
			onclick : function(d, i) {
				console.log("onclick", d, i);
			},
			onmouseover : function(d, i) {
				console.log("onmouseover", d, i);
			},
			onmouseout : function(d, i) {
				console.log("onmouseout", d, i);
			}
		},
		donut : {
			title : title,
		}
	});
}




