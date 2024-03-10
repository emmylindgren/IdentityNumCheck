#!/bin/bash
javac -cp src src/App.java

if [ $? -eq 0 ]; then
    echo "Build succeeded. Starting program reading from testData."
    echo

    while IFS= read -r line; do
        java -cp src App $line
        echo
    done < testdata.txt

else
    echo "Build failed."
fi