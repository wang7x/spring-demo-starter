CREATE TABLE IF NOT EXISTS  t_demo_record (
   record_id VARCHAR(64),
   allowance DECIMAL(19, 4) NOT NULL,
   cumulative_amount DECIMAL(19, 4) NOT NULL,
   PRIMARY KEY ( record_id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
