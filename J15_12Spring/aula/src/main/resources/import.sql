insert into tb_contatos(id,nome,email,fone)values(1,'maria','maria@gmail.com','(47)9809-0987');
insert into tb_contatos(id,nome,email,fone)values(2,'jose','jose@gmail.com','(47)9809-0687');

insert into tb_local(id,nome,rua,numero,bairro,cidade,estado,cep)values(1, 'Praca','California','1302','Madeiraras','Uberlandia','Minas Gerais','89301-351');
insert into tb_local(id,nome,rua,numero,bairro,cidade,estado,cep)values(2, 'Donut Shop','California','1348','Madeiraras','Uberlandia','Minas Gerais','89301-351');

insert into tb_compromissos(id,descricao,data,hora,contato_id,local_id)values(1, 'jogar bocha','2023-12-11','15:00:00',1,1)
insert into tb_compromissos(id,descricao,data,hora,contato_id,local_id)values(2, 'pescar','2023-12-11','15:00:00',2,2)
