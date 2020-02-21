# Auto-Fabricator

A lightweight desktop Java application used to parse and sort CAD data for use with a TC-50 Pipe Cutting Machine.

## Description

###  **Overview:**

This program takes data output from AutoCAD MEP in csv format and parses the information for useful data including pipe size, diameter, and service (ex. hot or cold water) . The pipes are then sorted into groups so that they can be optimally cut from a stock length of pipe of fixed length, while minimizing wasted pipe leftover.

###  **Background**:

Copper piping stock from 1/2" to 1-1/2" in diameter is manufactured in lengths of 20' feet. A single floor of an apartment building could have 500 pieces of copper pipe in varying lengths and sizes. The TC-50 Pipe cutting machine is fed lengths of pipe and needs to be provided with csv files containing the lengths of pipe to be cut, with specific formatting that the onboard computer can recognize.

Creating these files is a tedious process of hand sorting the raw data into new csv files of a specified format. It can take between 4-8 hours for a single building floor and is subject to human error. Copper pipe costs between $2 and $8 per foot, which adds up quickly on a construction project with  hundreds of thousands of feet of piping.

###  **Solution**:

This program automates the whole process, including the parsing, sorting, and outputting of properly named and formatted files. Aside from the time taken to select an input file and output folder path, this program runs in under a second.

**How it works**:

When the program is run, a window is shown that allows the user to select the source .csv file and a folder to save the output csv files.

Next, the program parses the csv table to create a list of Pipe objects. This is possible while the column structure and layout of the source file remains consistent.

The pipes are then added to separate Lists based on three parameters: diameter (5 sizes) , hot/cold, and end type (2 types).

(5 sizes) x (2 hot/cold) x (2 end types) = 20 possible different groups

Each group of cut pipes is then sorted by length in descending order. Starting with the first pipe, the algorithm adds pipes to a new Bundle as long as the total length of the bundle remains less than the size of the stock (slightly less than 20’).

**Example:**

Unsorted pipe lengths: 15’, 15’, 11’, 10’, 10’, 5’, 5’, 4’, 3’, 3’, 3’, 1’, 1’, 1’

Are grouped as follows:

(15’, 5’) = 20’
(15’, 5’) = 20’
(11’, 4’, 3’, 1’, 1’) = 20’
(3’, 3’, 1’ ) = 6’
