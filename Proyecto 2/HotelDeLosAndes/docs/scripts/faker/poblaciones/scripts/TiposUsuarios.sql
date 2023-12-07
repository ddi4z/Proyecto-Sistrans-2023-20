create sequence idTiposUsuarios start with 1 increment by 1;
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Cliente');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Recepcionista');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Empleado');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Administrador');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Gerente');
