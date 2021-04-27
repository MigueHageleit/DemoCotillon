
/* Roles */
INSERT INTO permisos (permiso) VALUES ('ROLE_ADMIN');
INSERT INTO permisos (permiso) VALUES ('ROLE_USER');

/* Usuarios */
/* Usuarios */
insert into usuarios (user, pass, activo, fk_id_per) values('admin', '$2a$10$pJWiSdAKZBqMRJPVQ3LoGu9.UuCCMfYrslOl9299Rch24605Li27W', 1, 1);
insert into usuarios (user, pass, activo, fk_id_per) values('usuario', '$2a$10$nmsnELze.Ca7dMnsbfGIuuczJlKMAk9SGCkgDczmosj91zCAMsFoO', 1, 2);


/* articulos */
INSERT INTO `cotillon_db`.`articulos` (`cant`, `cod_bar`, `descri`, `link_img`, `precio`) VALUES ('10', '1111111111111', 'Piñatas Emoticones', 'https://http2.mlstatic.com/D_NQ_NP_680105-MLA40897743719_022020-O.webp', '450');
INSERT INTO `cotillon_db`.`articulos` (`cant`, `cod_bar`, `descri`, `link_img`, `precio`) VALUES ('20', '2222222222222', 'Motivos de la Granja', 'https://http2.mlstatic.com/D_NQ_NP_2X_604838-MLA32529587304_102019-F.webp', '85');
INSERT INTO `cotillon_db`.`articulos` (`cant`, `cod_bar`, `descri`, `link_img`, `precio`) VALUES ('15', '3333333333333', 'Decoracion para Cumpleaños', 'https://http2.mlstatic.com/D_NQ_NP_2X_848540-MLA43023475549_082020-F.webp', '40');

