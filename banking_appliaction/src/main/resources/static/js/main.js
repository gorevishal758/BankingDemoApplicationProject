
//get transaction type
const transactType=document.querySelector("#transact-type");
//get transaction forms
const paymentCard=document.querySelector(".payment-card");
const transferCard=document.querySelector(".transfer-card");
const depositeCard=document.querySelector(".deposite-card");
const withdrawCard=document.querySelector(".withdraw-card");

//check for transaction type event listener
transactType.addEventListener("change",()=>{

    //check for transaction type and display form
    switch(transactType.value){
        case "payment":
            paymentCard.style.display="block";
            paymentCard.nextElementSibling.style.display="none";
            withdrawCard.style.display="none";
            depositeCard.style.display="none";
            
        break;    
        
        case "transfer":
            transferCard.previousElementSibling.style.display="none"
            transferCard.style.display="block";
            transferCard.nextElementSibling.style.display="none";
            withdrawCard.style.display="none";
        break; 

        case "deposite":
            paymentCard.style.display="none";
            depositeCard.previousElementSibling.style.display="none"
            depositeCard.style.display="block";
            depositeCard.nextElementSibling.style.display="none";
        break; 

        case "withdraw":
            withdrawCard.previousElementSibling.style.display="none"
            withdrawCard.style.display="block";
            transferCard.style.display="none";
            paymentCard.style.display="none";
           
        break; 


    }
    
});


