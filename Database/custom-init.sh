set -e

# Initialize the database with md5 authentication
initdb --username=user --pwfile=<(echo "password") --auth=md5

# Start the PostgreSQL service
pg_ctl -D /var/lib/postgresql/data -l logfile start

# Run the init.sql script
psql -U user -d fuelstationdb -a -f /docker-entrypoint-initdb.d/init.sql

# Stop the PostgreSQL service
pg_ctl -D /var/lib/postgresql/data stop
