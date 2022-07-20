// baseURL = "http://localhost:8080"

$(document).ready(function () {

	// Initializing table;
		$('#clfTable').bootstrapTable({
			data: tableData
		})

	// fetch(tableURL, {
	// 	method: 'POST',
	// 	headers: { 'Content-Type': 'application/json' },
	// 	body: JSON.stringify({ token: TOKEN, clf: currentClf })
	// }).then(response => response.json())
	// 	.then(data => {
	// 		// console.log(data);
	// 		$('#clfTable').bootstrapTable({
	// 			data: data.data
	// 		});
	// 	})
	// 	.catch(error => console.log(error));

	// detailButton = '<tr><td colspan="9"><a href="#"class="btn btn-outline-light float-right">View-Details</a></td></tr>'
	// tableBody = $("table tbody");
	// tableBody.append(detailButton);
	

	// $("#voList").on("click-row.bs.table", function (editable, columns, row) {
	// 	console.log("columns:", columns);

	// 	// You can either collect the data one by one
	// 	// var params = {id: columns.id, name: columns.name,};
	// 	// console.log("Params:", params);

	// 	// OR, you can remove the one that you don't want
	// 	// delete columns.name;
	// 	// console.log("columns:", columns);
	// });

	setTimeout(() => {
		$('#overlay').remove();
	}, 100);

});

const dummyData = [
	{
		"id": 1,
		"name": "VO-1",
		"voMemCount": 80,
		"mgnrega": "5 / 80",
		"ration": "7 / 80",
		"golden": "5 / 80",
		"bpl": "7 / 80",
		"apl": "4 / 80",
		"antyodaya": "3 / 80"
	}, {
		"id": 2,
		"name": "VO-2",
		"voMemCount": 70,
		"mgnrega": "5 / 70",
		"ration": "7 / 70",
		"golden": "5 / 70",
		"bpl": "7 / 70",
		"apl": "4 / 70",
		"antyodaya": "3 / 70"
	}, {
		"id": 3,
		"name": "VO-3",
		"voMemCount": 60,
		"mgnrega": "5 / 60",
		"ration": "7 / 60",
		"golden": "5 / 60",
		"bpl": "7 / 60",
		"apl": "4 / 60",
		"antyodaya": "3 / 60"
	},
	{
		"id": 4,
		"name": "VO-4",
		"voMemCount": 75,
		"mgnrega": "5 / 75",
		"ration": "7 / 75",
		"golden": "5 / 75",
		"bpl": "7 / 75",
		"apl": "4 / 75",
		"antyodaya": "3 / 75"
	}, {
		"id": 5,
		"name": "VO-5",
		"voMemCount": 57,
		"mgnrega": "5 / 57",
		"ration": "7 / 57",
		"golden": "5 / 57",
		"bpl": "7 / 57",
		"apl": "4 / 57",
		"antyodaya": "3 / 57"
	}
]