# MMLIB4J - training

The main target of this project, its to be used as a tool for generate 
csv based files to training artificial neural network.


## Getting Started

To start with this project, you gonna need:
   
   * JDK - at least 1.5
   * Maven
   * An IDE
   
To import this project in eclipse you can import as a Maven Project
   

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [MMLIB-4j](https://github.com/wonderalexandre/mmlib4j) - Core library of image processing

## How to Run

* java -Dout=outputfile -Doriginal=folder_with_original_images -Dmark=folder_with_mark_images -Dlabel=label_of_images -jar training.jar