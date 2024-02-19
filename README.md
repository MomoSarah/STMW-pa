eBay Auction Database Project

Overview
This project involves designing a database schema for eBay auction data, shredding XML data into CSV files, creating tables in a MySQL database, and populating them from the CSV files. The assignment is divided into three main points:

Designing a Database Schema: Identify the primary keys for each table and ensure the schema adheres to desired normal forms.

XML to CSV Conversion: Write a Java program to read XML files and generate CSV files for each table in the designed schema.

Database Creation and Population: Write SQL scripts to create tables in a MySQL database and load data from the generated CSV files.

Files and Directories
/schema_design: Contains the relational schema design for the eBay auction data, specifying primary keys and normalization forms.

/java_program: Houses the Java program responsible for converting XML data into CSV files.

/sql_scripts: Includes SQL scripts for creating tables in a MySQL database and loading data from CSV files.

/sample_data: A directory containing a small set of sample eBay auction XML files for testing.

Instructions
Schema Design (Point 1)
Review the relational schema in the /schema_design directory.
Understand the chosen primary keys and normalization forms.
Refer to the accompanying documentation explaining why the schema is "good" based on normalization principles.
XML to CSV Conversion (Point 2)
Navigate to the /java_program directory.
Open and run the Java program XmlToCsvConverter.java.
Ensure the program reads eBay auction XML files and generates CSV files for each table in the schema.
Database Creation and Population (Point 3)
Explore the /sql_scripts directory.
Run the SQL scripts in a MySQL environment to create tables and load data from the generated CSV files.
Verify the database has been successfully populated by running sample SQL queries.
Testing
Use sample SQL queries in the /sql_scripts directory to test the database.
Ensure that the queries return the expected results, confirming the correctness of the database schema and data population.
Contributors
[Your Name]
[Other contributors, if any]
Acknowledgments
This project is based on an adapted assignment from UCLA's course "CS144 Web Applications." We extend our gratitude to Junghoo Cho for providing the original material.

License
This project is licensed under the MIT License
