
DELIMITER $$
CREATE OR REPLACE PROCEDURE `procedure_aumentar_salario`(IN arg1 INTEGER, OUT res INTEGER)
BEGIN 
    UPDATE funcionarios as f
    SET f.salario_func = (f.salario_func + (f.salario_func * arg1 / 100))
    WHERE f.salario_func > 0;     
    SELECT ROW_COUNT() INTO res ;
END;$$
DELIMITER ;

