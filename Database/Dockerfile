FROM postgres:13

COPY init.sql /docker-entrypoint-initdb.d/
COPY pg_hba.conf /var/lib/postgresql/data/pg_hba.conf
COPY postgresql.conf /var/lib/postgresql/data/postgresql.conf
