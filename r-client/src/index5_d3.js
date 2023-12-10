
 // modal
 var modal = document.getElementById('msimpleModal');  
 var modalBtn = document.getElementById('mmodalBtn'); 
 var closeBtn = document.getElementsByClassName('mcloseBtn')[0];  
 
 modalBtn.addEventListener('click', openModal); 
 closeBtn.addEventListener('click', closeModal); 
 window.addEventListener('click', outsideClick); 
 
 function openModal(){
   modal.style.display = 'block';
   modalBtn.style.display = 'none';
 } 
 function closeModal(){
   modal.style.display = 'none';
   modalBtn.style.display = 'block';
 } 
 function outsideClick(e){
   if(e.target == modal){
     modal.style.display = 'none';
   modalBtn.style.display = 'block';
   }
 };
   