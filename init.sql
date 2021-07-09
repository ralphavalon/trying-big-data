CREATE TABLE IF NOT EXISTS iot_device (id serial PRIMARY KEY, created_at TIMESTAMP, user_id VARCHAR(255), type VARCHAR(50), value bigint);

CREATE INDEX by_created_at ON iot_device(created_at);
CREATE INDEX by_user_id_and_created_at ON iot_device(user_id, created_at);
CREATE INDEX by_type_and_created_at ON iot_device(type, created_at);
CREATE INDEX by_type ON iot_device(type);