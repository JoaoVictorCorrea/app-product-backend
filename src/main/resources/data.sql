INSERT INTO TBL_CATEGORY (NAME) VALUES ('Produção Própria');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('Nacional');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('Importado');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('Premium');

INSERT INTO TBL_PRODUCT (NAME, DESCRIPTION, PRICE, CATEGORY_ID, PROMOTION, NEW_PRODUCT) 
VALUES ('Produto1', 'Descrição1', 1.11, 1, true, false);

INSERT INTO TBL_PRODUCT (NAME, DESCRIPTION, PRICE, CATEGORY_ID, PROMOTION, NEW_PRODUCT) 
VALUES ('Produto2', 'Descrição2', 2.22, 2, false, true);

INSERT INTO TBL_PRODUCT (NAME, DESCRIPTION, PRICE, CATEGORY_ID, PROMOTION, NEW_PRODUCT) 
VALUES ('Produto3', 'Descrição3', 3.33, 3, true, true);

INSERT INTO TBL_PRODUCT (NAME, DESCRIPTION, PRICE, CATEGORY_ID, PROMOTION, NEW_PRODUCT) 
VALUES ('Produto4', 'Descrição4', 4.44, 4, false, false);