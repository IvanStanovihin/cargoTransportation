var isAddingOrEditing = false;
document.addEventListener('DOMContentLoaded',function(){
    document.getElementById("map").style.height = "0px";
})
function toggleMapDisplay(){
    var map = document.getElementById("map");
    if(map.style.height == '0px'){
        map.style.height = '500px';
    }
    else if(map.style.height =='500px'){
        map.style.height = '0px';
    }
}
// function addRow(){
//     var inputRow = document.getElementById('inputRow');
//     if(inputRow.style.display == 'table-row')
//         inputRow.style.display = 'none';
//     else 
//         inputRow.style.display = 'table-row';
// }
function addEditingRow(){
    if(!isAddingOrEditing){
        isAddingOrEditing=!isAddingOrEditing;
        var table = document.getElementById("appsTable");
        var tableHead = document.getElementById('table-header');
        var tr = table.insertRow(0);
        for(const header of tableHead.children){ 
            let input = document.createElement('input');
            input.type = 'text'; input.className = 'textbox'; input.placeholder = header.innerHTML;
            let th = document.createElement('th');
            th.appendChild(input);
            tr.appendChild(th);
        }
        let acceptButton = document.createElement('input');acceptButton.setAttribute('onclick','addRow(this)');
        acceptButton.type ='button'; acceptButton.value='✓'; 
        let declineButton = document.createElement('input');
        declineButton.type ='button'; declineButton.value='X';declineButton.setAttribute('onclick','deleteRow(this)');
        let th = document.createElement('th');
        th.appendChild(acceptButton);
        tr.appendChild(th);
        th = document.createElement('th');
        th.style.position = 'relative';
        th.style.left = '30px';
        th.appendChild(declineButton);
        tr.appendChild(th);
    }
}
function addRow(element){
    var row = element.parentElement.parentElement;
    var tableHead = document.getElementById('table-header');
    var table = document.getElementById("appsTable");
    let newRow = table.insertRow(0);
    for(let i = 0;i < tableHead.children.length; i++){
        let td = document.createElement('td');
        td.innerHTML += row.children[i].children[0].value;
        newRow.appendChild(td);
    }
    newRow.setAttribute('ondblclick','enterEditingMode(this)')
    deleteRow(element);
    isAddingOrEditing=false;    
}
function deleteRow(element){
    element.parentElement.parentElement.remove();
    isAddingOrEditing=false;
}
function enterEditingMode(row){
    if(!isAddingOrEditing){
        isAddingOrEditing=!isAddingOrEditing;
        var tableHead = document.getElementById('table-header');
        for(let i = 0;i < tableHead.children.length; i++){
            row.children[i].innerHTML = '<input type="text" class="textbox" placeholder="'+tableHead.children[i].innerHTML+'"></input>'
        }
        let acceptButton = document.createElement('input');acceptButton.setAttribute('onclick','addRow(this)');
        acceptButton.type ='button'; acceptButton.value='✓'; 
        let declineButton = document.createElement('input');
        declineButton.type ='button'; declineButton.value='X';declineButton.setAttribute('onclick','deleteRow(this)');
        let th = document.createElement('th');
        th.appendChild(acceptButton);
        row.appendChild(th);
        th = document.createElement('th');
        th.style.position = 'relative';
        th.style.left = '30px';
        th.appendChild(declineButton);
        row.appendChild(th);
    }
}