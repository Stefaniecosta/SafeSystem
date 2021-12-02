process.env.NODE_ENV = 'production'; // altere para 'production' ou 'dev'

var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var agenciasRouter = require('./routes/agencias');
var caixasRouter = require('./routes/caixas');
var leiturasRouter = require('./routes/leituras');

var app = express();

app.use(logger('dev')); 
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/agencias', agenciasRouter);
app.use('/caixas', caixasRouter);
app.use('/leituras', leiturasRouter);

module.exports = app;
