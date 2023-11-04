          
  const DelForm = document.getElementById('Deliverer-form');
  const SuppForm = document.getElementById('Supplier-form');
  const CustForm = document.getElementById('Customer-form');
  
  const userTypeRadios = document.getElementsByName('user-type');
  
  for (const radio of userTypeRadios) {
  
    radio.addEventListener('change', (event) => {
      console.log(event.target.value);
  
      if (event.target.value === 'Deliverer') {
  
        DelForm.style.display = 'block';
        SuppForm.style.display = 'none';
        CustForm.style.display = 'none';
        console.log('DelForm form displayed');
  
      } else if (event.target.value === 'Supplier') {
        DelForm.style.display = 'none';
        SuppForm.style.display = 'block';
        CustForm.style.display = 'none';
        console.log('SuppForm form displayed');
  
      } else if (event.target.value === 'Customer') {
        DelForm.style.display = 'none';
        SuppForm.style.display = 'none';
        CustForm.style.display = 'block';
        console.log('CustForm form displayed');
  
      }
    });
  }
  
