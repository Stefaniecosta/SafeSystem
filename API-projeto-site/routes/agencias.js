var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Agencia = require('../models').Agencia;
var Usuario = require('../models').Usuario;

let sessoes = [];

/* Recuperar usuário por login e senha */
router.post('/autenticar', function (req, res, next) {
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
			console.log('sessoes: ', sessoes);
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
router.post('/obterQuantidadeDeCaixas/:idAgencia', function (req, res, next) {

	let idAgencia = req.params.idAgencia;

	console.log('Obendo quantidade de caixas da agência logada');

	let instrucaoSql = `select * from maquina where fkAgencia = ${idAgencia} and status = 'ativo'`;

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
router.post('/obterDados/:idAgencia', function (req, res, next) {

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
router.post('/obterRegistrosDasMaquinas/:idMaquina', function (req, res, next) {

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

/* Cadastrar caixa */
router.post('/cadastrarCaixa', function (req, res, next) {
	console.log('Criando um caixa');

	Caixa.create({
		idAgencia: req.body.idAgencia,
		codCaixa: req.body.codCaixa

	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
		res.send(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Cadastrar agencia */
router.post('/cadastrarAgencia', function (req, res, next) {
	console.log('Criando uma agência');

	Agencia.create({
		nome: req.body.nome,
		endereco: req.body.endereco,
		codAgencia: req.body.codAgencia,
		slack: req.body.slack

	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
		res.send(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Cadastrar usuário */
router.post('/cadastrarUsuario', function (req, res, next) {
	console.log('Criando um usuário');

	Usuario.create({
		nome: req.body.nome,
		email: req.body.email,
		senha: req.body.senha,
		idAgencia: req.body.idAgencia

	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
		res.send(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Editar nome de usuário */
router.post('/editarUsuario/:idUsuario', function (req, res, next) {
	console.log('Alterando dados do usuário');

	let nome = req.body.nome;
	let email = req.body.email;
	let idUsuario = req.params.idUsuario;

	let instrucaoSql = `UPDATE usuario SET nome ='${nome}', email = '${email}' WHERE idUsuario = ${idUsuario}`;

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.UPDATE
	}).then(resultado => {
		console.log(`Nome alterado!`);

		if (resultado.length > 0) {
			res.json(resultado);
		} else {
			res.status(403).send('Erro atualizar o nome do usuario!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Verificação de usuário */
router.get('/sessao/:login', function (req, res, next) {
	let login = req.params.login;
	console.log(`Verificando se o usuário ${login} tem sessão`);

	let tem_sessao = false;
	for (let u = 0; u < sessoes.length; u++) {
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
router.get('/sair/:login', function (req, res, next) {
	let login = req.params.login;
	console.log(`Finalizando a sessão do usuário ${login}`);
	let nova_sessoes = []
	for (let u = 0; u < sessoes.length; u++) {
		if (sessoes[u] != login) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	sessoes = nova_sessoes;
	res.send(`Sessão do usuário ${login} finalizada com sucesso!`);
});


/* Recuperar todos os usuários */
router.get('/', function (req, res, next) {
	console.log('Recuperando todos os usuários');
	Agencia.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} registros`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

// obter dados do nome do processador e total da ram
router.post('/obterProcessadorERam/:idMaquina', function (req, res, next) {

	let idMaquina = req.params.idMaquina;

	console.log(`Obendo nome do processador e total de ram da maquina de id ${idMaquina}`);

	let instrucaoSql = `select totalRam, processador from [dbo].[maquina] where idMaquina = ${idMaquina}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Resultado encontrado: ${resultado}`);

		if (resultado.length > 0) {
			res.json(resultado);
		} else {
			res.status(403).send('Erro ao obter nome da cpu e/ou total de ram!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});


});

// obter total do disco

router.post('/obterEspacoTotal/:idMaquina', function (req, res, next) {

	let idMaquina = req.params.idMaquina;

	console.log(`Obendo total de disco do caixa de id ${idMaquina}`);

	let instrucaoSql = `select totalDisco from maquina where idMaquina = ${idMaquina}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Resultado encontrado: ${resultado}`);

		if (resultado.length > 0) {
			res.json(resultado);
		} else {
			res.status(403).send(`Erro ao obter o total de memória no disco do caixa de id ${idMaquina}!`);
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});


});

// obter dispositivos estranhos

router.post('/obterDispositivoEstranho/:idMaquina', function (req, res, next) {

	let idMaquina = req.params.idMaquina;

	// console.log(idMaquina)

	console.log(`Checando dispositivos estranhos do caixa de id ${idMaquina}`);

	let instrucaoSql = `select * from dispositivoEstranho where dataHora >= DATEADD(minute, -1, GETDATE()) and fkMaquina = ${idMaquina}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Resultado encontrado: ${resultado}`);

		if (resultado.length >= 0) {
			res.json(resultado);
		} else {
			res.status(403).send(`Erro ao obter dispositivos estranhos do caixa de id ${idMaquina}!`);
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});


});

// obtendo quantidade de dispositivos conectados

router.post('/obterDispositivosCadastrados/:idMaquina', function (req, res, next) {

	let idMaquina = req.params.idMaquina;

	console.log(idMaquina + "teste oi")

	console.log(`Checando dispositivos cadastrados do caixa de id ${idMaquina}`);

	let instrucaoSql = `select * from [dbo].[dispositivoPadrao] where fkMaquina = ${idMaquina}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Resultado encontrado: ${resultado}`);

		if (resultado.length >= 0) {
			res.json(resultado);
		} else {
			res.status(403).send(`Erro ao obter dispositivos conectados do caixa de id ${idMaquina}!`);
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});


});

router.post('/obterDadosGraficoCPU/:idMaquina/:contadorCPU', function (req, res, next) {

	let idMaquina = req.params.idMaquina;
	let contadorCPU = req.params.contadorCPU;

	

	// console.log(idMaquina)

	// Desejo enviar dois parâmetros na requisição, um seria o id da máquina e o outro
	// seria o contador (dia)... Entao seria realizado 7 selects, onde realizaria um
	// push no vetor criando um json ({data: xxxx-xx-xx, media: xx.xx}). Após essas
	// 7 requisisoes serem completas, o loop for se encerrará e nisso, o gráfico será
	// plotado na tela.

	console.log(`Obtendo média`);

	let instrucaoSql = `select avg(usoCPU) as 'media', GETDATE() -${contadorCPU} as 'data'
	from [dbo].[registroMaquina] 
	where dataHora >= DATEADD(day, -${contadorCPU}, GETDATE()) 
	and fkMaquina = ${idMaquina}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Resultado encontrado: ${resultado}`);

		if (resultado.length >= 0) {
			res.json(resultado);
		} else {
			res.status(403).send(`Não encontrei registros para tirar média do caixa de id!`);
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});


});

router.post('/obterDadosGraficoMediaRam/:idMaquina/:contadorRAM', function (req, res, next) {

	let idMaquina = req.params.idMaquina;
	let contadorRAM = req.params.contadorRAM;

	

	// console.log(idMaquina)

	// Desejo enviar dois parâmetros na requisição, um seria o id da máquina e o outro
	// seria o contador (dia)... Entao seria realizado 7 selects, onde realizaria um
	// push no vetor criando um json ({data: xxxx-xx-xx, media: xx.xx}). Após essas
	// 7 requisisoes serem completas, o loop for se encerrará e nisso, o gráfico será
	// plotado na tela.

	console.log(`Obtendo média de RAM`);

	let instrucaoSql = `select avg(usoRam) as 'media', GETDATE() -${contadorRAM} as 'data'
	from [dbo].[registroMaquina] 
	where dataHora >= DATEADD(day, -${contadorRAM}, GETDATE()) 
	and fkMaquina = ${idMaquina}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Resultado encontrado: ${resultado}`);

		if (resultado.length >= 0) {
			res.json(resultado);
		} else {
			res.status(403).send(`Não encontrei registros para tirar média do caixa de id!`);
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});


});

router.post('/obterDadosGraficoMediaDisco/:idMaquina/:contadorDISCO', function (req, res, next) {

	let idMaquina = req.params.idMaquina;
	let contadorDISCO = req.params.contadorRAM;

	

	// console.log(idMaquina)

	// Desejo enviar dois parâmetros na requisição, um seria o id da máquina e o outro
	// seria o contador (dia)... Entao seria realizado 7 selects, onde realizaria um
	// push no vetor criando um json ({data: xxxx-xx-xx, media: xx.xx}). Após essas
	// 7 requisisoes serem completas, o loop for se encerrará e nisso, o gráfico será
	// plotado na tela.

	console.log(`Obtendo média de DISCO`);

	let instrucaoSql = `select avg(usoRam) as 'media', GETDATE() -${contadorDISCO} as 'data'
	from [dbo].[registroMaquina] 
	where dataHora >= DATEADD(day, -${contadorDISCO}, GETDATE()) 
	and fkMaquina = ${idMaquina}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT
	}).then(resultado => {
		console.log(`Resultado encontrado: ${resultado}`);

		if (resultado.length >= 0) {
			res.json(resultado);
		} else {
			res.status(403).send(`Não encontrei registros para tirar média do caixa de id!`);
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});


});

module.exports = router;


