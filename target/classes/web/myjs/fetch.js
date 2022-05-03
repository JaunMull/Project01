let apiURL = 'http://localhost:8081/'
async function check(username, password){

    let checking = {username: username, password: password};
    //alert('it works');
    let response = await fetch(apiURL);
    // Bind function to onclick event for checkbox
    //alert(document.getElementById("manager").checked)
    if (document.getElementById("manager").checked){
            response = await fetch(apiURL + 'managerlogin',{
            method: 'POST',
            headers: {'Content-Type': 'application/json'} ,
            body: JSON.stringify(checking)});
    }else{
            response = await fetch(apiURL + 'login',{
            method: 'POST',
            headers: {'Content-Type': 'application/json'} ,
            body: JSON.stringify(checking)});
    }

    let result = await response.json();
    //alert(result)
    console.log('After Result:' +result.username);
    if (result.username == null | result.password == null){
        alert('Retry')
        window.location.href = 'index.html'
    }
    else{
        console.log('Success:', checking);
        if (document.getElementById("manager").checked){
            window.location.href = 'myhtml/Managerlogin.html'
        }else{
            window.location.href = 'myhtml/successfulLoginPage.html'
        }

    }
}


async function submitForm(employee_id, fname, reimbursement, reason){
    let insert = {employeeId: employee_id, name: fname, reimbursement: reimbursement, reason: reason}

    let response = await fetch(apiURL + 'reimbursements', {
        method: 'POST',
        headers: {'Content-Type':'application/json'},
        body:JSON.stringify(insert)
    })
    let result = await response;
    console.log(result);

}

function gather(){
    let id= document.getElementById('Id').value;
    let Fullname= document.getElementById('Fullname').value;
    let reimbursement= document.getElementById('Reimbursement').value;
    let reason= document.getElementById('Reason').value;
    submitForm(id, Fullname, reimbursement, reason);
}
function getall(){
    fetch(apiURL + 'allreimbursements')
        .then(response => response.json())
        .then(json => displayData(json))    //pass data to displayData() OR print data to console
        .catch(err => console.log('Request Failed', err)); // Catch errors
}

function getbyId(){
    fetch(apiURL + 'getId')
        .then(response => response.json())
        .then(json => displayData(json))    //pass data to displayData() OR print data to console
        .catch(err => console.log('Request Failed', err)); // Catch errors
}

function getform(id){
    let form = {formId: id}
    fetch(apiURL + 'formId',{
        method:'POST',
        headers: {'Content-Type':'application/json'},
        body:JSON.stringify(form)
    })
        .then(response => response.json())
        .then(json => displayDecide(json))    //pass data to displayData() OR print data to console
        .catch(err => console.log('Request Failed', err)); // Catch errors
}
function update(form,approval){
    let decide = {formId: form,status: approval}
    alert(form)
    alert(approval)
    //alert(decide)
    fetch(apiURL + 'update', {
        method: 'POST',
        headers: {'Content-Type':'application/json'},
        body:JSON.stringify(decide)})
}

function displayData(response) {
    console.log(response);
    let dataSection = document.getElementById('Table');

    //alert(response.length)
    //let list=document.createElement("ul");

    for(i=0;i<response.length;i++){
        let table= document.createElement('tr');
        table.innerHTML= `
            <tr class="table-secondary">
                <td>${response[i].formId}</td>    
                <td>${response[i].employeeId}</td>
                <td>${response[i].name}</td>
                <td>${response[i].reimbursement}</td>
                <td>${response[i].reason}</td>
                <td>${response[i].exact}</td>
                <td>${response[i].status}</td>
            </tr>
            `
        table.setAttribute("class", "table-dark");
        //alert(response[i].id +" "+response[i].name);
        dataSection.appendChild(table);
    }

    let once =document.getElementById("fortheonetime");
    once.setAttribute('disabled', true)
}

function displayDecide(response) {
    console.log(response);
    let dataSection = document.getElementById('Table1');

    //alert(response.length)
    //let list=document.createElement("ul");

    for(i=0;i<response.length;i++){
        let table= document.createElement('tr');
        table.innerHTML= `
            <td>${response[i].formId}</td>    
            <td>${response[i].employeeId}</td>
            <td>${response[i].name}</td>
            <td>${response[i].reimbursement}</td>
            <td>${response[i].reason}</td>
            <td>${response[i].exact}</td>
            <td><select id="choose" >
            <option value="pending">pending</option>
            <option value="approve">approve</option>
            <option value="deny">deny</option>
                </select></td>`
        table.setAttribute("class", "table-dark");
        //alert(response[i].id +" "+response[i].name);
        dataSection.appendChild(table);
    }
    
}

function signout(){
    fetch(apiURL + 'logout')
    window.location.href = apiURL;
}
