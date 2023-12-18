#!/bin/bash

echo "preparing the database..."

# Run the drop.sql batch file to drop existing tables.

mysql < drop.sql

# Run the create.sql batch file to create the database and the tables.
mysql < create.sql

# Compile and run the convertor
javac MySAX.java
java MySAX $EBAY_DATA/items-*.xml

# Run the load.sql batch file to load the data
mysql db < load.sql

# Remove all temporary files
rm *.class
rm *.csv