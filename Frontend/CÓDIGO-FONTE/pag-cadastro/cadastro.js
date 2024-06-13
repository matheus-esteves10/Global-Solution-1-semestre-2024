// PEGANDO ELEMENTOS 

const form = document.getElementById("form-cadastro");
const cpf = document.getElementById("idCpf");
const email = document.getElementById("idEmail");
const senha = document.getElementById("idSenha");
const confirmaSenha = document.getElementById("idConfirmaSenha");
const botao = document.getElementById("form-btn");

// TRATANDO ERROS DE INPUT

// se a validação falhar, evita o envio do formulário
form.addEventListener('submit', function(event) {
  if (formularioIsValid() === false){
    event.preventDefault();
  }
})

// executa verificação do input quando fora de foco
cpf.addEventListener("focus", () => {
    const divInput = cpf.parentElement;
    divInput.className = "div-input";
})
email.addEventListener("focus", () => {
    const divInput = email.parentElement;
    divInput.className = "div-input";
})
senha.addEventListener("focus", () => {
    const divInput = senha.parentElement;
    divInput.className = "div-input";
})
confirmaSenha.addEventListener("focus", () => {
    const divInput = confirmaSenha.parentElement;
    divInput.className = "div-input";
})

// verificadores de cada input
function verificarInputCpf() {
    const cpfValue = cpf.value;
    
    if (cpfValue === ""){
        erroInput(cpf, "Preencha o campo com seu CPF.");
    }else if (cpfValue.length < 14){
        erroInput(cpf, "Preencha com seu CPF completo.");
    }else{
        const divInput = cpf.parentElement;
        divInput.className = "div-input";
    }
}

function verificarInputEmail() {
    const emailValue = email.value;
    
    if (emailValue === ""){
        erroInput(email, "Preencha o campo com seu e-mail.");
    }else{
        const divInput = email.parentElement;
        divInput.className = "div-input";
    }
}

function verificarInputSenha() {
    const senhaValue = senha.value;
    
    if (senhaValue === ""){
        erroInput(senha, "A senha é obrigatória.");
    }else if(senhaValue.length < 8){
        erroInput(senha, "A senha deve ter no mínimo 8 caracteres.");
    }else{
        const divInput = senha.parentElement;
        divInput.className = "div-input";
    }
}

function verificarInputConfirmaSenha() {
    const senhaValue = senha.value;
    const confirmaSenhaValue = confirmaSenha.value;
    
    if (confirmaSenhaValue === ""){
        erroInput(confirmaSenha, "A confirmação de senha é obrigatória.");
    }else if(confirmaSenhaValue !== senhaValue){
        erroInput(confirmaSenha, "As senhas não são iguais.");
    }else{
        const divInput = confirmaSenha.parentElement;
        divInput.className = "div-input";
    }
}

// exibe erro no input
function erroInput(input, mensagem) {
    const divInput = input.parentElement;
    const txtMensagem = divInput.querySelector("p");

    txtMensagem.innerText = mensagem;

    divInput.className = "div-input erro"
}

// valida os inputs do formulário
function formularioIsValid() {
    verificarInputCpf();
    verificarInputEmail();
    verificarInputSenha();
    verificarInputConfirmaSenha();

    const divsFormulario = form.querySelectorAll(".div-input");

    const isValid = [...divsFormulario].every( (item) => {
        return item.className === "div-input";
    })

    if (isValid) {
        return true;
    }else{
        return false;
    }
}


// PADRÃO DE CPF
cpf.addEventListener("input", () => {
    let txtCpf = cpf.value;

    txtCpf = txtCpf.replace(/\D/g, "");
    txtCpf = txtCpf.replace(/(\d{3})(\d)/, "$1.$2");
    txtCpf = txtCpf.replace(/(\d{3})(\d)/, "$1.$2");
    txtCpf = txtCpf.replace(/(\d{3})(\d{1,2})$/, '$1-$2');

    cpf.value = txtCpf;
});