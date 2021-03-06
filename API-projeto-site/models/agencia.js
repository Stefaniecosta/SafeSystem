	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Agencia = sequelize.define('Agencia',{
		id: {
			field: 'idAgencia',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nome: {
			field: 'nomeAgencia',
			type: DataTypes.STRING,
			allowNull: false
		},
		endereco: {
			field: 'localizacaoAgencia',
			type: DataTypes.STRING,
			allowNull: false
		},
		codAgencia: {
			field: 'codigoAgencia',
			type: DataTypes.STRING,
			allowNull: false
		},
		slack: {
			field: 'slackWebHook',
			type: DataTypes.STRING,
			allowNull: false
		},
		fkBanco: {
			field: 'fkBanco',
			type: DataTypes.INTEGER,
			allowNull: true
		}
	}, 
	{
		tableName: 'agencia', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Agencia;
};
