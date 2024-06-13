//  SIMULANDO BANCO DE DADOS
const listaUsuarios = [
    {
      cpf: "12345678900",
      email: "usuario1@email.com",
      senha: "senha123"
    },
    {
      cpf: "11122233344",
      email: "usuario2@email.com",
      senha: "senha456"
    },
    {
      cpf: "22233344455",
      email: "usuario3@email.com",
      senha: "senha789"
    }
];

// PEGANDO ELEMENTOS
const form = document.getElementById("form-login")
const login = document.getElementById("idLogin")
const senha = document.getElementById("idSenha")
const botao = document.getElementById("form-btn")
const divForm = document.getElementById("idBoxLogin")

form.addEventListener("submit", function(event) {
    if (loginSenhaValidos() === false){
        event.preventDefault();
        senha.value = "";
        divForm.className = "box-login erro";
    }
})

function loginSenhaValidos(){
    const loginValue = login.value;
    const senhaValue = senha.value;
    
    for (let x = 0; x < listaUsuarios.length; x++) {
    
        if((loginValue == listaUsuarios[x].cpf || loginValue == listaUsuarios[x].email) && (senhaValue == listaUsuarios[x].senha)){
            return true;
        }else{
            return false;
        }
    }
}