# eBay Auction Database Project


This repository contains the solution for an assignment involving the design of a database schema for eBay auction data, shredding XML data into CSV files, creating tables in a MySQL database, and populating them from the CSV files. The assignment consists of three main parts:

1. [Relational Schema Design](#relational-schema-design)
2. [Java Program for XML to CSV Conversion](#java-program-for-xml-to-csv-conversion)
3. [SQL Scripts for Database Creation and Data Loading](#sql-scripts-for-database-creation-and-data-loading)
4. [Testing Database with SQL Queries](#testing-database-with-sql-queries)

## Relational Schema Design

The relational schema is designed to represent the eBay auction data efficiently while adhering to the desired normal forms of database design. Each table in the schema has its primary keys identified and is designed to minimize redundancy and dependency issues.

## Java Program for XML to CSV Conversion

A Java program is implemented to read the provided XML files and generate corresponding CSV files based on the relational schema designed earlier. The program ensures accurate conversion and proper formatting of data into CSV files.

## SQL Scripts for Database Creation and Data Loading

SQL scripts are provided to create tables in a MySQL database according to the designed relational schema. Additionally, these scripts facilitate the loading of data from CSV files into the respective tables in the database.

## Testing Database with SQL Queries

Several SQL queries are executed to test the functionality of the created database. These queries validate the integrity of the data and ensure that the database operates as expected.

## Usage

To use this repository, follow these steps:

1. Clone the repository to your local machine.
2. Review the relational schema design and make any necessary adjustments according to your requirements.
3. Compile and run the Java program to convert XML files to CSV files.
4. Execute the SQL scripts to create the database tables and load data from CSV files.
5. Test the database by running SQL queries against it.


## License

This project is licensed under the [MIT License](LICENSE).

Feel free to contribute to this repository by forking it and creating pull requests. If you encounter any issues or have suggestions for improvement, please open an issue. Thank you!
