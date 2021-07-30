
   create database if not exists RepairSystem character set utf8mb4
   default collate utf8mb4_general_ci;
   
use RepairSystem;

create table if not exists Login(

   id int not null primary key auto_increment,
   usuario varchar(15) not null,
   senha varchar(20) not null,
   classficacao varchar(15)

)engine = innodb, auto_increment = 1;


select * from Login;
-- truncate Login


create table if not exists Funcionario(

	cpf varchar(14) primary key not null ,
	nome varchar(45) not null,
    email varchar(45) not null,
	endereco varchar(40) not null,
	telefone varchar(14) not null,
	horasTrabalhadas int not null,
    classificacao varchar(14) not null

);

  select * from Funcionario;



create table if not exists Usuario(

  codigo_de_usuario int not null primary key auto_increment,
  usuario varchar(14) not null,
  senha varchar(20) not null,
  email varchar(40)not null,
  classficacao varchar(15)
  

)engine = innodb, auto_increment = 6000;

 insert into Usuario(usuario, senha, email, classficacao) values ("123456789", "pedro", "sabrina@gmail", "Adm");

select * from Usuario;
 -- truncate Usuario;
-- drop table Usuario;

create table if not exists Contrato(
nsquencia int not null primary key auto_increment,
cnpj varchar(18) not null,
tipoequipamento varchar (30) not null,
valorassociado int not null,
nomeempresa varchar (30) not null,
endereco varchar (30) not null,
ndequipamento int not null,
parcelaspagamento int not null
)engine = innodb, auto_increment = 7560;


select * from Contrato;
-- truncate Contrato;

create table if not exists Chamado(

nChamado int not null,
nomeEmpresa varchar(30) not null,
idEquipamento int not null,
motivoChamada varchar(100) not null,
dataAtendimento varchar(10) not null

);

select * from Chamado;
-- truncate Chamado;

create table if not exists Equipamento(

	nManutencao int not null primary key,  
	nSerie varchar(10) not null, 
	tipoEquipamento varchar(20) not null,
	valorAssociado int not null,
    nomeEquipamento varchar(20) not null,
	nContrato int not null,
    DataFabrica varchar(10) not null,
    parcelaPagamento int not null

);

select * from Equipamento;


create table if not exists Relatorio(
	nDoRelatorio int not null primary key,  
	cpfTecnico varchar(14) not null, 
	equipamentosReparados varchar(50) not null,
	problemaIdent varchar(50) not null,
    empresaSolicitante varchar(20) not null,
	nomeTecnico varchar(20) not null,
    ComponentesTrocados varchar(50) not null,
    solucao varchar(50) not null,
    dataRelatorio varchar(10) not null
);

select * from Relatorio;