insert into kitchen (id, name) values (1, 'Thai');
insert into kitchen (id, name) values (2, 'Indian');

insert into restaurant (name, tax_freight, kitchen_id) values ('Jabaquara Corner', 6.0, 1);
insert into restaurant (name, tax_freight, kitchen_id) values ('Bony', 66.0, 1);
insert into restaurant (name, tax_freight, kitchen_id) values ('Esquerda Esquerda', 1.0, 2);

insert into form_payment (description) values ('Credit');
insert into form_payment (description) values ('Debit');
insert into form_payment (description) values ('Money');