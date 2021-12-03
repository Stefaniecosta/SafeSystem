var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Caixa = require('../models').Caixa;
var Usuario = require('../models').Usuario;
var registroMaquina = require('../models').registroMaquina;
var dispositivoPadrao = require('../models').dispositivoPadrao;
var dispositivoEstranho = require('../models').dispositivoEstranho
module.exports = router;

//ROTA QUE CADASTRAR UM CAIXA

router.post('/cadastrarCaixas/' ,function(req, res){

    // let fkAgencia = req.params.idAgencia;
    let fkAgencia = 100;
    // let status = 

    Caixa.create({
        // <form id="form_cadastrar" method="post" onsubmit="return cadastrar()">
        // <input type="text" name="sistemaOperacional" placeholder="so">
        // <input type="text" name="totalRam" placeholder="ram">
        // <input type="text" name="processador" placeholder="procee">
        // <input type="text" name="totalDisco" placeholder="disco">
        // <input type="text" name="codigoCaixa" placeholder="codigo"

        sistemaOperacional : req.body.sistemaOperacional,
        totalRam : req.body.totalRam,
        processador : req.body.processador,
        totalDisco : req.body.totalDisco,
        codCaixa : req.body.codigoCaixa,
        idAgencia : 100,
        status : "ativo"
    }).then(resultado => {
        console.log("Post realizado com sucesso!!");
        res.send(resultado);
    }).catch(erro => {
        console.log('DEU UM ERRINHO')
        console.error(erro);
        res.status(500).send(erro.message);
    })
    
})

//ROTA QUE RECUPERA OS CAIXAS PELO ID DA AGENCCIA

router.get('/:idAgencia', (req, res) => {
	console.log('Recuperando funcionarios');

	// var fkAgencia =  req.params.idAgencia;
    var fkAgencia =  100;
	instrucaoSql = `select idMaquina, codigoCaixa, sistemaOperacional, totalRam, totalDisco, processador, status FROM maquina where fkAgencia = '${fkAgencia}'`;
	const sql = instrucaoSql;
	sequelize.query(sql, {
		model: Caixa,
		mapToModel: false 
	})
	.then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		res.json(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

//ROTA QUE DESATIVA UM CAIXA

router.get('/desativar/:id', function(req, res, next) {
    var id= req.params.id;
   
    instrucaoSql = `update maquina set status = 'inativo' where idMaquina = ${id};`
	const sql = instrucaoSql;

   
	sequelize.query(sql,{ type: sequelize.QueryTypes.UPDATE })
	.then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		res.json(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});
//ROTA QUE DELETE UM CAIXA E TODAS AS AS TABELAS EM SUA LIGAÇÃO

router.get('/deletar/:id', function(req, res, next) {
    var id= req.params.id;
   //REMOVENDO DA TABELA REGISTROS
    

    deleteMaquina = `delete from maquina where idMaquina = '${id}'`;
    const maquinaDelete = deleteMaquina;
    sequelize.query(maquinaDelete, {
        model: Caixa,
        mapToModel: false 
    }).then(resultado => {
        console.log(`Encontrados: ${resultado.length}`);
        res.json(resultado);
    }).catch(erro => {
        console.error(erro);
        res.status(500).send(erro.message);
    });

    
  });

  //ROTA QUE ATUALIZA UM CAIXA

  
router.post('/atualizar/:idCaixa', (req, res) => {
	console.log('Recuperando funcionarios');
	
	var id = req.params.idCaixa;
	var codigoCaixa = req.body.codigoCaixa;
	var so = req.body.sistemaOperacional;
    var ram = req.body.totalRam;
	var processador = req.body.processador;
	var disco = req.body.totalDisco;

	instrucaoSql = `update maquina set sistemaOperacional = '${so}', totalRam = '${ram}', processador = '${processador}' , totalDisco  = '${disco}', codigoCaixa = '${codigoCaixa}' where idMaquina = ${id};`
	const sql = instrucaoSql;
	
	sequelize.query(sql,{ type: sequelize.QueryTypes.UPDATE })
	.then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		res.json(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});


