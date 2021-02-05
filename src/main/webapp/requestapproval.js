/**
 * 
 */

//The following function will check if the user is a head dep/ben co. or a super and will give them the ability 
//To approve/reject applications

function getRequests(){
    if(user.role == 3){
        getSuper();
        getBenCo();
    }
    if(user.role == 2){
        getSuper();
        getDep();
    }

    if(user.role == 1){
        getSuper();
    }

}

function singleRequest(x){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if(this.readyState == 4 && this.status==200){
            console.log(this.responseText);
            window.location.href = 'http://localhost:8080/Project1/singlereq.html';

        }
    }
    xhttp.open("GET", "http://localhost:8080/Project1/getRequest.do?id=" + x, true );

    xhttp.send();
}

 
function getSuper(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
    if(this.readyState == 4 && this.status==200){
        input = JSON.parse(xhttp.responseText);
        forms = input;
        console.log(forms);
        
        for (let i = 0; i < input.length; i++) {
            let test = input[i].grade;
           if(test == 7){
            //Begin to format a table
            let output = document.getElementById("ReimbursementsS");
            let outputHtml = output.innerHTML;
            let status = "";
            let eventType = "";

            let reinbursement = 0;
            switch(input[i].grade){
                    case 1:
                    status = "A: Passed";
                    break;

                    case 2:
                    status = "B: Passed";
                    break;

                    case 3:
                    status = "C: Passed";
                    break;

                    case 4:
                    status = "D Or Less: Failed";
                    break;

                    case 5:
                    status = "Presentation Passed";
                    break;

                    case 6:
                    status = "Presentation Failed";
                    break;

                    case 7:
                    status = "Pending Supervisor Approval";
                    break;

                    case 8:
                    status = "Pending Department Head Approval";
                    break;

                    case 9:
                    status = "Passing Benefits Coordinator Approval";
                    break;

                    case 10:
                    status = "Pending Grade Submission";
                    break;

            }

            switch(input[i].eventId){
                    case 1:
                    eventType = "University Course";
                    reinbursement = input[i].cost / .80;
                    break;

                    case 2:
                    eventType = "Seminar";
                    reinbursement = input[i].cost / .60;
                    break;

                    case 3:
                    eventType = "Certification Preparation Class";
                    reinbursement = input[i].cost / .75;
                    break;

                    case 4:
                    eventType = "Certification";
                    reinbursement = input[i].cost;
                    break;

                    case 5:
                    eventType = "Technical Training";
                    reinbursement = input[i].cost / .90;
                    break;

                    case 6:
                    eventType = "Other";
                    reinbursement = input[i].cost / .30;
                    break;

            }


            outputHtml += `<table class="table table-striped table-bordered table-hover"><tr class="table-light">
                                <th>Category</th>
                                <th>Value</th>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Name of Employee</td>
                                <td>${input[i].fullName}</td>
                            </tr>`;
           
            //This will be a drop down option
            outputHtml += `<tr>
                            <td>Status of Reimbursement Request</td>
                            <td>${status}</td>
                        </tr>`;
            outputHtml += `<tr>
                                <td>Event Cost</td>
                                <td>${reinbursement}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Reimbursement Amount</td>
                                <td>${input[i].cost}</td>
                            </tr>`;

            outputHtml += `<tr>
                                <td>Date of Event</td>
                                <td>${input[i].date}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Type of Event</td>
                                <td>${eventType}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Time of the Event</td>
                                <td>${input[i].time}</td>
                            </tr>`;      
            outputHtml += `<tr>
                                <td>Location of Event</td>
                                <td>${input[i].location}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Description</td>
                                <td>${input[i].description}</td>
                            </tr>`;  
            outputHtml += `<tr>
                                <td>Justification</td>
                                <td>${input[i].justification}</td>
                            </tr>`;
                                  
                
                outputHtml += `</table>`;

                outputHtml += `<button class="btn btn-success" onclick="singleRequest(${input[i].id})">Go to Request</button>`; 

                output.innerHTML = outputHtml;
            }
        }     
    }
}   
xhttp.open("GET", "http://localhost:8080/Project1/getSuperRequests.do?id=" + user.id, true );
xhttp.send();
//END
}

function getDep(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
    if(this.readyState == 4 && this.status==200){
        input = JSON.parse(xhttp.responseText);
        forms = input;
        console.log(forms);
        
        for (let i = 0; i < input.length; i++) {
            //Begin to format a table
            let output = document.getElementById("ReimbursementsD");
            let outputHtml = output.innerHTML;
            let status = "";
            let eventType = "";

            let reinbursement = 0;
            switch(input[i].grade){
                    case 1:
                    status = "A: Passed";
                    break;

                    case 2:
                    status = "B: Passed";
                    break;

                    case 3:
                    status = "C: Passed";
                    break;

                    case 4:
                    status = "D Or Less: Failed";
                    break;

                    case 5:
                    status = "Presentation Passed";
                    break;

                    case 6:
                    status = "Presentation Failed";
                    break;

                    case 7:
                    status = "Pending Supervisor Approval";
                    break;

                    case 8:
                    status = "Pending Department Head Approval";
                    break;

                    case 9:
                    status = "Passing Benefits Coordinator Approval";
                    break;

                    case 10:
                    status = "Pending Grade Submission";
                    break;

            }

            switch(input[i].eventId){
                case 1:
                    eventType = "University Course";
                    reinbursement = input[i].cost / .80;
                    break;

                    case 2:
                    eventType = "Seminar";
                    reinbursement = input[i].cost / .60;
                    break;

                    case 3:
                    eventType = "Certification Preparation Class";
                    reinbursement = input[i].cost / .75;
                    break;

                    case 4:
                    eventType = "Certification";
                    reinbursement = input[i].cost;
                    break;

                    case 5:
                    eventType = "Technical Training";
                    reinbursement = input[i].cost / .90;
                    break;

                    case 6:
                    eventType = "Other";
                    reinbursement = input[i].cost / .30;
                    break;

            }


            outputHtml += `<table  class="table table-striped table-bordered table-hover"><tr class="table-light">
                                <th>Category</th>
                                <th>Value</th>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Name of Employee</td>
                                <td>${input[i].fullName}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Status of Reimbursement Request</td>
                                <td>${status}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Event Cost</td>
                                <td>${reinbursement}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Reimbursement Amount</td>
                                <td>${input[i].cost}</td>
                            </tr>`;

            outputHtml += `<tr>
                                <td>Date of Event</td>
                                <td>${input[i].date}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Type of Event</td>
                                <td>${eventType}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Time of the Event</td>
                                <td>${input[i].time}</td>
                            </tr>`;      
            outputHtml += `<tr>
                                <td>Location of Event</td>
                                <td>${input[i].location}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Description</td>
                                <td>${input[i].description}</td>
                            </tr>`;  
            outputHtml += `<tr>
                                <td>Justification</td>
                                <td>${input[i].justification}</td>
                            </tr>`;      
                           
                
                outputHtml += `</table>`;
                outputHtml += `<button onclick="singleRequest(${input[i].id})">Go to Request</button>`;  

                output.innerHTML = outputHtml;
            }
           
    }
}   

xhttp.open("GET", "http://localhost:8080/Project1/getDeptRequests.do?id=" + user.departmentId, true );
xhttp.send();
}

function getBenCo(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
    if(this.readyState == 4 && this.status==200){
        input = JSON.parse(xhttp.responseText);
        forms = input;
        console.log(forms);
        
        for (let i = 0; i < input.length; i++) {
            //Begin to format a table
            let output = document.getElementById("ReimbursementsB");
            let outputHtml = output.innerHTML;
            let status = "";
            let eventType = "";

            let reinbursement = 0;
            switch(input[i].grade){
                    case 1:
                    status = "A: Passed";
                    break;

                    case 2:
                    status = "B: Passed";
                    break;

                    case 3:
                    status = "C: Passed";
                    break;

                    case 4:
                    status = "D Or Less: Failed";
                    break;

                    case 5:
                    status = "Presentation Passed";
                    break;

                    case 6:
                    status = "Presentation Failed";
                    break;

                    case 7:
                    status = "Pending Supervisor Approval";
                    break;

                    case 8:
                    status = "Pending Department Head Approval";
                    break;

                    case 9:
                    status = "Passing Benefits Coordinator Approval";
                    break;

                    case 10:
                    status = "Pending Grade Submission";
                    break;

            }

            switch(input[i].eventId){
                case 1:
                    eventType = "University Course";
                    reinbursement = input[i].cost / .80;
                    break;

                    case 2:
                    eventType = "Seminar";
                    reinbursement = input[i].cost / .60;
                    break;

                    case 3:
                    eventType = "Certification Preparation Class";
                    reinbursement = input[i].cost / .75;
                    break;

                    case 4:
                    eventType = "Certification";
                    reinbursement = input[i].cost;
                    break;

                    case 5:
                    eventType = "Technical Training";
                    reinbursement = input[i].cost / .90;
                    break;

                    case 6:
                    eventType = "Other";
                    reinbursement = input[i].cost / .30;
                    break;

            }


            outputHtml += `<table class="table table-striped table-bordered table-hover"><tr class="table-light">
                                <th>Category</th>
                                <th>Value</th>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Name of Employee</td>
                                <td>${input[i].fullName}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Status of Reimbursement Request</td>
                                <td>${status}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Event Cost</td>
                                <td>${reinbursement}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Reimbursement Amount</td>
                                <td>${input[i].cost}</td>
                            </tr>`;

            outputHtml += `<tr>
                                <td>Date of Event</td>
                                <td>${input[i].date}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Type of Event</td>
                                <td>${eventType}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Time of the Event</td>
                                <td>${input[i].time}</td>
                            </tr>`;      
            outputHtml += `<tr>
                                <td>Location of Event</td>
                                <td>${input[i].location}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Description</td>
                                <td>${input[i].description}</td>
                            </tr>`;  
            outputHtml += `<tr>
                                <td>Justification</td>
                                <td>${input[i].justification}</td>
                            </tr>`;        
                outputHtml += `</table>`;
                outputHtml += `<button onclick="singleRequest(${input[i].id})">Go to Request</button>`;  

                output.innerHTML = outputHtml;
            }
           
    }
}   
xhttp.open("GET", "http://localhost:8080/Project1/getBencoRequests.do", true );
xhttp.send();
}