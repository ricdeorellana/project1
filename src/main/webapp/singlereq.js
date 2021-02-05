/**
 * 
 */
function seshInfo(){
    //Make an AJAX call

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function (){

        if(this.readyState == 4 && this.status==200){
            
            input = JSON.parse(this.responseText);
            forms = input;
            console.log(forms);

            //Begin to format a table
            let output = document.getElementById("Request");
            let outputHtml = output.innerHTML;
            let status = "";
            let eventType = "";

            let reinbursement = 0;
            switch(input.grade){
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

            switch(input.eventId){
                    case 1:
                    eventType = "University Course";
                    reinbursement = input.cost / .80;
                    break;

                    case 2:
                    eventType = "Seminar";
                    reinbursement = input.cost / .60;
                    break;

                    case 3:
                    eventType = "Certification Preparation Class";
                    reinbursement = input.cost / .75;
                    break;

                    case 4:
                    eventType = "Certification";
                    reinbursement = input.cost;
                    break;

                    case 5:
                    eventType = "Technical Training";
                    reinbursement = input.cost / .90;
                    break;

                    case 6:
                    eventType = "Other";
                    reinbursement = input.cost / .30;
                    break;

            }


            outputHtml += `<table class="table table-striped table-bordered table-hover"><tr class="table-dark">
                                <th>Category</th>
                                <th>Value</th>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Name of Employee</td>
                                <td>${input.fullName}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Status of Reimbursement Request</td>
                                <td>${status}</td>
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
                                <td>${input.cost}</td>
                            </tr>`;

            outputHtml += `<tr>
                                <td>Date of Event</td>
                                <td>${input.date}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Type of Event</td>
                                <td>${eventType}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Time of the Event</td>
                                <td>${input.time}</td>
                            </tr>`;      
            outputHtml += `<tr>
                                <td>Location of Event</td>
                                <td>${input.location}</td>
                            </tr>`;
            outputHtml += `<tr>
                                <td>Description</td>
                                <td>${input.description}</td>
                            </tr>`;  
            outputHtml += `<tr>
                                <td>Justification</td>
                                <td>${input.justification}</td>
                            </tr>`;      
                
                outputHtml += `</table>`;

                output.innerHTML = outputHtml;
            }
          
    
        

        if(this.readyState ==3){ console.log(3)}
        if(this.readyState ==2){ console.log(2)}
        if(this.readyState ==1){ console.log(1)}

    }

    xhttp.open("GET", "http://localhost:8080/Project1/request.do", true );

    xhttp.send();
}