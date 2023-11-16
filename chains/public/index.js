

function web3() {
  const Web3 = require('web3');
  const web3 = new Web3('http://localhost:8545');
  return web3;
}
async function walletConnect() {
  // await Moralis.authenticate({provider: "walletconnect"});

  const web3 = await walletConnect();
  // const web3 = new Web3(provider);
  const accounts = await web3.eth.getAccounts();
  const balance = await web3.eth.getBalance(accounts[0]);
  console.log(balance); 
  const provider = await Moralis.Web3.enable();
  return web3;
}
async function metaMask() {
  // await Moralis.authenticate();
  if (window.web3) {
    window.web3 = new Web3(window.web3.currentProvider);
    window.ethereum.enable();
  } else if(window.ethereum) {
   await window.ethereum.request({ method: 'eth_requestAccounts' });
   window.web3  = new Web3(window.ethereum);
  } else {
    console.log("Metamask not installed")
}
}
async function getBalance() {
  const balance = await Moralis.Web3API.account.getNativeBalance();
  const balances = await Moralis.Web3API.account.getTokenbalances();
  const balancesNft = await Moralis.Web3API.account.getNFTs();
  console.log(balance);
  console.log(balances);
  console.log(balancesNft);
}

function onSubmit(e) {
  e.preventDefault();

  document.querySelector('.msg').textContent = '';
  document.querySelector('#image').src = '';

  const prompt = document.querySelector('#prompt').value;
  const size = document.querySelector('#size').value;

  if (prompt === '') {
    alert('Please add some text');
    return;
  }

  generateImageRequest(prompt, size);
}

async function generateImageRequest(prompt, size) {
  try {
    showSpinner();

    const response = await fetch('/openai/generateimage', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        prompt,
        size,
      }),
    });

    if (!response.ok) {
      removeSpinner();
      throw new Error('That image could not be generated');
    }

    const data = await response.json();
    // console.log(data);

    const imageUrl = data.data;

    document.querySelector('#image').src = imageUrl;

    removeSpinner();
  } catch (error) {
    document.querySelector('.msg').textContent = error;
  }
}

function showSpinner() {
  document.querySelector('.spinner').classList.add('show');
}

function removeSpinner() {
  document.querySelector('.spinner').classList.remove('show');
}

document.querySelector('#image-form').addEventListener('submit', onSubmit);
