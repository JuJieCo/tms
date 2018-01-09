// Last updated 2006-02-21
function addRowToTable() {
	var tbl = document.getElementById('tblSample');
	var lastRow = tbl.rows.length;
	tbl.align= 'middle';
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	// left cell
	var cellLeft = row.insertCell(0);
	var textNode = document.createTextNode(iteration);
	
	cellLeft.appendChild(textNode);
	
	
	// right cell
	var cellRight = row.insertCell(1);
	var el = document.createElement('input');
	el.type = 'text';
	el.name = 'txtRow' ;
	//el.name = 'txtRow' + iteration;
	el.id = 'txtRow' + iteration;
	// el.size = 40;
	el.className = 'span7';
	el.onkeypress = keyPressTest;
	cellRight.appendChild(el);

	var cellRight1 = row.insertCell(2);
	var eel = document.createElement('input');
	eel.type = 'text';
	eel.name = 'txttRow';
	//eel.name = 'txttRow' + iteration;
	eel.id = 'txttRow' + iteration;
	// eel.size = 40;
	eel.className = 'span1';
	eel.onkeypress = keyPressTest;
	cellRight1.appendChild(eel);

	var cellRight2 = row.insertCell(3);
	var eeel = document.createElement('input');
	eeel.type = 'text';
	eeel.name = 'txtttRow';
	//eeel.name = 'txtttRow' + iteration;
	eeel.id = 'txtttRow' + iteration;
	// eeel.size = 40;
	eeel.className = 'span1';
	eeel.onkeypress = keyPressTest;
	cellRight2.appendChild(eeel);

	var cellLeft1 = row.insertCell(4);
	// var textNode = document.createTextNode(iteration);
	cellLeft1.appendChild("");

}
function keyPressTest(e, obj) {
	var validateChkb = document.getElementById('chkValidateOnKeyPress');
	if (validateChkb.checked) {
		var displayObj = document.getElementById('spanOutput');
		var key;
		if (window.event) {
			key = window.event.keyCode;
		} else if (e.which) {
			key = e.which;
		}
		var objId;
		if (obj != null) {
			objId = obj.id;
		} else {
			objId = this.id;
		}
		displayObj.innerHTML = objId + ' : ' + String.fromCharCode(key);
	}
}

function removeRowFromTable() {
	var tbl = document.getElementById('tblSample');
	var lastRow = tbl.rows.length;
	if (lastRow > 2)
		tbl.deleteRow(lastRow - 1);
}
function openInNewWindow(frm) {
	// open a blank window
	var aWindow = window
			.open('', 'TableAddRowNewWindow',
					'scrollbars=yes,menubar=yes,resizable=yes,toolbar=no,width=400,height=400');
	// set the target to the blank window
	frm.target = 'TableAddRowNewWindow';
	// submit
	frm.submit();
}
function validateRow(frm) {
	var chkb = document.getElementById('chkValidate');
	if (chkb.checked) {
		var tbl = document.getElementById('tblSample');
		var lastRow = tbl.rows.length - 1;
		var i;
		for (i = 1; i <= lastRow; i++) {
			var aRow = document.getElementById('txtRow' + i);
			if (aRow.value.length <= 0) {
				alert('Row ' + i + ' is empty');
				return;
			}
		}
	}
	openInNewWindow(frm);
}
