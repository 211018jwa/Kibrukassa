
window.addEventListener('load', async () => {

    let res = await fetch('http://localhost:8080/checkloginstatus', {
        credentials: 'include',
        method: 'GET'
    });

    // if (res.status === 200) {
    //     let userObj = await res.json();

    //     if (userObj.user_role === 'Finance Manager') {
    //         window.location.href = 'finance-manager-homepage.html';
    //     }
    // } else if (res.status === 401) {
    //     window.location.href = 'index.html';
    // }

    populateTableWithReimbursements();
});

async function populateTableWithReimbursements() {
    let res = await fetch('http://localhost:8080/reimbursements', {
        credentials: 'include',
        method: 'GET'
    });

    let tbodyElement = document.querySelector("#reimbursement-table tbody");
    tbodyElement.innerHTML = '';

    let reimbursementArray =  await res.json();

    for (let i = 0; i < reimbursementArray.length; i++) {
        let reimbursement = reimbursementArray[i];

        let tr = document.createElement('tr');

        let td1 = document.createElement('td');
        td1.innerHTML = reimbursement.id;

        let td2 = document.createElement('td');
        td2.innerHTML = reimbursement.amount;

        let td3 = document.createElement('td'); 
        td3.innerHTML = reimbursement.submitted;
       
        let td4 = document.createElement('td'); 
        td4.innerHTML = reimbursement.resolved;
               
        let td5 = document.createElement('td');
        td5.innerHTML = reimbursement.status;
       
        let td6 = document.createElement('td');
        td6.innerHTML = reimbursement.reimb_type;
      
        let td7 = document.createElement('td');
        td7.innerHTML = reimbursement.description;
       
        let td8 = document.createElement('td');
        td8.innerHTML = reimbursement.receipt;
       
        let td9 = document.createElement('td');
        td9.innerHTML = reimbursement.author;

        let td10 = document.createElement('td');
        td10.innerHTML = reimbursement.resolver;
        let td11 = document.createElement('td');
        
        if (reimbursement.resolver != 0) {
            td10.innerHTML = reimbursement.resolver;
            td5.innerHTML = reimbursement.status;
        } else { // otherwise, display the below content
            td5.innerHTML = 'Approved';
            td10.innerHTML = '-';
        }

        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tr.appendChild(td6);
        tr.appendChild(td7);
        tr.appendChild(td8);
        tr.appendChild(td9);
        tr.appendChild(td10);
        tr.appendChild(td10);
        tbodyElement.appendChild(tr);
    }
}


// Logout btn
let logoutBtn = document.querySelector('#logout');

logoutBtn.addEventListener('click', async () => {

    let res = await fetch('http://localhost:8080/logout', {
        'method': 'POST',
        'credentials': 'include'
    });

    if (res.status === 200) {
        window.location.href = 'index.html';
    }

})