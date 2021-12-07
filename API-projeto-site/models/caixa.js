'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Caixa = sequelize.define('Caixa',{
		id: {
			field: 'idCaixa',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},	
		codCaixa: {
			field: 'codigoCaixa',
			type: DataTypes.STRING,
			allowNull: false
		},	
		sistemaOperacional: {
			field: 'sistemaOperacional',
			type: DataTypes.STRING,
			allowNull: true
		},
		precessador: {
			field: 'precessador',
			type: DataTypes.STRING,
			allowNull: true
		},
		totalRam: {
			field: 'totalRam',
			type: DataTypes.FLOAT,
			allowNull: true
		},
		totalDisco: {
			field: 'totalDisco',
			type: DataTypes.FLOAT,
			allowNull: true
		},
        idAgencia: {
			field: 'fkAgencia',
			type: DataTypes.INTEGER,
			allowNull: false
		},
        status: {
			field: 'status',
			type: DataTypes.STRING,
			allowNull: false
		}
	}, 
	{
		tableName: 'maquina', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Caixa;
};
