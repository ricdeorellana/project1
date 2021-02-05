/**
 * 
 */

function sessInfo(){
    //Make an AJAX call

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function (){

        if(this.readyState == 4 && this.status==200){
            console.log(this.responseText);
            user = JSON.parse(this.responseText);

          
        }

        if(this.readyState ==3){ console.log(3)}
        if(this.readyState ==2){ console.log(2)}
        if(this.readyState ==1){ console.log(1)}

    }

    xhttp.open("GET", "http://localhost:8080/Project1/loggedIn.do", true );

    xhttp.send();
}








