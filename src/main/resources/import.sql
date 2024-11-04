-- Inserindo mais clientes
INSERT INTO cliente (nome, CPF, email, telefone) VALUES ('Pedro Santos', '123.456.789-01', 'pedro.santos@example.com', '(61) 12345-6789');
INSERT INTO cliente (nome, CPF, email, telefone) VALUES ('Julia Carvalho', '987.654.321-01', 'julia.carvalho@example.com', '(71) 98765-4321');
INSERT INTO cliente (nome, CPF, email, telefone) VALUES ('Mariana Costa', '321.654.987-01', 'mariana.costa@example.com', '(81) 87654-3210');
INSERT INTO cliente (nome, CPF, email, telefone) VALUES ('Ricardo Almeida', '456.789.123-01', 'ricardo.almeida@example.com', '(91) 76543-2109');
INSERT INTO cliente (nome, CPF, email, telefone) VALUES ('Paula Souza', '789.123.456-01', 'paula.souza@example.com', '(31) 65432-1098');

-- Inserindo mais fornecedores
INSERT INTO fornecedor (razao_social, nome_fantasia, CNPJ, email, telefone) VALUES ('Alimentos Nacionais Ltda', 'AlimNac', '11.222.333/0001-44', 'contato@alimnac.com', '(11) 92345-6789');
INSERT INTO fornecedor (razao_social, nome_fantasia, CNPJ, email, telefone) VALUES ('Eletrônicos ABC Ltda', 'EletronABC', '55.666.777/0001-88', 'sac@eletronabc.com', '(21) 93456-7890');
INSERT INTO fornecedor (razao_social, nome_fantasia, CNPJ, email, telefone) VALUES ('Papelaria Central', 'PapelCent', '33.444.555/0001-22', 'vendas@papelcent.com', '(41) 94567-8901');
INSERT INTO fornecedor (razao_social, nome_fantasia, CNPJ, email, telefone) VALUES ('TechMax Solutions', 'TechMax', '77.888.999/0001-33', 'support@techmax.com', '(51) 95678-9012');
INSERT INTO fornecedor (razao_social, nome_fantasia, CNPJ, email, telefone) VALUES ('Farmácia Viva', 'FarmViva', '99.000.111/0001-55', 'contato@farmviva.com', '(61) 96789-0123');

-- Inserindo pedidos
INSERT INTO pedido (codigo, nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES (2, 'Pedido B', 2, 3, TIMESTAMP '2024-10-29 10:00:00', NULL);
INSERT INTO pedido (codigo, nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES (3, 'Pedido C', 3, 4, TIMESTAMP '2024-10-30 12:15:00', NULL);
INSERT INTO pedido (codigo, nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES (4, 'Pedido D', 1, 1, TIMESTAMP '2024-10-31 14:30:00', NULL);
INSERT INTO pedido (codigo, nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES (5, 'Pedido E', 4, 5, TIMESTAMP '2024-11-01 09:45:00', NULL);
INSERT INTO pedido (codigo, nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES (6, 'Pedido F', 5, 2, TIMESTAMP '2024-11-02 11:20:00', NULL);

-- Inserindo produtos e associando com pedidos
INSERT INTO produto (codigo, nome, preco) VALUES (3, 'Caneta Azul', 1.50);
INSERT INTO produto (codigo, nome, preco) VALUES (4, 'Lápis Preto', 0.75);
INSERT INTO produto (codigo, nome, preco) VALUES (5, 'Caderno', 10.00);
INSERT INTO produto (codigo, nome, preco) VALUES (6, 'Mochila', 50.00);
INSERT INTO produto (codigo, nome, preco) VALUES (7, 'Calculadora', 25.00);
INSERT INTO produto (codigo, nome, preco) VALUES (8, 'Capa de Notebook', 40.00);
INSERT INTO produto (codigo, nome, preco) VALUES (9, 'Apontador', 2.50);
INSERT INTO produto (codigo, nome, preco) VALUES (10, 'Garrafa Térmica', 20.00);
INSERT INTO produto (codigo, nome, preco) VALUES (11, 'Copo Térmico', 15.00);
INSERT INTO produto (codigo, nome, preco) VALUES (12, 'Agenda', 8.00);


INSERT INTO produto_pedido (id, pedido_id, produto_id) VALUES (3, 3, 3);
