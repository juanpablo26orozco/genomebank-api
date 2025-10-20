-- Datos de ejemplo para pruebas (H2)
INSERT INTO species (id, scientific_name, common_name) VALUES (1, 'Drosophila melanogaster', 'mosca de la fruta');
INSERT INTO species (id, scientific_name, common_name) VALUES (2, 'Homo sapiens', 'humano');

INSERT INTO genomes (id, version_tag, species_id) VALUES (1, 'dm6', 1);
INSERT INTO genomes (id, version_tag, species_id) VALUES (2, 'GRCh38', 2);

INSERT INTO chromosomes (id, name, length_bp, sequence, genome_id) VALUES (1, '2L', 10, 'ACGTACGTAA', 1);
INSERT INTO chromosomes (id, name, length_bp, sequence, genome_id) VALUES (2, '3R', 9, 'TTGGCACGT', 1);
INSERT INTO chromosomes (id, name, length_bp, sequence, genome_id) VALUES (3, 'X', 10, 'TTGGCACGTA', 2);

INSERT INTO genes (id, symbol, start_pos, end_pos, strand, sequence, chromosome_id) VALUES (1, 'BRCA1', 1, 3, '+', 'ACG', 3);
INSERT INTO genes (id, symbol, start_pos, end_pos, strand, sequence, chromosome_id) VALUES (2, 'TP53', 4, 6, '-', 'TAC', 3);
INSERT INTO genes (id, symbol, start_pos, end_pos, strand, sequence, chromosome_id) VALUES (3, 'geneA', 1, 3, '+', 'ACG', 1);
INSERT INTO genes (id, symbol, start_pos, end_pos, strand, sequence, chromosome_id) VALUES (4, 'geneB', 4, 6, '+', 'TAA', 1);
INSERT INTO genes (id, symbol, start_pos, end_pos, strand, sequence, chromosome_id) VALUES (5, 'geneC', 1, 3, '-', 'GCT', 2);

INSERT INTO functions (id, code, name, category) VALUES (1, 'FUNC0001', 'DNA-binding transcription factor activity', 'MF');
INSERT INTO gene_function (id, gene_id, function_id, evidence) VALUES (1, 1, 1, 'experimental');
