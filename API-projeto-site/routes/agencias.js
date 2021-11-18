var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Agencia = require('../models').Agencia;

let sessoes = [];

/* Recuperar usuário por login e senha */
router.post('/autenticar', function(req, res, next) {
	console.log('Recuperando usuário por login e senha');

	var login = req.body.login; // depois de .body, use o nome (name) do campo em seu formulário de login
	var senha = req.body.senha; // depois de .body, use o nome (name) do campo em seu formulário de login	
	
	let instrucaoSql = `select * from usuario where email='${login}' and senha='${senha}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Agencia
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.login);
			console.log('sessoes: ',sessoes);
			res.json(resultado[0]);
			
		} else if (resultado.length == 0) {
			res.status(403).send('Login e/ou senha inválido(s)');
		} else {
			res.status(403).send('Mais de um usuário com o mesmo login e senha!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

/* Obtendo quantidade de caixas eletrônicos */
router.post('/obterQuantidadeDeCaixas/:idAgencia', function(req, res, next) {

	let idAgencia = req.params.idAgencia;
	
	console.log('Obendo quantidade de caixas da agência logada');

	let instrucaoSql = `select * from maquina where fkAgencia = ${idAgencia}`;

	console.log(instrucaoSql);
	
	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Caixas encontrados: ${resultado.length}`);

			if (resultado.length > 0) {
				res.json(resultado);
			} else {
				res.status(403).send('A agencia não possui caixas registrados!');
			}
		
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
	
	
});

/* Obter dados dos caixas visao geral*/
router.post('/obterDados/:idAgencia', function(req, res, next) {

	let idAgencia = req.params.idAgencia;
	
	console.log(`Obendo os registros da Agência ${idAgencia}`);

	let instrucaoSql = `select * from maquina where fkAgencia = ${idAgencia}`;

	console.log(instrucaoSql);
	
	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Resultado encontrado: ${resultado}`);

			if (resultado.length > 0) {
				res.json(resultado);
			} else {
				res.status(403).send('Erro ao obter os registros!');
			}
		
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
	
	
});


/* Obter registros das máquinas */
router.post('/obterRegistrosDasMaquinas/:idMaquina', function(req, res, next) {

	let idMaquina = req.params.idMaquina;
	
	console.log(`Obendo o ultimo registro da máquina ${idMaquina}`);

	let instrucaoSql = `select top 1 * from registroMaquina where fkMaquina = ${idMaquina} order by idRegistro desc`;

	console.log(instrucaoSql);
	
	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Resultado encontrado: ${resultado[0]}`);

			if (resultado.length > 0) {
				res.json(resultado);
			} else {
				res.status(403).send('Erro ao obter os registros!');
			}
		
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
	
	
});


/* Cadastrar usuário */
router.post('/cadastrar', function(req, res, next) {
	console.log('Criando um usuário');
	
	Agencia.create({
		nome : req.body.nome,
		login : req.body.login,
		senha: req.body.senha
	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});


/* Verificação de usuário */
router.get('/sessao/:login', function(req, res, next) {
	let login = req.params.login;
	console.log(`Verificando se o usuário ${login} tem sessão`);
	
	let tem_sessao = false;
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] == login) {
			tem_sessao = true;
			break;
		}
	}

	if (tem_sessao) {
		let mensagem = `Usuário ${login} possui sessão ativa!`;
		console.log(mensagem);
		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}
	
});


/* Logoff de usuário */
router.get('/sair/:login', function(req, res, next) {
	let login = req.params.login;
	console.log(`Finalizando a sessão do usuário ${login}`);
	let nova_sessoes = []
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] != login) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	sessoes = nova_sessoes;
	res.send(`Sessão do usuário ${login} finalizada com sucesso!`);
});


/* Recuperar todos os usuários */
router.get('/', function(req, res, next) {
	console.log('Recuperando todos os usuários');
	Agencia.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} registros`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

module.exports = router;