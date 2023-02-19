dropdb --if-exists sk_example_db
    dropuser --if-exists sk_example_user
    createuser sk_example_user
    createdb -O sk_example_user sk_example_db
    psql -U sk_example_user -d sk_example_db <<EOF
CREATE TABLE sk_example_table (id SERIAL, obj JSONB NOT NULL, PRIMARY KEY(id));
INSERT INTO sk_example_table (obj) VALUES ('{"current":0}'::JSONB);
SELECT * FROM pg_catalog.pg_tables WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema';
GRANT ALL ON SCHEMA public TO sk_example_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO sk_example_user;
EOF