function sortAndSum() {
    new Tablesort(document.getElementById("table-id"));
    totalCostFunction();
}


function totalCostFunction() {
    var cell = document.getElementById("table-id").getElementsByTagName("td");
    var sum = 0;
    for (var i = 0; i < cell.length; i++){
        if(cell[i].className == "countable" && cell[i].parentNode.style.display != "none"){
            sum += isNaN(cell[i].innerHTML) ? 0 : parseInt(cell[i].innerHTML);
        }
    }
    document.getElementById("totalcost").innerHTML = sum;
}


function filterProcessingFunction() {
    var productInput, productFilter, table, tr, productTd, i;
    productInput = document.getElementById("productFilter");
    productFilter = productInput.value.toUpperCase();
    table = document.getElementById("table-id");
    tr = table.getElementsByTagName("tr");
    var fromDate = new Date(document.getElementById("fromDateFilter").value);
    var toDate = new Date(document.getElementById("toDateFilter").value);

    for (i = 1; i < tr.length; i++) {
        productTd = tr[i].getElementsByTagName("td")[2];
        var dateTd = tr[i].getElementsByTagName("td")[3];
        var date = new Date(dateTd.innerHTML);
        var productMatch = productTd.innerHTML.toUpperCase().indexOf(productFilter) > -1;
        var rowDisplayProperty = tr[i].style.display;
        
        if (!isNaN(fromDate.getTime()) && productFilter != "" && !isNaN(toDate.getTime())) {
            if (productMatch && date >= fromDate && date <= toDate) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        } else if (!isNaN(fromDate.getTime()) && productFilter != "" && isNaN(toDate.getTime())) {
            if (date >= fromDate && productMatch) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        } else if (isNaN(fromDate.getTime()) && productFilter != "" && isNaN(toDate.getTime())) {
            if (productMatch) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        } else if (!isNaN(fromDate.getTime()) && productFilter == "" && !isNaN(toDate.getTime())) {
            if (date >= fromDate && date <= toDate) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        } else if (!isNaN(fromDate.getTime()) && productFilter == "" && isNaN(toDate.getTime())) {
            if (date >= fromDate) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        } else if (isNaN(fromDate.getTime()) && productFilter != "" && !isNaN(toDate.getTime())) {
            if (productMatch && date <= toDate) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        } else if (isNaN(fromDate.getTime()) && productFilter == "" && !isNaN(toDate.getTime())) {
            if (date <= toDate) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        } else if (isNaN(fromDate.getTime()) && productFilter == "" && isNaN(toDate.getTime())) {
            tr[i].style.display = "";
        }
    }
    totalCostFunction();
}